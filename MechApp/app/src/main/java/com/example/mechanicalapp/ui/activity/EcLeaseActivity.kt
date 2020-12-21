package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.InputFilter
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.adapter.PopWayAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecLease
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.impl.UpdateFilePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.ReleaseView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.GlideEngine
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_ec_lease.*
import kotlinx.android.synthetic.main.layout_title.*
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

/**
 * 机械出租
 */
class EcLeaseActivity : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener, OnTimeSelectListener, TextWatcher, ReleaseView<List<CodeData>> {

    private var mPicAdapter: PicAdapter? = null

    private var mPicList: MutableList<String> = ArrayList<String>()

    private var mStringList: MutableList<CodeData> = ArrayList<CodeData>()
    private var popRecy: RecyclerView? = null
    private var mPopWayAdapter: PopWayAdapter? = null


    private var mReMecLease = ReMecLease()

    private var mButtDialog: BottomSheetDialog? = null
    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null

    private var mPresenter: AddManagePresenterImpl? = null
    private var mUpLoadFilePresenter: UpdateFilePresenterImpl? = null

    override fun getLayoutId(): Int {

        return R.layout.activity_ec_lease
    }

    override fun initView() {
        super.initView()
        mPicAdapter = PicAdapter(this, mPicList, this)

        ry_pic.layoutManager = GridLayoutManager(this,3)
        ry_pic.adapter = mPicAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "机械出租"
        tv_way.setOnClickListener(this)
        ly_production_time.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        tv_submit.setOnClickListener(this)


        mReMecLease.bussiessType = "1"

        mPresenter = AddManagePresenterImpl(this, this)
        mUpLoadFilePresenter = UpdateFilePresenterImpl(this, this)

        (mPresenter as AddManagePresenterImpl).getBillMethod()

        et_ec_name.addTextChangedListener(this)
        et_way.addTextChangedListener(this)
        et_work_time.addTextChangedListener(this)
        et_phone.addTextChangedListener(this)
        et_name.addTextChangedListener(this)
        et_production_time.addTextChangedListener(this)
        et_address.addTextChangedListener(this)
        et_input.addTextChangedListener(this)
        et_input.filters=arrayOf(InputFilter.LengthFilter(200))
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
        ToastUtils.showText("请求失败")
    }

    override fun onItemClick(view: View, position: Int) {
        when (view?.id) {
            R.id.tv_screen -> {
                tv_way?.text = mStringList[position].itemText
                mReMecLease.priceUnit = mStringList[position].itemValue
                PopUtils.dismissPop()
            }
            R.id.iv_del -> {
                mPicList?.removeAt(position)
                mPicAdapter?.notifyDataSetChanged()
            }
            R.id.iv_pic -> {
                if (position == mPicList?.size) {
                    showDialogType()
                }
            }
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_way -> showInput()
            R.id.ly_production_time -> showTime()
            R.id.ly_ec_type -> jumpActivityForResult(
                Configs.EC_TYPE_RESULT_CODE,
                1,
                EcType::class.java
            )
            R.id.ly_ec_brand -> jumpActivityForResult(
                Configs.EC_BRAND_RESULT_CODE,
                1,
                Brand::class.java
            )
            R.id.ly_ec_model -> jumpActivityForResult(
                Configs.EC_MODEL_RESULT_CODE,
                1,
                EcModel::class.java
            )
            R.id.ly_address -> jumpActivityForResult(
                Configs.ADDRESS_RESULT_CODE,
                1,
                AddressSelActivity::class.java
            )
            R.id.tv_dialog_item1 -> setItem()
            R.id.tv_dialog_item2 -> setItem1()
            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
            R.id.tv_submit->submit()

        }
    }

    private fun submit() {
        if (checkInfo()){
            for (str in mPicList){
               mReMecLease.pic +="$str,"
            }
            mReMecLease.pic= mReMecLease.pic.substring(0,mReMecLease.pic.length-1)
            (mPresenter as AddManagePresenterImpl).addMecLease(mReMecLease)
        }
    }

    private fun setItem1() {
        mButtDialog?.dismiss()
        verifyStoragePermissions(this)
    }

    private fun setItem() {
        mButtDialog?.dismiss()
        takePoto()
    }

    private fun showTime() {
        val mTimePickerView = TimePickerBuilder(this, this).build()
        mTimePickerView.show()
    }


    private fun showInput() {

        this?.let {
            PopUtils.init(
                it,
                R.layout.pop_way,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                this
            )
        }
        PopUtils.showPopupWindow(tv_way)
    }

    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mPopWayAdapter = PopWayAdapter(this, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mPopWayAdapter
    }

    override fun onTimeSelect(date: Date?, v: View?) {

        mReMecLease.facDate = DateUtils.dateToStr(date)
        et_production_time.text = DateUtils.dateToStr(date)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == Configs.ADDRESS_RESULT_CODE) {
            data?.getStringExtra(Configs.SCREEN_RESULT_Extra)?.let {
                showAddress(
                    it,
                    data?.getStringExtra(Configs.SCREEN_RESULT_ID),
                    data?.getStringExtra(Configs.CITY_NAME),
                    data?.getDoubleExtra(Configs.CITY_LAT, 0.0),
                    data?.getDoubleExtra(Configs.CITY_LOT, 0.0)
                )
            }
        } else {
            showResult(
                requestCode,
                data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
                data?.getStringExtra(Configs.SCREEN_RESULT_ID)
            )
        }

        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showAddress(
        address: String,
        cityId: String?,
        city: String?,
        lat: Double,
        lot: Double
    ) {
        et_address.text = address
        mReMecLease.city = city
        mReMecLease.address = address
        mReMecLease.gpsLat = lat
        mReMecLease.gpsLon = lot
    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                et_ec_type.text = extra
                mReMecLease.cateName = extra
                mReMecLease.cateId = extraId
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                et_ec_brand.text = extra
                mReMecLease.brandName = extra
                mReMecLease.brandId = extraId
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                et_ec_model.text = extra
                mReMecLease.modelName = extra
                mReMecLease.modelId = extraId
            }

        }

    }

    private fun takePoto() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openCamera(PictureMimeType.ofImage())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: MutableList<LocalMedia?>) {
                    if (File(result[0]?.realPath.toString()).exists()){
                        mUpLoadFilePresenter?.upLoadFile(result[0]?.realPath.toString())
                    }else{
                        mUpLoadFilePresenter?.upLoadFile(result[0]?.path.toString())
                    }
                }

                override fun onCancel() {
                }
            });
    }

    private fun takePicture() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofAll())
            .imageEngine(GlideEngine.createGlideEngine())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                    if (File(result[0]?.realPath.toString()).exists()){
                        mUpLoadFilePresenter?.upLoadFile(result[0]?.realPath.toString())
                    }else{
                        mUpLoadFilePresenter?.upLoadFile(result[0]?.path.toString())
                    }
                }

                override fun onCancel() {
                    // 取消
                }
            })
    }

    override fun hasPermissions() {
        super.hasPermissions()
        takePicture()
    }

    private fun showDialogType() {
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(this)
            mDialogView = View.inflate(this, R.layout.dialog_user_data_buttom, null)
            mButtDialog?.setContentView(mDialogView!!)
            mDialogTv1 = mDialogView?.findViewById(R.id.tv_dialog_item1)
            mDialogTv2 = mDialogView?.findViewById(R.id.tv_dialog_item2)
            mDialogTv3 = mDialogView?.findViewById(R.id.tv_dialog_item3)
        }
        mDialogTv1?.setOnClickListener(this)
        mDialogTv2?.setOnClickListener(this)
        mDialogTv3?.setOnClickListener(this)

        mButtDialog?.show()
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {

        changeBtn()
    }

    private fun changeBtn() {
        tv_submit.isSelected =checkInfo()
    }

    private fun checkInfo(): Boolean {

        if (TextUtils.isEmpty(et_ec_name.text.toString().trim())) {
            return false
        }
        mReMecLease.title = et_ec_name.text.toString().trim()

//        if (TextUtils.isEmpty(et_way.text.toString().trim())) {
//            return false
//        }
        mReMecLease.price = et_way.text.toString().trim()

//        if (TextUtils.isEmpty(mReMecLease.cateName)) {
//            return false
//        }
//        if (TextUtils.isEmpty(mReMecLease.brandName)) {
//            return false
//        }
//        if (TextUtils.isEmpty(mReMecLease.modelName)) {
//            return false
//        }

//        if (TextUtils.isEmpty(et_work_time.text.toString().trim())) {
//            return false
//        }
        mReMecLease.workTime = et_work_time.text.toString().trim()

        if (TextUtils.isEmpty(et_phone.text.toString().trim())) {
            return false
        }
        mReMecLease.contactPhone = et_phone.text.toString().trim()

        if (TextUtils.isEmpty(et_name.text.toString().trim())) {
            return false
        }
        mReMecLease.contactName = et_name.text.toString().trim()

        if (TextUtils.isEmpty(et_production_time.text.toString().trim())) {
            return false
        }
        mReMecLease.facDate = et_production_time.text.toString().trim()

        if (TextUtils.isEmpty(et_address.text.toString().trim())) {
            return false
        }
        tv_tip.text="${et_input.text.length}/200"
        mReMecLease.address = et_address.text.toString().trim()
        mReMecLease.briefDesc = et_input.text.toString().trim()
        if (mPicList.size==0) {
            return false
        }
        return true
    }

    override fun showImg(netData: NetData?) {
        if (netData != null && netData.code == 200) {
            mPicList?.add(netData.message)
            mPicAdapter?.notifyDataSetChanged()
            changeBtn()
        }
    }

    override fun uploadFail(str: String) {

        ToastUtils.showText(str)
    }

    override fun showSuccess(netData: NetData?) {

        ToastUtils.showText(netData?.message)
        if (netData?.code==200){
            finish()
        }
    }

    override fun showData(t: List<CodeData>) {

        mStringList.clear()
        mStringList.addAll(t)
        if (mStringList.size>0){
            tv_way?.text = mStringList[0].itemText
            mReMecLease.priceUnit = mStringList[0].itemValue
        }
    }

}
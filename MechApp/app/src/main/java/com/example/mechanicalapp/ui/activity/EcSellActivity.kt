package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.InputFilter
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
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
import com.example.mechanicalapp.ui.adapter.PayWayAdapter
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CodeBean
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecBusiness
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
import kotlinx.android.synthetic.main.activity_ec_sell.*
import kotlinx.android.synthetic.main.layout_title.*
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class EcSellActivity : BaseCusActivity(), OnItemClickListener, View.OnClickListener,OnTimeSelectListener, TextWatcher,  ReleaseView<List<CodeData>>{

    private var mPicAdapter: PicAdapter? = null

    private var mPicList: MutableList<String> = ArrayList<String>()


    private var mPayWayList: MutableList<CodeData> = ArrayList<CodeData>()
    private var mPopPayWay: RecyclerView? = null
    private var mPayWayAdapter: PayWayAdapter? = null

    private var mReMecBusiness = ReMecBusiness()


    private var mButtDialog: BottomSheetDialog? = null

    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null

    private var mPresenter: AddManagePresenterImpl? = null
    private var mUpLoadFilePresenter: UpdateFilePresenterImpl? = null


    override fun getLayoutId(): Int {

        return R.layout.activity_ec_sell
    }

    override fun initView() {
        super.initView()

        mPicAdapter = PicAdapter(this, mPicList, this)
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation =RecyclerView.HORIZONTAL
        ry_pic.layoutManager =layoutManager
        ry_pic.adapter = mPicAdapter



        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "机械出售"

        ly_production_time.setOnClickListener(this)
        ly_pay_way.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        tv_submit.setOnClickListener(this)
        tv_yes.setOnClickListener(this)
        tv_no.setOnClickListener(this)


//        mPayWayList?.add("全款")
//        mPayWayList?.add("协议付款")
//        mPayWayList?.add("分期付款")

        mReMecBusiness.bussiessType = "1"//出售
        mReMecBusiness.isNew = "0"
        tv_yes.isSelected = true

        mPresenter = AddManagePresenterImpl(this, this)
        mUpLoadFilePresenter = UpdateFilePresenterImpl(this, this)


        et_ec_name.addTextChangedListener(this)
        et_way.addTextChangedListener(this)
        et_work_time.addTextChangedListener(this)
        et_phone.addTextChangedListener(this)
        et_name.addTextChangedListener(this)
        et_production_time.addTextChangedListener(this)
        et_address.addTextChangedListener(this)
        et_input.addTextChangedListener(this)
        et_input.filters=arrayOf(InputFilter.LengthFilter(200))
        (mPresenter as AddManagePresenterImpl).getPayWay()
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
            R.id.tv_pay_way -> {
                pay_way?.text = mPayWayList[position].itemText
                mReMecBusiness.paymentType = mPayWayList[position].itemValue
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
            R.id.ly_production_time -> showTime()
            R.id.ly_pay_way -> showPayWay()
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
            R.id.tv_submit -> sumbit()
            R.id.tv_yes -> {
                tv_yes.isSelected = true
                tv_no.isSelected = false
                mReMecBusiness.isNew = "0"
            }
            R.id.tv_no -> {
                tv_yes.isSelected = false
                tv_no.isSelected = true
                mReMecBusiness.isNew = "1"
            }
        }
    }

    private fun sumbit() {
        if (checkInfo()) {
            for (str in mPicList) {
                mReMecBusiness.pic += "$str,"
            }
            mReMecBusiness.pic= mReMecBusiness.pic.substring(0,mReMecBusiness.pic.length-1)
            (mPresenter as AddManagePresenterImpl).addMecBusiness(mReMecBusiness)
        }
    }

    private fun showTime() {
        val mTimePickerView = TimePickerBuilder(this, this).build()
        mTimePickerView.show()
    }

    //支付方式
    private fun showPayWay() {
        this?.let {
            PopUtils.init(it,
                R.layout.pop_layout_pay_way,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, object : PopUtils.onViewListener {
                    override fun getView(view: View?) {
                        mPopPayWay = view?.findViewById(R.id.pop_recycler_list)
                        mPayWayAdapter =
                            PayWayAdapter(this@EcSellActivity, mPayWayList, this@EcSellActivity)
                        mPopPayWay?.layoutManager = LinearLayoutManager(this@EcSellActivity)
                        mPopPayWay?.adapter = mPayWayAdapter
                    }
                }
            )
        }
        PopUtils.showPopupWindow(ly_pay_way)
    }


    override fun onTimeSelect(date: Date?, v: View?) {
        mReMecBusiness.facDate = DateUtils.dateToStr(date)
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
        mReMecBusiness.city = city
        mReMecBusiness.address = address
        mReMecBusiness.gpsLat = lat.toString()
        mReMecBusiness.gpsLon = lot.toString()
    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                et_ec_type.text = extra
                mReMecBusiness.cateName = extra
                mReMecBusiness.cateId = extraId
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                et_ec_brand.text = extra
                mReMecBusiness.brandName = extra
                mReMecBusiness.brandId = extraId
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                et_ec_model.text = extra
                mReMecBusiness.modelName = extra
                mReMecBusiness.modelId = extraId
            }
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
//                                        mPicList?.add(result[0]?.realPath.toString())
//                    mPicAdapter?.notifyDataSetChanged()
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

    private fun changeBtn() {
        tv_submit.isSelected = checkInfo()
    }

    private fun checkInfo(): Boolean {

        if (TextUtils.isEmpty(et_ec_name.text.toString().trim())) {
            return false
        }
        mReMecBusiness.title = et_ec_name.text.toString().trim()

        if (TextUtils.isEmpty(et_way.text.toString().trim())) {
            return false
        }
        mReMecBusiness.price = et_way.text.toString().trim()

        if (TextUtils.isEmpty(mReMecBusiness.cateName)) {
            return false
        }
        if (TextUtils.isEmpty(mReMecBusiness.brandName)) {
            return false
        }
        if (TextUtils.isEmpty(mReMecBusiness.modelName)) {
            return false
        }

        if (TextUtils.isEmpty(et_work_time.text.toString().trim())) {
            return false
        }
        mReMecBusiness.workTime = et_work_time.text.toString().trim()

        if (TextUtils.isEmpty(et_phone.text.toString().trim())) {
            return false
        }
        mReMecBusiness.contactPhone = et_phone.text.toString().trim()

        if (TextUtils.isEmpty(et_name.text.toString().trim())) {
            return false
        }
        mReMecBusiness.contactName = et_name.text.toString().trim()

        if (TextUtils.isEmpty(et_production_time.text.toString().trim())) {
            return false
        }
        mReMecBusiness.facDate = et_production_time.text.toString().trim()

        if (TextUtils.isEmpty(et_address.text.toString().trim())) {
            return false
        }
        mReMecBusiness.address = et_address.text.toString().trim()
        //付款方式
        if (TextUtils.isEmpty(mReMecBusiness.paymentType)) {
            return false
        }
        mReMecBusiness.briefDesc = et_input.text.toString().trim()
        if (mPicList.size == 0) {
            return false
        }
        tv_tip.text="${et_input.text.length}/200"
        return true
    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        changeBtn()
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

    //支付方式
    override fun showData(t: List<CodeData>) {
        mPayWayList.clear()
        mPayWayList.addAll(t)
    //    mPayWayAdapter?.notifyDataSetChanged()
    }

}
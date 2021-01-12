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
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.adapter.PopWayAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.RePartsLease
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.impl.UpdateFilePresenterImpl
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.ReleaseView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.GlideEngine
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_ask_rent_parts.*
import kotlinx.android.synthetic.main.layout_title.*
import java.io.File

class AskingRentPatsActivity : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener,ReleaseView<List<CodeData>>,TextWatcher {

    private var mPicAdapter: PicAdapter? = null
    private var mPicList: MutableList<String> = ArrayList<String>()

    private var mStringList: MutableList<CodeData> = ArrayList<CodeData>()
    private var popRecy: RecyclerView? = null
    private var mPopWayAdapter: PopWayAdapter? = null

    private var mReBean = RePartsLease()
    private var mPresenter: AddManagePresenterImpl? = null

    private var mButtDialog: BottomSheetDialog? = null

    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null
    private var mUpLoadFilePresenter: UpdateFilePresenterImpl? = null
    override fun getLayoutId(): Int {

        return R.layout.activity_ask_rent_parts
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
        tv_title.text = "配件求租"
        tv_way.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        tv_submit.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)


        mReBean.bussiessType = 2
        mPresenter = AddManagePresenterImpl(this, this)
        (mPresenter as AddManagePresenterImpl).getBillMethod()
        et_parts_name.addTextChangedListener(this)
//        et_ec_type.addTextChangedListener(this)
//        et_ec_type.addTextChangedListener(this)
        et_parts_brand.addTextChangedListener(this)
        et_parts_model.addTextChangedListener(this)
        et_way.addTextChangedListener(this)
        et_name.addTextChangedListener(this)
        et_phone.addTextChangedListener(this)
        et_input.addTextChangedListener(this)
        et_input.filters=arrayOf(InputFilter.LengthFilter(200))
    }

    override fun initPresenter() {
        mUpLoadFilePresenter = UpdateFilePresenterImpl(this, this)
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    override fun onItemClick(view: View, position: Int) {
        when (view?.id) {
            R.id.tv_screen -> {
                tv_way?.text = mStringList[position].itemText
                mReBean.priceUnit = mStringList[position].itemValue
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
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_way -> showInput()
            R.id.ly_ec_type->{
                jumpActivityForResult(
                    Configs.EC_TYPE_RESULT_CODE,
                    1,
                    EcType::class.java
                )
            }
            R.id.ly_address -> jumpActivityForResult(
                Configs.ADDRESS_RESULT_CODE,
                1,
                AddressSelActivity::class.java
            )
            R.id.tv_submit->submit()
            R.id.tv_dialog_item1 -> setItem()
            R.id.tv_dialog_item2 -> setItem1()
            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
        }
    }

    private fun submit() {

        if (checkInfo()){
            for (str in mPicList) {
                mReBean.pic += "$str,"
            }
            mReBean.pic= mReBean.pic.substring(0,mReBean.pic.length-1)
            (mPresenter as AddManagePresenterImpl).addPartsLease(mReBean)
        }
    }


    private fun showInput() {

        this?.let {
            PopUtils.init(
                it,
                R.layout.pop_way,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, this
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
        }else if (requestCode ==Configs.EC_TYPE_RESULT_CODE ){
            et_ec_type.text = data?.getStringExtra(Configs.SCREEN_RESULT_Extra)
            mReBean.cateName = data?.getStringExtra(Configs.SCREEN_RESULT_Extra)
            mReBean.cateId = data?.getStringExtra(Configs.SCREEN_RESULT_ID)
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
        mReBean.city = city
        mReBean.address = address
        mReBean.gpsLat = lat.toString()
        mReBean.gpsLon = lot.toString()
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
        if (netData?.code == 200) {
            finish()
        }
    }


    override fun showData(t: List<CodeData>) {
        mStringList.clear()
        mStringList.addAll(t)
        if (mStringList.size > 0) {
            tv_way?.text = mStringList[0].itemText
            mReBean.priceUnit = mStringList[0].itemValue
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {

        changeBtn()
    }

    private fun changeBtn() {
        tv_submit.isSelected = checkInfo()
    }

    private fun checkInfo(): Boolean {

        if (TextUtils.isEmpty(et_parts_name.text.toString().trim())) {
            return false
        }
        mReBean.title = et_parts_name.text.toString().trim()



        //适合机型
        if (TextUtils.isEmpty(et_ec_type.text.toString().trim())) {
            return false
        }

        mReBean.fitMachineType = et_ec_type.text.toString().trim()


        if (TextUtils.isEmpty(et_parts_brand.text.toString().trim())) {
            return false
        }
        mReBean.brand = et_parts_brand.text.toString().trim()

        if (TextUtils.isEmpty(et_parts_model.text.toString().trim())) {
            return false
        }
        mReBean.partsType = et_parts_model.text.toString().trim()

        if (TextUtils.isEmpty(et_way.text.toString().trim())) {
            return false
        }
        mReBean.price = et_way.text.toString().trim()

        if (TextUtils.isEmpty(et_phone.text.toString().trim())) {
            return false
        }
        mReBean.contactPhone = et_phone.text.toString().trim()

        if (TextUtils.isEmpty(et_name.text.toString().trim())) {
            return false
        }
        mReBean.contactName = et_name.text.toString().trim()

        if (TextUtils.isEmpty(et_address.text.toString().trim())) {
            return false
        }
        mReBean.address = et_address.text.toString().trim()
        mReBean.content = et_input.text.toString().trim()
        if (mPicList.size == 0) {
            return false
        }
        tv_tip.text="${et_input.text.length}/200"
        return true
    }

}
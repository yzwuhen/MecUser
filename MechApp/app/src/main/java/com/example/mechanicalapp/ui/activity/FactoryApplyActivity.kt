package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.provider.Settings
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.ApplyInfoBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReCer
import com.example.mechanicalapp.ui.mvp.impl.PersonCerPresenter
import com.example.mechanicalapp.ui.mvp.v.PersonCerView
import com.example.mechanicalapp.utils.GlideEngine
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_factory_apply.*
import kotlinx.android.synthetic.main.layout_title.*
import java.io.File
import java.lang.Exception

class FactoryApplyActivity : BaseCusActivity(), View.OnClickListener, PersonCerView,
    TextWatcher {

    private var mButtDialog: BottomSheetDialog? = null

    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null

    private var mPresenter: PersonCerPresenter? = null

    private var reCompanyCer = ReCer()
    private var picType: Int = 0
    override fun getLayoutId(): Int {
        return R.layout.activity_factory_apply
    }

    override fun initPresenter() {
        mPresenter = PersonCerPresenter(this, this)
        mPresenter?.getApporve("4")
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "维修厂入驻"

        ly_mec_type.setOnClickListener(this)
        ly_parts_type.setOnClickListener(this)
        iv_license_pic.setOnClickListener(this)
        iv_factory_pic.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        tv_submit.setOnClickListener(this)
        reCompanyCer.apporveType = 4

        tv_modify.setOnClickListener(this)
        ly_cus_server1.setOnClickListener(this)
        ly_cus_server.setOnClickListener(this)
        et_company_name.addTextChangedListener(this)
        et_user_name.addTextChangedListener(this)
        et_contacts_phone.addTextChangedListener(this)
        et_input.addTextChangedListener(this)
    }


    private fun submit() {
        if (checkInfo()) {
            mPresenter?.submitCer(reCompanyCer)
        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.ly_mec_type -> jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                MoreSelectMecType::class.java
            )
            R.id.ly_parts_type -> jumpActivityForReSult(
                Configs.PARTS_RESULT_CODE,
                MoreSelPartsType::class.java
            )
            R.id.iv_license_pic -> showDialogType(1)
            R.id.iv_factory_pic -> showDialogType(2)
            R.id.tv_dialog_item1 -> setItem()
            R.id.tv_dialog_item2 -> setItem()
            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
            R.id.tv_submit -> submit()
            R.id.ly_address -> {
                if (isLocationEnabled(this)){
                    jumpActivityForResult(
                        Configs.ADDRESS_RESULT_CODE,
                        1,
                        AddressSelActivity::class.java
                    )
                }else{
                    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    startActivity(intent)
                }
            }
            R.id.tv_modify -> modify()
            R.id.ly_cus_server -> openCall("400-654-9874")
            R.id.ly_cus_server1 -> openCall("400-654-9874")
        }
    }


    private fun modify() {

        ly_not_apply.visibility = View.VISIBLE
        ly_apply_fail.visibility = View.GONE

    }

    private fun setItem() {
        mButtDialog?.dismiss()
        verifyStoragePermissions(this)
    }

    override fun hasPermissions() {
        super.hasPermissions()
        takePicture()
    }

    private fun takePicture() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofAll())
            .imageEngine(GlideEngine.createGlideEngine())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                    if (File(result[0]?.realPath.toString()).exists()) {
                        (mPresenter as PersonCerPresenter)?.upLoadFile(result[0]?.realPath.toString())
                    } else {
                        (mPresenter as PersonCerPresenter)?.upLoadFile(result[0]?.path.toString())
                    }
                }

                override fun onCancel() {
                    // 取消
                }
            })
    }

    private fun showDialogType(type: Int) {
        picType = type
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(this)
            mDialogView = View.inflate(this, R.layout.dialog_user_data_buttom, null)
            mButtDialog?.setContentView(mDialogView!!)
            mDialogTv1 = mDialogView?.findViewById(R.id.tv_dialog_item1)
            mDialogTv2 = mDialogView?.findViewById(R.id.tv_dialog_item2)
            mDialogTv3 = mDialogView?.findViewById(R.id.tv_dialog_item3)
        }

        mDialogTv1?.text = "拍照"
        mDialogTv2?.text = "从相册选择"

        mDialogTv1?.setOnClickListener(this)
        mDialogTv2?.setOnClickListener(this)
        mDialogTv3?.setOnClickListener(this)

        mButtDialog?.show()
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
            showResult(requestCode, data?.getStringExtra(Configs.SCREEN_RESULT_Extra))
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
        et_company_address.text = address
        reCompanyCer.city = city
        reCompanyCer.companyAddress = address
        reCompanyCer.gpsLat = lat
        reCompanyCer.gpsLon = lot
    }

    private fun showResult(requestCode: Int, extra: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                tv_mec_type.text = extra
                reCompanyCer.repaireType = extra
            }
            Configs.PARTS_RESULT_CODE -> {
                tv_parts_type.text = extra
                reCompanyCer.componentType = extra
            }

        }

    }

    override fun afterTextChanged(p0: Editable?) {
        changeBtn()
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    private fun changeBtn() {
        tv_submit.isSelected = checkInfo()
    }


    private fun checkInfo(): Boolean {

        if (TextUtils.isEmpty(et_company_name.text.toString().trim())) {
            return false
        }
        reCompanyCer.companyName = et_company_name.text.toString().trim()

        if (TextUtils.isEmpty(et_user_name.text.toString().trim())) {
            return false
        }
        reCompanyCer.name = et_user_name.text.toString().trim()


        if (TextUtils.isEmpty(et_contacts_phone.text.toString().trim())) {
            return false
        }
        reCompanyCer.contactPhone = et_contacts_phone.text.toString().trim()


        if (TextUtils.isEmpty(et_company_address.text.toString().trim())) {
            return false
        }
        reCompanyCer.companyAddress = et_company_address.text.toString().trim()


        if (TextUtils.isEmpty(reCompanyCer.repaireType)) {
            return false
        }

        if (TextUtils.isEmpty(reCompanyCer.componentType)) {
            return false
        }
        if (TextUtils.isEmpty(reCompanyCer.socialPic)) {
            return false
        }
        if (TextUtils.isEmpty(reCompanyCer.repairPic)) {
            return false
        }
        return true
    }

    override fun success(netData: NetData?) {
        if (netData != null && netData is ApplyInfoBean) {
            if (netData.result == null || netData.result.records == null || netData.result.records.size == 0) {
                ly_not_apply.visibility = View.VISIBLE
            } else {
                reCompanyCer = netData.result.records[0]
                if (reCompanyCer.apporveStatus == 1) {
                    ly_apply_ing.visibility = View.VISIBLE
                } else if (reCompanyCer.apporveStatus == 2) {
                    ly_apply_success.visibility = View.VISIBLE

                    try {
                        tv_success_id_code.text="您的申请已通过，账号为：${netData.result.records[0].contactPhone}，" +
                                "初始密码是123456 。为保证账号安全性，请记得修改密码~ 维修厂管理官网地址：http：XXX"
                    }catch (e:Exception){

                    }

                } else {
                    ly_apply_fail.visibility = View.VISIBLE
                }
            }

        } else {
            ToastUtils.showText(netData?.message)
            if (netData?.code == 200) {
                finish()
            }
        }
    }

    override fun showImg(netData: NetData?) {
        if (netData != null && netData.code == 200) {
            if (picType == 1) {
                ImageLoadUtils.loadImage(
                    App.getInstance().applicationContext,
                    iv_license_pic,
                    netData.message,
                    R.mipmap.user_default
                )
                reCompanyCer.socialPic = netData.message
            } else {
                ImageLoadUtils.loadImage(
                    App.getInstance().applicationContext,
                    iv_factory_pic,
                    netData.message,
                    R.mipmap.user_default
                )
                reCompanyCer.repairPic = netData.message
            }
        }
        changeBtn()
    }

    override fun uploadFail(str: String) {

        ToastUtils.showText(str)
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }
}
package com.example.mechanicalapp.ui.activity

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
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
import kotlinx.android.synthetic.main.activity_company_certify.*
import kotlinx.android.synthetic.main.layout_title.*

class CompanyCertifyActivity:BaseCusActivity(),View.OnClickListener, PersonCerView,
    TextWatcher {


    private var mButtDialog: BottomSheetDialog? = null

    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null

    private var picType:Int=0

    private var mPresenter: PersonCerPresenter? = null

    private var reCompanyCer = ReCer()

    override fun getLayoutId(): Int {

        return R.layout.activity_company_certify
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "企业认证"
        tv_sketch.setOnClickListener(this)
        iv_positive_pic.setOnClickListener(this)
        iv_side_pic.setOnClickListener(this)
        iv_company_pic.setOnClickListener(this)
        tv_submit.setOnClickListener(this)

        et_company_name.addTextChangedListener(this)
        et_user_name.addTextChangedListener(this)
        et_company_code.addTextChangedListener(this)
        et_company_address.addTextChangedListener(this)
        reCompanyCer.apporveType=3
    }

    override fun initPresenter() {
        mPresenter = PersonCerPresenter(this, this)
    }



    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.iv_back -> finish()
            R.id.tv_sketch -> jumpActivity(null, SketchActivity::class.java)
            R.id.iv_positive_pic -> showDialogType(0)
            R.id.iv_side_pic -> showDialogType(1)
            R.id.iv_company_pic -> showDialogType(2)
            R.id.tv_dialog_item1 -> setItem()
            R.id.tv_dialog_item2 -> setItem()
            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
            R.id.tv_submit->submit()
        }
    }

    private fun submit() {
        mPresenter?.submitCer(reCompanyCer)

    }

    private fun setItem() {
        verifyStoragePermissions(this)
    }

    override fun hasPermissions() {
        super.hasPermissions()
        takePicture()
    }

    private fun showDialogType(type: Int) {
        picType =type
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




    private fun takePicture() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofAll())
           .imageEngine(GlideEngine.createGlideEngine())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                    (mPresenter as PersonCerPresenter).upLoadFile(result[0]?.realPath.toString())
                }

                override fun onCancel() {
                    // 取消
                }
            })
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


        if (TextUtils.isEmpty(et_company_code.text.toString().trim())) {
            return false
        }
        reCompanyCer.companyId = et_company_code.text.toString().trim()

        if (TextUtils.isEmpty(et_company_address.text.toString().trim())) {
            return false
        }
        reCompanyCer.companyAddress = et_company_address.text.toString().trim()


        if (TextUtils.isEmpty(reCompanyCer.idCardBackPic)) {
            return false
        }

        if (TextUtils.isEmpty(reCompanyCer.idCardFrontPic)) {
            return false
        }
        if (TextUtils.isEmpty(reCompanyCer.socialPic)) {
            return false
        }
        return true
    }

    override fun success(netData: NetData?) {
        ToastUtils.showText(netData?.message)
        if (netData?.code==200){
            finish()
        }
    }

    override fun showImg(netData: NetData?) {
        if (netData != null && netData.code == 200) {
            changeBtn()
            if (picType == 0) {
                ImageLoadUtils.loadImage(
                    App.getInstance().applicationContext,
                    iv_positive_pic,
                    netData.message,
                    R.mipmap.user_default
                )
                reCompanyCer.idCardFrontPic = netData.message
            } else if (picType ==1){
                ImageLoadUtils.loadImage(
                    App.getInstance().applicationContext,
                    iv_side_pic,
                    netData.message,
                    R.mipmap.user_default
                )
                reCompanyCer.idCardBackPic = netData.message
            }
            else{
                ImageLoadUtils.loadImage(
                    App.getInstance().applicationContext,
                    iv_company_pic,
                    netData.message,
                    R.mipmap.user_default
                )
                reCompanyCer.socialPic = netData.message
            }
        }
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
    override fun err()  {
    }
}
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
import kotlinx.android.synthetic.main.activity_person_certify.*
import kotlinx.android.synthetic.main.activity_person_certify.tv_submit
import kotlinx.android.synthetic.main.layout_title.*

class PersonalCertification : BaseCusActivity(), View.OnClickListener, PersonCerView, TextWatcher {


    private var mButtDialog: BottomSheetDialog? = null
    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null

    private var type: Int = 0
    private var mRePersonCer = ReCer()

    private var mUpFilePresenter: PersonCerPresenter? = null

    override fun getLayoutId(): Int {

        return R.layout.activity_person_certify
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "个人认证"
        tv_sketch.setOnClickListener(this)
        iv_positive_pic.setOnClickListener(this)
        iv_side_pic.setOnClickListener(this)
        tv_man.setOnClickListener(this)
        tv_woman.setOnClickListener(this)
        tv_submit.setOnClickListener(this)

        tv_man.isSelected = true
        mRePersonCer.apporveType=2
        mRePersonCer.sex = "男"
        et_user_name.addTextChangedListener(this)
        et_user_code.addTextChangedListener(this)
    }

    override fun initPresenter() {
        mUpFilePresenter = PersonCerPresenter(this, this)
    }


    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.iv_back -> finish()
            R.id.tv_sketch -> jumpActivity(null, SketchActivity::class.java)
            R.id.iv_positive_pic -> showDialogType(0)
            R.id.iv_side_pic -> showDialogType(1)
            R.id.tv_man -> {
                tv_man.isSelected = true
                tv_woman.isSelected = false
                mRePersonCer.sex = "男"
            }
            R.id.tv_woman -> {
                tv_man.isSelected = false
                tv_woman.isSelected = true
                mRePersonCer.sex = "女"
            }
            R.id.tv_dialog_item1 -> setItem()
            R.id.tv_dialog_item2 -> setItem1()
            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
            R.id.tv_submit->submit()
        }
    }

    private fun submit() {

        if (checkInfo()){
            mUpFilePresenter?.submitCer(mRePersonCer)
        }
    }

    private fun setItem() {
        mButtDialog?.dismiss()
        takePoto()
    }
    private fun setItem1() {
        verifyStoragePermissions(this)
    }
    override fun hasPermissions() {
        super.hasPermissions()
        takePicture()
    }

    private fun showDialogType(i: Int) {
        type = i
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
    private fun takePoto() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openCamera(PictureMimeType.ofImage())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: MutableList<LocalMedia?>) {
                    (mUpFilePresenter as PersonCerPresenter)?.upLoadFile(result[0]?.realPath.toString())
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
                    (mUpFilePresenter as PersonCerPresenter).upLoadFile(result[0]?.realPath.toString())
                }
                override fun onCancel() {
                    // 取消
                }
            })
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

        if (TextUtils.isEmpty(et_user_name.text.toString().trim())) {
            return false
        }
        mRePersonCer.name = et_user_name.text.toString().trim()

        if (TextUtils.isEmpty(et_user_code.text.toString().trim())) {
            return false
        }
        mRePersonCer.idCard = et_user_code.text.toString().trim()

        if (TextUtils.isEmpty(mRePersonCer.idCardBackPic)) {
            return false
        }

        if (TextUtils.isEmpty(mRePersonCer.idCardFrontPic)) {
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
            if (type == 0) {
                ImageLoadUtils.loadImage(
                    App.getInstance().applicationContext,
                    iv_positive_pic,
                    netData.message,
                    R.mipmap.user_default
                )
                mRePersonCer.idCardFrontPic = netData.message
            } else {
                ImageLoadUtils.loadImage(
                    App.getInstance().applicationContext,
                    iv_side_pic,
                    netData.message,
                    R.mipmap.user_default
                )
                mRePersonCer.idCardBackPic = netData.message
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
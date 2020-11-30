package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.TextView
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.UserInfo
import com.example.mechanicalapp.ui.mvp.impl.UserInfoPresenter
import com.example.mechanicalapp.ui.mvp.v.UserView
import com.example.mechanicalapp.utils.GlideEngine
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_user_data.*
import kotlinx.android.synthetic.main.layout_title.*

class UserDataActivity : BaseCusActivity(), View.OnClickListener, UserView {

    private var mButtDialog: BottomSheetDialog?=null

    private var mDialogView:View ?= null
    private var mDialogTv1:TextView ?= null
    private var mDialogTv2:TextView ?= null
    private var mDialogTv3:TextView ?= null

    private var dialogType:Int =0

    private var mPresenter:UserInfoPresenter?=null
    private var userInfo:UserInfo?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_user_data
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "个人资料"


        ly_user_pic.setOnClickListener(this)
        ly_sex.setOnClickListener(this)
        ly_nick.setOnClickListener(this)



        userInfo =App.getInstance().userInfo
    }

    override fun initPresenter() {
        mPresenter = UserInfoPresenter(this,this)
    }

    override fun onResume() {
        super.onResume()
        showInfo()
    }

    private fun showInfo() {
        ImageLoadUtils.loadCircle(this,iv_user_pic,App.getInstance().userInfo.avatar)
        tv_user_nick.text = App.getInstance().userInfo.realname
        if (App.getInstance().userInfo.sex==1){
            tv_user_sex.text ="男"
        }else{
            tv_user_sex.text ="女"
        }
        tv_user_phone.text =App.getInstance().userInfo.phone

    }
    override fun success(netData: NetData?) {

        ToastUtils.showText(netData?.message)
    }

    override fun showImg(netData: NetData?) {
        if (netData != null && netData.code == 200) {
          userInfo?.avatar =netData.message
            ImageLoadUtils.loadCircle(this,iv_user_pic,netData.message)
            mPresenter?.editUserInfo(userInfo)
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

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.iv_back -> finish()
            R.id.ly_user_pic ->showDialogType(0)
            R.id.ly_sex ->showDialogType(1)
            R.id.tv_dialog_item1->setItem()
            R.id.tv_dialog_item2->setItem1()
            R.id.tv_dialog_item3->mButtDialog?.dismiss()
            R.id.ly_nick->jumpActivity(null,ModifyNickActivity::class.java)
        }
    }

    private fun setItem1() {
        mButtDialog?.dismiss()
        if (dialogType==0){
            verifyStoragePermissions(this)
        }else{
            tv_user_sex.text ="女"
            userInfo?.sex =2
            mPresenter?.editUserInfo(userInfo)
        }

    }

    private fun setItem() {
        mButtDialog?.dismiss()
        if (dialogType==0){
            verifyStoragePermissions(this)
        }else{
            tv_user_sex.text ="男"
            userInfo?.sex =1
            mPresenter?.editUserInfo(userInfo)
        }
    }

    private fun takePicture() {
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofAll())
           .imageEngine(GlideEngine.createGlideEngine())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                    mPresenter?.upLoadFile(result[0]?.realPath.toString())
                   // ImageLoadUtils.loadImage(App.getInstance().applicationContext,iv_user_pic,result[0]?.path,R.mipmap.user_default)
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

     private fun showDialogType(type:Int){
         dialogType= type
        if (mButtDialog ==null){
            mButtDialog = BottomSheetDialog(this)
            mDialogView = View.inflate(this,R.layout.dialog_user_data_buttom,null)
            mButtDialog?.setContentView(mDialogView!!)
            mDialogTv1 = mDialogView?.findViewById(R.id.tv_dialog_item1)
            mDialogTv2 = mDialogView?.findViewById(R.id.tv_dialog_item2)
            mDialogTv3 = mDialogView?.findViewById(R.id.tv_dialog_item3)
        }
        if (type==0){
            mDialogTv1?.text ="拍照"
            mDialogTv2?.text ="从相册选择"
        }else{
            mDialogTv1?.text ="男"
            mDialogTv2?.text ="女"
        }
         mDialogTv1?.setOnClickListener(this)
         mDialogTv2?.setOnClickListener(this)
         mDialogTv3?.setOnClickListener(this)

        mButtDialog?.show()
    }
}
package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.TextView
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.utils.GlideEngine
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_user_data.*
import kotlinx.android.synthetic.main.item_job_want.*
import kotlinx.android.synthetic.main.layout_title.*

class UserDataActivity : BaseActivity<NetData>(), View.OnClickListener {



    private var mButtDialog: BottomSheetDialog?=null

    private var mDialogView:View ?= null
    private var mDialogTv1:TextView ?= null
    private var mDialogTv2:TextView ?= null
    private var mDialogTv3:TextView ?= null

    private var dialogType:Int =0

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
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
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
        if (dialogType==0){
            verifyStoragePermissions(this)
        }else{
            tv_sex.text ="女"
        }

    }

    private fun setItem() {
        mButtDialog?.dismiss()
        if (dialogType==0){
            verifyStoragePermissions(this)
        }else{
            tv_sex.text ="男"
        }
    }

    private fun takePicture() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofAll())
           .imageEngine(GlideEngine.createGlideEngine())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                    ImageLoadUtils.loadImage(App.getInstance().applicationContext,iv_user_pic,result[0]?.path,R.mipmap.user_default)
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
package com.example.mechanicalapp.ui.activity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_person_certify.*
import kotlinx.android.synthetic.main.activity_user_data.*
import kotlinx.android.synthetic.main.layout_title.*

class PersonalCertification:BaseActivity<NetData>(),View.OnClickListener {

    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(
        "android.permission.READ_EXTERNAL_STORAGE",
        "android.permission.WRITE_EXTERNAL_STORAGE",
        "android.permission.CAMER"
    )
    private var mButtDialog: BottomSheetDialog?=null

    private var mDialogView:View ?= null
    private var mDialogTv1: TextView?= null
    private var mDialogTv2: TextView?= null
    private var mDialogTv3: TextView?= null

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

        when(view?.id){
            R.id.iv_back->finish()
            R.id.tv_sketch->jumpActivity(null,SketchActivity::class.java)
            R.id.iv_positive_pic->showDialogType(0)
            R.id.iv_side_pic->showDialogType(1)
            R.id.tv_dialog_item1->setItem()
            R.id.tv_dialog_item2->setItem()
            R.id.tv_dialog_item3->mButtDialog?.dismiss()
        }
    }

    private fun setItem() {
        verifyStoragePermissions(this)
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
            mDialogTv1?.text ="拍照"
            mDialogTv2?.text ="从相册选择"

        mDialogTv1?.setOnClickListener(this)
        mDialogTv2?.setOnClickListener(this)
        mDialogTv3?.setOnClickListener(this)

        mButtDialog?.show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode === -1 && android.R.attr.data != null) {
            when (requestCode) {
                PictureConfig.CHOOSE_REQUEST -> {
                    val selectList = PictureSelector.obtainMultipleResult(data)
                    iv_user_pic.setImageURI(Uri.parse(selectList[0].compressPath))
                }
            }
        }
    }
    private fun verifyStoragePermissions(activity: Activity?) {
        try {
            //检测是否有写的权限
            val permission = ActivityCompat.checkSelfPermission(
                activity!!,
                "android.permission.WRITE_EXTERNAL_STORAGE"
            )
            Log.v("sssss", "ssssssssssdsdsd ${permission != PackageManager.PERMISSION_GRANTED}")
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                Log.v("sssss", "ssssssssssdsdsd===========")
                ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
                )
            }else{
                takePicture()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    private fun takePicture() {
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofAll())
//            .loadImageEngine(GlideEngine.createGlideEngine())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                }
                override fun onCancel() {
                    // 取消
                }
            })
    }
}
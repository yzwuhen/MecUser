package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.ReleaseView
import com.example.mechanicalapp.ui.mvp.v.UpLoadFileView
import com.example.mechanicalapp.utils.StringUtils
import com.example.mechanicalapp.utils.ToastUtils
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File


open class UpdateFilePresenterImpl(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    var baseModel = ModelImpl()

    override fun request() {
    }

    fun upLoadFile(fileUrl: String){

        val file: File = File(fileUrl)

        if (!file.exists()){
            ToastUtils.showText("无法获取文件")
            return
        }

        //
     if (fileUrl.contains(".mp4")&&StringUtils.getRingDuring(fileUrl)>0){
        if (StringUtils.getRingDuring(fileUrl)>6000){
            ToastUtils.showText("只能上传不超过60s的视频")
            return
        }
     }

        val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

        baseView.showLoading()
        baseModel.upLoadFile(body, object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {
                (baseView as UpLoadFileView).showImg(t)
            }

            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
                (baseView as UpLoadFileView).uploadFail(e?.message.toString())
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        })
    }

    override fun onDestroy() {
    }
}
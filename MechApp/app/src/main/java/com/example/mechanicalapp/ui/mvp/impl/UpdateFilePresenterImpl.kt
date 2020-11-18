package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.ReleaseView
import com.example.mechanicalapp.ui.mvp.v.UpLoadFileView
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
        Log.v("sssssssssss","sssssssssssssssssssss${file.exists()}")
        val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

        baseView.showLoading()
        baseModel.upLoadFile(body, object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {
                (baseView as UpLoadFileView).showImg(t)
            }

            override fun onError(e: Throwable?) {
                Log.v("upLoadFile","=======upLoadFile=====${e}")
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
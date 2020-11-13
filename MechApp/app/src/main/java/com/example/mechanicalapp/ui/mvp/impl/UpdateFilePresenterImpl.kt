package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File


class UpdateFilePresenterImpl(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var baseModel = ModelImpl()


    override fun request() {
    }

    fun upLoadFile(fileUrl: String){

        val file: File = File(fileUrl)
        Log.e("yz_mec", "$fileUrl======File---===========$file")
        Log.e("yz_mec", "======File---===========${file.exists()}")
        val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

        baseModel.upLoadFile(body, object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {
            }

            override fun onError(e: Throwable?) {
                Log.e("yz_mec", "=================$e")
            }

            override fun onCompleted() {
            }
        })
    }

    override fun onDestroy() {
    }
}
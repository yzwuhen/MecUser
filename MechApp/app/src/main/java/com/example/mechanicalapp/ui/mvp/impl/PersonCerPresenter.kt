package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.ApplyInfoBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReCer
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.PersonCerView

class PersonCerPresenter(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) : UpdateFilePresenterImpl(mContext, baseView) {

    fun submitCer(mRePersonCer: ReCer){
        baseView.showLoading()
        baseModel.submitCer(App.getInstance().token,mRePersonCer, object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {
                (baseView as PersonCerView).success(t)
            }
            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
                baseView.err()
            }
            override fun onCompleted() {
                baseView.hiedLoading()
            }
        })
    }

    fun getApporve(type: String) {

        baseView.showLoading()
        baseModel.getApplyInfo(App.getInstance().token,type,App.getInstance().userInfo.username,NetSubscribe<ApplyInfoBean>(object :ISubscriberListener<ApplyInfoBean>{
            override fun onNext(t: ApplyInfoBean?) {
                (baseView as PersonCerView).success(t)
            }

            override fun onError(e: Throwable?) {
                Log.v("ssss","sssssssssssss=====$e")
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))
    }
}
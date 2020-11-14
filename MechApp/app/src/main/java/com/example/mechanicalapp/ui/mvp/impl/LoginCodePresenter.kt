package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.LoginCode
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.api.AppsApi
import com.example.mechanicalapp.ui.mvp.apps.AppService
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.LoginCodeView

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginCodePresenter(private var mContext: Context, private var baseView: LoginCodeView<NetData>) :
    BasePresenter {

    private var appsApi: AppsApi? = null
    private var appsService: AppService? = null

    init {

        appsApi = AppsApi()
        appsService = appsApi?.service
    }

    override fun request() {

    }

    fun loginCode(phone: String?, code: String?) {

        var mLoginCode = LoginCode()
        mLoginCode.captcha=code
        mLoginCode.mobile =phone
        appsService?.loginCode(mLoginCode)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LoginCodeBean>(object : ISubscriberListener<LoginCodeBean> {
                override fun onNext(t: LoginCodeBean?) {
                    if (t != null) {
                        baseView.loginSuccess(t)
                    }else{
                       baseView.LoginErr()
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.LoginErr()
                }

                override fun onCompleted() {
                }
            }))

    }

    override fun onDestroy() {

    }
}
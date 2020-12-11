package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.*
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.api.AppsApi
import com.example.mechanicalapp.ui.mvp.apps.AppService
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.LoginCodeView
import com.example.mechanicalapp.utils.ToastUtils

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody

//不写model了
class LoginCodePresenter(private var mContext: Context, private var baseView: LoginCodeView) :
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

        baseView.showLoading()
        var mLoginCode = LoginCode()
        mLoginCode.captcha=code
        mLoginCode.mobile =phone
        appsService?.loginCode(mLoginCode)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LoginCodeBean>(object : ISubscriberListener<LoginCodeBean> {
                override fun onNext(t: LoginCodeBean?) {
                    if (t != null) {
                        baseView.success(t)
                    }else{
                       baseView.loginErr("数据是空")
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                    baseView.loginErr(e?.message)
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            }))

    }
    fun loginPwd(phone: String?, code: String?) {

        baseView.showLoading()
        var mLoginCode = LoginCode()
        mLoginCode.password=code
        mLoginCode.mobile =phone
        appsService?.loginPwd(mLoginCode)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LoginCodeBean>(object : ISubscriberListener<LoginCodeBean> {
                override fun onNext(t: LoginCodeBean?) {
                    if (t != null) {
                        baseView.success(t)
                    }else{
                        baseView.loginErr("数据是空")
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                    baseView.loginErr(e?.message)
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            }))

    }
    override fun onDestroy() {

    }

    fun register(reRegister: ReRegister) {

        baseView.showLoading()
        appsService?.register(reRegister)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LoginCodeBean>(object : ISubscriberListener<LoginCodeBean> {
                override fun onNext(t: LoginCodeBean?) {
                    if (t != null) {
                        baseView.success(t)
                    }else{
                        baseView.loginErr("数据是空")
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                    baseView.loginErr(e?.message)
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            }))
    }

    fun loginThree(reLoginThree: ReLoginThree){
        baseView.showLoading()
        appsService?.loginThree(reLoginThree)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LoginCodeBean>(object : ISubscriberListener<LoginCodeBean> {
                override fun onNext(t: LoginCodeBean?) {
                    if (t != null) {
                        baseView.success(t)
                    }else{
                        baseView.loginErr("数据是空")
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                    baseView.loginErr(e?.message)
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            }))

    }

    fun bindPhone(reLoginThree: ReLoginThree?){
        baseView.showLoading()
        appsService?.bindThree(reLoginThree)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LoginCodeBean>(object : ISubscriberListener<LoginCodeBean> {
                override fun onNext(t: LoginCodeBean?) {
                    if (t != null) {
                        baseView.success(t)
                    }else{
                        baseView.loginErr("数据是空")
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                    baseView.loginErr(e?.message)
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            }))

    }
    fun resetPwd(resetPwd: ResetPwd) {

        baseView.showLoading()
        appsService?.resetPwd(App.getInstance().token,resetPwd)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LoginCodeBean>(object : ISubscriberListener<LoginCodeBean> {
                override fun onNext(t: LoginCodeBean?) {
                    if (t != null) {
                        baseView.success(t)
                    }else{
                        baseView.loginErr("操作失败")
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                    baseView.loginErr(e?.message)
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            }))
    }

    fun getMsgCode(requestBody: ReGetMsgCode) {

        baseView.showLoading()
        appsService?.getMsgCode(requestBody)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                   ToastUtils.showText(t?.message)

                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                    baseView.loginErr(e?.message)
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            }))
    }


}
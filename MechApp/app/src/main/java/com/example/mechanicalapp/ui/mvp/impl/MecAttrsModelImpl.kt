package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.api.AppsApi
import com.example.mechanicalapp.ui.mvp.apps.AppService
import com.example.mechanicalapp.ui.mvp.m.BaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MecAttrsModelImpl : BaseModel {


    private var appsApi: AppsApi? = null
    private var appsService: AppService? = null

    init {
        appsApi = AppsApi()
        appsService = appsApi?.service
    }


    fun getMecModelList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<NetData>) {

        Log.e("sssss============","sssssssss==============getMecModelList")
        appsService?.getMecModelList(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(mISubscriberListener))


    }
    fun getMecTypeList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<NetData>) {

        Log.e("sssss============","sssssssss==============getMecModelList")
        appsService?.getMecType(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(mISubscriberListener))


    }

    fun getMecBrandList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<NetData>) {

        Log.e("sssss============","sssssssss==============getMecModelList")
        appsService?.getMecBrandList(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(mISubscriberListener))


    }


    override fun initRequest() {


    }
}
package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
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


    fun getMecModelList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<MecModelBean>) {

        appsService?.getMecModelList(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecModelBean>(mISubscriberListener))


    }
    fun getMecTypeList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<MecTypeParentBean>) {

        appsService?.getMecParentType(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeParentBean>(mISubscriberListener))
    }

    fun getMecTypeChildList(pageIndex:Int,pageSize:Int,pid:String,mISubscriberListener: ISubscriberListener<MecTypeChildBean>) {

        appsService?.getMecChildType(pageIndex,pageSize,pid)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeChildBean>(mISubscriberListener))
    }

    fun getPartsModelList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<MecModelBean>) {

        appsService?.getPartsModelList(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecModelBean>(mISubscriberListener))


    }

    fun getPartsTypeList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<MecTypeParentBean>) {

        appsService?.getPartsParentType(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeParentBean>(mISubscriberListener))
    }

    fun getPartsTypeChildList(pageIndex:Int,pageSize:Int,pid:String,mISubscriberListener: ISubscriberListener<MecTypeChildBean>) {

        appsService?.getPartsChildType(pageIndex,pageSize,pid)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeChildBean>(mISubscriberListener))
    }




    fun getMecBrandList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<BrandBean>) {

        appsService?.getMecBrandList(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<BrandBean>(mISubscriberListener))


    }


    override fun initRequest() {


    }
}
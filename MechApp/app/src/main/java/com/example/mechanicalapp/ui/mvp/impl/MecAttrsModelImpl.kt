package com.example.mechanicalapp.ui.mvp.impl

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
    fun getMecTypeList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<MecTypeRootBean>) {

        appsService?.getMecParentType(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeRootBean>(mISubscriberListener))
    }



    fun getPartsModelList(pageIndex:Int,pageSize:Int,mISubscriberListener: ISubscriberListener<MecModelBean>) {

        appsService?.getPartsModelList(pageIndex,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecModelBean>(mISubscriberListener))


    }

    fun getPartType(token: String?, iSubscriberListener: ISubscriberListener<MecTypeBean>) {
        appsService?.getPartType(token)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeBean>(iSubscriberListener))

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
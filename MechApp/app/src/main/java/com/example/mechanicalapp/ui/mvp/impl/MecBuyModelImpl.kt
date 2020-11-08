package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MoreBusinessData
import com.example.mechanicalapp.ui.data.MoreLeaseData
import com.example.mechanicalapp.ui.data.MoreSellBean
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.api.AppsApi
import com.example.mechanicalapp.ui.mvp.apps.AppService
import com.example.mechanicalapp.ui.mvp.m.BaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MecBuyModelImpl : BaseModel {


    private var appsApi: AppsApi? = null
    private var appsService: AppService? = null

    init {
        appsApi = AppsApi()
        appsService = appsApi?.service
    }

    fun getSellList(type:Int,pageIndex:Int,pageSize:Int,brandId:String?,cateId:String?,modelId:String?,mISubscriberListener: ISubscriberListener<MoreSellBean>) {

        Log.e("sssss============","sssssssss==============getMecBuyList")
        appsService?.getSellList(type,pageIndex,pageSize,brandId,cateId,modelId)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreSellBean>(mISubscriberListener))


    }

    fun getMecBuyList(type:Int,pageIndex:Int,pageSize:Int,brandId:String?,cateId:String?,modelId:String?,mISubscriberListener: ISubscriberListener<MoreBusinessData>) {

        Log.e("sssss============","sssssssss==============getMecBuyList")
        appsService?.getMecBuyList(type,pageIndex,pageSize,brandId,cateId,modelId)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreBusinessData>(mISubscriberListener))


    }

    override fun initRequest() {


    }
}
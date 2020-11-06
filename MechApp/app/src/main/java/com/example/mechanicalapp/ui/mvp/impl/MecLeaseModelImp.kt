package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MoreLeaseData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.api.AppsApi
import com.example.mechanicalapp.ui.mvp.apps.AppService
import com.example.mechanicalapp.ui.mvp.m.BaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MecLeaseModelImp: BaseModel {


    private var appsApi: AppsApi? = null
    private var appsService: AppService? = null

    init {
        appsApi = AppsApi()
        appsService = appsApi?.service
    }



    fun getLeaseList(type:Int,pageIndex:Int,pageSize:Int,brandId:String?,cateId:String?,modelId:String?,mISubscriberListener: ISubscriberListener<MoreLeaseData>) {
        Log.e("sssss============","sssssssss==============getLeaseList")
        appsService?.getMecList(type,pageIndex,pageSize,brandId,cateId,modelId)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreLeaseData>(mISubscriberListener))


    }

    fun getPartsLeaseList(type:Int,pageIndex:Int,pageSize:Int,brandId:String?,cateId:String?,modelId:String?,mISubscriberListener: ISubscriberListener<MoreLeaseData>) {
        Log.e("sssss============","sssssssss==============getLeaseList")
        appsService?.getMecList(type,pageIndex,pageSize,brandId,cateId,modelId)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreLeaseData>(mISubscriberListener))


    }

    override fun initRequest() {


    }
}
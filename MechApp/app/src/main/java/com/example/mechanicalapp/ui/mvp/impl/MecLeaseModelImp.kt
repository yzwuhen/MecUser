package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MoreLeaseData
import com.example.mechanicalapp.ui.data.PartsBean
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



    //出租==求租
    fun getLeaseList(
                     type: Int,
                     pageIndex: Int,
                     pageSize: Int,
                     brandId: String?,
                     cateId: String?,
                     modelId: String?,
                     title: String?,
                     sort: Int,
                     mSGriceLe: String?,
                     mSPriceGe: String?,
                     mSTenancyGe: String?,
                     mSTenancyLe: String?,
                     mSWorkTimeGe: String?,
                     SWorkTimeLe: String?,
                     mISubscriberListener: ISubscriberListener<MoreLeaseData>) {
        appsService?.getMecList(type,pageIndex,pageSize,brandId,cateId,modelId,title)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreLeaseData>(mISubscriberListener))

    }


    fun getPartsLeaseList(type:Int,pageIndex:Int,pageSize:Int,cateId:String?,title:String?,mISubscriberListener: ISubscriberListener<PartsBean>) {
        appsService?.getPartsList(type,pageIndex,pageSize,cateId,title)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<PartsBean>(mISubscriberListener))


    }

    override fun initRequest() {


    }
}
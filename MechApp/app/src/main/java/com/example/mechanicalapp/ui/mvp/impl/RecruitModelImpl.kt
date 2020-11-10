package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.RecruitBean
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.api.AppsApi
import com.example.mechanicalapp.ui.mvp.apps.AppService
import com.example.mechanicalapp.ui.mvp.m.BaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RecruitModelImpl  : BaseModel {


    private var appsApi: AppsApi? = null
    private var appsService: AppService? = null

    init {
        appsApi = AppsApi()
        appsService = appsApi?.service
    }


    fun getRecruitList(type:Int,pageIndex:Int,pageSize:Int,region:String?,typeWork:String?,sort:String?,jobTitle:String?,mISubscriberListener: ISubscriberListener<RecruitBean>) {

        Log.e("sssss============","sssssssss==============getMecBuyList")
        appsService?.getRecruitList(pageIndex,pageSize,type.toString(),region,typeWork,sort,jobTitle)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<RecruitBean>(mISubscriberListener))


    }

    override fun initRequest() {


    }
}
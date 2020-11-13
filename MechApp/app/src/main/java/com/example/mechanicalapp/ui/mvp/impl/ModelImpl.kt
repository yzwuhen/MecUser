package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MoreFactoryBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecBusiness
import com.example.mechanicalapp.ui.data.request.ReMecLease
import com.example.mechanicalapp.ui.data.request.RePartsLease
import com.example.mechanicalapp.ui.data.request.ReWorkAbout
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.api.AppsApi
import com.example.mechanicalapp.ui.mvp.apps.AppService
import com.example.mechanicalapp.ui.mvp.m.BaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MultipartBody

class ModelImpl : BaseModel {


    private var appsApi: AppsApi? = null
    private var appsService: AppService? = null

    init {
        appsApi = AppsApi()
        appsService = appsApi?.service
    }


    override fun initRequest() {


    }

    fun getFactoryList(
        page: Int,
        pageSize: Int,
        mecType: String?,
        partType: String?,
        sort: String?,
        name: String?,
        iSubscriberListener: ISubscriberListener<MoreFactoryBean>
    ) {
        appsService?.getFactoryList(page, pageSize, mecType, partType, sort, name)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreFactoryBean>(iSubscriberListener))

    }

    fun addMecLease(mReMecLease: ReMecLease, iSubscriberListener: ISubscriberListener<NetData>) {
        appsService?.addMecLease(mReMecLease)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun addMecBusiness(
        mReMecBusiness: ReMecBusiness,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.addMecBusiness(mReMecBusiness)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }


    fun addPartsLease(
        mRePartsLease: RePartsLease,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.addPartsLease(mRePartsLease)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun addWorkAbout(mReWorkAbout: ReWorkAbout, iSubscriberListener: ISubscriberListener<NetData>) {
        appsService?.addWorkAbout(mReWorkAbout)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun upLoadFile(body: MultipartBody.Part, iSubscriberListener: ISubscriberListener<NetData>) {
        appsService?.uploadFile(body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
}
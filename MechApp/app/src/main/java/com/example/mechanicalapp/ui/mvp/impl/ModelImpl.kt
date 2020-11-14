package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.CodeBean
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


    fun getCode(code: String, iSubscriberListener: ISubscriberListener<CodeBean>) {
        appsService?.getCode(code)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<CodeBean>(iSubscriberListener))
    }
    //获取工种
    fun getWorkTypeList(
        page: Int,
        pageSize: Int,
        mecType: String?,
        partType: String?,
        sort: String?,
        name: String?,
        iSubscriberListener: ISubscriberListener<MoreFactoryBean>
    ) {
        appsService?.getWorkTypeList(page, pageSize, mecType, partType, sort, name)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreFactoryBean>(iSubscriberListener))

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

    fun addMecLease(
        mReMecLease: ReMecLease,
        token: String?,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.addMecLease(mReMecLease, token)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun addMecBusiness(
        mReMecBusiness: ReMecBusiness, token: String?,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.addMecBusiness(mReMecBusiness, token)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }


    fun addPartsLease(
        mRePartsLease: RePartsLease, token: String?,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.addPartsLease(mRePartsLease, token)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun addWorkAbout(
        mReWorkAbout: ReWorkAbout,
        token: String?,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.addWorkAbout(mReWorkAbout, token)
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

    fun getCollect(
        token: String,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.getCollectList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun getSecondCollect(
        token: String,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.getCollectSecondHandList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun getPartsCollect(
        token: String,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.getCollectPartsList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun getRecruitCollect(
        token: String,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.getCollectRecruitList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun getFactoryCollect(
        token: String,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.getCollectFactoryList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun getGoodsCollect(
        token: String,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.getCollectGoodsyList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
}
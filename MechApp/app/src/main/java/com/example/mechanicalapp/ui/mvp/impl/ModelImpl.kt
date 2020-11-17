package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.*
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
        iSubscriberListener: ISubscriberListener<MecTypeParentBean>
    ) {
        appsService?.getWorkTypeList(page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeParentBean>(iSubscriberListener))

    }

    //获取工种子级
    fun getWorkTypeChildList(
        page: Int,
        pageSize: Int,
        pid: String,
        iSubscriberListener: ISubscriberListener<MecTypeChildBean>
    ) {
        appsService?.getWorkTypeChildList(page, pageSize, pid)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeChildBean>(iSubscriberListener))

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


    fun addFactory(
        mReFactoryOrder: ReFactoryOrder, token: String?,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {
        appsService?.addFactoryOrder(mReFactoryOrder, token)
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
        token: String?,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<CollectLeaseBean>
    ) {
        appsService?.getCollectList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<CollectLeaseBean>(iSubscriberListener))
    }

    fun getSecondCollect(
        token: String?,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<CollectBusinessBean>
    ) {
        appsService?.getCollectSecondHandList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<CollectBusinessBean>(iSubscriberListener))
    }

    fun getPartsCollect(
        token: String?,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<CollectPartsBean>
    ) {
        appsService?.getCollectPartsList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<CollectPartsBean>(iSubscriberListener))
    }

    fun getRecruitCollect(
        token: String?,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<CollectRecruitBean>
    ) {
        appsService?.getCollectRecruitList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<CollectRecruitBean>(iSubscriberListener))
    }

    fun getFactoryCollect(
        token: String?,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<CollectFactoryBean>
    ) {
        appsService?.getCollectFactoryList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<CollectFactoryBean>(iSubscriberListener))
    }

    fun getGoodsCollect(
        token: String?,
        type: Int,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<CollectGoodsBean>
    ) {
        appsService?.getCollectGoodsList(token, type, page, pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<CollectGoodsBean>(iSubscriberListener))
    }

    fun delCollect(
        token: String?,
        ids: String?,
        iSubscriberListener: ISubscriberListener<NetData>
    ) {

        appsService?.delCollect(token, ids)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun getLeaseList(token: String?,type: Int,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<MoreLeaseData>){
        appsService?.getMyLeaseList(token,type,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreLeaseData>(iSubscriberListener))
    }

    fun getBusinessList(token: String?,type: Int,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<MoreLeaseData>){
        appsService?.getMyLeaseList(token,type,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreLeaseData>(iSubscriberListener))
    }


    fun refreshLease(token: String?,id: String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        appsService?.getRefreshLeaseList(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
    fun editLease(token: String?,id: String,isOn:String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        body.isOn =isOn
        appsService?.editLease(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }


    fun delLease(token: String?,id: String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        appsService?.delLease(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
}
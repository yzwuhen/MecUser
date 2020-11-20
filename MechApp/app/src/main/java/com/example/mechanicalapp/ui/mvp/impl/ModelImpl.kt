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

    fun getBusinessList(token: String?,type: Int,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<MoreSellBean>){
        appsService?.getMyBusinessList(token,type,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MoreSellBean>(iSubscriberListener))
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




    fun refreshBusiness(token: String?,id: String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        appsService?.getRefreshBusiness(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
    fun editBusiness(token: String?,id: String,isOn:String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        body.isOn =isOn
        appsService?.editBusiness(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }


    fun delBusiness(token: String?,id: String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        appsService?.delBusiness(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }


    fun getPartsList(token: String?,type: Int,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<PartsBean>){
        appsService?.getReleasePartsList(token,type,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<PartsBean>(iSubscriberListener))
    }

    fun refreshParts(token: String?,id: String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        appsService?.refreshParts(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
    fun editParts(token: String?,id: String,isOn:String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        body.isOn =isOn
        appsService?.editParts(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }


    fun delParts(token: String?,id: String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        appsService?.delParts(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }



    fun getWorkList(token: String?,type: Int,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<RecruitBean>){
        appsService?.getReleaseWorkList(token,type,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<RecruitBean>(iSubscriberListener))
    }

    fun refreshWork(token: String?,id: String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        appsService?.refreshWork(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
    fun editWork(token: String?,id: String,isOn:String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        body.isOn =isOn
        appsService?.editWork(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }


    fun delWork(token: String?,id: String,iSubscriberListener: ISubscriberListener<NetData>){
        var body=ReMyRelease()
        body.id =id
        appsService?.delWork(token,body)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }



    fun getLookLeaseList(token: String?,type: Int,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<MyLookLeaseBean>){
        appsService?.getLookLeaseList(token,type,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MyLookLeaseBean>(iSubscriberListener))
    }

    fun getLookSecondLeaseList(token: String?,type: Int,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<MyLookLeaseBean>){
        appsService?.getLookSecondLeaseList(token,type,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MyLookLeaseBean>(iSubscriberListener))
    }

    fun getLookPartsList(token: String?,type: Int,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<LookPartsBean>){
        appsService?.getLookParts(token,type,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LookPartsBean>(iSubscriberListener))
    }

    fun getLookRecruitList(token: String?,type: Int,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<LookRecruitBean>){
        appsService?.getLookRecruitList(token,type,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LookRecruitBean>(iSubscriberListener))
    }
    fun getLookFactoryList(token: String?,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<LookFactoryBean>){
        appsService?.getLookFactoryList(token,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LookFactoryBean>(iSubscriberListener))
    }
    fun getLookGoodsList(token: String?,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<LookGoodsBean>){
        appsService?.getLookGoodsList(token,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<LookGoodsBean>(iSubscriberListener))
    }



    fun getMyMecList(token: String?,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<MyLookLeaseBean>){
        appsService?.getMyMecList(token,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MyLookLeaseBean>(iSubscriberListener))
    }


    fun getAddressList(token: String?,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<NetData>){
        appsService?.getAddressList(token,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun getIntegral(token: String?, iSubscriberListener: ISubscriberListener<IntegralBean>) {

        appsService?.getIntegral(token)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<IntegralBean>(iSubscriberListener))
    }

    fun getIntegralList(
        token: String?,
        page: Int,
        pageSize: Int,
        iSubscriberListener: ISubscriberListener<IntegralListBean>
    ) {

        appsService?.getIntegralList(token,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<IntegralListBean>(iSubscriberListener))
    }

    fun signIntegral(token: String?, iSubscriberListener: ISubscriberListener<NetData>) {

        appsService?.signIntegral(token)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }

    fun submitCer(token: String?, mRePersonCer: ReCer, iSubscriberListener: ISubscriberListener<NetData>) {
        appsService?.submitCer(token,mRePersonCer)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))

    }


    fun getMecType(token: String?, iSubscriberListener: ISubscriberListener<MecTypeBean>) {
        appsService?.getMecType(token)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeBean>(iSubscriberListener))

    }
    fun getPartType(token: String?, iSubscriberListener: ISubscriberListener<MecTypeBean>) {
        appsService?.getPartType(token)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecTypeBean>(iSubscriberListener))

    }

    fun getLeaseDetails(token: String?,id: String?,iSubscriberListener: ISubscriberListener<MecDetailsBean>){
        appsService?.getLeaseDetails(token,id)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<MecDetailsBean>(iSubscriberListener))
    }

    fun getBusinessDetails(token: String?,id: String?,iSubscriberListener: ISubscriberListener<BusinessDetailsBean>){
        appsService?.getBusinessDetails(token,id)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<BusinessDetailsBean>(iSubscriberListener))
    }


    fun getGoodsDetails(token: String?,id: String?,iSubscriberListener: ISubscriberListener<GoodsDetailsBean>){
        appsService?.getGoodsDetail(token,id)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<GoodsDetailsBean>(iSubscriberListener))
    }

    fun getComment(token: String?,id: String?,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<NetData>){
        appsService?.getComment(token,id,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
    fun getCommentGoods(token: String?,id: String?,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<NetData>){
        appsService?.getCommentGoods(token,id,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
    fun getCommentMiddle(token: String?,id: String?,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<NetData>){
        appsService?.getCommentMiddle(token,id,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
    fun getCommentBad(token: String?,id: String?,page: Int,pageSize: Int,iSubscriberListener: ISubscriberListener<NetData>){
        appsService?.getCommentBad(token,id,page,pageSize)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }


    fun addCollect(token: String?,recollect: ReCollect,iSubscriberListener: ISubscriberListener<NetData>){
        appsService?.addCollect(token,recollect)
            ?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )?.subscribe(NetSubscribe<NetData>(iSubscriberListener))
    }
}
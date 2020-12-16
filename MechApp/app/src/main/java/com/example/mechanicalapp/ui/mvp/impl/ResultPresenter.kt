package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.amap.api.location.DPoint
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView

class ResultPresenter (
    private var baseView: NetDataView<NetData>
) :
    BasePresenter {


    private var baseModel: ModelImpl? = null
    private var page: Int = 1
    private var pageSize: Int = 30
    private var brandId: String? = null
    private var cateId: String? = null
    private var modelId: String? = null
    private var title: String? = null

    private var mSGriceLe :String ?=null
    private var mSPriceGe:String ?=null

    private var mSTenancyGe:String ?=null
    private var mSTenancyLe:String ?=null

    private var mSWorkTimeGe:String ?=null
    private var mSWorkTimeLe:String ?=null
    private var isMap:String ?=null
    private var sort=0

    private var lon :String?=null
    private var lat:String?=null

    private var type :String?=null

    private var repaireType:String?=null//机械类型 （维修类型）
    private var  componentType:String?=null //配件类型

    private var city: String? = null
    private var typeWork: String? = null
    private var typeWorkId:String?=null

    init {
        baseModel = ModelImpl()
    }

    override fun request() {

    }

    fun getLeaseList(types:String?) {
        baseView.showLoading()
        type =types
        baseModel?.getLeaseList(type,
            page,
            pageSize,
            brandId,
            cateId,
            modelId,
            title,
            sort,
            mSGriceLe,
            mSPriceGe,
            mSTenancyGe,
            mSTenancyLe,
            mSWorkTimeGe,
            mSWorkTimeLe,
            isMap,
            lat,
            lon,
            object : ISubscriberListener<MoreLeaseData> {
                override fun onNext(t: MoreLeaseData?) {
                    if (t?.code == 200 && t.result != null) {
                        if (page==1){
                            baseView.refreshUI(t)
                        }else{
                            baseView.loadMore(t)
                        }
                    } else {
                        baseView.err()
                    }
                    page++
                }
                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    fun getSellList(types:String?) {
        type =types
        baseView.showLoading()
        baseModel?.getSellList(type,
            page,
            pageSize,
            brandId,
            cateId,
            modelId,
            title,
            sort,
            mSGriceLe,
            mSPriceGe,
            mSTenancyGe,
            mSTenancyLe,
            mSWorkTimeGe,
            mSWorkTimeLe,
            isMap,
            lat,
            lon,
            object : ISubscriberListener<MoreSellBean> {
                override fun onNext(t: MoreSellBean?) {
                    if (t?.code == 200 && t.result != null) {
                        if (t?.code == 200 && t.result != null) {
                            if (page==1){
                                baseView.refreshUI(t)
                            }else{
                                baseView.loadMore(t)
                            }
                        } else {
                            baseView.err()
                        }
                        page++
                    } else {
                        baseView.err()
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    fun getPartsLeaseList(types: String?) {
        type =types
        baseModel?.getPartsLeaseList(type,
            page,
            pageSize,
            cateId,
            title,
            sort,
            isMap,
            lat,
            lon,
            object : ISubscriberListener<PartsBean> {
                override fun onNext(t: PartsBean?) {
                    if (t?.code == 200 && t.result != null) {
                        if (page==1){
                            baseView.refreshUI(t)
                        }else{
                            baseView.loadMore(t)
                        }
                    } else {
                        baseView.err()
                    }
                    page++
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getFactoryList() {

        baseView.showLoading()
        baseModel?.getFactoryList(
            page,
            pageSize,
            repaireType,
            componentType,
            sort.toString(),
            title,
            isMap,
            lat,
            lon,
            object : ISubscriberListener<MoreFactoryBean> {
                override fun onNext(t: MoreFactoryBean?) {
                    if (t?.code == 200 && t.result != null) {
                        if (page==1){
                            baseView.refreshUI(t)
                        }else{
                            baseView.loadMore(t)
                        }
                        page++
                    } else {
                        baseView.err()
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    fun getRecruitList(type:String?) {

        baseModel?.getRecruitList(type,
            page,
            pageSize,
            city,
            typeWork,
            typeWorkId,
            sort,
            title,
            isMap,
            lat,
            lon,
            object : ISubscriberListener<RecruitBean> {
                override fun onNext(t: RecruitBean?) {
                    if (t?.code == 200 && t.result != null) {
                        if (page==1){
                            baseView.refreshUI(t)
                        }else{
                            baseView.loadMore(t)
                        }
                        page++
                    } else {
                        baseView.err()
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }
    fun getEngList() {
        baseView.showLoading()
        baseModel?.getEng(App.getInstance().token, title,page,pageSize ,NetSubscribe<EngListBean>(object :
            ISubscriberListener<EngListBean> {
            override fun onNext(t: EngListBean?) {
                if (t?.code == 200 && t.result != null) {
                    if (page==1){
                        baseView.refreshUI(t)
                    }else{
                        baseView.loadMore(t)
                    }
                    page++
                } else {
                    baseView.err()
                }
            }

            override fun onError(e: Throwable?) {
                Log.v("ssss", "sss=========$e")
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))
    }

    override fun onDestroy() {
    }


    fun setLocation(thisPoint: DPoint) {
        this.lat =thisPoint.latitude.toString()
        this.lon =thisPoint.longitude.toString()
        resetPage()
    }

    fun resetPage(){
        page=1
    }
    fun setTitle(s: String?) {
        this.title =s
        resetPage()
        //这个不能在这里设置请求  搜索的时候根据title 搜索的对应页面请求不一样 其它的不会发生冲突
       // getLeaseList(type)
    }
    fun setBrandId(id:String?){
        if (id==""){
            this.brandId=null
        }else{
            this.brandId =id
        }
        resetPage()
    }
    fun setSort(int: Int){
        sort =int
        resetPage()
    }

    fun setCateId(id:String?){
        if (id==""){
            this.cateId=null
        }else{
            this.cateId =id
        }
        resetPage()
    }
    fun setModelId(id:String?){
        if (id==""){
            this.modelId=null
        }else{
            this.modelId =id
        }
        resetPage()
    }
    fun setPriceQJ(startPrice:String?,endPrice:String?){
        mSGriceLe =endPrice
        mSPriceGe =startPrice
        resetPage()
    }

    fun setJL(startJL:String?,endJL:String?){
        mSTenancyLe =endJL
        mSTenancyGe =startJL
        resetPage()
    }
    fun setWorkTime(startWork:String?,endWork:String?){
        mSWorkTimeLe =endWork
        mSWorkTimeGe =startWork
        resetPage()
    }

    fun setRepaireType(mecType:String?){
        repaireType =mecType
        resetPage()
    }
    fun setComponentType(partsType:String?){
        componentType =partsType
        resetPage()
    }

    fun setIsMap() {
        isMap ="1"
    }
    fun workType(type:String?,id:String?){
        typeWork =type
        typeWorkId =id
        resetPage()
    }
    fun setCity(str:String?){
        city =str
        resetPage()
    }

    fun getHotCode() {
        baseView.showLoading()
        baseModel?.getHotCode(NetSubscribe(object :ISubscriberListener<HotCodeBean>{
            override fun onNext(t: HotCodeBean?) {
                baseView.refreshUI(t)
            }

            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))

    }

}
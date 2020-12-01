package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
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

    private var sort=0

    private var lon=0.0
    private var lat=0.0

    private var type=1

    init {
        baseModel = ModelImpl()
    }

    override fun request() {

    }

    fun getLeaseList(types:Int) {
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
            object : ISubscriberListener<MoreLeaseData> {
                override fun onNext(t: MoreLeaseData?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page==1){
                            baseView.refreshUI(t)
                        }else{
                            baseView.loadMore(t)
                        }
                    } else {
                        baseView?.err()
                    }
                    page++
                }
                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                    baseView?.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    fun getSellList(types:Int) {
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
            object : ISubscriberListener<MoreSellBean> {
                override fun onNext(t: MoreSellBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (t?.code == 200 && t?.result != null) {
                            if (page==1){
                                baseView.refreshUI(t)
                            }else{
                                baseView.loadMore(t)
                            }
                        } else {
                            baseView?.err()
                        }
                        page++
                    } else {
                        baseView?.err()
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    fun getPartsLeaseList(types: Int) {
        type =types
        baseModel?.getPartsLeaseList(type,
            page,
            pageSize,
            cateId,
            title,
            sort,
            object : ISubscriberListener<PartsBean> {
                override fun onNext(t: PartsBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page==1){
                            baseView.refreshUI(t)
                        }else{
                            baseView.loadMore(t)
                        }
                    } else {
                        baseView?.err()
                    }
                    page++
                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                    baseView?.hiedLoading()
                }

                override fun onCompleted() {
                    baseView?.hiedLoading()
                }
            })
    }

    fun getFactoryList() {

        baseView.showLoading()
        baseModel?.getFactoryList(
            page,
            pageSize,
            null,
            null,
            sort.toString(),
            title,
            object : ISubscriberListener<MoreFactoryBean> {
                override fun onNext(t: MoreFactoryBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page==1){
                            baseView.refreshUI(t)
                        }else{
                            baseView.loadMore(t)
                        }
                        page++
                    } else {
                        baseView?.err()
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    fun getRecruitList(type:Int) {

        baseModel?.getRecruitList(type,
            page,
            pageSize,
            null,
            null,
            null,
            sort,
            title,
            object : ISubscriberListener<RecruitBean> {
                override fun onNext(t: RecruitBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page==1){
                            baseView.refreshUI(t)
                        }else{
                            baseView.loadMore(t)
                        }
                        page++
                    } else {
                        baseView?.err()
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    override fun onDestroy() {
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

}
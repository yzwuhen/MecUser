package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MoreLeaseData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.MecLeaseView

class MecLeaseListPresenter(
    private var mContext: Context,
    private var baseView: MecLeaseView<NetData>
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


    private var type :String?=null

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
            null,null,null,
            object : ISubscriberListener<MoreLeaseData> {
                override fun onNext(t: MoreLeaseData?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page==1){
                            t?.result?.records?.let { baseView?.refreshUI(it) }
                            baseView?.hiedLoading()
                        }else{
                            t?.result?.records?.let { baseView?.loadMore(it) }
                            baseView?.hiedLoading()
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

    //求租
    fun getRentList(type:String) {
        baseView.showLoading()
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
            null,null,null,
            object : ISubscriberListener<MoreLeaseData> {
                override fun onNext(t: MoreLeaseData?) {
                    if (t?.code == 200 && t?.result != null) {
                        t?.result?.records?.let { baseView?.refreshUI(it) }
                        baseView?.hiedLoading()
                    } else {
                        baseView?.err()
                    }

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


    override fun onDestroy() {
    }

    fun resetPage(){
        page=1
    }
    fun setTitle(s: String?) {
        this.title =s
        resetPage()
        getLeaseList(type)
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
        getLeaseList(type)
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
        getLeaseList(type)
    }

    fun setJL(startJL:String?,endJL:String?){
        mSTenancyLe =endJL
        mSTenancyGe =startJL
        resetPage()
        getLeaseList(type)
    }
    fun setWorkTime(startWork:String?,endWork:String?){
        mSWorkTimeLe =endWork
        mSWorkTimeGe =startWork
        resetPage()
        getLeaseList(type)
    }

}
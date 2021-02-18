package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MoreLeaseData
import com.example.mechanicalapp.ui.data.MoreSellBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReScreenData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.MecSellView

class SellPresenter (
    private var mContext: Context,
    private var baseView: MecSellView<NetData>
) :
    BasePresenter {


    private var baseModel: MecBuyModelImpl? = null
    private var page: Int = 1
    private var pageSize: Int = 30
    private var brandId: String? = null
    private var cateId: String? = null
    private var modelId: String? = null
    private var title:String?=null


    private var mSGriceLe :String ?=null
    private var mSPriceGe:String ?=null

    private var mSTenancyGe:String ?=null
    private var mSTenancyLe:String ?=null

    private var mSWorkTimeGe:String ?=null
    private var mSWorkTimeLe:String ?=null

    private var sort=0

    private var lon=0.0
    private var lat=0.0

    private var type:String?=null

    init {
        baseModel = MecBuyModelImpl()
    }

    override fun request() {

    }

    fun getSellList(types:String?) {
        type =types
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
                        t?.result?.records?.let { baseView?.refreshUI(it) }
                        baseView?.hiedLoading()
                    } else {
                        baseView?.err()
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                }

                override fun onCompleted() {
                }
            })
    }
    fun resetPage(){
        page=1
    }
    fun setTitle(s: String?) {
        this.title =s
    }
    fun setBrandId(id:String?){
        if (id==""){
            this.brandId=null
        }else{
            this.brandId =id
        }
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

    fun setScreen(reScreenData: ReScreenData?){
        if (reScreenData!=null){
            mSGriceLe =reScreenData?.priceStart
            mSPriceGe =reScreenData?.priceEnd
            mSTenancyLe =reScreenData?.engAgeStart
            mSTenancyGe =reScreenData?.engAgeEnd
            mSWorkTimeLe =reScreenData?.workTimeStart
            mSWorkTimeGe =reScreenData?.workTimeEnd
        }else{
            mSGriceLe =null
            mSPriceGe =null
            mSTenancyLe =null
            mSTenancyGe =null
            mSWorkTimeLe =null
            mSWorkTimeGe =null
        }
        resetPage()
        getSellList(type)
    }
//    fun setPriceQJ(startPrice:String?,endPrice:String?){
//        mSGriceLe =endPrice.toString()
//        mSPriceGe =startPrice.toString()
//        resetPage()
//        getSellList(type)
//    }
//
//    fun setJL(startJL:String?,endJL:String?){
//        mSTenancyLe =endJL
//        mSTenancyGe =startJL
//        resetPage()
//        getSellList(type)
//    }
//    fun setWorkTime(startWork:String?,endWork:String?){
//        mSWorkTimeLe =endWork
//        mSWorkTimeGe =startWork
//        resetPage()
//        getSellList(type)
//    }

    override fun onDestroy() {
    }
}
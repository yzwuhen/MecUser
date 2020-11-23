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


    private var baseModel: MecLeaseModelImp? = null
    private var page: Int = 1
    private var pageSize: Int = 30
    private var brandId: String? = null
    private var cateId: String? = null
    private var modelId: String? = null
    private var title: String? = null
    init {
        baseModel = MecLeaseModelImp()
    }

    override fun request() {

    }

    fun getLeaseList(type:Int) {

        baseModel?.getLeaseList(type,
            page,
            pageSize,
            brandId,
            cateId,
            modelId,
            title,
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
                    baseView?.err()
                }

                override fun onCompleted() {
                }
            })
    }

    //求租
    fun getRentList(type:Int) {

        baseModel?.getLeaseList(type,
            page,
            pageSize,
            brandId,
            cateId,
            modelId,
            title,
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
                    baseView?.err()
                }

                override fun onCompleted() {
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

}
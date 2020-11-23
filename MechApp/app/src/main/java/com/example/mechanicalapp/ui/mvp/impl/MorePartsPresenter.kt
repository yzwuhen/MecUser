package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsBean
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.MorePartsLeaseView

class MorePartsPresenter(
    private var mContext: Context,
    private var baseView: MorePartsLeaseView<NetData>
) :
    BasePresenter {


    private var baseModel: MecLeaseModelImp? = null
    private var page: Int = 1
    private var pageSize: Int = 30
    private var cateId: String? = null
    private var title: String? = null

    init {
        baseModel = MecLeaseModelImp()
    }

    override fun request() {

    }

    fun getPartsLeaseList(type: Int) {

        baseModel?.getPartsLeaseList(type,
            page,
            pageSize,
            cateId,
            title,
            object : ISubscriberListener<PartsBean> {
                override fun onNext(t: PartsBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page==1){
                            t?.result?.records?.let { baseView?.refreshUI(it) }
                        }else{
                            t?.result?.records?.let { baseView?.loadMore(it) }
                        }
                        baseView?.hiedLoading()
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

    fun resetPage(){
        page=1
    }
    fun setTitle(s: String?) {
        this.title =s
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

    override fun onDestroy() {
    }
}
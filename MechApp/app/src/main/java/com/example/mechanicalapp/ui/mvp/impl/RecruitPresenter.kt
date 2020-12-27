package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.amap.api.location.DPoint
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.RecruitBean
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.WorkAboutView

class RecruitPresenter (
    private var mContext: Context,
    private var baseView: WorkAboutView
) :
    BasePresenter {

    private var baseModel: RecruitModelImpl? = null
    private var page: Int = 1
    private var pageSize: Int = 30
    private var city: String? = null
    private var typeWork: String? = null
    private var typeWorkId:String?=null
    private var sort: Int=0
    private var jobTitle:String?=null
    private var lon :String?=null
    private var lat:String?=null

    init {
        baseModel = RecruitModelImpl()
    }

    override fun request() {

    }

    fun getRecruitList(type:Int) {

        baseModel?.getRecruitList(type,
            page,
            pageSize,
            city,
            typeWork,
            typeWorkId,
            sort,
            jobTitle,
            object : ISubscriberListener<RecruitBean> {
                override fun onNext(t: RecruitBean?) {
                   if (t?.code == 200 && t?.result != null) {
                        t?.result?.records?.let { baseView?.refreshRecruitUI(it) }
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

    fun workType(type:String?,id:String?){
        typeWork =type
        typeWorkId =id
        resetPage()
    }
    fun setCity(str:String?){
        city =str
        resetPage()
    }


    fun setTitle(s:String){
        this.jobTitle = s
        resetPage()
    }
    fun resetPage(){
        page=1
    }

    override fun onDestroy() {
    }

    fun setScreen(position: Int) {
        sort =position
        resetPage()
    }
}
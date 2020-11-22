package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
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
    private var region: String? = null
    private var typeWork: String? = null
    private var sort: String? = null
    private var jobTitle:String?=null

    init {
        baseModel = RecruitModelImpl()
    }

    override fun request() {

    }

    fun getRecruitList(type:Int) {

        baseModel?.getRecruitList(type,
            page,
            pageSize,
            region,
            typeWork,
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

    fun setTitle(s:String){
        this.jobTitle = s
    }

    override fun onDestroy() {
    }
}
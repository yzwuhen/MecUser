package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.WorkAboutView

class RecruitPresenter (
    private var mContext: Context,
    private var baseView: WorkAboutView
) :
    BasePresenter {


    private var baseModel: RecruitModelImpl? = null
    private var page: Int = 0
    private var pageSize: Int = 30
    private var region: String? = null
    private var typeWork: String? = null
    private var sort: String? = null

    init {
        baseModel = RecruitModelImpl()
    }

    override fun request() {

    }

    fun getRecruitList() {

        baseModel?.getRecruitList(
            page,
            pageSize,
            region,
            typeWork,
            sort,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
//                  /  if (t?.code == 200 && t?.result != null) {
//                    //    t?.result?.records?.let { baseView?.refreshUI(it) }
//                    //    baseView?.hiedLoading()
//                    } else {
//                //        baseView?.err()
//                    }

                }

                override fun onError(e: Throwable?) {
               //     baseView?.err()
                    Log.e("sssss============", "sssssssss==============onError$e")
                }

                override fun onCompleted() {
                }
            })
    }

    fun getWantWorkList() {

        baseModel?.getWantWorkList(
            page,
            pageSize,
            region,
            typeWork,
            sort,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
//                  /  if (t?.code == 200 && t?.result != null) {
//                    //    t?.result?.records?.let { baseView?.refreshUI(it) }
//                    //    baseView?.hiedLoading()
//                    } else {
//                //        baseView?.err()
//                    }

                }

                override fun onError(e: Throwable?) {
                    //     baseView?.err()
                    Log.e("sssss============", "sssssssss==============onError$e")
                }

                override fun onCompleted() {
                }
            })
    }

    override fun onDestroy() {
    }
}
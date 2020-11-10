package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MoreFactoryBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.FactoryView

class FactoryPresenter(
    private var mContext: Context,
    private var baseView: FactoryView
) :
    BasePresenter {


    private var baseModel: ModelImpl? = null
    private var page: Int = 0
    private var pageSize: Int = 30
    private var mecType: String? = null
    private var partsType: String? = null
    private var sort: String? = null

    init {
        baseModel = ModelImpl()
    }

    override fun request() {

    }

    fun getFactoryList() {

        baseModel?.getFactoryList(
            page,
            pageSize,
            mecType,
            partsType,
            sort,
            object : ISubscriberListener<MoreFactoryBean> {
                override fun onNext(t: MoreFactoryBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        t?.result?.records?.let { baseView?.refreshUI(it) }
                        baseView?.hiedLoading()
                    } else {
                        baseView?.err()
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                    Log.e("sssss============", "sssssssss==============onError$e")
                }

                override fun onCompleted() {
                }
            })
    }

    override fun onDestroy() {
    }
}
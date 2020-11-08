package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.MecAtrrsView

class MecModelPresenter  (
    private var mContext: Context,
    private var baseView: MecAtrrsView<NetData>
) :
    BasePresenter {


    private var baseModel: MecAttrsModelImpl? = null
    private var page: Int = 0
    private var pageSize: Int = 30

    init {
        baseModel = MecAttrsModelImpl()
    }

    override fun request() {

    }

    fun getMecModelList() {

        baseModel?.getMecModelList(
            page,
            pageSize,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
//                        if (t?.code == 200 && t?.result != null) {
//                            t?.result?.records?.let { baseView?.refreshUI(it) }
//                            baseView?.hiedLoading()
//                        } else {
//                            baseView?.err()
//                        }

                }
                override fun onError(e: Throwable?) {
                    //     baseView?.err()
                    Log.e("sssss============", "sssssssss==============onError$e")
                }

                override fun onCompleted() {
                }
            })
    }
    fun getMecTypeList() {

        baseModel?.getMecTypeList(
            page,
            pageSize,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
//                        if (t?.code == 200 && t?.result != null) {
//                            t?.result?.records?.let { baseView?.refreshUI(it) }
//                            baseView?.hiedLoading()
//                        } else {
//                            baseView?.err()
//                        }

                }
                override fun onError(e: Throwable?) {
                    //     baseView?.err()
                    Log.e("sssss============", "sssssssss==============onError$e")
                }

                override fun onCompleted() {
                }
            })
    }
    fun getMecBrandList() {

        baseModel?.getMecBrandList(
            page,
            pageSize,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
//                        if (t?.code == 200 && t?.result != null) {
//                            t?.result?.records?.let { baseView?.refreshUI(it) }
//                            baseView?.hiedLoading()
//                        } else {
//                            baseView?.err()
//                        }

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
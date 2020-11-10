package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.MecAttrsView
import com.example.mechanicalapp.ui.mvp.v.MecTypeView

class MecModelPresenter(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
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
            object : ISubscriberListener<MecTypeParentBean> {
                override fun onNext(t: MecTypeParentBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        t?.result?.records?.let {
                            (baseView as MecTypeView<BaseData>)?.refreshLeftUI(
                                it
                            )
                        }
                        if (t?.result?.records?.size!! >0){
                            t?.result?.records?.get(0)?.pid?.let { getMecTypeChildList(it) }
                        }

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


    fun getMecTypeChildList(pid: String) {

        baseModel?.getMecTypeChildList(
            page,
            pageSize,
            pid,
            object : ISubscriberListener<MecTypeChildBean> {
                override fun onNext(t: MecTypeChildBean?) {
                        if (t?.code == 200 && t?.result != null) {

                            t?.result?.records?.let {
                                (baseView as MecTypeView<BaseData>)?.refreshRightUI(
                                    it
                                )
                            }

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
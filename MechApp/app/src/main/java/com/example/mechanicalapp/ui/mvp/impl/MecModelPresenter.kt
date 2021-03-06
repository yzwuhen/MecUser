package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.MecAttrsView
import com.example.mechanicalapp.ui.mvp.v.MecTypeView
import com.example.mechanicalapp.ui.mvp.v.NetDataView

class MecModelPresenter(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    BasePresenter {


    private var baseModel: MecAttrsModelImpl? = null
    private var page: Int = 1
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
            object : ISubscriberListener<MecModelBean> {
                override fun onNext(t: MecModelBean?) {
                        if (t?.code == 200 && t?.result != null) {
                            t?.result?.records?.let { (baseView as MecAttrsView<MecModelData>)?.refreshUI(it) }
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

    fun getMecTypeList() {
        baseView?.showLoading()
        baseModel?.getMecTypeList(
            page,
            pageSize,
            object : ISubscriberListener<MecTypeRootBean> {
                override fun onNext(t: MecTypeRootBean?) {
                        (baseView as NetDataView<NetData>).refreshUI(t)
                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                    baseView?.hiedLoading()
                }

                override fun onCompleted() {
                    baseView?.hiedLoading()
                }
            })
    }

//
//    fun getMecTypeChildList(pid: String) {
//
//        baseModel?.getMecTypeChildList(
//            page,
//            pageSize,
//            pid,
//            object : ISubscriberListener<MecTypeChildBean> {
//                override fun onNext(t: MecTypeChildBean?) {
//                    if (t?.code == 200 && t?.result != null) {
//
//                        t?.result?.records?.let {
//                            (baseView as MecTypeView<BaseData>)?.refreshRightUI(
//                                it
//                            )
//                        }
//
//                        baseView?.hiedLoading()
//                    } else {
//                        baseView?.err()
//                    }
//                }
//
//                override fun onError(e: Throwable?) {
//                    baseView?.err()
//                }
//
//                override fun onCompleted() {
//                }
//            })
//    }


    fun getMecBrandList() {
        baseModel?.getMecBrandList(
            page,
            pageSize,
            object : ISubscriberListener<BrandBean> {
                override fun onNext(t: BrandBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        t?.result?.records?.let { (baseView as MecAttrsView<BrandData>)?.refreshUI(it) }
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
}
package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.MecAttrsView
import com.example.mechanicalapp.ui.mvp.v.MecTypeView

class PartsTypePresenter(
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


    fun getPartsModelList() {

        baseModel?.getPartsModelList(
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


    fun getPartsTypeList() {
        baseModel?.getPartsTypeList(
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
                        if (t?.result?.records?.size!! > 0) {
                            t?.result?.records?.get(0)?.id?.let { getPartsTypeChildList(it) }
                        }

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


    fun getPartsTypeChildList(pid: String) {

        baseModel?.getPartsTypeChildList(
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
                }

                override fun onCompleted() {
                }
            })
    }

    override fun onDestroy() {
    }
}
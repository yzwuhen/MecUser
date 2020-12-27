package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.MecAttrsView
import com.example.mechanicalapp.ui.mvp.v.MecTypeView
import com.example.mechanicalapp.ui.mvp.v.TypeView

class PartsTypePresenter(
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
        baseView.showLoading()
        baseModel?.getPartType(App.getInstance().token,object :
            ISubscriberListener<MecTypeBean> {
            override fun onNext(t: MecTypeBean?) {
                (baseView as TypeView<MecTypeBean>).refreshLeftUI(t)
            }
            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
                baseView.err()
            }
            override fun onCompleted() {
                baseView.hiedLoading()
            }
        })
    }



    override fun onDestroy() {
    }
}
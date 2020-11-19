package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MecLeaseData
import com.example.mechanicalapp.ui.data.MyLookLeaseBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.MyReleaseView

class DetailsPresenter (
    private var baseView: BaseView<NetData>
): BasePresenter {
    private var baseModel = ModelImpl()

    override fun request() {

    }
    fun getLeaseDetails(id: String?) {
        baseView.showLoading()
        baseModel.getLeaseDetails(
            App.getInstance().token,
            id,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }

    override fun onDestroy() {
    }
}
package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsOrderDetailsBean
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.mvp.v.OrderView

/**
 * 配件订单详情
 */
class OrderDetailsPresenter(
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    var baseModel = ModelImpl()
    override fun request() {

    }

    //获取配件订单详情
    fun getPartsOrderDetails(orderId: String) {
        baseView.showLoading()
        baseModel.getPartsOrderDetails(
            App.getInstance().token,
            orderId,
            NetSubscribe<PartsOrderDetailsBean>(object :
                ISubscriberListener<PartsOrderDetailsBean> {
                override fun onNext(t: PartsOrderDetailsBean?) {
                    (baseView as NetDataView<NetData>).refreshUI(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
        )

    }


    override fun onDestroy() {
    }

    fun cancelPartsOrder(orderId: String) {
        baseView.hiedLoading()
        baseModel.cancelPartsOrder(
            App.getInstance().token,
            orderId,
            NetSubscribe<NetData>(object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as NetDataView<NetData>).refreshUI(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
        )
    }
}
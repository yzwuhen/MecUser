package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.OrderView
import com.example.mechanicalapp.ui.mvp.v.ReleaseView

class OrderPresenter(
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var page: Int = 1
    private var pageSize: Int = 30
    var baseModel = ModelImpl()

    fun getOrderList(state: String) {
        baseModel.getOrderList(
            App.getInstance().token,
            state,
            page,
            pageSize,
            NetSubscribe<OrderBean>(object :
                ISubscriberListener<OrderBean> {
                override fun onNext(t: OrderBean?) {
                    if (page == 1) {
                        (baseView as OrderView<OrderBean>).showData(t)
                    } else {
                        (baseView as OrderView<OrderBean>).showDataMore(t)
                    }
                    page++
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

    //订单菜单
    fun getOrderTv() {
        baseModel.getCode("mec_repair_order_status",
            object : ISubscriberListener<CodeBean> {
                override fun onNext(t: CodeBean?) {
                    if (t?.code == 200) {
                        (baseView as OrderView<NetData>).showData(t)
                    }
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    fun getPartsOrderList(state: String) {
        baseModel.getPartsOrderList(
            App.getInstance().token,
            state,
            page,
            pageSize,
            NetSubscribe<OrderBean>(object :
                ISubscriberListener<OrderBean> {
                override fun onNext(t: OrderBean?) {
                    if (page == 1) {
                        (baseView as OrderView<OrderBean>).showData(t)
                    } else {
                        (baseView as OrderView<OrderBean>).showDataMore(t)
                    }
                    page++
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

    override fun request() {
    }

    override fun onDestroy() {
    }

    fun resetPage() {
        page = 1
    }

    fun getOrderDetails(orderId: String) {
        baseModel.getOrderDetails(
            App.getInstance().token,
            orderId,
            NetSubscribe<OrderDetailsBean>(object : ISubscriberListener<OrderDetailsBean> {
                override fun onNext(t: OrderDetailsBean?) {
                    (baseView as OrderView<NetData>).showData(t)
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
        )

    }

    fun cancelOrder(orderId: String) {
        baseModel.cancelOrder(
            App.getInstance().token,
            orderId,
            NetSubscribe<NetData>(object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as OrderView<NetData>).showData(t)
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
        )

    }
}
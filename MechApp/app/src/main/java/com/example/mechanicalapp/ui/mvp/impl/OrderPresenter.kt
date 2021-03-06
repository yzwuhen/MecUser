package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReExpress
import com.example.mechanicalapp.ui.data.request.RePay
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.mvp.v.OrderView
import com.example.mechanicalapp.ui.mvp.v.ReleaseView

/**
 * 都是维修订单
 *
 * 不改了=。= 写两套
 */
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
            null,
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
        baseView.showLoading()
        var type:String?=null
        type = if (state=="0"){
            null
        }else{
            state
        }
        baseModel.getPartsOrderList(
            App.getInstance().token,
            App.getInstance().userInfo.username,
            type,
            page,
            pageSize,
            NetSubscribe<PartOrderListBean>(object :
                ISubscriberListener<PartOrderListBean> {
                override fun onNext(t: PartOrderListBean?) {
                    if (page == 1) {
                        (baseView as OrderView<NetData>).showData(t)
                    } else {
                        (baseView as OrderView<NetData>).showDataMore(t)
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

    fun getPartsOrderAfterSaleList() {
        baseView.showLoading()
        baseModel.getPartsOrderAfterSaleList(
            App.getInstance().token,
            page,
            pageSize,
            NetSubscribe<PartOrderListBean>(object :
                ISubscriberListener<PartOrderListBean> {
                override fun onNext(t: PartOrderListBean?) {
                    if (page == 1) {
                        (baseView as OrderView<NetData>).showData(t)
                    } else {
                        (baseView as OrderView<NetData>).showDataMore(t)
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
    fun postExpress(mReExpress: ReExpress) {
        baseView.hiedLoading()
        baseModel.postExpress(
            App.getInstance().token,
            mReExpress,
            NetSubscribe<PostExpressBean>(object : ISubscriberListener<PostExpressBean> {
                override fun onNext(t: PostExpressBean?) {
                   (baseView as OrderView<PostExpressBean>).showData(t)
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
    fun payWx(orderId: String) {
        var mRePay = RePay()
        mRePay.id = orderId
        baseView.showLoading()
        baseModel.payWx(App.getInstance().token, mRePay, NetSubscribe<WxPayBean>(object :
            ISubscriberListener<WxPayBean> {
            override fun onNext(t: WxPayBean?) {
                (baseView as OrderView<NetData>).showData(t)
            }

            override fun onError(e: Throwable?) {
                Log.v("ssss", "sss=========$e")
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))
    }
    fun payAlly(orderId: String) {
        var mRePay = RePay()
        mRePay.id = orderId
        baseView.showLoading()
        baseModel.payAlly(App.getInstance().token, mRePay, NetSubscribe<AliPayBean>(object :
            ISubscriberListener<AliPayBean> {
            override fun onNext(t: AliPayBean?) {
                (baseView as OrderView<NetData>).showData(t)
            }
            override fun onError(e: Throwable?) {
                Log.v("ssss", "sss=========$e")
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))
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


    fun cancelPartsOrder(orderId: String) {
        baseView.hiedLoading()
        baseModel.cancelPartsOrder(
            App.getInstance().token,
            orderId,
            NetSubscribe<NetData>(object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as OrderView<NetData>).showData(t)
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

    fun cancelRefund(id: String?) {
        baseView.hiedLoading()
        baseModel.cancelRefund(
            App.getInstance().token,
            id,
            NetSubscribe<ReCancelRefundBean>(object : ISubscriberListener<ReCancelRefundBean> {
                override fun onNext(t: ReCancelRefundBean?) {
                    (baseView as OrderView<ReCancelRefundBean>).showData(t)
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

    fun sureGetGoods(id: String?) {
        baseView.hiedLoading()
        baseModel.sureGetGoods(
            App.getInstance().token,
            id,
            NetSubscribe<NetData>(object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as OrderView<NetData>).showData(t)
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
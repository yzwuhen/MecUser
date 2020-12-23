package com.example.mechanicalapp.ui.mvp.p

import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReEvaluate
import com.example.mechanicalapp.ui.data.request.RePay
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.impl.ModelImpl
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.NetDataView

class MecAppPresenter(
    private var baseView: BaseView<NetData>
) : BasePresenter {

    var baseModel = ModelImpl()
    override fun request() {

    }

    fun getList(type: Int, id: String?) {
        baseView.showLoading()
        baseModel.getList(App.getInstance().token, type, id, NetSubscribe<ListBean>(object :
            ISubscriberListener<ListBean> {
            override fun onNext(t: ListBean?) {
                (baseView as NetDataView<NetData>).refreshUI(t)
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

    override fun onDestroy() {
    }

    fun getEvaluate(repairOrderId: String?) {
        baseModel.getEvaluate(
            App.getInstance().token,
            repairOrderId,
            NetSubscribe<ListBean>(object :
                ISubscriberListener<ListBean> {
                override fun onNext(t: ListBean?) {
                    (baseView as NetDataView<NetData>).refreshUI(t)
                }

                override fun onError(e: Throwable?) {
                    Log.v("ssss", "sss=========$e")
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
        )

    }

    fun postEvaluate(mReEvaluate: ReEvaluate?) {
        baseView.showLoading()
        baseModel.postEvaluate(App.getInstance().token, mReEvaluate, NetSubscribe<NetData>(object :
            ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {
                (baseView as NetDataView<NetData>).refreshUI(t)
            }

            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))
    }

    fun payWx(orderId: String) {
        var mRePay = RePay()
        mRePay.id = orderId
        baseView.showLoading()
        baseModel.payWx(App.getInstance().token, mRePay, NetSubscribe<WxPayBean>(object :
            ISubscriberListener<WxPayBean> {
            override fun onNext(t: WxPayBean?) {
                (baseView as NetDataView<NetData>).refreshUI(t)
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

    fun getEngList() {
        baseView.showLoading()
        baseModel.getEngLetter(App.getInstance().token, NetSubscribe<EngListLetterBean>(object :
            ISubscriberListener<EngListLetterBean> {
            override fun onNext(t: EngListLetterBean?) {
              (baseView as NetDataView<NetData>).refreshUI(t)
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
}
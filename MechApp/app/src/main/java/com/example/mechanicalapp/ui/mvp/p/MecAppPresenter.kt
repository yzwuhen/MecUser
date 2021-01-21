package com.example.mechanicalapp.ui.mvp.p

import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.MainActivity
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReEvaluate
import com.example.mechanicalapp.ui.data.request.ReEvaluateParts
import com.example.mechanicalapp.ui.data.request.RePay
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.impl.ModelImpl
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.mvp.v.OrderView

//整套乱了。随便了
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

    fun postPartsEvaluate(mList: List<ReEvaluateParts>) {
        baseView.showLoading()
        baseModel.postEvaluateParts(App.getInstance().token, mList, NetSubscribe<NetData>(object :
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
    fun payAlly(orderId: String) {
        var mRePay = RePay()
        mRePay.id = orderId
        baseView.showLoading()
        baseModel.payAlly(App.getInstance().token, mRePay, NetSubscribe<AliPayBean>(object :
            ISubscriberListener<AliPayBean> {
            override fun onNext(t: AliPayBean?) {
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

    fun getLogistics(orderId: String) {
        baseView.showLoading()
        baseModel.getLogistics(App.getInstance().token, orderId,NetSubscribe<LogisticsBean>(object :
            ISubscriberListener<LogisticsBean> {
            override fun onNext(t: LogisticsBean?) {
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

    //获取订单评价
    fun getMyPartsEvaluate(orderId: String) {
        baseView.showLoading()
        baseModel.getMyPartsEvaluate(App.getInstance().token, orderId,NetSubscribe<LookEvaluateBean>(object :
            ISubscriberListener<LookEvaluateBean> {
            override fun onNext(t: LookEvaluateBean?) {
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

    //分享获得积分
    fun shareTo() {
        baseModel.shareTo(App.getInstance().token,NetSubscribe<NetData>(object :
            ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {
            }
            override fun onError(e: Throwable?) {
                Log.v("ssss", "sss=========$e")
            }
            override fun onCompleted() {
            }
        }))
    }

    fun getUserInfo(){
        baseModel.getMySelf(App.getInstance().token,NetSubscribe<MySelfInfoBean>(object :
            ISubscriberListener<MySelfInfoBean> {
            override fun onNext(netData: MySelfInfoBean?) {
                if (netData?.code == 200) {
                    App.getInstance().setUser(netData.result)
                }
                (baseView as NetDataView<NetData>).refreshUI(netData)
            }
            override fun onError(e: Throwable?) {
                (baseView as NetDataView<NetData>).err()
            }
            override fun onCompleted() {
            }
        }))
    }
}
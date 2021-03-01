package com.example.mechanicalapp.ui.mvp.p

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReEvaluate
import com.example.mechanicalapp.ui.data.request.ReEvaluateParts
import com.example.mechanicalapp.ui.data.request.RePay
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.impl.ModelImpl
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.CommentView
import com.example.mechanicalapp.ui.mvp.v.NetDataView

//整套乱了。随便了
class MecAppPresenter(
    private var baseView: BaseView<NetData>
) : BasePresenter {
    var baseModel = ModelImpl()
    override fun request() {
    }

    private var pageNo=1
    private var pageSize =30

    fun getList(type: Int, id: String?) {
        baseView.showLoading()
        baseModel.getList(App.getInstance().token, type, id, NetSubscribe<ListBean>(object :
            ISubscriberListener<ListBean> {
            override fun onNext(t: ListBean?) {
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

    fun getFactoryCommentList(page: Int,id: String?) {
        baseModel.getFactoryCommentList(
            App.getInstance().token,
            id,page,30,
            object : ISubscriberListener<FactoryCommentListBean> {
                override fun onNext(t: FactoryCommentListBean?) {
                    if (t?.code==200&&t?.result!=null&&t?.result?.pages!=null){
                        if (page==1){
                           (baseView as NetDataView<NetData>).refreshUI(t)
                        }else{
                          (baseView as NetDataView<NetData>).loadMore(t)
                        }
                    }else{
                        if (page==1){
                            (baseView as CommentView).refreshUI(null)
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getEngMsg(ids: String?) {
        baseModel.getEngInfo(
            App.getInstance().token,
            ids,
            object : ISubscriberListener<EnMsgBean> {
                override fun onNext(t: EnMsgBean?) {
                    (baseView as NetDataView<EnMsgBean>).refreshUI(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }

    fun getNotifyMsgList() {
        baseModel.getNotifyMsgList(
            App.getInstance().token,
            App.getInstance().userInfo.phone,
            pageNo,pageSize,
            object : ISubscriberListener<SysMsgBean> {
                override fun onNext(t: SysMsgBean?) {
                    if (pageNo==1){
                        (baseView as NetDataView<NetData>).refreshUI(t)
                        pageNo++
                    }else{
                        (baseView as NetDataView<NetData>).loadMore(t)
                    }
                }
                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }
    fun resetPage(){
        pageNo=1
    }

    fun getSysMsgDetails(id: String?) {
        baseModel.getSysMsgDetails(
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

    //获取摄像头列表
    fun getCameraList(){
        baseView.showLoading()
        baseModel.getCameraList(
            App.getInstance().token,
            object : ISubscriberListener<CameraListBean> {
                override fun onNext(t: CameraListBean?) {
                    (baseView as NetDataView<NetData>).refreshUI(t)
                }
                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCameraVideo(id: String?) {
        baseModel.getCameraVideo(
            App.getInstance().token,id,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                }
                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    fun getVersion() {
        baseModel.getVersion(
            object : ISubscriberListener<AppVersionBean> {
                override fun onNext(t: AppVersionBean?) {
                    (baseView as NetDataView<NetData>).refreshUI(t)
                }
                override fun onError(e: Throwable?) {
                }
                override fun onCompleted() {
                }
            })

    }
}
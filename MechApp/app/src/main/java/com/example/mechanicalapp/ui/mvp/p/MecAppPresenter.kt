package com.example.mechanicalapp.ui.mvp.p

import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.ListBean
import com.example.mechanicalapp.ui.data.NetData
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
        baseModel.getList(App.getInstance().token,type,id, NetSubscribe<ListBean>(object :
            ISubscriberListener<ListBean> {
            override fun onNext(t: ListBean?) {
               (baseView as NetDataView<NetData>).refreshUI(t)
            }

            override fun onError(e: Throwable?) {
                Log.v("ssss","sss=========$e")
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
        baseModel.getEvaluate(App.getInstance().token,repairOrderId, NetSubscribe<ListBean>(object :
            ISubscriberListener<ListBean> {
            override fun onNext(t: ListBean?) {
                (baseView as NetDataView<NetData>).refreshUI(t)
            }

            override fun onError(e: Throwable?) {
                Log.v("ssss","sss=========$e")
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))

    }
}
package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReApplyRefund
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.PersonCerView

class ApplyRefundPresenter (
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) : UpdateFilePresenterImpl(mContext, baseView) {


     fun applyRefund(reApplyRefund: ReApplyRefund){
        baseView.showLoading()
        baseModel.applyRefund(App.getInstance().token,reApplyRefund,NetSubscribe<NetData>(object :ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {

            }

            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }

        }))
    }
}
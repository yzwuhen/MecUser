package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.ReportBean
import com.example.mechanicalapp.ui.data.request.ReReport
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.MecSellView
import com.example.mechanicalapp.ui.mvp.v.ReportView

class ReportPresenter(
private var mContext: Context,
private var baseView: BaseView<NetData>
) : UpdateFilePresenterImpl(mContext, baseView){


    override fun request() {

    }

    override fun onDestroy() {
    }

    fun report(reReport: ReReport) {
        baseView.showLoading()
        baseModel.report(App.getInstance().token,reReport,NetSubscribe<NetData>(object :ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {
                (baseView as ReportView).showSuccess(t)

            }

            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))
    }

    fun getReportList() {
        baseModel.getReportList(App.getInstance().token,NetSubscribe<ReportBean>(object :ISubscriberListener<ReportBean>{
            override fun onNext(t: ReportBean?) {

                (baseView as ReportView).showSuccess(t)
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
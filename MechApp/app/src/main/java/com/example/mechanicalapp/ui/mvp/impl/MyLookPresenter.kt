package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MecLeaseData
import com.example.mechanicalapp.ui.data.MoreLeaseData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.MyReleaseView

class MyLookPresenter(
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var baseModel = ModelImpl()
    private var page: Int = 0;
    private var pageSize: Int = 30;
    override fun request() {
    }

    fun getLookLeaseList(type: Int) {
        baseView.showLoading()
        baseModel.getLookLeaseList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<MoreLeaseData> {
                override fun onNext(t: MoreLeaseData?) {
//                    if (t?.code == 200 && t?.result != null) {
//                        if (page == 0) {
//                            t?.result?.records?.let {
//                                (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(
//                                    it
//                                )
//                            }
//                        } else {
//                            t?.result?.records?.let {
//                                (baseView as MyReleaseView<MecLeaseData>)?.loadMore(
//                                    it
//                                )
//                            }
//                        }
//
//                    } else {
//                        (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(null)
//                    }
//                    page++
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

    fun resetPage() {
        page =0
    }
}
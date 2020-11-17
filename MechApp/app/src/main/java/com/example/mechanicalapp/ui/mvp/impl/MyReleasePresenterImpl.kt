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

class MyReleasePresenterImpl(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    //不想写那么多了直接都用这个ModelImpl
    private var baseModel = ModelImpl()
    private var page: Int = 0;
    private var pageSize: Int = 30;

    override fun request() {
    }

    fun getLeaseList(type: Int) {
        baseView.showLoading()
        baseModel.getLeaseList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<MoreLeaseData> {
                override fun onNext(t: MoreLeaseData?) {
                    page++
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 0) {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<MecLeaseData>)?.loadMore(
                                    it
                                )
                            }
                        }

                    } else {
                        (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(null)
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

    fun refreshLease(id: String) {
        baseView.showLoading()
        baseModel.refreshLease(
            App.getInstance().token,
            id,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as MyReleaseView<NetData>)?.showData(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    //编辑 下架重新上架
    fun editLease(id: String,isOn:String) {
        baseView.showLoading()
        baseModel.editLease(
            App.getInstance().token,
            id,
            isOn,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as MyReleaseView<NetData>)?.showData(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun delLease(id: String) {
        baseView.showLoading()
        baseModel.delLease(
            App.getInstance().token,
            id,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as MyReleaseView<NetData>)?.showData(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }




    //出售 求购
    fun getBusinessList(type: Int) {
        baseView.showLoading()
        baseModel.getLeaseList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<MoreLeaseData> {
                override fun onNext(t: MoreLeaseData?) {
                    page++
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 0) {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<MecLeaseData>)?.loadMore(
                                    it
                                )
                            }
                        }

                    } else {
                        (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(null)
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


    override fun onDestroy() {
    }

    fun resetPage() {
        page = 0
    }
}
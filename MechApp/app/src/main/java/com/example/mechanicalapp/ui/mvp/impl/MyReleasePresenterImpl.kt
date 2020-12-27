package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
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
    private var page: Int = 1;
    private var pageSize: Int = 30;

    override fun request() {
    }

    fun getMyLeaseList(type: Int) {
        baseView.showLoading()
        baseModel.getMyLeaseList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<MoreLeaseData> {
                override fun onNext(t: MoreLeaseData?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
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
                    ++page
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
    fun editLease(id: String, isOn: String) {
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
    fun getMyBusinessSellList(type: Int) {
        baseView.showLoading()
        baseModel.getMyBusinessList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<MoreSellBean> {
                override fun onNext(t: MoreSellBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<MecSellData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<MecSellData>)?.loadMore(
                                    it
                                )
                            }
                        }

                    } else {
                        (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(null)
                    }
                    ++page
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }


    fun refreshBusiness(id: String) {
        baseView.showLoading()
        baseModel.refreshBusiness(
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
    fun editBusiness(id: String, isOn: String) {
        baseView.showLoading()
        baseModel.editBusiness(
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

    fun delBusiness(id: String) {
        baseView.showLoading()
        baseModel.delBusiness(
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


    fun getMyPartsList(type: Int) {
        baseView.showLoading()
        baseModel.getMyPartsList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<PartsBean> {
                override fun onNext(t: PartsBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<PartsData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<PartsData>)?.loadMore(
                                    it
                                )
                            }
                        }

                    } else {
                        (baseView as MyReleaseView<PartsData>)?.refreshUI(null)
                    }
                    ++page
                }

                override fun onError(e: Throwable?) {
                    Log.e(":sssss","ssssssssss$e")
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }


    fun refreshParts(id: String) {
        baseView.showLoading()
        baseModel.refreshParts(
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
    fun editParts(id: String, isOn: String) {
        baseView.showLoading()
        baseModel.editParts(
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

    fun delParts(id: String) {
        baseView.showLoading()
        baseModel.delParts(
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

    fun getMyWorkList(type: Int) {
        baseView.showLoading()
        baseModel.getMyWorkList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<RecruitBean> {
                override fun onNext(t: RecruitBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<RecruitData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<RecruitData>)?.loadMore(
                                    it
                                )
                            }
                        }

                    } else {
                        (baseView as MyReleaseView<RecruitData>)?.refreshUI(null)
                    }
                    ++page
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }


    fun refreshWork(id: String) {
        baseView.showLoading()
        baseModel.refreshWork(
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
    fun editWork(id: String, isOn: String) {
        baseView.showLoading()
        baseModel.editWork(
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

    fun delWork(id: String) {
        baseView.showLoading()
        baseModel.delWork(
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


    override fun onDestroy() {
    }

    fun resetPage() {
        page = 1
    }
}
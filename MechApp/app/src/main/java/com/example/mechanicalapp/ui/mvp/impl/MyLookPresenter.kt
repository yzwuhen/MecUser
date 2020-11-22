package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.MyReleaseView

class MyLookPresenter(
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var baseModel = ModelImpl()
    private var page: Int = 1
    private var pageSize: Int = 30
    override fun request() {
    }

    fun getLookLeaseList(type: Int) {
        baseView.showLoading()
        baseModel.getLookLeaseList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<MyLookLeaseBean> {
                override fun onNext(t: MyLookLeaseBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.let {
                                (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.let {
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
    fun getLookSecondLeaseList(type: Int) {
        baseView.showLoading()
        baseModel.getLookSecondLeaseList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<MyLookLeaseBean> {
                override fun onNext(t: MyLookLeaseBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.let {
                                (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.let {
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
    fun getLookPartsList(type: Int) {
        baseView.showLoading()
        baseModel.getLookPartsList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<LookPartsBean> {
                override fun onNext(t: LookPartsBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.let {
                                (baseView as MyReleaseView<PartsData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.let {
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
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }


    fun getLookRecruitList(type: Int) {
        baseView.showLoading()
        baseModel.getLookRecruitList(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<LookRecruitBean> {
                override fun onNext(t: LookRecruitBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.let {
                                (baseView as MyReleaseView<RecruitData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.let {
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
    fun getLookFactoryList() {
        baseView.showLoading()
        baseModel.getLookFactoryList(
            App.getInstance().token,
            page,
            pageSize,
            object : ISubscriberListener<LookFactoryBean> {
                override fun onNext(t: LookFactoryBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<FactoryData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.records?.let {
                                (baseView as MyReleaseView<FactoryData>)?.loadMore(
                                    it
                                )
                            }
                        }

                    } else {
                        (baseView as MyReleaseView<FactoryData>)?.refreshUI(null)
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


    fun getLookGoodsList() {
        baseView.showLoading()
        baseModel.getLookGoodsList(
            App.getInstance().token,
            page,
            pageSize,
            object : ISubscriberListener<LookGoodsBean> {
                override fun onNext(t: LookGoodsBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.let {
                                (baseView as MyReleaseView<GoodsData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.let {
                                (baseView as MyReleaseView<GoodsData>)?.loadMore(
                                    it
                                )
                            }
                        }

                    } else {
                        (baseView as MyReleaseView<GoodsData>)?.refreshUI(null)
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
    override fun onDestroy() {
    }

    fun resetPage() {
        page = 1
    }
}
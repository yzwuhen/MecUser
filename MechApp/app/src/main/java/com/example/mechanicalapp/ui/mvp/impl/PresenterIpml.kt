package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.CollectBaseView
import com.example.mechanicalapp.ui.mvp.v.CollectView

class PresenterImpl(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var baseModel = ModelImpl()
    private var page: Int = 1
    private var pageSize: Int = 30

    override fun request() {
    }

    fun getCollectList(type: Int) {
        page = 1
        baseView.showLoading()
        baseModel.getCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectLeaseBean> {
                override fun onNext(t: CollectLeaseBean?) {
                    if (t?.code == 200) {
                        (baseView as CollectView<MecLeaseData>).refreshUI(t?.result)
                    } else {
                        (baseView as CollectView<MecLeaseData>).refreshUI(null)
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCollectListMore(type: Int) {
        ++page
        baseView.showLoading()
        baseModel.getCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectLeaseBean> {
                override fun onNext(t: CollectLeaseBean?) {
                    if (t?.code == 200) {
                        (baseView as CollectView<MecLeaseData>).loadMore(t?.result)
                    } else {
                        (baseView as CollectView<MecLeaseData>).loadMore(null)
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCollectSecondHandList(type: Int) {
        page = 1
        baseView.showLoading()
        baseModel.getSecondCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectBusinessBean> {
                override fun onNext(t: CollectBusinessBean?) {
                    if (t?.code == 200) {
                        t?.result?.let { (baseView as CollectView<MecSellData>).refreshUI(it) }
                    } else {
                        (baseView as CollectView<MecSellData>).refreshUI(null)
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCollectSecondHandListMore(type: Int) {
        ++page
        baseView.showLoading()
        baseModel.getSecondCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectBusinessBean> {
                override fun onNext(t: CollectBusinessBean?) {
                    if (t?.code == 200) {
                        t?.result?.let { (baseView as CollectView<MecSellData>).loadMore(it) }
                    } else {
                        (baseView as CollectView<MecSellData>).loadMore(null)
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCollectPartsList(type: Int) {
        page = 1
        baseView.showLoading()
        baseModel.getPartsCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectPartsBean> {
                override fun onNext(t: CollectPartsBean?) {
                    if (t?.code == 200) {
                        t?.result?.let { (baseView as CollectView<PartsData>).refreshUI(it) }
                    } else {
                        (baseView as CollectView<PartsData>).refreshUI(null)
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCollectPartsListMore(type: Int) {
        ++page
        baseView.showLoading()
        baseModel.getPartsCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectPartsBean> {
                override fun onNext(t: CollectPartsBean?) {
                    if (t?.code == 200) {
                        t?.result?.let { (baseView as CollectView<PartsData>).loadMore(it) }
                    } else {
                        (baseView as CollectView<PartsData>).loadMore(null)
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getFactoryCollect(type: Int) {
        page = 1
        baseView.showLoading()
        baseModel.getFactoryCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectFactoryBean> {
                override fun onNext(t: CollectFactoryBean?) {
                    if (t?.code == 200) {
                        t?.result?.records.let { (baseView as CollectView<FactoryData>).refreshUI(it) }
                    } else {
                        (baseView as CollectView<FactoryData>).refreshUI(null)
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getFactoryCollectMore(type: Int) {
        ++page
        baseView.showLoading()
        baseModel.getFactoryCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectFactoryBean> {
                override fun onNext(t: CollectFactoryBean?) {
                    if (t?.code == 200) {
                        t?.result?.records.let { (baseView as CollectView<FactoryData>).loadMore(it) }
                    } else {
                        (baseView as CollectView<FactoryData>).loadMore(null)
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    fun getRecruitCollect(type: Int) {
        page = 1
        baseView.showLoading()
        baseModel.getRecruitCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectRecruitBean> {
                override fun onNext(t: CollectRecruitBean?) {
                    if (t?.code == 200) {
                        t?.result?.let { (baseView as CollectView<RecruitData>).refreshUI(it) }
                    } else {
                        (baseView as CollectView<RecruitData>).refreshUI(null)
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getRecruitCollectMore(type: Int) {
        ++page
        baseView.showLoading()
        baseModel.getRecruitCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectRecruitBean> {
                override fun onNext(t: CollectRecruitBean?) {
                    if (t?.code == 200) {
                        t?.result?.let { (baseView as CollectView<RecruitData>).loadMore(it) }
                    } else {
                        (baseView as CollectView<RecruitData>).loadMore(null)
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    fun getGoodsCollect(type: Int) {
        page = 1
        baseView.showLoading()
        baseModel.getGoodsCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectGoodsBean> {
                override fun onNext(t: CollectGoodsBean?) {
                    if (t?.code == 200) {
                        (baseView as CollectView<GoodsData>).refreshUI(t?.result)
                    } else {
                        (baseView as CollectView<GoodsData>).refreshUI(null)
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getGoodsCollectMore(type: Int) {
        ++page
        baseView.showLoading()
        baseModel.getGoodsCollect(
            App.getInstance().token,
            type,
            page,
            pageSize,
            object : ISubscriberListener<CollectGoodsBean> {
                override fun onNext(t: CollectGoodsBean?) {
                    if (t?.code == 200) {
                        (baseView as CollectView<GoodsData>).loadMore(t?.result)
                    } else {
                        (baseView as CollectView<GoodsData>).loadMore(null)
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    override fun onDestroy() {
    }

    fun del(ids: String?) {
        baseView.showLoading()
        baseModel.delCollect(
            App.getInstance().token,
            ids,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    if (t != null) {
                        (baseView as CollectBaseView).success(t)
                    }

                }

                override fun onError(e: Throwable?) {
                    baseView.err()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }
}
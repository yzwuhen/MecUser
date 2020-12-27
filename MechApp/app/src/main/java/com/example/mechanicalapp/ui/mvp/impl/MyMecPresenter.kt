package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.CollectView
import com.example.mechanicalapp.ui.mvp.v.MyMecDetailsView

class MyMecPresenter(
    private var baseView: BaseView<NetData>
) : BasePresenter {
    private var baseModel = ModelImpl()
    private var page: Int = 1
    private var pageSize: Int = 30
    private var tittle:String?=null
    override fun request() {
    }

    fun getMecList() {
        baseView.showLoading()
        baseModel.getMyMecList(
            App.getInstance().token,
            null,
            page,
            pageSize,
            object : ISubscriberListener<MyMecListBean> {
                override fun onNext(t: MyMecListBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        if (page == 1) {
                            t?.result?.records.let {
                                (baseView as CollectView<MecData>)?.refreshUI(
                                    it
                                )
                            }
                        } else {
                            t?.result?.records.let {
                                (baseView as CollectView<MecData>)?.loadMore(
                                    it
                                )
                            }
                        }

                    } else {
                        (baseView as CollectView<MecData>)?.refreshUI(null)
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

    fun getMecDetails(id:String){
        baseView.showLoading()
        baseModel.getMecDetails(
            App.getInstance().token,
            id,
            object : ISubscriberListener<MyMecDetailsBean> {
                override fun onNext(t: MyMecDetailsBean?) {
                    (baseView as MyMecDetailsView).showData(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }

    fun delMyMec(data: MyMecDetailsBean.ResultBean?){
        baseView.showLoading()
        baseModel.delMyMec(
            App.getInstance().token,
            data,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as MyMecDetailsView).showData(t)
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

    fun reset() {
        page = 1
    }
    fun setTitle(s:String?){
        tittle =s
        reset()
    }
}
package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.GoodsListBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.NetDataView

class GoodsListPresenter (
    private var baseView: BaseView<NetData>
) :
    BasePresenter {
    private var baseModel = ModelImpl()
    private var page: Int = 1
    private var pageSize: Int = 30
    private var orderByPrice=0
    private var orderByScale=0
    private var orderType=0
    private var title=""

    fun getGoodsList() {
        baseView.showLoading()
        baseModel.getGoodsList(
            App.getInstance().token,
            orderByPrice,
            orderByScale,
            orderType,
            title,
            page,
            pageSize,
            NetSubscribe<GoodsListBean>(object :ISubscriberListener<GoodsListBean>{
                override fun onNext(t: GoodsListBean?) {
                    if (t?.code==200){
                        if (page==1){
                            (baseView as NetDataView<NetData>).refreshUI(t)
                        }else{
                            (baseView as NetDataView<NetData>).loadMore(t)
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
         )

    }

    override fun request() {

    }

    override fun onDestroy() {
    }

    fun setTitle(title: String) {

        this.title =title
    }

    fun resetPage() {

        page =1
    }
}
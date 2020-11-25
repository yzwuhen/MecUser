package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.ShopCarBean
import com.example.mechanicalapp.ui.data.ShopCarData
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.NetDataView

class ShopCarPresenter(
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var page: Int = 1
    private var pageSize: Int = 30
    var baseModel = ModelImpl()
    override fun request() {
    }

    fun getCarList() {
        baseView.showLoading()
        baseModel.getShopList(
            App.getInstance().token,
            page,
            pageSize,
            NetSubscribe<ShopCarBean>(object :
                ISubscriberListener<ShopCarBean> {
                override fun onNext(t: ShopCarBean?) {
                    if (page == 1) {
                        (baseView as NetDataView<NetData>).refreshUI(t)
                    } else {
                        (baseView as NetDataView<NetData>).loadMore(t)
                    }
                    page++
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

    override fun onDestroy() {
    }

    fun resetPage() {
        page = 1
    }

    fun edit(shopCarData: ShopCarData) {
        baseView.showLoading()
        baseModel.editShopCar(
            App.getInstance().token,
            shopCarData,
            NetSubscribe<NetData>(object :
                ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {

                    //编辑不需要立即更新UI 因为已经更新过一次、不考虑失败后的信息差情况
                 //   (baseView as NetDataView<NetData>).refreshUI(t)
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

    fun del(id: String?) {
        baseView.showLoading()
        baseModel.delShopCar(
            App.getInstance().token,
            id,
            NetSubscribe<NetData>(object :
                ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as NetDataView<NetData>).refreshUI(t)
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
}
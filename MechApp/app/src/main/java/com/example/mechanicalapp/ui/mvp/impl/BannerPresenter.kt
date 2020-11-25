package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.BannerBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.NetDataView

class BannerPresenter(
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    var baseModel = ModelImpl()
    override fun request() {
    }

    override fun onDestroy() {
    }

    fun getBanner(type:Int) {
        baseModel.getBanner(
            App.getInstance().token,
            type,
            NetSubscribe<BannerBean>(object :
                ISubscriberListener<BannerBean> {
                override fun onNext(t: BannerBean?) {

                    (baseView as NetDataView<BannerBean>).refreshUI(t)

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
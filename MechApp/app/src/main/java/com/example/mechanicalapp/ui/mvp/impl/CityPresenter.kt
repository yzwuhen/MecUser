package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.OrderBean
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.OrderView

class CityPresenter (
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    var baseModel = ModelImpl()

    override fun request() {

    }

    fun getCityList() {
        baseModel.getCity(
            App.getInstance().token,
            NetSubscribe<NetData>(object :
                ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {

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
}
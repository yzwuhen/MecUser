package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView

class MapPresenter (
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    var baseModel = ModelImpl()
    override fun request() {

    }

    fun getMapMecLease(lag:Double,lot:Double,type:Int,title:String?){
        baseModel.getMapMecLease(
            App.getInstance().token,
            lag,lot,type,title,
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
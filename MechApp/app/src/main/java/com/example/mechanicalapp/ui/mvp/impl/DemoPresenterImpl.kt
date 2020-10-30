package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.m.BaseModel
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView

class DemoPresenterImpl(private var baseView: BaseView<NetData>?) : BasePresenter {

    private var baseModel: DemoModelImpl? = null

    init {
        baseModel = DemoModelImpl()
    }


    override fun request() {
        baseModel?.getHomeData(object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {
                Log.e("sssss============","sssssssss==============onNext")

            }

            override fun onError(e: Throwable?) {
                Log.e("sssss============","sssssssss==============onError$e")
            }

            override fun onCompleted() {
            }
        })
    }

    override fun onDestroy() {
    }


}



package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.m.BaseModel
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.p.OnFinishListener
import com.example.mechanicalapp.ui.mvp.v.BaseView

class DemoPresenterImpl(private var baseView: BaseView<MutableList<BannerData>>?) : BasePresenter, OnFinishListener {

    private var baseModel: BaseModel? = null
    private var listbanner:MutableList<BannerData> ?=ArrayList()
    init {
        baseModel = DemoModelImpl(this)

        var bannerData: BannerData
        bannerData = BannerData()
        bannerData.img_path =
            "https://t8.baidu.com/it/u=2247852322,986532796&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1600708280&t=2c8b3ed72148e0c4fb274061565e6723"

        listbanner?.add(bannerData)
        listbanner?.add(bannerData)
    }


    override fun request() {
            baseModel?.initRequest()
        }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

    override fun onUsernameError() {

    }

    override fun onPasswordError() {
        TODO("Not yet implemented")
    }

    override fun onErr() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(data: NetData) {
        listbanner?.let { baseView?.showData(it) }
    }


}



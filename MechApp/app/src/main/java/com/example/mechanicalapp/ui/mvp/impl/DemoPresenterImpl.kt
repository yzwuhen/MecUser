package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.HomeData
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.m.BaseModel
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.HomeBaseView

class DemoPresenterImpl(private var baseView: HomeBaseView<NetData>?) : BasePresenter {

    private var baseModel: DemoModelImpl? = null

    init {
        baseModel = DemoModelImpl()
    }


    override fun request() {
        baseModel?.getHomeData(object : ISubscriberListener<HomeData> {
            override fun onNext(t: HomeData?) {
                if (t?.code == 200 && t?.result != null) {
                    baseView?.showAd(t?.result?.adList)
                    baseView?.showHotMec(t?.result?.hotMechineCateList)
                    baseView?.showParts(t?.result?.mecProds)
                    baseView?.showLease(t?.result?.newMecMarketMechanicsOut)
                    baseView?.showUserRent(t?.result?.newMecMarketMechanicsIn)
                    baseView?.showBossSell(t?.result?.newMecMarketOldMechanicsOut)
                    baseView?.showBossBuy(t?.result?.newMecMarketOldMechanicsIn)
                    baseView?.hiedLoading()
                } else {
                    baseView?.err()
                }

            }

            override fun onError(e: Throwable?) {
                baseView?.err()
                Log.e("sssss============", "sssssssss==============onError$e")
            }

            override fun onCompleted() {
            }
        })
    }

    override fun onDestroy() {
    }


}



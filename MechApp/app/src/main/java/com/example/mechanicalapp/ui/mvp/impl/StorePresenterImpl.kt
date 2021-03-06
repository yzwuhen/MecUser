package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.StoreBean
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.StoreView

class StorePresenterImpl(
    private var mContext: Context,
    private var baseView: StoreView<StoreLeftBean>
) :
    BasePresenter {


    private var baseModel: StoreModelImpl? = null

    init {
        baseModel = StoreModelImpl()
    }

    override fun request() {
        baseView.showLoading()
        baseModel?.getStoreData(object : ISubscriberListener<StoreBean> {
            override fun onNext(t: StoreBean?) {
                if (t?.code == 200 && t?.result != null) {
                    t?.result?.adList?.let { baseView?.showAd(it) }
                    baseView?.showData(t?.result.productCategoryVoList)
                } else {
                    baseView?.err()
                }

            }

            override fun onError(e: Throwable?) {
                baseView?.err()
                baseView?.hiedLoading()
            }

            override fun onCompleted() {
                baseView?.hiedLoading()
            }
        })
    }

    override fun onDestroy() {
    }
}
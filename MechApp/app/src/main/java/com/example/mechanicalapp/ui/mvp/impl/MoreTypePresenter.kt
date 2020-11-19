package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.MecTypeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.TypeView

class MoreTypePresenter(
    private var baseView: BaseView<NetData>
) : BasePresenter {
    var baseModel = ModelImpl()
    override fun request() {
    }

    override fun onDestroy() {
    }

    fun getMecType() {

        baseView.showLoading()
        baseModel.getMecType(App.getInstance().token,object :
            ISubscriberListener<MecTypeBean> {
            override fun onNext(t: MecTypeBean?) {
                (baseView as TypeView<MecTypeBean>).refreshLeftUI(t)
            }
            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
                baseView.err()
            }
            override fun onCompleted() {
                baseView.hiedLoading()
            }
        })
    }

    fun getPartType() {
        baseView.showLoading()
        baseModel.getPartType(App.getInstance().token,object :
            ISubscriberListener<MecTypeBean> {
            override fun onNext(t: MecTypeBean?) {
                (baseView as TypeView<MecTypeBean>).refreshLeftUI(t)
            }
            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
                baseView.err()
            }
            override fun onCompleted() {
                baseView.hiedLoading()
            }
        })
    }
}
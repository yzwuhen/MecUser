package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.CreatOrderBean
import com.example.mechanicalapp.ui.data.MyAddressBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReOrder
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.NetDataView

class SureOrderPresenter(
    private var baseView: BaseView<NetData>
) :
    BasePresenter {
    private var baseModel = ModelImpl()

    override fun request() {
    }

    fun getAddressList() {
        baseView.showLoading()
        baseModel.getAddressList(
            App.getInstance().token,
            1,
            2,
            object : ISubscriberListener<MyAddressBean> {
                override fun onNext(t: MyAddressBean?) {
                    (baseView as NetDataView<NetData>).refreshUI(t)
                }
                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }
    fun creatOrder(reOrder: ReOrder) {
        baseView.showLoading()
        baseModel.addOrder(
            App.getInstance().token,
            reOrder, NetSubscribe(object :ISubscriberListener<CreatOrderBean>{
                override fun onNext(t: CreatOrderBean?) {
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


    override fun onDestroy() {
    }
}
package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView

class AddressPresenterImpl (
    private var baseView: BaseView<NetData>
) :
    BasePresenter {
    private var baseModel = ModelImpl()
    private var page: Int = 0;
    private var pageSize: Int = 30;
    override fun request() {

    }

    fun getAddressList(){
        baseView.showLoading()
        baseModel.getAddressList(
            App.getInstance().token,
            page,
            pageSize,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
//                    if (t?.code == 200 && t?.result != null) {
//                        if (page == 0) {
//                            t?.result?.records?.let {
//                                (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(
//                                    it
//                                )
//                            }
//                        } else {
//                            t?.result?.records?.let {
//                                (baseView as MyReleaseView<MecLeaseData>)?.loadMore(
//                                    it
//                                )
//                            }
//                        }
//
//                    } else {
//                        (baseView as MyReleaseView<MecLeaseData>)?.refreshUI(null)
//                    }
//                    page++
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }




    override fun onDestroy() {
    }


}
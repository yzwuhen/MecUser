package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecLease
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView

class AddMecLeasePresenterImpl(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var baseModel = ModelImpl()


    override fun request() {
    }

    fun addMecLease(mReMecLease: ReMecLease){
        baseModel.addMecLease(mReMecLease,object :ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {

            }

            override fun onError(e: Throwable?) {
            }

            override fun onCompleted() {
            }
        })
    }


    override fun onDestroy() {
    }
}
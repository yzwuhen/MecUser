package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReAddMec
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.PersonCerView

class AddMecPresenter(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) : UpdateFilePresenterImpl(mContext, baseView){

    fun addMec(reAddMec: ReAddMec){
        baseView.showLoading()
        baseModel.addMec(App.getInstance().token,reAddMec, object :
            ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {
                (baseView as PersonCerView).success(t)
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
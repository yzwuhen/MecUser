package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReSuggest
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.ReleaseView

class SuggestPresenter (
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    UpdateFilePresenterImpl(mContext,baseView) {
    fun postSuggest(reSuggest: ReSuggest) {
        baseView.showLoading()
        baseModel.postSuggest(App.getInstance().token,reSuggest,NetSubscribe<NetData>(object :ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {
                (baseView as ReleaseView<NetData>)?.showSuccess(t)
            }

            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))
    }
}
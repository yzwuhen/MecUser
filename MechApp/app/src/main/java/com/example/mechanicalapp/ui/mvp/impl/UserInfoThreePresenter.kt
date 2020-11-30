package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.RecruitBean
import com.example.mechanicalapp.ui.data.UserInfoBean
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.NetDataView

class UserInfoThreePresenter(
    private var baseView: BaseView<NetData>
) :
    BasePresenter {
    private var baseModel = ModelImpl()
    override fun request() {
    }

    fun getUserLease(user:String,type:Int){

        baseView?.showLoading()
        baseModel?.getUserInfo(App.getInstance().token,type,user,NetSubscribe<UserInfoBean>(object :ISubscriberListener<UserInfoBean>{
            override fun onNext(t: UserInfoBean?) {
                (baseView as NetDataView<UserInfoBean>).refreshUI(t)
            }

            override fun onError(e: Throwable?) {
                baseView?.hiedLoading()
            }

            override fun onCompleted() {
                baseView?.hiedLoading()
            }
        }))
    }

    override fun onDestroy() {


    }
}
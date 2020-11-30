package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.UserInfo
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.UserView

class UserInfoPresenter(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    UpdateFilePresenterImpl(mContext,baseView) {
    override fun request() {

    }

    fun editUserInfo(userInfo: UserInfo?){
        baseView.showLoading()
        baseModel.editUser(App.getInstance().token,userInfo,NetSubscribe<NetData>(object : ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {

                (baseView as UserView).success(t)
            }

            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        }))
    }

    override fun onDestroy() {
    }
}
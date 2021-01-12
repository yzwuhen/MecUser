package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.UserInfo
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.UserView
import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.RequestCallback
import com.netease.nimlib.sdk.uinfo.UserService
import com.netease.nimlib.sdk.uinfo.constant.UserInfoFieldEnum
import com.orhanobut.hawk.Hawk


class UserInfoPresenter(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    UpdateFilePresenterImpl(mContext, baseView) {
    override fun request() {

    }

    fun editUserInfo(userInfo: UserInfo?){
        baseView.showLoading()
        baseModel.editUser(App.getInstance().token, userInfo, NetSubscribe<NetData>(object :
            ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {
                (baseView as UserView).success(t)
                Hawk.put(Configs.USER_INFO,userInfo)
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

    fun upImHeaderImg(message: String) {

        val fields: MutableMap<UserInfoFieldEnum, Any> = HashMap(1)
        fields.put(UserInfoFieldEnum.AVATAR,message)
        NIMClient.getService(UserService::class.java).updateUserInfo(fields).setCallback(object :RequestCallback<Void>{
            override fun onSuccess(p0: Void?) {
                Log.v("===========","ssssssssss==============更新IM头像成功")
            }

            override fun onFailed(p0: Int) {
                Log.v("===========","ssssssssss==============更新IM头像失败")
            }

            override fun onException(p0: Throwable?) {
            }
        })
//        fields[UserInfoFieldEnum.AVATAR] =message
    }
}
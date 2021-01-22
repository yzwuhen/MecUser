package com.example.mechanicalapp.ui.mvp.p

import android.util.Log
import com.example.mechanicalapp.ui.mvp.v.MsgView
import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.RequestCallback
import com.netease.nimlib.sdk.friend.FriendService
import com.netease.nimlib.sdk.msg.MsgService
import com.netease.nimlib.sdk.msg.model.RecentContact


class MsgPresenter<T>(
    private var baseView: MsgView<T>
) : BasePresenter {
    override fun request() {
        getMsgList()
    }

    private fun getMsgList() {
        (baseView as MsgView<List<RecentContact>>).refreshChartUI(
            NIMClient.getService(MsgService::class.java).queryRecentContactsBlock()
        )
    }

    fun getBlackList() {
        (baseView as MsgView<List<String>>).refreshChartUI(
            NIMClient.getService(
                FriendService::class.java
            ).blackList)
    }

    fun addBlackList(account:String){
        NIMClient.getService(FriendService::class.java).addToBlackList(account).setCallback(object :RequestCallback<Void>{
            override fun onSuccess(p0: Void?) {
                Log.v("ssss","sssssss================success")
                baseView.successChart()
            }

            override fun onFailed(p0: Int) {
                    Log.v("ssss","sssssss================onFailed")
            }

            override fun onException(p0: Throwable?) {
                Log.v("ssss","sssssss================onException")
            }
        })
    }

    fun removeBlackList(account:String){
        NIMClient.getService(FriendService::class.java).removeFromBlackList(account).setCallback(object :RequestCallback<Void>{
            override fun onSuccess(p0: Void?) {
                baseView.successChart()
            }

            override fun onFailed(p0: Int) {
            }

            override fun onException(p0: Throwable?) {
            }
        })
    }


    override fun onDestroy() {
    }

    fun delChat(recentContact: RecentContact) {
        NIMClient.getService(MsgService::class.java).deleteRecentContact(recentContact)
    }

    fun clearUnreadCount(recentContact: RecentContact) {
        NIMClient.getService(MsgService::class.java).clearUnreadCount(recentContact.fromAccount,recentContact.sessionType)
    }


}
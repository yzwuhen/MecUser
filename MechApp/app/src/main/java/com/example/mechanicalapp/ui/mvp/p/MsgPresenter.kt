package com.example.mechanicalapp.ui.mvp.p

import android.util.Log
import com.example.mechanicalapp.ui.mvp.v.MsgView
import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.RequestCallbackWrapper
import com.netease.nimlib.sdk.msg.MsgService
import com.netease.nimlib.sdk.msg.model.RecentContact


class MsgPresenter(
    private var baseView: MsgView
) : BasePresenter {
    override fun request() {
        getMsgList()
    }

    private fun getMsgList() {

        baseView.refreshUI(NIMClient.getService(MsgService::class.java).queryRecentContactsBlock())

//        NIMClient.getService(MsgService::class.java).queryRecentContacts()
//            .setCallback(object : RequestCallbackWrapper<List<RecentContact>>() {
//                override fun onResult(code: Int, recents: List<RecentContact>, e: Throwable) {
//                    // recents参数即为最近联系人列表（最近会话列表）
//                    Log.v("ssss==========","===================$e")
//                    baseView.refreshUI(recents)
//                }
//            })
    }

    override fun onDestroy() {
    }
}
package com.example.mechanicalapp.ui.mvp.p

import com.example.mechanicalapp.ui.mvp.v.MsgView
import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.RequestCallbackWrapper
import com.netease.nimlib.sdk.ResponseCode
import com.netease.nimlib.sdk.msg.MsgService
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum
import com.netease.nimlib.sdk.msg.model.RecentContact


class MsgPresenter(
    private var baseView: MsgView
) : BasePresenter {
    override fun request() {
        getMsgList()
    }

    private fun getMsgList() {
        baseView.refreshUI(NIMClient.getService(MsgService::class.java).queryRecentContactsBlock())
    }

    override fun onDestroy() {
    }
}
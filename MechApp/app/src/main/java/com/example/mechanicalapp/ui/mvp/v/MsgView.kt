package com.example.mechanicalapp.ui.mvp.v

import com.netease.nimlib.sdk.InvocationFuture
import com.netease.nimlib.sdk.msg.model.RecentContact

interface MsgView  {
    fun refreshUI(list: List<RecentContact>?)
}
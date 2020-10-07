package com.example.mechanicalapp.ui.mvp.p

import com.example.mechanicalapp.ui.data.NetData

interface OnFinishListener : BaseListener<NetData> {
    fun onUsernameError()

    fun onPasswordError()

}
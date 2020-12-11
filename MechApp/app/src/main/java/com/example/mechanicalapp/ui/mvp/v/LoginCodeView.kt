package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData


interface LoginCodeView:BaseView<NetData> {
    fun success(netData: NetData)
    fun loginErr(exception: String?)
}
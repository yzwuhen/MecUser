package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface IntegralView<T> :BaseView<NetData> {
    fun showData(t:T?)
    fun showDataMore(t:T?)
    fun success(netData: NetData?)
}
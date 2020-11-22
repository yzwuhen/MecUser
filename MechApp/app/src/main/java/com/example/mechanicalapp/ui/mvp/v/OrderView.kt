package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface OrderView<T>:BaseView<NetData> {
    fun showData(data: T?)
    fun showDataMore(data: T?)
}
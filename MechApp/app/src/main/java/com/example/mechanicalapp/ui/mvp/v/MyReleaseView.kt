package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface MyReleaseView<T>:BaseView<NetData> {
    fun refreshUI(list: List<T>?)
    fun loadMore(list: List<T>?)
    fun showData(netData:NetData?)
}
package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface NetDataView<T> : BaseView<NetData> {
    fun refreshUI(data: T?)
    fun loadMore(data: T?)
}
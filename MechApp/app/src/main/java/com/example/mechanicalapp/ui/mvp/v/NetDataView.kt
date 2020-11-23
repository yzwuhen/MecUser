package com.example.mechanicalapp.ui.mvp.v

interface NetDataView<T> : BaseView<T> {
    fun refreshUI(data: T?)
    fun loadMore(data: T?)
}
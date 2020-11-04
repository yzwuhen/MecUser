package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.StoreLeftBean


interface BaseView<T> {
    fun showLoading()
    fun hiedLoading()
    fun showData(t: MutableList<StoreLeftBean>)
}
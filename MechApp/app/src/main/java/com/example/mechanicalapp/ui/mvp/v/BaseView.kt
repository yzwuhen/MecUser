package com.example.mechanicalapp.ui.mvp.v


interface BaseView<T> {
    fun showLoading()
    fun hiedLoading()
    fun showData(t: T)
}
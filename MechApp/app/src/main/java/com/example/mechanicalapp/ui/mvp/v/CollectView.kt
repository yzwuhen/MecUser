package com.example.mechanicalapp.ui.mvp.v


interface CollectView<T>:CollectBaseView {
    fun refreshUI(list: List<T>?)
    fun loadMore(list: List<T>?)
}
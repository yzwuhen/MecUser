package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface CollectView<T>:CollectBaseView {
    fun refreshUI(list: List<T>?)
    fun loadMore(list: List<T>?)

}
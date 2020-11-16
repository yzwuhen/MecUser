package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface FactoryOrderView<T> :BaseView<NetData> {
    fun showData(t:T)
}
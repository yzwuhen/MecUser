package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface TypeView<T>:BaseView<NetData> {
    fun refreshLeftUI(t:T?)
}
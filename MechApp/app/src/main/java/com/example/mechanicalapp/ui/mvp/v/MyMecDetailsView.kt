package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface MyMecDetailsView  :BaseView<NetData> {
    fun showData(netData: NetData?)
}
package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface MecDetailsView <T>:BaseView<NetData> {
    fun showData(data: T?)
    fun collectSuccess(netData: NetData?)
}
package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface ReleaseView <T> :BaseView<NetData> {
    fun showImg(netData: NetData?)
    fun showSuccess(netData: NetData?)
    fun showData(t:T)
}
package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface CollectBaseView :BaseView<NetData> {
    fun success(netData: NetData)
}
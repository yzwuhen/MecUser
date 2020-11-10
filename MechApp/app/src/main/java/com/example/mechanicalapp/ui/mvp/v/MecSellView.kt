package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.MecSellData

interface MecSellView<NetData> : BaseView<NetData> {
    fun refreshUI(list: List<MecSellData>)
    fun loadMore(list: List<MecSellData>)
}
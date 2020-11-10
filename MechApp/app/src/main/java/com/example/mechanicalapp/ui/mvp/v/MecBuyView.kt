package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.MecBuyData


interface MecBuyView <NetData> : BaseView<NetData> {
    fun refreshUI(list: List<MecBuyData>)
    fun loadMore(list: List<MecBuyData>)
}
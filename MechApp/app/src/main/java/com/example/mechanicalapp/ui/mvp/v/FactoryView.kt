package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.FactoryData
import com.example.mechanicalapp.ui.data.NetData

interface FactoryView :BaseView<NetData> {
    fun refreshUI(list: List<FactoryData>)
    fun loadMore(list: List<FactoryData>)

}
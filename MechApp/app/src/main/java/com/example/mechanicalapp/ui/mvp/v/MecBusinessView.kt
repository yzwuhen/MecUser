package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.MecData

interface MecBusinessView<NetData> : BaseView<NetData> {
    fun refreshUI(list: List<MecData>)
    fun loadMore(list: List<MecData>)
    fun err()
}
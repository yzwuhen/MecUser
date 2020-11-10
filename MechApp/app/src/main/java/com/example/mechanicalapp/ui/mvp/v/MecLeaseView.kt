package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.MecLeaseData

interface MecLeaseView <NetData> : BaseView<NetData> {
    fun refreshUI(list: List<MecLeaseData>)
    fun loadMore(list: List<MecLeaseData>)
}
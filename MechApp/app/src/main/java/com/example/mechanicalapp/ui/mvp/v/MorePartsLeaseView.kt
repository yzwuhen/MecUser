package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.MecLeaseData
import com.example.mechanicalapp.ui.data.PartsBean
import com.example.mechanicalapp.ui.data.PartsData

interface MorePartsLeaseView <NetData> :BaseView<NetData> {
    fun refreshUI(list: List<PartsData>)
    fun loadMore(list: List<PartsData>)
}
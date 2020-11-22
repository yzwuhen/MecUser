package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.CityData
import com.example.mechanicalapp.ui.data.NetData

interface AddressView:BaseView<NetData> {
    fun showCity(list: List<CityData>)
    fun showData(netData: NetData?)
}
package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.StoreLeftBean


interface StoreView <T> :BaseView<T> {

    fun showAd(adList: List<BannerData>)
    fun showData(hotMec: List<T>)
}
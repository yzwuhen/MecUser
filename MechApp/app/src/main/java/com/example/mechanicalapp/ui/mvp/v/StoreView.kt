package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.StoreLeftBean


interface StoreView <StoreLeftBean> :BaseView<StoreLeftBean> {

    fun showAd(adList: List<BannerData>)
//    fun showData(hotMec: List<StoreLeftBean>)
    fun err()
}
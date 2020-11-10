package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.*

interface HomeBaseView<NetData> : BaseView<NetData> {

    fun showAd(adList: List<BannerData>)
    fun showHotMec(hotMec: List<HotMechineCate>)//热门器械
    fun showParts(mecProds: List<HomePartsData>)//热门配件

    fun showLease(list: List<MecLeaseData>)//出租
    fun showUserRent(list: List<MecLeaseData>)//求租
    fun showBossSell(list: List<MecSellData>)//出售
    fun showBossBuy(list: List<MecBuyData>)//求购
}
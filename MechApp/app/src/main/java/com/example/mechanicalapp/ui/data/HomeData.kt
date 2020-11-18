package com.example.mechanicalapp.ui.data

class HomeData : NetData() {
    val result: Result? = null

    data class Result(
        val adList: List<BannerData>,
        val hotMechineCateList: List<HotMechineCate>,
        val mecProds: List<HomePartsData>,
        val newMecMarketMechanicsIn: List<MecLeaseData>,//求租
        val newMecMarketMechanicsOut: List<MecLeaseData>,//出租
        val newMecMarketOldMechanicsIn: List<MecSellData>,//求购列表
        val newMecMarketOldMechanicsOut: List<MecSellData>//出售列表
    )

}
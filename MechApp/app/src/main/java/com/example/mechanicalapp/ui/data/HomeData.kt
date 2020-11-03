package com.example.mechanicalapp.ui.data

class HomeData : NetData() {
    val result: Result? = null

    data class Result(
        val adList: List<BannerData>,
        val hotMechineCateList: List<HotMechineCate>,
        val mecProds: List<PartsData>,
        val newMecMarketMechanicsIn: List<MecRentData>,
        val newMecMarketMechanicsOut: List<MecSellData>,
        val newMecMarketOldMechanicsIn: List<MecRentData>,
        val newMecMarketOldMechanicsOut: List<MecSellData>
    )

}
package com.example.mechanicalapp.config

object Configs {
    //tye== 0 出租出售 1 招牌  2 求职 3 商品（配件） 4 配件求租 5 配件出租   6是搜索我的设备 7是搜索维修订单 8是工程师
    //9 是home 搜索 热门搜索跳转到多配件页  10跳转到维修厂
    const val HISTORY_TYPE :String ="history_type"
    const val SEARCH_TYPE :String="type"
    const val SEARCH_RESULT_TYPE :String="search_result_type"
    const val MEC_Lease_DETAILS_TYPE :String="mec_lease_details_type"// 0是出租 1 是出售
    const val MEC_ID :String="mec_id"//传的机械id
    const val MEC_ASK_DETAILS_TYPE :String="mec_ask_details_type"// 0是求租 1 是求购

    const val USER_HOME_PAGE :String="user_home_page"// 0是出售求购  1是出租求组  2求职招聘 3 配件出租求组
    const val USER_HOME_PAGE_Index :String="user_home_page_index"// 0是左  1 是右

    const val MORE_VIEW_TYPE :String="more_view_type"//  出租 出售  求租求购区分   0是租 1 是买卖

    const val EC_TYPE_RESULT_CODE:Int =1;//机械类型选择后返回得result_code
    const val EC_BRAND_RESULT_CODE:Int =2;//机械品牌选择后返回得result_code
    const val EC_MODEL_RESULT_CODE:Int =3;//机械型号选择后返回得result_code
    const val FACTORY_RESULT_CODE:Int =4;//维修厂选择后返回得result_code
    const val PARTS_RESULT_CODE:Int =5;//配件类型选择后返回得result_code
    const val CITY_RESULT_CODE:Int =6;//城市选择后返回得result_code
    const val PARTS_TYPE_RESULT_CODE:Int =7;//配件类型选择后返回得result_code
    const val ADDRESS_RESULT_CODE:Int =8;//选择地址后返回的result_code
    const val WORK_TYPE_RESULT_CODE:Int =9;//选择公众后后返回的result_code

    const val ADDRESS_LIST_SELECT_RESULT:Int =10;//地址列表选择后返回

    const val SCREEN_RESULT_Extra:String ="screen_type";//选择后返回得result_string
    const val SCREEN_RESULT_ID:String ="screen_id";//选择后返回得result_code

    const val FACTORY_ADDRESS:String ="factory_address";//维修厂地址
    const val CITY_NAME:String ="city_name";//选择后返回得result_code
    const val CITY_LAT:String ="city_lat";//选择后返回得result_code
    const val CITY_LOT:String ="city_lot";//选择后返回得result_code



//    const val EC_BRAND_RESULT_Extra:String ="ec_brand";//机械品牌选择后返回得result_code
//    const val EC_MODEL_RESULT_Extra:String ="ec_model";//机械型号选择后返回得result_code

    //const val BASE_URL:String="http://206e5202m7.imwork.net"
    const val BASE_URL:String="http://taotaopingping.info"
  //  const val TOKEN:String="token"

}
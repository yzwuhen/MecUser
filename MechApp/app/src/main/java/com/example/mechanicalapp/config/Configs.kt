package com.example.mechanicalapp.config

object Configs {
    //tye== 0 出租出售 1 招牌  2 求职 3 商品（配件） 4 配件求租 5 配件出租   6是搜索我的设备 7是搜索维修订单 8是工程师
    //9 是home 搜索 热门搜索跳转到多配件页  10跳转到维修厂
    //重新规划上面部分暂时保留 0 机械出租 1 机械求租 2 机械出售 3 机械求购  4配件出租 5 配件求租 6维修厂 7搜索我的设备 8 搜索维修订单 9 工程师 10home搜索  11 搜索商品
    //12 求职 13 招聘
    const val HISTORY_TYPE :String ="history_type"
    const val SEARCH_TYPE :String="type"
    //无用了 不需要分类型了
    const val SEARCH_RESULT_TYPE :String="search_result_type"
    //搜索内容
    const val SEARCH_RESULT_TITLE :String="search_result_title"

    const val MEC_Lease_DETAILS_TYPE :String="mec_lease_details_type"// 0是出租 1 是出售
    const val MEC_ID :String="mec_id"//传的机械id
    const val MEC_ASK_DETAILS_TYPE :String="mec_ask_details_type"// 0是求租 1 是求购

    const val USER_HOME_PAGE_NAME :String="user_home_page_name"//creat_by
    const val USER_HOME_PAGE :String="user_home_page"//1 是配件  2 是机械出售 3 是机械租赁 4 是招聘
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
    const val WORK_TYPE_RESULT_CODE:Int =9;//选择工种后后返回的result_code

    const val ADDRESS_LIST_SELECT_RESULT:Int =10;//地址列表选择后返回

    const val SCREEN_RESULT_Extra:String ="screen_type";//选择后返回得result_string
    const val SCREEN_RESULT_ID:String ="screen_id";//选择后返回得result_code

    const val FACTORY_ADDRESS:String ="factory_address";//维修厂地址
    const val CITY_NAME:String ="city_name";//选择后返回得result_code
    const val CITY_LAT:String ="city_lat";//选择后返回得result_code
    const val CITY_LOT:String ="city_lot";//选择后返回得result_code


    const val HISTORY_MEC_LEASE:String ="history_mec_lease"//历史记录 搜索机械出租
    const val HISTORY_MEC_ASK:String ="history_mec_ask"//历史记录 搜索机械求租
    const val HISTORY_MEC_SELL:String ="history_mec_sell"//历史记录 搜索机械出售
    const val HISTORY_MEC_BUY:String ="history_mec_buy"//历史记录 搜索机械求购
    const val HISTORY_PARTS_LEASE:String ="history_parts_lease"//历史记录 搜索配件 出租
    const val HISTORY_PARTS_ASK:String ="history_parts_ask"//历史记录 搜索配件求租
    const val HISTORY_GOODS:String ="history_goods"//历史记录 搜索求职商品
    const val HISTORY_RECRUIT:String ="history_recruit"//历史记录 搜索招聘
    const val HISTORY_JOB_WANT:String ="history_job_want"//历史记录 搜索求职
    const val HISTORY_FACTORY:String ="history_factory"//历史记录 搜索求职维修厂
    const val HISTORY_WORKER:String ="history_worker"//历史记录 工程师
    const val HISTORY_MY_MEC:String ="history_my_mec"//历史记录 我得设备
    const val HISTORY_REPAIR:String ="history_repair"//历史记录 维修订单
    const val HISTORY_HOME:String ="history_home"//历史记录 首页搜索
    const val VISIT:String ="visit"//最近访问
    //const val BASE_URL:String="http://206e5202m7.imwork.net"
     const val BASE_URL:String="http://taotaopingping.info"
    // const val BASE_URL ="http://81.71.123.237"

    const val TOKEN:String="token"
    const val USER_INFO:String="user_info"
    
    const val WX_APP_ID="wxcee9e76d06d68a8f"

}
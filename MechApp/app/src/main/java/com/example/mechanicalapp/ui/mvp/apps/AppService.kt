package com.example.mechanicalapp.ui.mvp.apps

import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.LoginCode
import io.reactivex.Observable
import retrofit2.http.*

interface AppService {
    @GET("/app/getAppList")
    fun getApps(
        @Query("page") page: Int?,
        @Query("pageSize") pageSize: Int?,
        @Query("type") type: Int?,
        @Query("extre") extre: String?
    ): Observable<NetData>

    @POST("/jeecg-boot/sys/appPhoneLogin")
    fun loginCode(@Body requestBody: LoginCode):Observable<LoginCodeBean>

    /*
    * 首页数据
    * */
    @GET("/jeecg-boot/app/userIndex")
    fun getHomeData():Observable<HomeData>

    /*
    * 商城首页数据
    * */
    @GET("/jeecg-boot/shop/mecProductCategory/AllList")
    fun getStoreData():Observable<StoreBean>


    /**
     * 租赁机械表-分页列表查询
     * 出租求组
     */
    @GET("/jeecg-boot/market/mecMarketMechanics/list")
    fun getMecList(@Query("bussiessType")bussiessType:Int,@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,
                      @Query(" brandId") brandId:String?, @Query("cateId")cateId:String?, @Query("modelId")modelId:String?
    ):Observable<MoreLeaseData>


    /**
     * 租赁配件-分页列表查询
     * 出租 求租
     * bussiessType 1出租2求租
     */
    @GET("/jeecg-boot/market/mecMarketParts/list")
    fun getPartsList(@Query("bussiessType")bussiessType:Int,@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,
                   @Query(" brandId") brandId:String?, @Query("cateId")cateId:String?, @Query("modelId")modelId:String?
    ):Observable<MoreLeaseData>


    /**
     * 交易机械表-分页列表查询
     * 出售求购
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/list")
    fun getMecBuyList(@Query("bussiessType")bussiessType:Int,@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,
                   @Query(" brandId") brandId:String?, @Query("cateId")cateId:String?, @Query("modelId")modelId:String?
    ):Observable<MoreBusinessData>


    /**
     * 配件租赁表-分页列表查询
     * 出售求购
     */
    @GET("/jeecg-boot/market/mecMarketMechanics/list")
    fun getRentList(@Query("bussiessType")bussiessType:Int,@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,
                   @Query(" brandId") brandId:String?, @Query("cateId")cateId:String?, @Query("modelId")modelId:String?
    ):Observable<MoreLeaseData>
}
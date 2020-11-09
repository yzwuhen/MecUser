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
    fun getPartsList(@Query("bussiessType")bussiessType:Int, @Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,
                     @Query(" brandId") brandId:String?, @Query("cateId")cateId:String?, @Query("modelId")modelId:String?
    ):Observable<PartsBean>


    /**
     * 交易机械表-分页列表查询
     * 求购
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/list")
    fun getMecBuyList(@Query("bussiessType")bussiessType:Int,@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,
                   @Query(" brandId") brandId:String?, @Query("cateId")cateId:String?, @Query("modelId")modelId:String?
    ):Observable<MoreBusinessData>


    /**
     * 交易机械表-分页列表查询
     * 出售
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/list")
    fun getSellList(@Query("bussiessType")bussiessType:Int,@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,
                      @Query(" brandId") brandId:String?, @Query("cateId")cateId:String?, @Query("modelId")modelId:String?
    ):Observable<MoreSellBean>




    /**
     * 招聘列表
     * region：地区
     */
    @GET("/jeecg-boot/market/mecMarketRecruit/list")
    fun getRecruitList(@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,@Query("recruitType")recruitType:String,
                      @Query(" region") region:String?, @Query("typeWork")typeWork:String?, @Query("sort")sort:String?
    ):Observable<RecruitBean>


    /**
     * 求职列表
     * region：地区
     */
    @GET("/jeecg-boot/market/mecMarketRecruit/list")
    fun getWantWorkList(@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,@Query("recruitType")recruitType:String,
                       @Query(" region") region:String?, @Query("typeWork")typeWork:String?, @Query("sort")sort:String?
    ):Observable<NetData>




    /**
     * 工厂列表
     * region：地区
     */
    @GET("/jeecg-boot/repair/mecRepaireFactory/list")
    fun getFactoryList(@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int,@Query("mecType")mecType:String?,
                        @Query(" partsType") partsType:String? ,@Query("sort")sort:String?
    ):Observable<NetData>




    /**
     * 机型
     *
     */
    @GET("/jeecg-boot/machine/mecMachineModel/list")
    fun getMecModelList(@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int):Observable<NetData>
    /**
     * 机械类型
     *
     */
    @GET("/jeecg-boot/machine/mecMachineCate/rootList")
    fun getMecType(@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int):Observable<NetData>
    /**
     * 机械品牌
     *
     */
    @GET("/jeecg-boot/machine/mecMachineBrand/list")
    fun getMecBrandList(@Query("pageNo")pageNo:Int, @Query("pageSize")pageSize:Int):Observable<NetData>
}
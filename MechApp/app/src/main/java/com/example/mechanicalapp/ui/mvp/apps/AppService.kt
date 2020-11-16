package com.example.mechanicalapp.ui.mvp.apps

import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.*
import io.reactivex.Observable
import okhttp3.MultipartBody
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
    fun getMecList(
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query(" brandId") brandId: String?,
        @Query("cateId") cateId: String?,
        @Query("modelId") modelId: String?,
        @Query("tittle") title: String?
    ):Observable<MoreLeaseData>


    /**
     * 租赁配件-分页列表查询
     * 出租 求租
     * bussiessType 1出租2求租
     */
    @GET("/jeecg-boot/market/mecMarketParts/list")
    fun getPartsList(
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query(" brandId") brandId: String?,
        @Query("cateId") cateId: String?,
        @Query("modelId") modelId: String?
    ):Observable<PartsBean>


    /**
     * 交易机械表-分页列表查询
     * 求购
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/list")
    fun getMecBuyList(
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query(" brandId") brandId: String?,
        @Query("cateId") cateId: String?,
        @Query("modelId") modelId: String?
    ):Observable<MoreBusinessData>


    /**
     * 交易机械表-分页列表查询
     * 出售
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/list")
    fun getSellList(
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query(" brandId") brandId: String?,
        @Query("cateId") cateId: String?,
        @Query("modelId") modelId: String?,
        @Query("title") title: String?
    ):Observable<MoreSellBean>




    /**
     * 招聘列表
     * region：地区
     */
    @GET("/jeecg-boot/market/mecMarketRecruit/list")
    fun getRecruitList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("recruitType") recruitType: String,
        @Query(" region") region: String?,
        @Query("typeWork") typeWork: String?,
        @Query("sort") sort: String?,
        @Query("jobTittle") jobTittle: String?
    ):Observable<RecruitBean>


    /**
     * 求职列表
     * region：地区
     */
    @GET("/jeecg-boot/market/mecMarketRecruit/list")
    fun getWantWorkList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("recruitType") recruitType: String,
        @Query(" region") region: String?,
        @Query("typeWork") typeWork: String?,
        @Query(
            "sort"
        ) sort: String?,
        @Query("jobTittle") jobTittle: String?
    ):Observable<NetData>




    /**
     * 工厂列表
     * region：地区
     */
    @GET("/jeecg-boot/repair/mecRepaireFactory/list")
    fun getFactoryList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("mecType") mecType: String?,
        @Query(" partsType") partsType: String?,
        @Query("sort") sort: String?,
        @Query("name") name: String?
    ):Observable<MoreFactoryBean>


    /**
     * 获取工种
     * region：地区
     * 返回格式与机械类型差不多 就直接用了
     */
    @GET("/jeecg-boot/market/mecMarketRecruitCate/rootList")
    fun getWorkTypeList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<MecTypeParentBean>

    /**
     * 获取工种 子级
     * region：地区
     * 返回格式与机械类型差不多 就直接用了
     */
    @GET("/jeecg-boot/market/mecMarketRecruitCate/rootList")
    fun getWorkTypeChildList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("id") id:String
    ):Observable<MecTypeChildBean>


    /**
     * 机型
     *
     */
    @GET("/jeecg-boot/machine/mecMachineModel/list")
    fun getMecModelList(@Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int):Observable<MecModelBean>
    /**
     * 机械父级类型
     *
     */
    @GET("/jeecg-boot/machine/mecMachineCate/rootList")
    fun getMecParentType(@Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int):Observable<MecTypeParentBean>

    /**
     * 机械子级类型
     *
     */
    @GET("/jeecg-boot/machine/mecMachineCate/childList")
    fun getMecChildType(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("id") pid: String
    ):Observable<MecTypeChildBean>



    /**
     * 配件-机型
     *
     */
    @GET("/jeecg-boot//parts/mecPartsModel/list")
    fun getPartsModelList(@Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int):Observable<MecModelBean>


    /**
     * 配件父级类型
     *
     */
    @GET("/jeecg-boot/parts/mecPartsCate/rootList")
    fun getPartsParentType(@Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int):Observable<MecTypeParentBean>

    /**
     * 配件子级类型
     *
     */
    @GET("/jeecg-boot/parts/mecPartsCate/childList")
    fun getPartsChildType(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("id") pid: String
    ):Observable<MecTypeChildBean>


    /**
     * 机械品牌
     *
     */
    @GET("/jeecg-boot/machine/mecMachineBrand/list")
    fun getMecBrandList(@Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int):Observable<BrandBean>


    /**
     * 添加租赁机械
     *
     */
    @POST("/jeecg-boot/market/mecMarketMechanics/add")
    fun addMecLease(@Body mReMecLease: ReMecLease,@Header("X-Access-Token")token: String?) :Observable<NetData>

    /**
     * 添加交易机械--出售 求购
     */
    @POST("/jeecg-boot/market/mecMarketOldMechanics/add")
    fun addMecBusiness(@Body mReMecSell: ReMecBusiness,@Header("X-Access-Token")token: String?) :Observable<NetData>


    /**
     * 添加配件--出售 求购
     */
    @POST("/jeecg-boot/market/mecMarketParts/add")
    fun addPartsLease(@Body mRePartsLease: RePartsLease,@Header("X-Access-Token")token: String?) :Observable<NetData>

    /**
     * 招聘需求--招聘、 求职
     */
    @POST("/jeecg-boot/market/mecMarketRecruit/add")
    fun addWorkAbout(@Body mReWorkAbout: ReWorkAbout,@Header("X-Access-Token")token: String?) :Observable<NetData>


    /**
     * 上传文件
     */
    @Multipart
    @POST("/jeecg-boot/sys/common/upload")
    fun uploadFile(
        @Part file: MultipartBody.Part?
    ): Observable<NetData>


    /**
     * 收藏的 机械租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_Machine")
    fun getCollectList(@Header("X-Access-Token")token:String,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<NetData>


    /**
     * 收藏的 二手机械租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_oldMachine")
    fun getCollectSecondHandList(@Header("X-Access-Token")token:String,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<NetData>

    /**
     * 收藏的 配件租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_parts")
    fun getCollectPartsList(@Header("X-Access-Token")token:String,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<NetData>

    /**
     * 收藏的 招聘 求职
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_Recruit")
    fun getCollectRecruitList(@Header("X-Access-Token")token:String,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<NetData>


    /**
     * 收藏的 工厂租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_repairFactory")
    fun getCollectFactoryList(@Header("X-Access-Token")token:String,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<NetData>

    /**
     * 收藏的 商品租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList")
    fun getCollectGoodsyList(@Header("X-Access-Token")token:String,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<NetData>

    /**
     * 收藏的 商品租赁
     */
    @GET("/jeecg-boot/sys/dictItem/listByDictCode")
    fun getCode(@Query("dictCode")dictCode:String): Observable<CodeBean>



}
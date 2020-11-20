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
     * 租赁机械表-分页列表查询
     * 出租求组
     */
    @GET("/jeecg-boot/market/mecMarketMechanics/list")
    fun getMyLeaseList(
        @Header("X-Access-Token")token:String?,
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<MoreLeaseData>


    /**
     * 租赁机械表-分页列表查询
     * 出售 求购
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/list")
    fun getMyBusinessList(
        @Header("X-Access-Token")token:String?,
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<MoreSellBean>


    /**
     * 租赁机械表-分页列表查询
     * 刷新
     */
    @POST("/jeecg-boot/market/mecMarketMechanics/refresh")
    fun getRefreshLeaseList(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>
    /**
     * 租赁机械表-分页列表查询
     * 下架\ 上架
     */
    @POST("/jeecg-boot/market/mecMarketMechanics/edit")
    fun editLease(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>

    /**
     * 租赁机械表-分页列表查询
     * 删除
     */
    @POST("/jeecg-boot/market/mecMarketMechanics/delete")
    fun delLease(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>



    /**
     * 买卖机械表-分页列表查询
     * 刷新
     */
    @POST("/jeecg-boot/market/mecMarketOldMechanics/refresh")
    fun getRefreshBusiness(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>
    /**
     * 买卖机械表-分页列表查询
     * 下架\ 上架
     */
    @POST("/jeecg-boot/market/mecMarketOldMechanics/edit")
    fun editBusiness(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>

    /**
     * 买卖机械表-分页列表查询
     * 删除
     */
    @POST("/jeecg-boot/market/mecMarketOldMechanics/delete")
    fun delBusiness(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>


    /**
     * 租赁配件-分页列表查询
     * 出租 求租
     * bussiessType 1出租2求租
     */
    @GET("/jeecg-boot/market/mecMarketParts/list")
    fun getReleasePartsList(
        @Header("X-Access-Token")token:String?,
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<PartsBean>


    /**
     * 配件机械表-分页列表查询
     * 刷新
     */
    @POST("/jeecg-boot/market/mecMarketParts/refresh")
    fun refreshParts(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>
    /**
     * 配件机械表-分页列表查询
     * 下架\ 上架
     */
    @POST("/jeecg-boot/market/mecMarketParts/edit")
    fun editParts(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>

    /**
     * 配件机械表-分页列表查询
     * 删除
     */
    @POST("/jeecg-boot/market/mecMarketParts/delete")
    fun delParts(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>



    /**
     * 求职招聘-分页列表查询
     * 求职招聘
     * bussiessType 1出租2求租
     */
    @GET("/jeecg-boot/market/mecMarketRecruit/list")
    fun getReleaseWorkList(
        @Header("X-Access-Token")token:String?,
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<RecruitBean>


    /**
     * 求职招聘-分页列表查询
     * 刷新
     */
    @POST("/jeecg-boot/market/mecMarketRecruit/refresh")
    fun refreshWork(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>
    /**
     * 求职招聘-分页列表查询
     * 下架\ 上架
     */
    @POST("/jeecg-boot/market/mecMarketRecruit/edit")
    fun editWork(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>

    /**
     * 求职招聘-分页列表查询
     * 删除
     */
    @POST("/jeecg-boot/market/mecMarketRecruit/delete")
    fun delWork(
        @Header("X-Access-Token")token:String?,
        @Body body: ReMyRelease
    ):Observable<NetData>




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
     * 添加维修单
     */
    @POST("/jeecg-boot/repair/mecRepairOrder/add")
    fun addFactoryOrder(@Body mReFactoryOrder: ReFactoryOrder,@Header("X-Access-Token")token: String?) :Observable<NetData>



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
    fun getCollectList(@Header("X-Access-Token")token:String?,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<CollectLeaseBean>


    /**
     * 收藏的 二手机械租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_oldMachine")
    fun getCollectSecondHandList(@Header("X-Access-Token")token:String?,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<CollectBusinessBean>

    /**
     * 收藏的 配件租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_parts")
    fun getCollectPartsList(@Header("X-Access-Token")token:String?,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<CollectPartsBean>

    /**
     * 收藏的 招聘 求职
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_Recruit")
    fun getCollectRecruitList(@Header("X-Access-Token")token:String?,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<CollectRecruitBean>


    /**
     * 收藏的 工厂租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_repairFactory")
    fun getCollectFactoryList(@Header("X-Access-Token")token:String?,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<CollectFactoryBean>

    /**
     * 收藏的 商品租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList")
    fun getCollectGoodsList(@Header("X-Access-Token")token:String?,@Query("type")type:Int, @Query("pageNo") pageNo: Int, @Query("pageSize") pageSize: Int): Observable<CollectGoodsBean>

    /**
     * 收藏的 商品租赁
     */
    @GET("/jeecg-boot/sys/dictItem/listByDictCode")
    fun getCode(@Query("dictCode")dictCode:String): Observable<CodeBean>


    /**
     * 收藏的 商品租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList")
    fun delCollect(@Header("X-Access-Token")token:String?,@Query("ids")ids:String?): Observable<NetData>



    /**
     * 租赁机械表-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_Machine")
    fun getLookLeaseList(
        @Header("X-Access-Token")token:String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<MyLookLeaseBean>



    /**
     * 二手设备买卖-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_oldMachine")
    fun getLookSecondLeaseList(
        @Header("X-Access-Token")token:String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<MyLookLeaseBean>

    /**
     * 配件表-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_parts")
    fun getLookParts(
        @Header("X-Access-Token")token:String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<LookPartsBean>
    /**
     * 求职招聘-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_Recruit")
    fun getLookRecruitList(
        @Header("X-Access-Token")token:String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<LookRecruitBean>

    /**
     * 维修厂-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_repairFactory")
    fun getLookFactoryList(
        @Header("X-Access-Token")token:String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<LookFactoryBean>



    /**
     * 商品-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList")
    fun getLookGoodsList(
        @Header("X-Access-Token")token:String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<LookGoodsBean>


    /**
     * 租赁机械表-分页列表查询
     * wo de 地址
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_Machine")
    fun getAddressList(
        @Header("X-Access-Token")token:String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<NetData>

    /**
     * 租赁机械表-分页列表查询
     * 获取我的积分
     */
    @GET("/jeecg-boot/market/mecMarketPoints/getAuthPoints")
    fun getIntegral(
        @Header("X-Access-Token")token:String?
    ):Observable<IntegralBean>

    /**
     * 租赁机械表-分页列表查询
     * 获取我的积分列表
     */
    @GET("/jeecg-boot/market/mecMarketPointsLog/list")
    fun getIntegralList(
        @Header("X-Access-Token")token:String?,
    @Query("pageNo") pageNo: Int,
    @Query("pageSize") pageSize: Int
    ):Observable<IntegralListBean>

    /**
     * 签到
     */
    @GET("/jeecg-boot/market/mecMarketPoints/signInMarketAuthPoints")
    fun signIntegral(
        @Header("X-Access-Token")token:String?
    ):Observable<NetData>


    /**
     * 提交个人认证  企业认证 维修厂认证
     */
    @POST("/jeecg-boot/market/mecUserApprove/add")
    fun submitCer(
        @Header("X-Access-Token")token:String?,
        @Body rePersonCer: ReCer
    ):Observable<NetData>

    /**
     * 获取机械类型树
     */
    @GET("/jeecg-boot/machine/mecMachineCate/getTreeList")
    fun getMecType(
        @Header("X-Access-Token")token:String?
    ):Observable<MecTypeBean>


    /**
     * 获取配件类型树
     */
    @GET("/jeecg-boot/repair/mecRepairOrderDetail/getPartsList")
    fun getPartType(
        @Header("X-Access-Token")token:String?
    ):Observable<MecTypeBean>



    /**
     *
     * 获取我的设备列表
     */
    @GET("/jeecg-boot/machine/mecMachine/list")
    fun getMyMecList(
        @Header("X-Access-Token")token:String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ):Observable<MyLookLeaseBean>


    /**
     *
     * 获取机械出租 求租详情
     */
    @GET("/jeecg-boot/market/mecMarketMechanics/queryById")
    fun getLeaseDetails(
        @Header("X-Access-Token")token:String?,
        @Query("id") id: String?
    ):Observable<MecDetailsBean>


    /**
     *
     * 获取机械出租出售详情
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/queryById")
    fun getBusinessDetails(
        @Header("X-Access-Token")token:String?,
        @Query("id") id: String?
    ):Observable<BusinessDetailsBean>


    /**
     *
     * 获取商品详情
     */
    @GET("/jeecg-boot/shop/mecProd/queryById")
    fun getGoodsDetail(
        @Header("X-Access-Token")token:String?,
        @Query("id") id: String?
    ):Observable<GoodsDetailsBean>


    /**
     *
     * 添加收藏
     */
    @POST("/jeecg-boot/my/mecMyStore/add")
    fun addCollect(
        @Header("X-Access-Token")token:String?,
        @Body reCollect: ReCollect
    ):Observable<NetData>

}
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
    fun loginCode(@Body requestBody: LoginCode): Observable<LoginCodeBean>

    @POST("/jeecg-boot/sys/appPhonePasswordLogin")
    fun loginPwd(@Body requestBody: LoginCode): Observable<LoginCodeBean>

    @POST("/jeecg-boot/sys/register")
    fun register(@Body requestBody: ReRegister): Observable<LoginCodeBean>


    @FormUrlEncoded
    @POST("/jeecg-boot/sys/loginByAliToken")
    fun loginAli(@Field("accessToken")accessToken:String?): Observable<LoginCodeBean>

    @POST("/jeecg-boot/sys/appLoginByThirdId")
    fun loginThree(@Body requestBody: ReLoginThree): Observable<LoginCodeBean>

    @POST("/jeecg-boot/sys/appBindUserByThirdId")
    fun bindThree(@Body requestBody: ReLoginThree?): Observable<LoginCodeBean>

    @POST("/jeecg-boot/sys/user/appChangePassword")
    fun resetPwd(
        @Header("X-Access-Token") token: String?,
        @Body requestBody: ResetPwd
    ): Observable<LoginCodeBean>

    @POST("/jeecg-boot/sys/sms")
    fun getMsgCode(@Body requestBody: ReGetMsgCode): Observable<NetData>


    @POST("/jeecg-boot/sys/user/checkCaptcha")
    fun verifyCode(@Body requestBody: ReGetMsgCode): Observable<NetData>

    @POST("/jeecg-boot/sys/user/forgotPassword")
    fun forgotPwd(@Body requestBody: ReGetMsgCode): Observable<NetData>

    /*
    * 首页数据
    * */
    @GET("/jeecg-boot/app/userIndex")
    fun getHomeData(): Observable<HomeData>

    /*
    * 商城首页数据
    * */
    @GET("/jeecg-boot/shop/mecProductCategory/AllList")
    fun getStoreData(): Observable<StoreBean>


    /**
     * 租赁机械表-分页列表查询
     * 出租求组
     */
    @GET("/jeecg-boot/market/mecMarketMechanics/list")
    fun getMecList(
        @Query("bussiessType") bussiessType: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query(" brandId") brandId: String?,
        @Query("cateId") cateId: String?,
        @Query("modelId") modelId: String?,
        @Query("title") title: String?,
        @Query("sort") sort: Int?,
        @Query("SGriceLe") mSGriceLe: String?,
        @Query("SPriceGe") mSPriceGe: String?,
        @Query(" STenancyGe") mSTenancyGe: String?,
        @Query("STenancyLe") mSTenancyLe: String?,
        @Query("SWorkTimeGe") mSWorkTimeGe: String?,
        @Query("SWorkTimeLe") mSWorkTimeLe: String?,
        @Query("isMap") isMap: String?,
        @Query("SGpsLat") lat: String?,
        @Query("SGpsLon") lon: String?
    ): Observable<MoreLeaseData>

    /**
     * 租赁机械表-分页列表查询
     * 出租求组
     */
    @GET("/jeecg-boot/market/mecMarketRecruit/getMyList")
    fun getMyLeaseList(
        @Header("X-Access-Token") token: String?,
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MoreLeaseData>


    /**
     * 租赁机械表-分页列表查询
     * 出售 求购
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/getMyList")
    fun getMyBusinessList(
        @Header("X-Access-Token") token: String?,
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MoreSellBean>


    /**
     * 租赁机械表-分页列表查询
     * 刷新
     */
    @POST("/jeecg-boot/market/mecMarketMechanics/refresh")
    fun getRefreshLeaseList(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>

    /**
     * 租赁机械表-分页列表查询
     * 下架\ 上架
     */
    @POST("/jeecg-boot/market/mecMarketMechanics/edit")
    fun editLease(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>

    /**
     * 租赁机械表-分页列表查询
     * 删除
     */
    @POST("/jeecg-boot/market/mecMarketMechanics/delete")
    fun delLease(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>


    /**
     * 买卖机械表-分页列表查询
     * 刷新
     */
    @POST("/jeecg-boot/market/mecMarketOldMechanics/refresh")
    fun getRefreshBusiness(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>

    /**
     * 买卖机械表-分页列表查询
     * 下架\ 上架
     */
    @POST("/jeecg-boot/market/mecMarketOldMechanics/edit")
    fun editBusiness(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>

    /**
     * 买卖机械表-分页列表查询
     * 删除
     */
    @POST("/jeecg-boot/market/mecMarketOldMechanics/delete")
    fun delBusiness(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>


    /**
     * 租赁配件-分页列表查询
     * 出租 求租
     * bussiessType 1出租2求租
     */
    @GET("/jeecg-boot/market/mecMarketParts/getMyList")
    fun getReleasePartsList(
        @Header("X-Access-Token") token: String?,
        @Query("bussiessType") bussiessType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<PartsBean>


    /**
     * 配件机械表-分页列表查询
     * 刷新
     */
    @POST("/jeecg-boot/market/mecMarketParts/refresh")
    fun refreshParts(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>

    /**
     * 配件机械表-分页列表查询
     * 下架\ 上架
     */
    @POST("/jeecg-boot/market/mecMarketParts/edit")
    fun editParts(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>

    /**
     * 配件机械表-分页列表查询
     * 删除
     */
    @POST("/jeecg-boot/market/mecMarketParts/delete")
    fun delParts(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>


    /**
     * 求职招聘-分页列表查询
     * 求职招聘
     * recruitType
     */
    @GET("/jeecg-boot/market/mecMarketRecruit/getMyList")
    fun getReleaseWorkList(
        @Header("X-Access-Token") token: String?,
        @Query("recruitType") recruitType: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<RecruitBean>


    /**
     * 求职招聘-分页列表查询
     * 刷新
     */
    @POST("/jeecg-boot/market/mecMarketRecruit/refresh")
    fun refreshWork(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>

    /**
     * 求职招聘-分页列表查询
     * 下架\ 上架
     */
    @POST("/jeecg-boot/market/mecMarketRecruit/edit")
    fun editWork(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>

    /**
     * 求职招聘-分页列表查询
     * 删除
     */
    @POST("/jeecg-boot/market/mecMarketRecruit/delete")
    fun delWork(
        @Header("X-Access-Token") token: String?,
        @Body body: ReMyRelease
    ): Observable<NetData>


    /**
     * 租赁配件-分页列表查询
     * 出租 求租
     * bussiessType 1出租2求租
     */
    @GET("/jeecg-boot/market/mecMarketParts/list")
    fun getPartsList(
        @Query("bussiessType") bussiessType: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("cateId") cateId: String?,
        @Query("title") title: String?,
        @Query("sort") sort: Int?,
        @Query("isMap") isMap: String?,
        @Query("SGpsLat") lat: String?,
        @Query("SGpsLon") lon: String?
    ): Observable<PartsBean>


    /**
     * 交易机械表-分页列表查询
     * 求购
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/list")
    fun getMecBuyList(
        @Query("bussiessType") bussiessType: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query(" brandId") brandId: String?,
        @Query("cateId") cateId: String?,
        @Query("modelId") modelId: String?,
        @Query("title") title: String?,
        @Query("sort") sort: Int?,
        @Query("SGriceLe") mSGriceLe: String?,
        @Query("SPriceGe") mSPriceGe: String?,
        @Query(" STenancyGe") mSTenancyGe: String?,
        @Query("STenancyLe") mSTenancyLe: String?,
        @Query("SWorkTimeGe") mSWorkTimeGe: String?,
        @Query("SWorkTimeLe") mSWorkTimeLe: String?
    ): Observable<MoreBusinessData>


    /**
     * 交易机械表-分页列表查询
     * 出售
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/list")
    fun getSellList(
        @Query("bussiessType") bussiessType: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query(" brandId") brandId: String?,
        @Query("cateId") cateId: String?,
        @Query("modelId") modelId: String?,
        @Query("title") title: String?,
        @Query("sort") sort: Int?,
        @Query("SGriceLe") mSGriceLe: String?,
        @Query("SPriceGe") mSPriceGe: String?,
        @Query(" STenancyGe") mSTenancyGe: String?,
        @Query("STenancyLe") mSTenancyLe: String?,
        @Query("SWorkTimeGe") mSWorkTimeGe: String?,
        @Query("SWorkTimeLe") mSWorkTimeLe: String?,
        @Query("isMap") isMap: String?,
        @Query("SGpsLat") lat: String?,
        @Query("SGpsLon") lon: String?
    ): Observable<MoreSellBean>


    /**
     * 招聘列表
     * region：地区
     */
    @GET("/jeecg-boot/market/mecMarketRecruit/list")
    fun getRecruitList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("recruitType") recruitType: String,
        @Query("city") region: String?,
        @Query("cateName") typeWork: String?,
        @Query("cateId") typeWorkId: String?,
        @Query("sort") sort: Int,
        @Query("jobtitle") jobtitle: String?,
        @Query("isMap") isMap: String?,
        @Query("SGpsLat") lat: String?,
        @Query("SGpsLon") lon: String?
    ): Observable<RecruitBean>


    /**
     * 工厂列表
     * region：地区
     */
    @GET("/jeecg-boot/repair/mecRepaireFactory/list")
    fun getFactoryList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("repaireType") mecType: String?,//机械类型
        @Query("componentType") partsType: String?,
        @Query("sort") sort: String?,
        @Query("name") name: String?,
        @Query("isMap") isMap: String?,
        @Query("SGpsLat") lat: String?,
        @Query("SGpsLon") lon: String?
    ): Observable<MoreFactoryBean>


    /**
     * 获取工种
     * region：地区
     * 返回格式与机械类型差不多 就直接用了
     */
    @GET("/jeecg-boot/market/mecMarketRecruitCate/getTreeList")
    fun getWorkTypeList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<WorkTypeBean>


    /**
     * 机型
     *
     */
    @GET("/jeecg-boot/machine/mecMachineModel/list")
    fun getMecModelList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MecModelBean>

    /**
     * 机械父级类型
     *
     */
    @GET("/jeecg-boot/machine/mecMachineCate/getTreeList")
    fun getMecParentType(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MecTypeRootBean>

    /**
     * 机械子级类型
     *
     */
    @GET("/jeecg-boot/machine/mecMachineCate/childList")
    fun getMecChildType(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("id") pid: String
    ): Observable<MecTypeChildBean>


    /**
     * 配件-机型
     *
     */
    @GET("/jeecg-boot//parts/mecPartsModel/list")
    fun getPartsModelList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MecModelBean>


    /**
     * 配件父级类型
     *
     */
    @GET("/jeecg-boot/parts/mecPartsCate/rootList")
    fun getPartsParentType(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MecTypeParentBean>

    /**
     * 配件子级类型
     *
     */
    @GET("/jeecg-boot/parts/mecPartsCate/childList")
    fun getPartsChildType(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int,
        @Query("id") pid: String
    ): Observable<MecTypeChildBean>


    /**
     * 机械品牌
     *
     */
    @GET("/jeecg-boot/machine/mecMachineBrand/list")
    fun getMecBrandList(
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<BrandBean>


    /**
     * 添加租赁机械
     *
     */
    @POST("/jeecg-boot/market/mecMarketMechanics/add")
    fun addMecLease(
        @Body mReMecLease: ReMecLease,
        @Header("X-Access-Token") token: String?
    ): Observable<NetData>

    /**
     * 添加交易机械--出售 求购
     */
    @POST("/jeecg-boot/market/mecMarketOldMechanics/add")
    fun addMecBusiness(
        @Body mReMecSell: ReMecBusiness,
        @Header("X-Access-Token") token: String?
    ): Observable<NetData>


    /**
     * 添加维修单
     */
    @POST("/jeecg-boot/repair/mecRepairOrder/add")
    fun addFactoryOrder(
        @Body mReFactoryOrder: ReFactoryOrder,
        @Header("X-Access-Token") token: String?
    ): Observable<NetData>


    /**
     * 添加配件--出售 求购
     */
    @POST("/jeecg-boot/market/mecMarketParts/add")
    fun addPartsLease(
        @Body mRePartsLease: RePartsLease,
        @Header("X-Access-Token") token: String?
    ): Observable<NetData>

    /**
     * 招聘需求--招聘、 求职
     */
    @POST("/jeecg-boot/market/mecMarketRecruit/add")
    fun addWorkAbout(
        @Body mReWorkAbout: ReWorkAbout,
        @Header("X-Access-Token") token: String?
    ): Observable<NetData>


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
    fun getCollectList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CollectLeaseBean>


    /**
     * 收藏的 二手机械租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_oldMachine")
    fun getCollectSecondHandList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CollectBusinessBean>

    /**
     * 收藏的 配件租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_parts")
    fun getCollectPartsList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CollectPartsBean>

    /**
     * 收藏的 招聘 求职
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_Recruit")
    fun getCollectRecruitList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CollectRecruitBean>


    /**
     * 收藏的 工厂租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList_repairFactory")
    fun getCollectFactoryList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CollectFactoryBean>

    /**
     * 收藏的 商品租赁
     */
    @GET("/jeecg-boot/my/mecMyStore/appQueryPageList")
    fun getCollectGoodsList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CollectGoodsBean>

    /**
     * 收藏的 商品租赁
     */
    @GET("/jeecg-boot/sys/dictItem/listByDictCode")
    fun getCode(@Query("dictCode") dictCode: String): Observable<CodeBean>


    /**
     * 批量删除收藏
     */
    @GET("/jeecg-boot/my/mecMyStore/delBystoreIds")
    fun delBatchCollect(
        @Header("X-Access-Token") token: String?,
        @Query("storeIds") ids: String?,
        @Query("type")  type: Int?
    ): Observable<NetData>


    /**
     * 租赁机械表-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_Machine")
    fun getLookLeaseList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MyLookLeaseBean>


    /**
     * 二手设备买卖-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_oldMachine")
    fun getLookSecondLeaseList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MyLookLeaseBean>

    /**
     * 配件表-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_parts")
    fun getLookParts(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<LookPartsBean>

    /**
     * 求职招聘-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_Recruit")
    fun getLookRecruitList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<LookRecruitBean>

    /**
     * 维修厂-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList_repairFactory")
    fun getLookFactoryList(
        @Header("X-Access-Token") token: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<LookFactoryBean>


    /**
     * 商品-分页列表查询
     * 我的查看
     */
    @GET("/jeecg-boot/my/mecMyViewed/appQueryPageList")
    fun getLookGoodsList(
        @Header("X-Access-Token") token: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<LookGoodsBean>


    /**
     *
     * wo de 地址
     */
    @GET("/jeecg-boot/shop/mecReceiver/getMylist")
    fun getAddressList(
        @Header("X-Access-Token") token: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MyAddressBean>


    /**
     * 租赁机械表-分页列表查询
     * wo de 地址
     */
    @POST("/jeecg-boot/shop/mecReceiver/add")
    fun addAddress(
        @Header("X-Access-Token") token: String?,
        @Body reAddress: ReAddress?
    ): Observable<NetData>


    /**
     * 租赁机械表-分页列表查询
     * wo de 地址
     */
    @GET("/jeecg-boot/shop/mecReceiver/delete")
    fun delAddress(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<NetData>


    /**
     * 租赁机械表-分页列表查询
     * wo de 地址
     */
    @POST("/jeecg-boot/shop/mecReceiver/edit")
    fun editAddress(
        @Header("X-Access-Token") token: String?,
        @Body reAddress: ReAddress?
    ): Observable<NetData>


    /**
     * 租赁机械表-分页列表查询
     * 获取我的积分
     */
    @GET("/jeecg-boot/market/mecMarketPoints/getAuthPoints")
    fun getIntegral(
        @Header("X-Access-Token") token: String?
    ): Observable<IntegralBean>

    /**
     * 租赁机械表-分页列表查询
     * 获取我的积分列表
     */
    @GET("/jeecg-boot/market/mecMarketPointsLog/list")
    fun getIntegralList(
        @Header("X-Access-Token") token: String?,
        @Query("createBy") createBy: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<IntegralListBean>

    /**
     * 签到
     */
    @GET("/jeecg-boot/market/mecMarketPoints/signInMarketAuthPoints")
    fun signIntegral(
        @Header("X-Access-Token") token: String?
    ): Observable<NetData>


    /**
     * 提交个人认证  企业认证 维修厂认证
     */
    @POST("/jeecg-boot/market/mecUserApprove/add")
    fun submitCer(
        @Header("X-Access-Token") token: String?,
        @Body rePersonCer: ReCer
    ): Observable<NetData>

    /**
     * 获取机械类型树
     */
    @GET("/jeecg-boot/machine/mecMachineCate/getTreeList")
    fun getMecType(
        @Header("X-Access-Token") token: String?
    ): Observable<MecTypeBean>


    /**
     * 获取配件类型树
     */
    @GET("/jeecg-boot/repair/mecRepairOrderDetail/getPartsList")
    fun getPartType(
        @Header("X-Access-Token") token: String?
    ): Observable<MecTypeBean>


    /**
     *
     * 获取我的设备列表
     */
    @GET("/jeecg-boot/machine/mecMachine/list")
    fun getMyMecList(
        @Header("X-Access-Token") token: String?,
        @Query("title") title: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<MyMecListBean>


    /**
     *
     * 获取我的设备列表
     */
    @GET("/jeecg-boot/machine/mecMachine/queryById")
    fun getMecDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<MyMecDetailsBean>


    /**
     *
     * 删除
     */
    @GET("/jeecg-boot/machine/mecMachine/delete")
    fun delMyMec(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<NetData>


    /**
     *
     * 获取机械出租 求租详情
     */
    @GET("/jeecg-boot/market/mecMarketMechanics/queryById")
    fun getLeaseDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<MecDetailsBean>

    /**
     *
     * 获取配件出租 求租详情
     */
    @GET("/jeecg-boot/market/mecMarketParts/queryById")
    fun getPartsLeaseDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<PartsDetailsBean>

    /**
     *
     * 获取维修厂详情
     */
    @GET("/jeecg-boot/repair/mecRepaireFactory/queryInfoById")
    fun getFactoryDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<FactoryDetailsBean>

    /**
     *
     * 获取机械出租出售详情
     */
    @GET("/jeecg-boot/market/mecMarketOldMechanics/queryById")
    fun getBusinessDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<BusinessDetailsBean>


    /**
     *
     * 获取商品详情
     */
    @GET("/jeecg-boot/shop/mecProd/queryByIdApp")
    fun getGoodsDetail(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<GoodsDetailsBean>

    /**
     *
     * 获取评论列表
     */
    @GET("/jeecg-boot/shop/mecProd/commentListAll")
    fun getComment(
        @Header("X-Access-Token") token: String?,
        @Query("productId") id: String?,
        @Query("pageNo") page: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CommentBean>

    /**
     *
     * 获取好评评论列表
     */
    @GET("/jeecg-boot/shop/mecProd/commentListGood")
    fun getCommentGoods(
        @Header("X-Access-Token") token: String?,
        @Query("productId") id: String?,
        @Query("pageNo") page: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CommentBean>

    /**
     *
     * 获取中评评论列表
     */
    @GET("/jeecg-boot/shop/mecProd/commentListMiddle")
    fun getCommentMiddle(
        @Header("X-Access-Token") token: String?,
        @Query("productId") id: String?,
        @Query("pageNo") page: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CommentBean>

    /**
     *
     * 获取评论列表
     */
    @GET("/jeecg-boot/shop/mecProd/commentListBad")
    fun getCommentBad(
        @Header("X-Access-Token") token: String?,
        @Query("productId") id: String?,
        @Query("pageNo") page: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<CommentBean>

    /**
     *
     * 获取评论数量
     */
    @GET("/jeecg-boot/shop/mecProductComment/getCommentLevelCount")
    fun getCommentNun(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<CommentNumBean>


    /**
     *
     * 添加收藏
     */
    @POST("/jeecg-boot/my/mecMyStore/add")
    fun addCollect(
        @Header("X-Access-Token") token: String?,
        @Body reCollect: ReCollect
    ): Observable<NetData>

    /**
     *
     *删除收藏
     */
    @GET("/jeecg-boot/my/mecMyStore/delBystoreId")
    fun delCollect(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int?,
        @Query("storeId") id: String?
    ): Observable<NetData>

    /**
     *
     *判断是否收藏
     */
    @GET("/jeecg-boot/my/mecMyStore/isExist")
    fun judgeCollect(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int?,
        @Query("storeId") id: String?
    ): Observable<IsCollectBean>

    /**
     *
     *判断是否收藏
     */
    @POST("/jeecg-boot/shop/mecShoppingCard/add")
    fun addShopCar(
        @Header("X-Access-Token") token: String?,
        @Body reAddCar: ReAddCar?
    ): Observable<AddCarBean>


    /**
     * 添加我的设备
     */
    @POST("/jeecg-boot/machine/mecMachine/add")
    fun addMec(
        @Header("X-Access-Token") token: String?,
        @Body reAddMec: ReAddMec
    ): Observable<NetData>

    /**
     * 编辑我的设备
     */
    @POST("/jeecg-boot/machine/mecMachine/edit")
    fun editMec(
        @Header("X-Access-Token") token: String?,
        @Body reAddMec: ReAddMec
    ): Observable<NetData>

    /**
     *
     *获取维修订单
     */
    @GET("/jeecg-boot/shop/mecArea/groupList")
    fun getCity(
        @Header("X-Access-Token") token: String?
    ): Observable<CityListBean>


    /**
     *
     *获取广告轮播
     */
    @GET("/jeecg-boot/shop/mecShopAd/list")
    fun getBanner(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int
    ): Observable<BannerBean>


    /**
     *
     *购物车列表
     */
    @GET("/jeecg-boot/shop/mecShoppingCard/listMy")
    fun getCarList(
        @Header("X-Access-Token") token: String?,
        @Query("type") type: Int?,
        @Query("pageNo") pageNo: Int?,
        @Query("pageSize") pageSize: Int?
    ): Observable<ShopCarBean>


    /**
     *
     *编辑购物车列表
     */
    @POST("/jeecg-boot/shop/mecShoppingCard/editPost")
    fun editCar(
        @Header("X-Access-Token") token: String?,
        @Body shopCarData: ShopCarData
    ): Observable<NetData>


    /**
     *
     *删除单个购物车
     */
    @FormUrlEncoded
    @POST("/jeecg-boot/shop/mecShoppingCard/deletePost")
    fun delCar(
        @Header("X-Access-Token") token: String?,
        @Field("id") id: String?
    ): Observable<NetData>


    /**
     *
     *获取维修订单
     */
    @GET("/jeecg-boot/repair/mecRepairOrder/list")
    fun getOrderList(
        @Header("X-Access-Token") token: String?,
        @Query("createBy") createBy: String?,
        @Query("status") state: String?,
        @Query("productType") productType: String?,
        @Query("pageNo") pageNo: Int?,
        @Query("pageSize") pageSize: Int?
    ): Observable<OrderBean>

    /**
     *
     *获取配件订单
     */
    @GET("/jeecg-boot/shop/mecOrder/list")
    fun getPartsOrderList(
        @Header("X-Access-Token") token: String?,
        @Query("createBy") createBy: String?,
        @Query("status") state: String?,
        @Query("pageNo") pageNo: Int?,
        @Query("pageSize") pageSize: Int?
    ): Observable<PartOrderListBean>
    /**
     *
     *获取售后配件订单
     */
    @GET("/jeecg-boot/shop/mecOrderBack/queryMyPageList")
    fun getPartsOrderAfterSaleList(
        @Header("X-Access-Token") token: String?,
        @Query("pageNo") pageNo: Int?,
        @Query("pageSize") pageSize: Int?
    ): Observable<PartOrderListBean>


    /**
     *
     *取消配件订单
     */
    @GET("/jeecg-boot/shop/mecOrder/deleteGet")
    fun cancelPartsOrder(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<NetData>

    /**
     *
     *获取维修订单详情
     */
    @GET("/jeecg-boot/repair/mecRepairOrder/queryById")
    fun getOrderDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<OrderDetailsBean>

    /**
     *
     *取消维修订单
     */
    @GET("/jeecg-boot/repair/mecRepairOrder/delete")
    fun cancelOrder(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<NetData>


    /**
     * 我的商品列表
     */
    @GET("/jeecg-boot/shop/mecProd/appListPage")
    fun getGoodsList(
        @Header("X-Access-Token") token: String?,
        @Query("orderByPrice") orderByPrice: String?,
        @Query("orderByScale") orderByScale: String?,
        @Query("orderType") orderType: String?,
        @Query("title") title: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<GoodsListBean>


    /**
     *
     * 生成订单
     */
    @POST("/jeecg-boot/shop/mecOrder/add")
    fun addOrder(
        @Header("X-Access-Token") token: String?,
        @Body reOrder: ReOrder?
    ): Observable<CreatOrderBean>

    /**
     *
     *购物车里生成订单
     */
    @POST("/jeecg-boot/shop/mecOrder/addOrderByShoppingCart")
    fun addCarOrder(
        @Header("X-Access-Token") token: String?,
        @Body reOrder: ReOrderCar?
    ): Observable<CreatOrderBean>

    /**
     *
     *用户信息==非个人
     */
    @GET("/jeecg-boot/market/userIndex/queryById")
    fun getUserInfo(
        @Header("X-Access-Token") token: String?,
        @Query("create_by") create_by: String?,
        @Query("type") type: Int
    ): Observable<UserInfoBean>

    /**
     *
     *查询 招聘 求职详情
     */
    @GET("/jeecg-boot/market/mecMarketRecruit/queryById")
    fun getRecruitDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<RecruitDetailsBean>


    /**
     *
     *举报
     */
    @POST("/jeecg-boot/report/mecReport/add")
    fun report(
        @Header("X-Access-Token") token: String?,
        @Body report: ReReport?
    ): Observable<NetData>

    /**
     *
     *获取举报说明列表
     */
    @GET("/jeecg-boot/report/mecReport/list")
    fun getReportList(
        @Header("X-Access-Token") token: String?
    ): Observable<ReportBean>


    /**
     *
     *获取订单详情
     */
    @GET("/jeecg-boot/shop/mecOrder/detail")
    fun getPartsOrderDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<PartsOrderDetailsBean>
    /**
     *
     *获取售后订单详情
     */
    @GET("/jeecg-boot/shop/mecOrderBack/detail")
    fun getPartsOrderAfterDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<PartsOrderDetailsBean>


    /**
     *
     *修改用户信息
     */
    @POST("/jeecg-boot/my/mecMyInfo/edit")
    fun editUserInfo(
        @Header("X-Access-Token") token: String?,
        @Body userInfo: UserInfo?
    ): Observable<NetData>


    /**
     *
     *意见反馈
     */
    @POST("/jeecg-boot/my/mecMyInfo/edit")
    fun postSuggest(
        @Header("X-Access-Token") token: String?,
        @Body reSuggest: ReSuggest?
    ): Observable<NetData>


    /**
     *
     *获取热门搜索关键词
     */
    @GET("/jeecg-boot/shop/mecHotSearchKeyword/keywords")
    fun getHotCode(
        @Header("X-Access-Token") token: String?
    ): Observable<HotCodeBean>

    /*
* 清单列表
* */
    @GET("/jeecg-boot/repair/mecRepairOrderDetail/queryByRepairOrderId")
    fun getList(
        @Header("X-Access-Token") token: String?,
        @Query("status") status: Int,
        @Query("repairOrderId") repairOrderId: String?
    ): Observable<ListBean>

    /* 工程订单评论
    * */
    @GET("/jeecg-boot/repair/mecRepairComment/queryById")
    fun getEvaluate(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<ListBean>

    /*提交工程订单评论
  * */
    @POST("/jeecg-boot/repair/mecRepairComment/add")
    fun postEvaluate(
        @Header("X-Access-Token") token: String?,
        @Body requestBody: ReEvaluate?
    ): Observable<NetData>


    /**
     * 提交配件订单评价
     */
    @POST("/jeecg-boot/shop/mecProductComment/addBatch")
    fun postEvaluateParts(
        @Header("X-Access-Token") token: String?,
        @Body body: @JvmSuppressWildcards List<ReEvaluateParts>?
    ): Observable<NetData>


    /*微信支付
  * */
    @POST("/jeecg-boot/shop/mecOrder/wxPay")
    fun payWx(
        @Header("X-Access-Token") token: String?,
        @Body requestBody: RePay?
    ): Observable<WxPayBean>


    /*微信支付
  * */
    @FormUrlEncoded
    @POST("/jeecg-boot/repair/mecRepairOrder/wxPay")
    fun payRepairWx(
        @Header("X-Access-Token") token: String?,
        @Field("id") id: String?
    ): Observable<WxPayBean>

    /*支付宝支付支付
* */
    @POST("/jeecg-boot/shop/mecOrder/alipay")
    fun payAlly(
        @Header("X-Access-Token") token: String?,
        @Body requestBody: RePay?
    ): Observable<AliPayBean>
    /*支付宝支付支付
* */
    @FormUrlEncoded
    @POST("/jeecg-boot/repair/mecRepairOrder/alipay")
    fun payRepairAlly(
        @Header("X-Access-Token") token: String?,
        @Field("id") id: String?
    ): Observable<AliPayBean>


    /* 获取工程师列表
* */
    @GET("/jeecg-boot/repair/mecRepairEngineer/list")
    fun getEngList(
        @Header("X-Access-Token") token: String?,
        @Query("name") name: String?
    ): Observable<EngListBean>

    /* 获取工程师列表
* */
    @GET("/jeecg-boot/repair/mecRepairEngineer/list")
    fun getEngList(
        @Header("X-Access-Token") token: String?,
        @Query("name") name: String?,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<EngListBean>

    /**
     * 带首字母的工程师列表
     */
    @GET("jeecg-boot/repair/mecRepairEngineer/groupList")
    fun getEngListLetter(
        @Header("X-Access-Token") token: String?
    ): Observable<EngListLetterBean>

    /**
     * 申请售后
     */
    @POST(
        "/jeecg-boot/shop/mecOrderBack/add"
    )
    fun applyRefund(
        @Header("X-Access-Token") token: String?,
        @Body reApplyRefund: ReApplyRefund?
    ): Observable<NetData>


    /**
     * 获取认证信息 (2个人,3企业,4维修厂)
     */
    @GET("/jeecg-boot/market/mecUserApprove/list")
    fun getApplyInfo(
        @Header("X-Access-Token") token: String?,
        @Query("apporveType") apporveType: String?,
        @Query("createBy") createBy: String?
    ): Observable<ApplyInfoBean>




    /**
     * 添加物流信息
     */
    @FormUrlEncoded
    @POST("/jeecg-boot/shop/mecOrderBack/writeTrackNo")
    fun postExpress(
        @Header("X-Access-Token") token: String?,
       @Field("id")id:String?,
        @Field("deliverycorpCode")deliverycorpCode:String?,
        @Field("trackNo")trackNo:String?
    ): Observable<PostExpressBean>

    /**
     * 取消售后
     */
    @FormUrlEncoded
    @POST("/jeecg-boot/shop/mecOrderBack/cancel")
    fun cancelRefund(
        @Header("X-Access-Token") token: String?,
        @Field("id") id:String?
    ): Observable<ReCancelRefundBean>

    /**
     * 确认收货
     */
    @GET("/jeecg-boot/shop/mecOrder/sureReceived")
    fun sureGetGoods(
        @Header("X-Access-Token") token: String?,
        @Query("id") id:String?
    ): Observable<NetData>

    /**
     * 查看物流
     */
    @GET("/jeecg-boot/shop/mecOrder/searchWL")
    fun getLogistics(
        @Header("X-Access-Token") token: String?,
        @Query("id") id:String?
    ): Observable<LogisticsBean>

    /**
     * 获取订单的评价
     */
    @GET("/jeecg-boot/shop/mecProductComment/queryByOrderId")
    fun getMyPartsEvaluate(
        @Header("X-Access-Token") token: String?,
        @Query("orderId") id:String?
    ): Observable<LookEvaluateBean>

    /**
     * 分享得积分
     */
    @GET("/jeecg-boot/market/mecMarketPoints/shareMarketAuthPoints")
    fun shareTo(
        @Header("X-Access-Token") token: String?
    ): Observable<NetData>

    /**
     * 分享得积分
     */
    @GET("/jeecg-boot/sys/user/getUserInfoByToken")
    fun getMySelf(
        @Header("X-Access-Token") token: String?
    ): Observable<MySelfInfoBean>



    /**
     * 添加浏览记录
     */
    @POST("/jeecg-boot/my/mecMyViewed/add")
    fun addRecordView(
        @Body reRecordView: ReRecordView?,
        @Header("X-Access-Token") token: String?
    ): Observable<MySelfInfoBean>

    /**
     *
     * 获取维修厂评论列表
     */
    @GET("/jeecg-boot/repair/mecRepaireFactory/commentList")
    fun getFactoryCommentList(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?,
        @Query("pageNo") page: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<FactoryCommentListBean>

    /**
     *
     * im工程人员列表-分页列表查询
     */
    @GET("/jeecg-boot/repair/mecRepairEngineer/listByIds")
    fun getEngInfo(
        @Header("X-Access-Token") token: String?,
        @Query("imIds") id: String?
    ): Observable<EnMsgBean>



    /**
     *
     * 获取系统消息列表
     */
    @GET("/jeecg-boot/notice/mecNotice/appList")
    fun getNotifyMsgList(
        @Header("X-Access-Token") token: String?,
        @Query("createBy") createBy: String?,
        @Query("pageNo") pageNo: Int?,
    @Query("pageSize") pageSize: Int?
    ): Observable<SysMsgBean>

    /**
     *
     * 获取系统消息详情
     */
    @GET("/jeecg-boot/notice/mecNotice/queryById")
    fun getNotifyMsgDetails(
        @Header("X-Access-Token") token: String?,
        @Query("id") id: String?
    ): Observable<NetData>


    /**
     *
     * 获取摄像头列表
     */
    @GET("/jeecg-boot/repair/mecRepairWebcam/listOffline")
    fun getCameraList(
        @Header("X-Access-Token") token: String?
    ): Observable<CameraListBean>



    /**
     *
     * 查询摄像头
     * 获取Url
     */
    @GET("/jeecg-boot/repair/mecRepairWebcam/queryById")
    fun getCameraVideo(
        @Header("X-Access-Token") token: String?,
        @Query("id") id:String?
    ): Observable<NetData>

    /**
     *
     * 获取版本信息
     */
    @POST("/jeecg-boot/version/mecAppVersion/getAppVersion")
    fun getVersion(
        @Body reAppVersion: ReAppVersion?
    ): Observable<AppVersionBean>
}
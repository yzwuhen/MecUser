package com.example.mechanicalapp.ui.mvp.apps

import com.example.mechanicalapp.ui.data.HomeData
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreBean
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

    @GET("/jeecg-boot/app/userIndex")
    fun getHomeData():Observable<HomeData>



    @GET("/jeecg-boot/shop/mecProductCategory/AllList")
    fun getStoreData():Observable<StoreBean>
}
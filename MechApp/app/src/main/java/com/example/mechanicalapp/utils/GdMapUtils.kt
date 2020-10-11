package com.example.mechanicalapp.utils

import android.util.Log
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode
import com.amap.api.location.AMapLocationListener
import com.amap.api.maps.model.MyLocationStyle
import com.example.mechanicalapp.App


object GdMapUtils {
    private var myLocationStyle: MyLocationStyle? = null
    private var mlocationClient:AMapLocationClient?=null
    private var mLocationOption:AMapLocationClientOption?=null
    private var mLocationListener:LocationListener?=null
    public fun location(locationListener:LocationListener) {
//        myLocationStyle =
//            MyLocationStyle() //初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
//        myLocationStyle!!.myLocationType(MyLocationStyle.LOCATION_TYPE_SHOW)
//        myLocationStyle?.interval(20000) //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。

        mLocationListener =locationListener
        mlocationClient = AMapLocationClient(App.getInstance().applicationContext)
        //初始化定位参数
        //初始化定位参数
        mLocationOption = AMapLocationClientOption()
        //设置定位回调监听
        //设置定位回调监听
        mlocationClient?.setLocationListener(mAMapLocationListener)
        //设置为高精度定位模式
        //设置为高精度定位模式
        mLocationOption?.locationMode=AMapLocationMode.Hight_Accuracy
        mLocationOption?.interval =60000
        //只定位一次
        mLocationOption?.isOnceLocation = true
        //设置定位参数
        //设置定位参数
        mlocationClient?.setLocationOption(mLocationOption)
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        mlocationClient?.startLocation() //启动定位

    }

    object mAMapLocationListener: AMapLocationListener{
        override fun onLocationChanged(amapLocation: AMapLocation?) {

            Log.e("yz_map", "sss=====$amapLocation")
            if (mLocationListener!=null){
                if (amapLocation != null
                    && amapLocation.errorCode === 0
                ) {
                    Log.e("yz_map", "成功了 可以回调了")
                    mLocationListener?.locationSuccess(amapLocation)
                } else {
                    val errText = "定位失败," + amapLocation?.errorCode
                        .toString() + ": " + amapLocation?.errorInfo
                    Log.e("yz_map", errText)
                    mLocationListener?.locationErr()
                }
            }

        }

    }

    /**
     * 停止定位
     */
    public fun deactivate(){
        mLocationListener = null;
        if (mlocationClient != null) {
            mlocationClient?.stopLocation();
            mlocationClient?.onDestroy();
        }
        mlocationClient = null;
    }

    interface LocationListener{
        fun locationSuccess(mapLocation: AMapLocation)
        fun locationErr()
    }
}
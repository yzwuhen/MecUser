package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.amap.api.location.AMapLocation
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.model.*
import com.amap.api.services.core.LatLonPoint
import com.amap.api.services.core.PoiItem
import com.amap.api.services.geocoder.GeocodeResult
import com.amap.api.services.geocoder.GeocodeSearch
import com.amap.api.services.geocoder.RegeocodeQuery
import com.amap.api.services.geocoder.RegeocodeResult
import com.amap.api.services.poisearch.PoiResult
import com.amap.api.services.poisearch.PoiSearch
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.LocationAddressAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.utils.GdMapUtils
import kotlinx.android.synthetic.main.activity_address_sel.*


class AddressSelActivity : BaseActivity<NetData>(), GdMapUtils.LocationListener,
    OnItemClickListener, TextWatcher {

    var aMap: AMap? = null

    private var mLocationAddressAdapter: LocationAddressAdapter? = null
    private var mList: MutableList<PoiItem> = ArrayList<PoiItem>()
    private var poiQuery: PoiSearch.Query? = null
    private var marker: Marker? = null
    private var mCityCode: String = "020"

    override fun getLayoutId(): Int {
        return R.layout.activity_address_sel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        map?.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()

        if (aMap == null) {
            aMap = map.map
        }
        GdMapUtils.location(this)

        mLocationAddressAdapter = LocationAddressAdapter(mList, this)
        recycler_list.layoutManager = LinearLayoutManager(this)
        recycler_list.adapter = mLocationAddressAdapter
        initListener()
    }

    private fun initListener() {
        //地图移动的时候 监听
        aMap?.setOnCameraChangeListener(object : AMap.OnCameraChangeListener {
            override fun onCameraChange(cameraPosition: CameraPosition?) {
                if (cameraPosition != null) {
                    latSearchList(cameraPosition.target.latitude, cameraPosition.target.longitude)
                };
            }

            override fun onCameraChangeFinish(p0: CameraPosition?) {
            }
        })
        aMap?.setOnMapClickListener(object : AMap.OnMapClickListener {
            override fun onMapClick(p0: LatLng?) {


            }

        })
        et_search.addTextChangedListener(this)
    }

    private fun latSearchList(latitude: Double, longitude: Double) {
        //设置周边搜索的中心点以及半径

        //设置周边搜索的中心点以及半径
        val geocodeSearch = GeocodeSearch(this)
        //地点范围500米
        //地点范围500米
        val query = RegeocodeQuery(LatLonPoint(latitude, longitude), 500f, GeocodeSearch.AMAP)

        geocodeSearch.getFromLocationAsyn(query)

        geocodeSearch.setOnGeocodeSearchListener(object : GeocodeSearch.OnGeocodeSearchListener {
            override fun onRegeocodeSearched(result: RegeocodeResult, rCode: Int) {
                if (rCode == 1000) {
                    if (result?.regeocodeAddress != null && result.regeocodeAddress.formatAddress != null) {
                        searchList(
                            result.regeocodeAddress.cityCode,
                            result.regeocodeAddress.township
                        )
                    }
                }
            }

            override fun onGeocodeSearched(geocodeResult: GeocodeResult, i: Int) {}
        })

    }

    //poi搜索
    private fun searchList(cityCode: String, road: String) {
        if (TextUtils.isEmpty(road)) {
            mList.clear()
            mLocationAddressAdapter?.notifyDataSetChanged()
        }
        poiQuery = PoiSearch.Query(road, "", cityCode)
        poiQuery?.pageSize = 15
        poiQuery?.pageNum = 0
        val poiSearch = PoiSearch(this, poiQuery)
        poiSearch.setOnPoiSearchListener(object : PoiSearch.OnPoiSearchListener {
            override fun onPoiSearched(result: PoiResult?, rCode: Int) {
                if (rCode === 1000) {
                    if (result?.query != null) { // 搜索poi的结果
                        if (result.query == poiQuery) { // 是否是同一条
                            //     poiResult = result;
                            // 取得搜索到的poiitems有多少页
                            val poiItems: List<PoiItem> =
                                result.pois// 取得第一页的poiitem数据，页数从数字0开始
//                            val suggestionCities: List<SuggestionCity> = result
//                                .searchSuggestionCitys// 当搜索不到poiitem数据时，会返回含有搜索关键字的城市信息
                            mList.clear()
                            if (poiItems.isNotEmpty()) {
                                mList.addAll(poiItems)
                            }
                            mLocationAddressAdapter?.notifyDataSetChanged()
                        }
                    }
                }

            }

            override fun onPoiItemSearched(p0: PoiItem?, p1: Int) {

            }

        })
        poiSearch.searchPOIAsyn()
    }

    private fun addMark(latitude: Double, longitude: Double) {
        if (marker == null) {
            var view = layoutInflater.inflate(R.layout.map_center_view, null)
            marker =aMap!!.addMarker(MarkerOptions().position(LatLng(latitude, longitude)).icon(BitmapDescriptorFactory.fromView(view)))
        } else {
            marker?.position = LatLng(latitude, longitude)
        }
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

    private fun moveMap(latitude: Double, longitude: Double) {

        aMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latitude, longitude), 14f))
        addMark(latitude, longitude)
    }

    override fun locationSuccess(mapLocation: AMapLocation) {
        mCityCode = mapLocation.cityCode
        moveMap(mapLocation.latitude, mapLocation.longitude)
    }

    override fun locationErr() {
    }

    override fun onItemClick(view: View, position: Int) {
        callback( "${mList[position].provinceName}${mList[position].cityName} ${mList[position].adName}",
            mList[position].cityCode,mList[position].cityName,
            mList[position].latLonPoint.latitude,mList[position].latLonPoint.longitude)
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        searchList(mCityCode, et_search?.text.toString().trim());
    }

    private fun callback(address: String, cityId: String,city:String,lat:Double,lot:Double) {
        var intent = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra, address)
        bundle.putString(Configs.SCREEN_RESULT_ID, cityId)
        bundle.putString(Configs.CITY_NAME, city)
        bundle.putDouble(Configs.CITY_LAT, lat)
        bundle.putDouble(Configs.CITY_LOT, lot)
        intent.putExtras(bundle)
        setResult(Configs.EC_TYPE_RESULT_CODE, intent)
        finish()
    }


    override fun onDestroy() {
        super.onDestroy()
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        map?.onDestroy()
        GdMapUtils.deactivate()
    }

    override fun onResume() {
        super.onResume()
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        map?.onResume()
    }

    override fun onPause() {
        super.onPause()
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        map?.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        map?.onSaveInstanceState(outState)
    }

}
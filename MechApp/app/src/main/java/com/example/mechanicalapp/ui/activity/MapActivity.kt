package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amap.api.location.AMapLocation
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.model.LatLng
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.GdMapUtils
import kotlinx.android.synthetic.main.activity_map.*
import kotlinx.android.synthetic.main.layout_search_title.*

class MapActivity:BaseActivity<NetData> (),View.OnClickListener,GdMapUtils.LocationListener,OnItemClickListener,PopUtils.onViewListener{
    var aMap: AMap? = null
    var popRecy : RecyclerView?=null
    private var mScreenAdapter : ScreenAdapter?=null
    private var mStringList :MutableList<String> = ArrayList<String>()
    override fun getLayoutId(): Int {

        return R.layout.activity_map
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        map?.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()

        iv_back.setOnClickListener(this)

        if (aMap == null) {
            aMap = map.map
        }
            GdMapUtils.location(this)

        mStringList?.add("智能排序")
        mStringList?.add("最新上架")
        mStringList?.add("距离由远到近")
        mStringList?.add("价格低")

        ly_screen1.setOnClickListener(this)
        ly_screen2.setOnClickListener(this)
        ly_screen3.setOnClickListener(this)
        ly_screen4.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.ly_screen1 -> jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcType::class.java
            )
            R.id.ly_screen2 -> jumpActivityForReSult(
                Configs.EC_BRAND_RESULT_CODE,
                Brand::class.java
            )
            R.id.ly_screen3 -> jumpActivityForReSult(
                Configs.CITY_RESULT_CODE,
                SearchCityActivity::class.java
            )
            R.id.ly_screen4->showPop()
        }
    }


    private fun showPop() {
        this?.let { PopUtils.init(this, it,this) }
        PopUtils.showPopupWindow(tv_screen1)
    }

    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(this, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mScreenAdapter
    }



    private fun moveMap(latitude: Double, longitude: Double) {

        aMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latitude, longitude), 14f))
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

    override fun locationSuccess(mapLocation: AMapLocation) {

        moveMap(mapLocation.latitude, mapLocation.longitude)
    }


    override fun locationErr() {
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        showResult(requestCode, data?.getStringExtra(Configs.SCREEN_RESULT_Extra))
        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showResult(requestCode: Int, extra: String?) {
        if (extra.isNullOrEmpty()){
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> tv_screen1.text = extra
            Configs.EC_BRAND_RESULT_CODE -> tv_screen2.text = extra
            Configs.CITY_RESULT_CODE -> tv_screen3.text = extra
        }

    }
    override fun onItemClick(view: View, position: Int) {

    }
}
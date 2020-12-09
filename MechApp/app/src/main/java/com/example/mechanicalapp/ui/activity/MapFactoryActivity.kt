package com.example.mechanicalapp.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amap.api.location.AMapLocation
import com.amap.api.location.CoordinateConverter
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.model.*
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.FactoryData
import com.example.mechanicalapp.ui.data.MoreFactoryBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.ResultPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.GdMapUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.activity_map_factory.*
import kotlinx.android.synthetic.main.layout_search_title.*

class MapFactoryActivity  : BaseCusActivity(), View.OnClickListener, GdMapUtils.LocationListener,
    OnItemClickListener, PopUtils.onViewListener, NetDataView<NetData>, AMap.OnMarkerClickListener {
    var aMap: AMap? = null
    var popRecy: RecyclerView? = null
    private var mScreenAdapter: ScreenAdapter? = null
    private var mStringList: MutableList<String> = ArrayList<String>()
    private var mPresenter: ResultPresenter? = null

    private var mList = ArrayList<FactoryData>()
    private var mMarkerList = ArrayList<Marker>()
    private var mPosition = 0
    private var markerLocat: Marker? = null
    override fun getLayoutId(): Int {

        return R.layout.activity_map_factory
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

        mStringList?.add("智能排序")
        mStringList?.add("距离由近到远")
        mStringList?.add("最新上架")

        initListener()
    }

    override fun initPresenter() {
        mPresenter = ResultPresenter(this)
        mPresenter?.setIsMap()
        //根据type 去请求接口
        mPresenter?.setLocation(App.getInstance().thisPoint)
        getData()
    }

    private fun getData() {
        mPresenter?.getFactoryList()
    }

    private fun initListener() {
        iv_back.setOnClickListener(this)
        ly_screen1.setOnClickListener(this)
        ly_screen2.setOnClickListener(this)
        ly_screen3.setOnClickListener(this)
      //  iv_locat.setOnClickListener(this)
        root_view.setOnClickListener(this)
        //地图移动的时候 监听
        aMap?.setOnCameraChangeListener(object : AMap.OnCameraChangeListener {
            override fun onCameraChange(cameraPosition: CameraPosition?) {
                if (cameraPosition != null) {
                    //   latSearchList(cameraPosition.target.latitude, cameraPosition.target.longitude)
                };
            }

            override fun onCameraChangeFinish(p0: CameraPosition?) {
            }
        })
        aMap?.setOnMapClickListener { }

    }


    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.ly_screen1 -> jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcType::class.java
            )
            R.id.ly_screen2 -> jumpActivityForReSult(
                Configs.PARTS_TYPE_RESULT_CODE,
                PartsTypeActivity::class.java
            )
            R.id.ly_screen3 -> showPop()
            R.id.iv_locat -> locat()
            R.id.item_root -> jum()
        }
    }




    private fun jum() {


    }

    private fun locat() {
        moveMap(App.getInstance().thisPoint.latitude,App.getInstance().thisPoint.longitude)
        addMark(App.getInstance().thisPoint.latitude,App.getInstance().thisPoint.longitude)
    }

    private fun addMark(latitude: Double, longitude: Double) {
        if (markerLocat == null) {
            var view = layoutInflater.inflate(R.layout.map_center_view, null)
            markerLocat =aMap!!.addMarker(MarkerOptions().position(LatLng(latitude, longitude)).icon(BitmapDescriptorFactory.fromView(view)))
        } else {
            markerLocat?.position = LatLng(latitude, longitude)
        }
    }

    private fun showPop() {
        this?.let { PopUtils.init(this, it, this) }
        PopUtils.showPopupWindow(tv_screen1)
    }

    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(this, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mScreenAdapter
    }


    private fun moveMap(latitude: Double, longitude: Double) {

        aMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latitude, longitude), 10f))
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

        showResult(
            requestCode,
            data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
            data?.getStringExtra(Configs.SCREEN_RESULT_ID)
        )
        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                tv_screen1.text = extra
                if (extra =="不限"){
                    mPresenter?.setRepaireType(null)
                }else{
                    mPresenter?.setRepaireType(extra)
                }
            }
            Configs.PARTS_TYPE_RESULT_CODE -> {
                tv_screen2.text = extra
                if (extra =="不限"){
                    mPresenter?.setComponentType(null)
                }else{
                    mPresenter?.setComponentType(extra)
                }

            }

        }
        getData()
    }

    override fun onItemClick(view: View, position: Int) {
        when(view?.id){
            R.id.tv_screen->{
                tv_screen3.text=mStringList[position]
                mPresenter?.setSort(position)
                getData()
                PopUtils.dismissPop()
            }

        }
    }

    override fun refreshUI(data: NetData?) {
        if (data != null && data is MoreFactoryBean && data.result != null) {
            mList.clear()
            mList.addAll(data.result.records)
            addMarks()
        }

    }

    private fun addMarks() {
        aMap?.clear(true)
        mMarkerList.clear()
        markerLocat=null
        addMark(App.getInstance().thisPoint.latitude,App.getInstance().thisPoint.longitude)
        for (index in mList.indices) {

            var marks = aMap!!.addMarker(
                MarkerOptions().position(LatLng(mList[index].lat, mList[index].lng)).icon(
                    BitmapDescriptorFactory.fromView(
                        getView(
                            getRes(
                                index == 0

                            )
                        )
                    )
                )
            )
            marks.title = index.toString()
            mMarkerList.add(marks)
        }
        aMap?.setOnMarkerClickListener(this)
        mPosition = 0
        showViewInfo(mPosition)
    }

    override fun loadMore(data: NetData?) {
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        showViewInfo(marker?.title?.toInt()!!)
        changeMarker(marker?.title?.toInt()!!)

        return true;
    }


    //修改marker 的icon
    private fun changeMarker(toInt: Int) {
        if (mPosition != toInt) {
            mMarkerList[mPosition]?.setIcon(
                BitmapDescriptorFactory.fromView(
                    getView(
                        getRes(
                            false
                        )
                    )
                )
            )
            mMarkerList[toInt]?.setIcon(
                BitmapDescriptorFactory.fromView(
                    getView(
                        getRes(
                            true

                        )
                    )
                )
            )
            mPosition = toInt
        }

    }

    //点击marker 底部显示对应的信息
    @SuppressLint("SetTextI18n")
    private fun showViewInfo(position: Int) {
        if (mList.size==0){
            root_view.visibility =View.GONE
            return
        }
        root_view.visibility =View.VISIBLE
       tv_item_title.text =mList[position].companyName
       ratingBar.rating =mList[position].star
        tv_score.text="${mList[position].star}分"
        tv_address.text ="${mList[position].city}  | "
        tv_distance.text="距离：${
            StringUtils.getDistance(
                CoordinateConverter.calculateLineDistance(
                    App.getInstance().thisPoint,
                    GdMapUtils.getPoint(mList[position].lat, mList[position].lng)
                )
            )
        }km"
        tv_introduce.text ="简介：${mList[position].introduction}"

        ImageLoadUtils.loadImage(this,iv_item_pic,mList[position].factoryPicture,R.mipmap.ic_launcher)
    }

    private fun getRes(isSelect: Boolean): Int {

            if (isSelect) {
                R.mipmap.map_marks_n6
            } else {
                R.mipmap.map_marks_n6
            }
        return R.mipmap.map_marks_n6
    }

    fun getView(res: Int): View {
        var view = layoutInflater.inflate(R.layout.map_mark, null)
        var markerIV = view?.findViewById(R.id.iv_map) as ImageView
        markerIV.setImageResource(res)
        return view
    }
}
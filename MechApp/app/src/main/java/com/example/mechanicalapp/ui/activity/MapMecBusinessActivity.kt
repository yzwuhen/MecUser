package com.example.mechanicalapp.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
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
import com.example.mechanicalapp.ui.`interface`.ProgressListener
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.HomeCityData
import com.example.mechanicalapp.ui.data.MecSellData
import com.example.mechanicalapp.ui.data.MoreSellBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.ResultPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.ui.view.TwoWayProgressBar
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.GdMapUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_map_business.*
import kotlinx.android.synthetic.main.layout_search_title.*
import kotlin.math.ceil

class MapMecBusinessActivity : BaseCusActivity(), View.OnClickListener, GdMapUtils.LocationListener,
    ProgressListener,
    OnItemClickListener, PopUtils.onViewListener, NetDataView<NetData>, AMap.OnMarkerClickListener {
    var aMap: AMap? = null
    var popRecy: RecyclerView? = null
    private var mScreenAdapter: ScreenAdapter? = null
    private var mStringList: MutableList<String> = ArrayList<String>()
    private var mPresenter: ResultPresenter? = null

    private var mList = ArrayList<MecSellData>()
    private var mMarkerList = ArrayList<Marker>()
    private var mTvList = ArrayList<TextView>()
    private var mPosition = 0
    private var markerLocat: Marker? = null


    private var mButtDialog: BottomSheetDialog? = null
    private var mDialogView: View? = null
    private var mDialogTvRest: TextView? = null

    private var mDialogTvSure: TextView? = null
    private var mProgress1: TwoWayProgressBar? = null
    private var mProgress2: TwoWayProgressBar? = null
    private var mProgress3: TwoWayProgressBar? = null
    private var mTvProgress1: TextView? = null
    private var mTvProgress2: TextView? = null
    private var mTvProgress3: TextView? = null
    private var mLyAddress: LinearLayout?=null

    private var list1: MutableList<String> = ArrayList<String>()
    private var list2: MutableList<String> = ArrayList<String>()
    private var list3: MutableList<String> = ArrayList<String>()

    override fun getLayoutId(): Int {

        return R.layout.activity_map_business
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

        mStringList.add("智能排序")
        mStringList.add("最新上架")
        mStringList.add("距离由远到近")
        mStringList.add("价格低")

        tv_all.isSelected = true

        mTvList.add(tv_all)
        mTvList.add(tv_condition1)
        mTvList.add(tv_condition2)
        initListener()
    }
    private fun showDialogType() {
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(this)
            mDialogView = View.inflate(this, R.layout.dialog_screen, null)
            mButtDialog?.setContentView(mDialogView!!)

            mDialogTvRest = mDialogView?.findViewById(R.id.tv_reset)
            mDialogTvSure = mDialogView?.findViewById(R.id.tv_sure)


            mTvProgress1 =mDialogView?.findViewById(R.id.tv_progress1)
            mTvProgress2 =mDialogView?.findViewById(R.id.tv_progress2)
            mTvProgress3 =mDialogView?.findViewById(R.id.tv_progress3)

            mLyAddress =mDialogView?.findViewById(R.id.ly_address)
            mLyAddress?.visibility =View.GONE

            list1.add("￥0")
            list1.add("￥10")
            list1.add("￥20")
            list1.add("￥30")
            list1.add("￥40")
            list1.add("￥50")
            list1.add("不限")

            list2.add("0")
            list2.add("1")
            list2.add("2")
            list2.add("3")
            list2.add("4")
            list2.add("5")
            list2.add("6")
            list2.add("7")
            list2.add("8")
            list2.add("9")
            list2.add("10")
            list2.add("不限")

            list3.add("0")
            list3.add("2000")
            list3.add("4000")
            list3.add("6000")
            list3.add("8000")
            list3.add("不限")

            mProgress1 = mDialogView?.findViewById(R.id.progress1)
            mProgress2 = mDialogView?.findViewById(R.id.progress2)
            mProgress3 = mDialogView?.findViewById(R.id.progress3)


            mProgress1?.setTextList(list1)
            mProgress2?.setTextList(list2)
            mProgress3?.setTextList(list3)

            mProgress1?.addProgressListener(this)
            mProgress2?.addProgressListener(this)
            mProgress3?.addProgressListener(this)

            mDialogTvRest?.setOnClickListener(this)
            mDialogTvSure?.setOnClickListener(this)
        }
        mButtDialog?.show()
    }
    override fun initPresenter() {
        mPresenter = ResultPresenter(this)
        mPresenter?.setIsMap()
        getData()
    }

    private fun getData() {
        //根据type 去请求接口
        mPresenter?.setLocation(App.getInstance().thisPoint)
        mPresenter?.getSellList(null)
    }

    private fun initListener() {
        iv_back.setOnClickListener(this)
        ly_screen1.setOnClickListener(this)
        ly_screen2.setOnClickListener(this)
        ly_screen3.setOnClickListener(this)
        ly_screen4.setOnClickListener(this)
        ly_screen5.setOnClickListener(this)
        tv_all.setOnClickListener(this)
        tv_condition1.setOnClickListener(this)
        tv_condition2.setOnClickListener(this)
        iv_locat.setOnClickListener(this)
        root_view1.setOnClickListener(this)
        root_view2.setOnClickListener(this)
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
    override fun progress(leftPos: Double, rightPos: Double,isUp:Boolean,view: View) {

        when(view?.id){
            R.id.progress1->{
                if (rightPos==0.0){
                    if (isUp){
                        mPresenter?.setPriceQJ(ceil((1-leftPos)*60).toString(),null)
                        getData()
                    }
                    mTvProgress1?.text ="不限"
                }else{
                    if (isUp){
                        mPresenter?.setPriceQJ(
                            ceil((1-leftPos)*60).toString(),
                            ceil((1-rightPos)*60).toString())
                        getData()
                    }
                    mTvProgress1?.text ="￥${ceil((1-rightPos)*60).toInt()}"
                }

            }
            R.id.progress2->{
                if (rightPos==0.0){
                    mTvProgress2?.text ="不限"
                    if (isUp){
                        mPresenter?.setJL(ceil((1-leftPos)*10).toInt().toString(),null)
                        getData()
                    }
                }else{
                    if (isUp){
                        mPresenter?.setJL(
                            ceil((1-leftPos)*10).toInt().toString(),
                            ceil((1-rightPos)*10).toInt().toString())
                        getData()
                    }
                    mTvProgress2?.text ="${ceil((1-rightPos)*10).toInt()}年"
                }
            }
            R.id.progress3->{
                if (rightPos==0.0){
                    if (isUp){
                        mPresenter?.setWorkTime((ceil((1-leftPos)*5).toInt()*2000).toString(),null)
                        getData()
                    }
                    mTvProgress3?.text="不限"
                }else{
                    if (isUp){
                        mPresenter?.setWorkTime((ceil((1-leftPos)*5).toInt()*2000).toString(),(ceil((1-rightPos)*5).toInt()*2000).toString())
                        getData()
                    }
                    mTvProgress3?.text ="${ceil((1-rightPos)*5).toInt()*2000}小时"
                }
            }
        }
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
                Configs.EC_BRAND_RESULT_CODE,
                Brand::class.java
            )
            R.id.ly_screen3 -> jumpActivityForReSult(
                Configs.CITY_RESULT_CODE,
                SearchCityActivity::class.java
            )
            R.id.ly_screen4 -> showPop()
            R.id.ly_screen5 -> showDialogType()
            R.id.tv_all -> showView(0)
            R.id.tv_condition1 -> showView(1)
            R.id.tv_condition2 -> showView(2)
            R.id.iv_locat -> locat()
            R.id.item_root -> jum()
        }
    }

    private fun showView(position: Int) {
        for (index in mTvList.indices) {
            mTvList[index].isSelected = index == position
        }
        showMarksType(position)
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
        if (requestCode==Configs.CITY_RESULT_CODE){
            if (data?.getSerializableExtra(Configs.SCREEN_RESULT_Extra)!=null){
                showResultAddress(requestCode, data?.getSerializableExtra(Configs.SCREEN_RESULT_Extra)as HomeCityData)
            }
        }else{
            showResult(
                requestCode,
                data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
                data?.getStringExtra(Configs.SCREEN_RESULT_ID)
            )
        }

        super.onActivityResult(requestCode, resultCode, data)

    }
    private fun showResultAddress(requestCode: Int, homeCityData: HomeCityData) {
        tv_screen3.text = homeCityData.name
    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                tv_screen1.text = extra
                mPresenter?.setCateId(extraId)
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                tv_screen2.text = extra
                mPresenter?.setBrandId(extraId)
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                tv_screen3.text = extra
                mPresenter?.setModelId(extraId)
            }
        }
        getData()
    }

    override fun onItemClick(view: View, position: Int) {
        when(view?.id){
            R.id.tv_screen->{
                tv_screen4.text=mStringList[position]
                mPresenter?.setSort(position)
                getData()
                PopUtils.dismissPop()
            }

        }
    }

    override fun refreshUI(data: NetData?) {
        if (data != null && data is MoreSellBean && data.result != null) {
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
                MarkerOptions().position(LatLng(mList[index].gpsLat, mList[index].gpsLon)).icon(
                    BitmapDescriptorFactory.fromView(
                        getView(
                            getRes(
                                index == 0,
                                mList[index].bussiessType
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

    //marker 筛选
    private fun showMarksType(position: Int) {
        when (position) {
            0 -> {
                for (marker in mMarkerList) {
                    if (!marker.isVisible) {
                        marker.isVisible = true
                    }
                }
            }
            1 -> {
                for (index in mList.indices) {
                    mMarkerList[index].isVisible = mList[index].bussiessType == "1"
                }
            }
            2 -> {
                for (index in mList.indices) {
                    mMarkerList[index].isVisible = mList[index].bussiessType == "2"
                }
            }
        }
    }

    //修改marker 的icon
    private fun changeMarker(toInt: Int) {
        if (mPosition != toInt) {
            mMarkerList[mPosition]?.setIcon(
                BitmapDescriptorFactory.fromView(
                    getView(
                        getRes(
                            false,
                            mList[mPosition].bussiessType
                        )
                    )
                )
            )
            mMarkerList[toInt]?.setIcon(
                BitmapDescriptorFactory.fromView(
                    getView(
                        getRes(
                            true,
                            mList[toInt].bussiessType
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
            return
        }
        if (mList[position].bussiessType == "1") {
            root_view1.visibility = View.VISIBLE
            root_view2.visibility = View.GONE
            ImageLoadUtils.loadImageCenterCrop(
                this,
                iv_pic,
                mList[position].pic,
                R.mipmap.ic_launcher
            )

            tv_title.text = mList[position].title

            tv_address_data.text = "${mList[position].city} | ${mList[position].facDate}"

            tv_distance.text = "距离：${
                StringUtils.getDistance(
                    CoordinateConverter.calculateLineDistance(
                        App.getInstance().thisPoint,
                        GdMapUtils.getPoint(mList[position].gpsLat, mList[position].gpsLon)
                    )
                )
            }km"

            if (mList[position].isNew == "1") {
                tv_label.visibility = View.VISIBLE
            } else {
                tv_label.visibility = View.GONE
            }

            if (DateUtils.getUserDate("yyyy-mm-dd") == mList[position].createTime) {
                tv_new_pic.visibility = View.VISIBLE
            } else {
                tv_new_pic.visibility = View.INVISIBLE
            }

            if (mList[position].isPerson == "1") {
                iv_sr.visibility = View.VISIBLE
            } else {
                iv_sr.visibility = View.GONE
            }

            if (mList[position].isEnterprise == "1") {
                iv_qy.visibility = View.VISIBLE
            } else {
                iv_qy.visibility = View.GONE
            }
            tv_rent.text = "￥${mList[position].price}"
            tv_time.text =
                DateUtils.dateDiffs(mList[position].updateTime, System.currentTimeMillis())
        } else {
            root_view1.visibility = View.GONE
            root_view2.visibility = View.VISIBLE

            tv_rent_user_nick.text = mList[position].contactName
            tv_rent_address_data.text = "${mList[position].city}"// | ${mList[position].workTime}小时内

            tv_rent_equipment.text = mList[position].modelName + mList[position].title

            tv_rent_time.text =
                DateUtils.dateDiffs(mList[position].updateTime, System.currentTimeMillis())

            ImageLoadUtils.loadCircle(this, iv_rent_user, mList[position].avatar)

            tv_rent_price.visibility = View.GONE
            tv_rent1.visibility = View.VISIBLE
            tv_rent1.text = "￥${mList[position].price}"


            tv_rent_distance.text = "距离：${
                StringUtils.getDistance(
                    CoordinateConverter.calculateLineDistance(
                        App.getInstance().thisPoint,
                        GdMapUtils.getPoint(mList[position].gpsLat, mList[position].gpsLon)
                    )
                )
            }km"

            if (mList[position].isPerson == "1") {
                iv_rent_sr.visibility = View.VISIBLE
            } else {
                iv_rent_sr.visibility = View.GONE
            }

        }

    }

    private fun getRes(isSelect: Boolean, type: String): Int {
        return if (type == "2") {
            if (isSelect) {
                R.mipmap.map_marks_s5
            } else {
                R.mipmap.map_marks_n5
            }
        } else {
            if (isSelect) {
                R.mipmap.map_marks_s4
            } else {
                R.mipmap.map_marks_n4
            }
        }
        return R.mipmap.map_marks_n4
    }

    fun getView(res: Int): View {
        var view = layoutInflater.inflate(R.layout.map_mark, null)
        var markerIV = view?.findViewById(R.id.iv_map) as ImageView
        markerIV.setImageResource(res)
        return view
    }
}
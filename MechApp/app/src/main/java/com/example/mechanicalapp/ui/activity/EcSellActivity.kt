package com.example.mechanicalapp.ui.activity

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.adapter.PopWayAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.activity_ec_sell.*
import kotlinx.android.synthetic.main.layout_title.*
import java.util.*
import kotlin.collections.ArrayList

class EcSellActivity : BaseActivity<NetData>(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener, OnTimeSelectListener {

    private var mPicAdapter : PicAdapter?=null

    private var mPicList :MutableList<String> ?=null

    private var mStringList :MutableList<String> = ArrayList<String>()
    private var popRecy : RecyclerView?=null
    private var mPopWayAdapter : PopWayAdapter?=null


    private var mPayWayList :MutableList<String> = ArrayList<String>()
    private var mPopPayWay : RecyclerView?=null
    private var mPayWayAdapter : PopWayAdapter?=null

    override fun getLayoutId(): Int {

        return R.layout.activity_ec_sell
    }

    override fun initView() {
        super.initView()

        mPicList = ArrayList<String>()
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")
        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>,this)
        ry_pic.layoutManager = GridLayoutManager(this,3)
        ry_pic.adapter = mPicAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text ="机械出售"
        tv_way.setOnClickListener(this)
        ly_production_time.setOnClickListener(this)
        ly_pay_way.setOnClickListener(this)
        mStringList?.add("元/月")
        mStringList?.add("元/台班")
        mStringList?.add("元/小时")
        mStringList?.add("面议")
        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>,this)

        mPayWayList?.add("全款")
        mPayWayList?.add("协议付款")
        mPayWayList?.add("分期付款")

    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onItemClick(view: View, position: Int) {
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_way->showInput()
            R.id.ly_production_time ->showTime()
            R.id.ly_pay_way->showPayWay()
        }
    }

    private fun showTime() {

        val mTimePickerView = TimePickerBuilder(this, this).build()
        mTimePickerView.show()
    }



    private fun showInput() {

        this?.let { PopUtils.init(it,
            R.layout.pop_way,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT, this) }
        PopUtils.showPopupWindow(tv_way)
    }

    private fun showPayWay(){
        this?.let { PopUtils.init(it,
            R.layout.pop_layout_pay_way,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT, object :PopUtils.onViewListener{
                override fun getView(view: View?) {
                    mPopPayWay =view?.findViewById(R.id.pop_recycler_list)
                    mPayWayAdapter = PopWayAdapter(this@EcSellActivity,mPayWayList,this@EcSellActivity)
                    mPopPayWay?.layoutManager = LinearLayoutManager(this@EcSellActivity)
                    mPopPayWay?.adapter = mPayWayAdapter
                }
            }
        ) }
        PopUtils.showPopupWindow(ly_pay_way)
    }

    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mPopWayAdapter = PopWayAdapter(this,mStringList,this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mPopWayAdapter
    }

    override fun onTimeSelect(date: Date?, v: View?) {


    }
}
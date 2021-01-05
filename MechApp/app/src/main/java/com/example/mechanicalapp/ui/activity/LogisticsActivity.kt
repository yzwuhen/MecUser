package com.example.mechanicalapp.ui.activity

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.LogisticsAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.LogisticsBean
import com.example.mechanicalapp.ui.data.LogisticsData
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import kotlinx.android.synthetic.main.activity_logistics.*
import kotlinx.android.synthetic.main.layout_title.*

class LogisticsActivity :BaseCusActivity(),NetDataView<LogisticsBean>,OnItemClickListener,View.OnClickListener {

    private var orderId = ""
    private var mPresenter: MecAppPresenter? = null
    private var mAdapter:LogisticsAdapter?=null
    private var mList=ArrayList<LogisticsData.TracesBean>()
    override fun getLayoutId(): Int {

        return R.layout.activity_logistics
    }

    override fun initView() {
        super.initView()
        orderId = intent.getStringExtra("order_id").toString()

        mAdapter = LogisticsAdapter(this,mList,this)
        recycle_list.layoutManager =LinearLayoutManager(this)
        recycle_list.adapter =mAdapter

        ly_left.setOnClickListener(this)
        tv_title.text ="物流信息"
        rl_title.setBackgroundColor(Color.parseColor("FFB923"))

    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
        //020201231104409015449
        mPresenter?.getLogistics(orderId)
    }

    override fun refreshUI(data: LogisticsBean?) {

        if (data!=null&&data.result!=null){
            tv_logistics.text="物流公司：${data.result.shipperCode}"
            tv_logistics_code.text="物流单号：${data.result.logisticCode}"
            mList.clear()
            mList.addAll(data.result.traces)
            mAdapter?.notifyDataSetChanged()
        }
    }

    override fun loadMore(data: LogisticsBean?) {
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }
    override fun onItemClick(view: View, position: Int) {

    }
    override fun onClick(p0: View?) {

        finish()
    }
}
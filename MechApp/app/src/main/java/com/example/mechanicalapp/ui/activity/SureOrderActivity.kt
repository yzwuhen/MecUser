package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.SureOrderGoodsAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_sure_order.*
import kotlinx.android.synthetic.main.layout_title.*

class SureOrderActivity:BaseActivity<NetData>(),View.OnClickListener,OnItemClickListener {

    private var mAdapter:SureOrderGoodsAdapter?=null
    private var mList:MutableList<String> =ArrayList<String>()

    override fun getLayoutId(): Int {
        return R.layout.activity_sure_order
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "确认订单"

        ly_address.setOnClickListener(this)
        tv_settlement.setOnClickListener(this)
        tv_freight_rule.setOnClickListener(this)

        mList.add("红色")
        mList.add("黄色")
        mList.add("黑色")
        mList.add("蓝色")

        recycler_list.layoutManager = LinearLayoutManager(this)
        mAdapter = SureOrderGoodsAdapter(this,mList,this)
        recycler_list.adapter = mAdapter
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.ly_address->jumpActivity(null,MyAddressActivity::class.java)
            R.id.tv_settlement->jumpActivity(null,PayActivity::class.java)
            R.id.tv_freight_rule->jumpActivity(null,FreightRuleActivity::class.java)
        }
    }

    override fun onItemClick(view: View, position: Int) {


    }
}
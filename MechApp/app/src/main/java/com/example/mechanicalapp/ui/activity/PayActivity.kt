package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PayAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PayData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_pay.*
import kotlinx.android.synthetic.main.layout_title.*

class PayActivity:BaseActivity<NetData>() ,View.OnClickListener,OnItemClickListener{
    private var mAdapter:PayAdapter?=null
    private var mList:MutableList<PayData> =ArrayList<PayData>()

    private var price=0.0
    private var  orderNum=""
    override fun getLayoutId(): Int {
        return R.layout.activity_pay
    }

    override fun initView() {
        super.initView()


        price = intent.getDoubleExtra("order_price",0.0)
        orderNum = intent.getStringExtra("order_num").toString()


        tv_tip_info.text ="￥$price"
        tv_tip_info1.text ="订单号：$orderNum"

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text ="支付订单"

        val payData=PayData()
        payData.mIcon=R.mipmap.zfb
        payData.mText="支付宝"
        payData.isCheck =true
        val payData1=PayData()
        payData1.mIcon=R.mipmap.wxzf
        payData1.mText="微信支付"
        val payData2=PayData()
        payData2.mIcon=R.mipmap.yl
        payData2.mText="银联支付"
        val payData3=PayData()
        payData3.mIcon=R.mipmap.xxzf
        payData3.mText="线下支付"

        mList.add(payData)
        mList.add(payData1)
        mList.add(payData2)
        mList.add(payData3)

        mAdapter = PayAdapter(this,mList,this)
        recycle_list.layoutManager =LinearLayoutManager(this)
        recycle_list.adapter = mAdapter
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
        }
    }

    override fun onItemClick(view: View, position: Int) {


    }
}
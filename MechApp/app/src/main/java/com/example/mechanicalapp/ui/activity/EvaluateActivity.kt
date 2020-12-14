package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.OrderData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import kotlinx.android.synthetic.main.activity_evaluate.*
import kotlinx.android.synthetic.main.layout_title.*

class EvaluateActivity:BaseCusActivity(),View.OnClickListener ,NetDataView<NetData>{
    private var orderData:OrderData?=null
    private var mPresenter: MecAppPresenter?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_evaluate
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "我的评价"

        orderData = intent.getSerializableExtra("key") as  OrderData


        tv_order_num.text = "订单号：${orderData?.orderNum}"

        tv_order_state.text = orderData?.status_dictText

        tv_ec_type.text =orderData?.productType
        tv_contacts.text =orderData?.customerName

        tv_contacts_phone.text =orderData?.customerPhone
      //  tv_money.text="￥${orderData.payTime}"
    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
        mPresenter?.getEvaluate(orderData?.id)
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

    override fun refreshUI(data: NetData?) {

    }

    override fun loadMore(data: NetData?) {
    }
}
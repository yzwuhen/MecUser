package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.PartsOrderChildAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsOrderDetailsBean
import com.example.mechanicalapp.ui.data.request.ReApplyRefund
import com.example.mechanicalapp.ui.mvp.impl.OrderDetailsPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.DateUtils
import kotlinx.android.synthetic.main.activity_parts_details.*
import kotlinx.android.synthetic.main.layout_title.*

class PartsOrderDetails :BaseCusActivity(), View.OnClickListener,NetDataView<NetData> {

    private var orderType: Int = 0
    private var orderId=""
    private var mPresenter: OrderDetailsPresenter?=null

    private var datas:PartsOrderDetailsBean.ResultBean.OrderBean?=null

    override fun getLayoutId(): Int {

        return R.layout.activity_parts_details
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)

        orderType = intent.getIntExtra("order_type", 0)
        orderId = intent.getStringExtra("order_id").toString()

        if (orderType == 0) {
            tv_title.text = "待支付订单"
            ly_tip.visibility = View.VISIBLE
            ly_order1.visibility = View.VISIBLE

        } else if (orderType == 1) {
            tv_title.text = "待发货订单"
            ly_tip.visibility = View.GONE
            ly_order2.visibility = View.VISIBLE

            ly_pay_time.visibility = View.VISIBLE
        } else if (orderType == 2) {
            tv_title.text = "待收货订单"
            tv_tip_info1.text = "商家已发货"
            tv_tip_info.text = "还剩1天5小时自动确认收货"

            ly_order3.visibility = View.VISIBLE
        } else if (orderType == 3) {
            tv_title.text = "待评价订单"
            ly_tip.visibility = View.GONE

            ly_order4.visibility = View.VISIBLE

            ly_pay_time.visibility = View.VISIBLE
            ly_send_goods_time.visibility = View.VISIBLE
            ly_get_goods_time.visibility = View.VISIBLE
        } else if (orderType == 4) {
            tv_title.text = "已完成订单"
            ly_tip.visibility = View.GONE

            ly_pay_time.visibility = View.VISIBLE
            ly_send_goods_time.visibility = View.VISIBLE
            ly_get_goods_time.visibility = View.VISIBLE
            ly_evaluate_time.visibility = View.VISIBLE
        } else if (orderType == 5) {
            tv_title.text = "已关闭订单"
            ly_tip.visibility = View.GONE
        }


        tv_cancel_order.setOnClickListener(this)
        tv_pay.setOnClickListener(this)
        tv_apply_refund.setOnClickListener(this)
        tv_look_logistics.setOnClickListener(this)
        tv_apply_refund3.setOnClickListener(this)
        tv_confirm.setOnClickListener(this)
        tv_evaluate.setOnClickListener(this)
        tv_look_evaluate.setOnClickListener(this)

    }

    override fun initPresenter() {

        mPresenter = OrderDetailsPresenter(this)
        mPresenter?.getPartsOrderDetails(orderId)
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
            R.id.tv_cancel_order->cancelOrder()
            R.id.tv_pay->goPay()
            R.id.tv_apply_refund->applyRefund()
//            R.id.tv_look_logistics->finish()
            R.id.tv_apply_refund3->applyRefund()
            R.id.tv_confirm->confirm()
            R.id.tv_evaluate->jumpActivity(null,EvaluatePartsActivity::class.java)
            R.id.tv_look_evaluate->jumpActivity(null,EvaluatePartsActivity::class.java)

        }

    }

    private fun confirm() {


    }

    private fun applyRefund() {
        var bundle = Bundle()
        var reApplyRefund =ReApplyRefund()
        reApplyRefund.businessId

        jumpActivity(null,ApplyRefundActivity::class.java)
    }

    private fun goPay() {
        var bundle =Bundle()
        bundle.putString("order_num",datas?.orderNum)
        bundle.putString("order_id",datas?.id)
        bundle.putString("created_time",datas?.createTime)
        datas?.amount?.let { bundle.putDouble("order_price", it) }
        jumpActivity(bundle,PayActivity::class.java)
    }

    private fun cancelOrder() {


    }

    override fun refreshUI(data: NetData?) {
        if (data!=null &&data is PartsOrderDetailsBean&&data.result!=null){
            showData(data.result)
        }

    }

    private fun showData(data: PartsOrderDetailsBean.ResultBean) {
        datas =data.order
        tv_user_name.text =data.order.receiverName
        tv_user_phone.text = data.order.receiverPhone
        tv_address.text =data.order.receiverAddress
        //备注
        tv_remarks.text =data.order.memo

        tv_order_num.text =data.order.orderNum
        tv_created_time.text =data.order.createTime

        //支付时间
        tv_pay_time.text =data.order.paymentTime
//        tv_send_goods_time.text=data.order.

        recycle_list.layoutManager = LinearLayoutManager(this)
        var mPartsOrderChildAdapter = PartsOrderChildAdapter(this,data.productList,0,null)
        recycle_list.adapter =mPartsOrderChildAdapter

        tv_all_nun.text ="共${data.order.quantity}件商品"
        tv_money.text ="￥${data.order.amount}"


        tv_tip_info.text="还剩${DateUtils.getHours(data.order.expire,DateUtils.getDateByLongWithFormat(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"))}小时自动关闭订单"
    }

    override fun loadMore(data: NetData?) {
    }
}
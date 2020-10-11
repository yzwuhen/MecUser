package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_parts_details.*
import kotlinx.android.synthetic.main.layout_title.*

class PartsOrderDetails : BaseActivity<NetData>(), View.OnClickListener {

    private var orderType: Int = 0
    override fun getLayoutId(): Int {

        return R.layout.activity_parts_details
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)

        orderType = intent.getIntExtra("order_type", 0)

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
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
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
        jumpActivity(null,ApplyRefundActivity::class.java)
    }

    private fun goPay() {
        jumpActivity(null,PayActivity::class.java)
    }

    private fun cancelOrder() {


    }
}
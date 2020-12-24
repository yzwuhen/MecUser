package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.RatingBar
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.OrderDetailsData
import com.example.mechanicalapp.ui.data.request.ReEvaluate
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_evaluate.*
import kotlinx.android.synthetic.main.layout_title.*

class EvaluateActivity:BaseCusActivity(),View.OnClickListener ,NetDataView<NetData>,RatingBar.OnRatingBarChangeListener{
    private var orderData: OrderDetailsData?=null
    private var mPresenter: MecAppPresenter?=null

    private var mReEvaluate =ReEvaluate()
    override fun getLayoutId(): Int {

        return R.layout.activity_evaluate
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_btn.setOnClickListener(this)
        tv_title.text = "我的评价"

        orderData = intent.getSerializableExtra("key") as  OrderDetailsData


        tv_order_num.text = "订单号：${orderData?.orderNum}"

        tv_order_state.text = orderData?.statusName

        tv_ec_type.text =orderData?.productType
        tv_contacts.text =orderData?.customerName

        tv_contacts_phone.text =orderData?.customerPhone
      //  tv_money.text="￥${orderData.payTime}"
        mReEvaluate.orderId =orderData?.id
       mReEvaluate?.customerId=orderData?.customerId
        mReEvaluate?.customerName =orderData?.customerName
        mReEvaluate?.customerPhone =orderData?.customerPhone
        mReEvaluate?.repairFactoryId =orderData?.repairFactoryId
        mReEvaluate?.starLevel ="3"
        ratingBar.setOnRatingBarChangeListener(this)
    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
      //  mPresenter?.getEvaluate(orderData?.id)
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_btn->submit()
        }
    }

    private fun submit() {


        mReEvaluate?.commentContent = tv_info.text.toString()
        mPresenter?.postEvaluate(mReEvaluate)
    }

    override fun refreshUI(data: NetData?) {
        ToastUtils.showText(data?.message)
        if (data?.code==200){
            finish()
        }

    }

    override fun loadMore(data: NetData?) {
    }

    override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
        mReEvaluate?.starLevel =p1.toInt().toString()
    }
}
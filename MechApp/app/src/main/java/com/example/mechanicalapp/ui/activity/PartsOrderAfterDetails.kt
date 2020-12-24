package com.example.mechanicalapp.ui.activity

import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.PartsOrderChildAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.OrderBackData
import com.example.mechanicalapp.ui.data.PartsOrderDetailsBean
import com.example.mechanicalapp.ui.data.request.ReExpress
import com.example.mechanicalapp.ui.mvp.impl.OrderDetailsPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_parts_order_after.*
import kotlinx.android.synthetic.main.layout_title.*

class PartsOrderAfterDetails : BaseCusActivity(), View.OnClickListener, NetDataView<NetData> {

    private var orderType: Int = 0
    private var orderId = ""
    private var mPresenter: OrderDetailsPresenter? = null

    private var mExpressDialog: BottomSheetDialog? = null
    private var mExpressDialogView: View? = null
    private var mDialogEtExpressName:EditText?=null
    private var mDialogEtExpressNum:EditText?=null
    private var mDialogClose:ImageView?=null
    private var mDialogSure:TextView?=null

    private var mOrderBackData :OrderBackData?=null
    private var mReExpress=ReExpress()

    private lateinit var datas: PartsOrderDetailsBean.ResultBean.OrderBean
    override fun getLayoutId(): Int {
        return R.layout.activity_parts_order_after
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)

        orderType = intent.getIntExtra("order_type", 0)
        orderId = intent.getStringExtra("order_id").toString()

        mReExpress.orderId =orderId

        if (orderType == 0) {
            tv_title.text = "售后中"
            ly_order1.visibility = View.VISIBLE
            ly_contact_cus_server.visibility =View.GONE
            ly_post_address.visibility =View.VISIBLE
            //寄回后才显示
            ly_send_back_time.visibility =View.VISIBLE
        } else if (orderType == 1) {
            tv_title.text = "售后成功"
            ly_send_back_time.visibility =View.VISIBLE
            ly_refund_time.visibility =View.VISIBLE
        } else if (orderType == 2) {
            ly_send_back_time.visibility =View.VISIBLE
            tv_title.text = "售后失败"

        } else if (orderType == 3) {
            tv_title.text = "售后关闭"
            ly_close_time.visibility =View.VISIBLE
        }

        tv_cancel_refund.setOnClickListener(this)
        tv_contact_cus_server.setOnClickListener(this)
        tv_fill_order_num.setOnClickListener(this)

    }

    override fun initPresenter() {
        mPresenter = OrderDetailsPresenter(this)
        mPresenter?.getPartsOrderAfterDetails(orderId)
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_contact_cus_server->openCall("400800")
            R.id.tv_cancel_refund->cancelRefund()
            R.id.tv_fill_order_num->showInputDialog()
            R.id.iv_dialog_close->mExpressDialog?.dismiss()
            R.id.tv_dialog_sure->postExpressInfo()
        }

    }

    private fun cancelRefund() {
    }

    //提交快递信息
    private fun postExpressInfo() {
        mExpressDialog?.dismiss()
        if (TextUtils.isEmpty(mDialogEtExpressName?.text.toString())){
            ToastUtils.showText("请输入运输公司名称")
            return
        }
        mReExpress.deliveryCorp =mDialogEtExpressName?.text.toString()
        if (TextUtils.isEmpty(mDialogEtExpressNum?.text.toString())){
            ToastUtils.showText("请输入快递单号")
            return
        }
        mReExpress.trackingNo =mDialogEtExpressNum?.text.toString()
        mPresenter?.postExpress(mReExpress)
    }

    private fun showInputDialog() {
        if (mExpressDialog == null) {
            mExpressDialog = BottomSheetDialog(this)
            mExpressDialogView = View.inflate(this, R.layout.dialog_fill_post_num, null)
            mExpressDialog?.setContentView(mExpressDialogView!!)
            mDialogEtExpressName = mExpressDialogView?.findViewById(R.id.et_dialog_post_company)
            mDialogEtExpressNum = mExpressDialogView?.findViewById(R.id.et_dialog_post_num)
            mDialogClose = mExpressDialogView?.findViewById(R.id.iv_dialog_close)
            mDialogSure = mExpressDialogView?.findViewById(R.id.tv_dialog_sure)

            mDialogClose?.setOnClickListener(this)
            mDialogSure?.setOnClickListener(this)
        }
        mExpressDialog?.show()
    }


    override fun refreshUI(data: NetData?) {
        if (data != null && data is PartsOrderDetailsBean && data.result != null) {
            showData(data.result)
        }
    }

    private fun showData(data: PartsOrderDetailsBean.ResultBean) {

        if (data.order != null) {
            datas = data.order
            mOrderBackData =data.orderBack;
            tv_order_num.text = data.order.orderNum

            recycle_list.layoutManager = LinearLayoutManager(this)
            var mPartsOrderChildAdapter = PartsOrderChildAdapter(this, data.productList, 0, null)
            recycle_list.adapter = mPartsOrderChildAdapter
            tv_all_nun.text = "共${data.order.quantity}件商品"
            tv_money.text = "￥${data.order.amount}"

            tv_apply_time.text =mOrderBackData?.applyTime
            tv_send_back_user_name.text =data.orderDelivery.consignee
            tv_send_back_user_address.text ="${data.orderDelivery.areaName}${data.orderDelivery.address}"
        }
    }

    override fun loadMore(data: NetData?) {
    }
}
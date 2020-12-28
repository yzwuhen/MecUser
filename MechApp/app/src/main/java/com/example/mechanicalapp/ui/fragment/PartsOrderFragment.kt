package com.example.mechanicalapp.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.ApplyRefundActivity
import com.example.mechanicalapp.ui.activity.EvaluateActivity
import com.example.mechanicalapp.ui.activity.EvaluatePartsActivity
import com.example.mechanicalapp.ui.activity.PartsOrderDetails
import com.example.mechanicalapp.ui.adapter.PartsOrderAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.OrderPresenter
import com.example.mechanicalapp.ui.mvp.v.OrderView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.liaoinstan.springview.widget.SpringView
import com.tencent.mm.opensdk.modelpay.PayReq
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import kotlinx.android.synthetic.main.layout_spring_list.*
import java.io.Serializable

class PartsOrderFragment(var type: Int) : BaseCusFragment(), OnItemClickListener,
    View.OnClickListener, PopUtils.onViewListener,
    OrderView<NetData> {


    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null

    private var mAdapter: PartsOrderAdapter? = null
    var mList: MutableList<PartsOrderData> = ArrayList<PartsOrderData>()

    private var mButtDialog: BottomSheetDialog? = null

    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null
    private var mDialogTv4: TextView? = null

    private var popType = 0
    private var clickPosition = 0
    private var api: IWXAPI? = null
    override fun initView() {
        super.initView()
        mAdapter = PartsOrderAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter
        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as OrderPresenter).resetPage()
                getDataList()
            }

            override fun onLoadmore() {
                getDataList()
            }
        })
        mPresenter = OrderPresenter(this)
        api = WXAPIFactory.createWXAPI(mContext, Configs.WX_APP_ID)
    }

    override fun onResume() {
        super.onResume()
        (mPresenter as OrderPresenter).resetPage()
        getDataList()
    }

    fun getDataList() {
        (mPresenter as OrderPresenter).getPartsOrderList(type.toString())
    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
        if (mList.size==0){
            showEmptyView(R.mipmap.no_order,"还没有下单，快去下单吧")
        }else{
            hideEmptyView()
        }
    }

    override fun onStop() {
        super.onStop()
        hideEmptyView()
    }
    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }


    override fun onItemClick(view: View, position: Int) {

        when (view?.id) {
//            R.id.tv_look_logistics->jumpActivity(null,null)
            R.id.tv_apply_refund -> showPop(1, position)
            R.id.tv_cancel_order -> showPop(0, position)
            R.id.tv_confirm -> showPop(3, position)
            R.id.tv_pay -> showBtnDialog(position)
            R.id.tv_evaluate -> jumEvaluate(position)
            R.id.tv_look_evaluate -> jumLookEvaluate(position)
            R.id.ly_root -> jumAct(position)
            R.id.item_child_root -> jumAct(position)
        }

    }

    private fun jumLookEvaluate(position: Int) {
        jumpActivity(null, EvaluateActivity::class.java)
    }

    private fun jumEvaluate(position: Int) {
        var bundle = Bundle()
        bundle.putSerializable("data", mList[clickPosition].orderItemList as Serializable)
        bundle.putInt("num", mList[clickPosition].quantity)
        bundle.putString("id", mList[clickPosition].id)
        jumpActivity(bundle, EvaluatePartsActivity::class.java)
    }

    private fun jumAct(position: Int) {
        var bundle = Bundle()
        bundle.putInt("order_type", mList[position].status)
        bundle.putString("order_id", mList[position].id)
        jumpActivity(bundle, PartsOrderDetails::class.java)
    }

    private fun showBtnDialog(position: Int) {
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(mContext)
            mDialogView = View.inflate(mContext, R.layout.dialog_pay, null)
            mButtDialog?.setContentView(mDialogView!!)
            mDialogTv1 = mDialogView?.findViewById(R.id.tv_dialog_item1)
            mDialogTv2 = mDialogView?.findViewById(R.id.tv_dialog_item2)
            mDialogTv3 = mDialogView?.findViewById(R.id.tv_dialog_item3)
            mDialogTv4 = mDialogView?.findViewById(R.id.tv_dialog_item4)

            mDialogTv1?.setOnClickListener(this)
            mDialogTv2?.setOnClickListener(this)
            mDialogTv3?.setOnClickListener(this)
            mDialogTv4?.setOnClickListener(this)
        }
        clickPosition = position
        mButtDialog?.show()
    }

    private fun showPop(i: Int, position: Int) {

        if (mPopwindow == null) {
            mPopwindow = activity?.let {
                PopUtils.init(
                    mContext,
                    it, R.layout.pop_del_mec,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
        }
        popType = i
        clickPosition = position
        if (i == 0) {
            popInfo?.text = "确认取消订单吗？"
            popCancel?.text = "取消"
            popSure?.text = "确定"
        } else if (i == 1) {
            popInfo?.text = "一张订单只能申请一次退款 是否继续操作？"
            popCancel?.text = "取消"
            popSure?.text = "申请退款"
        } else if (i == 2) {
            popInfo?.text = "您的订单正在进行售后，请处理完后再确认收货"
            popCancel?.visibility = View.GONE
            popSure?.text = "知道了"
        } else if (i == 3) {
            popInfo?.text = "确认收货后不可再申请退货 请确认商品没问题后再进行操作"
            popCancel?.text = "取消"
            popSure?.text = "确认收货"
        }
        activity?.let { PopUtils.showPopupWindow(fl_bottom, it) }

    }

    override fun getView(view: View?) {
        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popInfo = view?.findViewById(R.id.tv_pop_info)

        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }


    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.tv_pop_sure -> popYes()
            R.id.tv_pop_cancel -> activity?.let { PopUtils.dismissPop(it) }

            R.id.tv_dialog_item1 -> mButtDialog?.dismiss()
            R.id.tv_dialog_item2 -> {
                payWx()
                mButtDialog?.dismiss()
            }

            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
            R.id.tv_dialog_item4 -> mButtDialog?.dismiss()
        }
    }


    private fun payWx() {
        (mPresenter as OrderPresenter)?.payWx(mList[clickPosition].id)
    }

    private fun payAlly() {

    }

    private fun popYes() {
        activity?.let { PopUtils.dismissPop(it) }
        when (popType) {
            0 -> cancelOrder()
            1 -> applyRefund()
            3 -> getGoods()
            4 -> cancleSh()
        }

    }

    //取消售后
    private fun cancleSh() {


    }

    //确认收货
    private fun getGoods() {


    }

    private fun applyRefund() {

        if (mList[clickPosition].isBackOrder == "1") {
            ToastUtils.showText("已经申请过售后，请耐心等待结果")
            return
        }
        var bundle = Bundle()
        bundle.putSerializable("data", mList[clickPosition].orderItemList as Serializable)
        bundle.putInt("num", mList[clickPosition].quantity)
        bundle.putDouble("price", mList[clickPosition].amount)
        bundle.putString("id", mList[clickPosition].id)
        jumpActivity(bundle, ApplyRefundActivity::class.java)
    }

    private fun payToWx(msg: WxPayBean.ResultBean.MsgBean?) {
        var request = PayReq();
        request.appId = msg?.appid;
        request.partnerId = msg?.partnerid;
        request.prepayId = msg?.prepayid;
        request.packageValue = msg?.packageX;
        request.nonceStr = msg?.noncestr;
        request.timeStamp = msg?.timestamp;
        request.sign = msg?.sign;
        api?.sendReq(request);

    }

    private fun cancelOrder() {
        (mPresenter as OrderPresenter)?.cancelPartsOrder(mList[clickPosition].id)
    }

    override fun err() {
    }

    override fun showData(data: NetData?) {
        if (data != null && data is PartOrderListBean) {
            mList.clear()
            if (data?.code == 200 && data?.result?.records?.isNotEmpty()!!) {
                mList.addAll(data?.result?.records!!)
            }
            mAdapter?.notifyDataSetChanged()
        } else if (data is WxPayBean) {
            payToWx(data?.result?.msg)
        } else {
            ToastUtils.showText(data?.message)
            spring_list?.callFresh()
        }

    }

    override fun showDataMore(data: NetData?) {
        if (data != null && data is PartOrderListBean) {
            if (data?.code == 200 && data?.result?.records?.isNotEmpty()!!) {
                mList.addAll(data?.result?.records!!)
                mAdapter?.notifyDataSetChanged()
            }
        }
    }

}
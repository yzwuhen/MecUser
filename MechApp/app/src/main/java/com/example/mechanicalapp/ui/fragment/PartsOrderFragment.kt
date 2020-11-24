package com.example.mechanicalapp.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.EvaluatePartsActivity
import com.example.mechanicalapp.ui.activity.PartsOrderDetails
import com.example.mechanicalapp.ui.adapter.PartsOrderAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.OrderPresenter
import com.example.mechanicalapp.ui.mvp.v.OrderView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_spring_list.*

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
                (mPresenter as OrderPresenter).getPartsOrderList(type.toString())
            }

            override fun onLoadmore() {
                (mPresenter as OrderPresenter).getPartsOrderList(type.toString())
            }
        })
        mPresenter = OrderPresenter(this)
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
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }


    override fun onItemClick(view: View, position: Int) {

        when (view?.id) {
//            R.id.tv_look_logistics->jumpActivity(null,null)
            R.id.tv_apply_refund -> showPop(1)
            R.id.tv_cancel_order -> showPop(0)
            R.id.tv_confirm -> showPop(3)
            R.id.tv_pay -> showBtnDialog()
            R.id.tv_evaluate -> jumpActivity(null, EvaluatePartsActivity::class.java)
            R.id.tv_look_evaluate -> jumpActivity(null, EvaluatePartsActivity::class.java)
//            R.id.tv_input_odd_num->jumpActivity(null,null)
            R.id.tv_cancel_sale -> showPop(4)
            R.id.ly_root -> jumAct(position)
        }

    }

    private fun jumAct(position: Int) {
        var bundle = Bundle()
        bundle.putInt("order_type", position)
        jumpActivity(bundle, PartsOrderDetails::class.java)
    }

    private fun showBtnDialog() {
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(mContext)
            mDialogView = View.inflate(mContext, R.layout.dialog_pay, null)
            mButtDialog?.setContentView(mDialogView!!)
            mDialogTv1 = mDialogView?.findViewById(R.id.tv_dialog_item1)
            mDialogTv2 = mDialogView?.findViewById(R.id.tv_dialog_item2)
            mDialogTv3 = mDialogView?.findViewById(R.id.tv_dialog_item3)
            mDialogTv4 = mDialogView?.findViewById(R.id.tv_dialog_item4)
        }

        mDialogTv1?.setOnClickListener(this)
        mDialogTv2?.setOnClickListener(this)
        mDialogTv3?.setOnClickListener(this)
        mDialogTv4?.setOnClickListener(this)
        mButtDialog?.show()
    }

    private fun showPop(i: Int) {

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
        } else if (i == 4) {
            popInfo?.text = "售后取消后不可再发起申请 是否继续操作？"
            popCancel?.text = "取消"
            popSure?.text = "取消售后"
        }
        activity?.let { PopUtils.showPopupWindow(fl_bottom, it) }

    }

    private fun dismiss(types: Int) {
        activity?.let { PopUtils.dismissPop(it) }
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
            R.id.tv_pop_sure -> dismiss(0)
            R.id.tv_pop_cancel -> activity?.let { PopUtils.dismissPop(it) }

            R.id.tv_dialog_item1 -> mButtDialog?.dismiss()
            R.id.tv_dialog_item2 -> mButtDialog?.dismiss()
            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
            R.id.tv_dialog_item4 -> mButtDialog?.dismiss()
        }
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
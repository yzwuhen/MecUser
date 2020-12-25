package com.example.mechanicalapp.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.PartsOrderAfterDetails
import com.example.mechanicalapp.ui.adapter.PartsOrderAfterAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReExpress
import com.example.mechanicalapp.ui.mvp.impl.OrderDetailsPresenter
import com.example.mechanicalapp.ui.mvp.impl.OrderPresenter
import com.example.mechanicalapp.ui.mvp.v.OrderView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.liaoinstan.springview.widget.SpringView
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import kotlinx.android.synthetic.main.layout_spring_list.*

class PartsOrderAfterSaleFragment  : BaseCusFragment(), OnItemClickListener,
    View.OnClickListener, PopUtils.onViewListener,
    OrderView<NetData> {


    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null

    private var mAdapter: PartsOrderAfterAdapter? = null
    var mList: MutableList<PartsOrderData> = ArrayList<PartsOrderData>()

    private var mExpressDialog: BottomSheetDialog? = null
    private var mExpressDialogView: View? = null
    private var mDialogEtExpressName: EditText?=null
    private var mDialogEtExpressNum: EditText?=null
    private var mDialogClose: ImageView?=null
    private var mDialogSure:TextView?=null
    private var mReExpress= ReExpress()
    private var clickPosition=0
    private var api: IWXAPI?=null
    override fun initView() {
        super.initView()
        mAdapter = PartsOrderAfterAdapter(mContext, mList, this)
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
    fun getDataList(){
        (mPresenter as OrderPresenter).getPartsOrderAfterSaleList()
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

    //提交快递信息
    private fun postExpressInfo() {
        //clickPosition
        mExpressDialog?.dismiss()
        if (TextUtils.isEmpty(mDialogEtExpressName?.text.toString())){
            ToastUtils.showText("请输入运输公司名称")
            return
        }
        mReExpress.deliverycorpCode =mDialogEtExpressName?.text.toString()
        if (TextUtils.isEmpty(mDialogEtExpressNum?.text.toString())){
            ToastUtils.showText("请输入快递单号")
            return
        }
        mReExpress.id =mList[clickPosition]?.id
        mReExpress.trackNo =mDialogEtExpressNum?.text.toString()
        (mPresenter as OrderPresenter)?.postExpress(mReExpress)
    }

    private fun showInputDialog(position: Int) {
        if (mExpressDialog == null) {
            mExpressDialog = BottomSheetDialog(mContext)
            mExpressDialogView = View.inflate(mContext, R.layout.dialog_fill_post_num, null)
            mExpressDialog?.setContentView(mExpressDialogView!!)
            mDialogEtExpressName = mExpressDialogView?.findViewById(R.id.et_dialog_post_company)
            mDialogEtExpressNum = mExpressDialogView?.findViewById(R.id.et_dialog_post_num)
            mDialogClose = mExpressDialogView?.findViewById(R.id.iv_dialog_close)
            mDialogSure = mExpressDialogView?.findViewById(R.id.tv_dialog_sure)

            mDialogClose?.setOnClickListener(this)
            mDialogSure?.setOnClickListener(this)
        }
        mExpressDialog?.show()
        clickPosition =position
    }


    override fun onItemClick(view: View, position: Int) {

        when (view?.id) {
            R.id.tv_input_odd_num->showInputDialog(position)
            R.id.tv_cancel_sale -> showPop(position)
            R.id.ly_root -> jumAct(position)
            R.id.item_child_root->jumAct(position)
        }
    }
    private fun jumAct(position: Int) {
        var bundle = Bundle()
        bundle.putInt("order_type", mList[position].status)
        bundle.putString("order_id",mList[position].id)
        jumpActivity(bundle, PartsOrderAfterDetails::class.java)
    }

    private fun showPop(position: Int) {

        if (mPopwindow == null) {
            mPopwindow = activity?.let {
                PopUtils.init(
                    mContext,
                    it, R.layout.pop_del_mec,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
            popInfo?.text = "售后取消后不可再发起申请 是否继续操作？"
            popCancel?.text = "取消"
            popSure?.text = "取消售后"
        }
        clickPosition =position



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
            R.id.iv_dialog_close->mExpressDialog?.dismiss()
            R.id.tv_dialog_sure->postExpressInfo()
        }
    }


    private fun popYes() {
        activity?.let { PopUtils.dismissPop(it) }
           cancleSh()

    }

    //取消售后
    private fun cancleSh() {
        (mPresenter as OrderPresenter)?.cancelRefund(mList[clickPosition].id)
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
        else if (data is ReCancelRefundBean){
            ToastUtils.showText(data.message)
            if (data.code==200){
             spring_list?.callFresh()
            }
        }
        else if (data is PostExpressBean){
            ToastUtils.showText(data?.message)
            spring_list?.callFresh()
        }
        else{
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
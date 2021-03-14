package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.OrderPresenter
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.OrderView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.netease.nim.uikit.api.NimUIKit
import com.umeng.socialize.ShareAction
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class OrderDetailsActivity : BaseCusActivity(), View.OnClickListener,
    PopUtils.onViewListener,OrderView<NetData> {

    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null

    private var mShareDialog: BottomSheetDialog?=null
    private var mShareView: View?=null
    private var mLyWx: LinearLayout?=null
    private var mLyQq: LinearLayout?=null
    private var mLySina: LinearLayout?=null
    private var mTvCancelShare: TextView?=null


    private var popInputInfo: EditText? = null
    private var popInputCancel: TextView? = null
    private var popInputSure: TextView? = null
    private var mInputPopwindow: PopupWindow? = null

    private var orderId=""
    private var type=0
    private var popIndex=0

    private var mPresenter:OrderPresenter?=null
    private var orderData:OrderDetailsData?=null
    private var mMecPresenter: MecAppPresenter?=null
    private var mMecRepairEngineerBean: OrderDetailsData.MecRepairEngineerBean?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_order_details
    }

    override fun initView() {
        super.initView()

        iv_right.setImageResource(R.mipmap.share_icon)
        tv_title.text = "订单详情"

        orderId = intent.getStringExtra("id").toString()
        type =intent.getIntExtra("status",0)

        //type =0 的是是待确认 可以取消订单  默认显示取消订单的
        //订单被接后 底部的私信和电话功能开通并显示维修工厂内容
        if (type == 1) {
            tv_cancel_order.visibility = View.GONE
            ly_state1.visibility = View.VISIBLE
            ly_factory.visibility = View.VISIBLE
        } else if (type == 2) {
            tv_cancel_order.visibility = View.GONE
            ly_state2.visibility = View.VISIBLE
            ly_factory.visibility = View.VISIBLE
        } else if (type == 4) {
            tv_cancel_order.visibility = View.GONE
            ly_state3.visibility = View.VISIBLE
            ly_factory.visibility = View.VISIBLE
            tv_all_price.visibility =View.VISIBLE
        }
        else if (type == 3) {
            tv_cancel_order.visibility = View.GONE
            ly_state4.visibility = View.VISIBLE
            ly_factory.visibility = View.VISIBLE
            tv_all_price.visibility =View.VISIBLE
        }


        iv_left.setOnClickListener(this)
        ly_right.setOnClickListener(this)
        tv_cancel_order.setOnClickListener(this)
        ly_letter.setOnClickListener(this)
        ly_call.setOnClickListener(this)
        tv_letter.setOnClickListener(this)
        tv_call.setOnClickListener(this)
        ly_evaluate.setOnClickListener(this)
        ly_look_details1.setOnClickListener(this)
        ly_look_details.setOnClickListener(this)
        iv_look.setOnClickListener(this)
        tv_letter1.setOnClickListener(this)
        tv_call1.setOnClickListener(this)
        ly_look_details2.setOnClickListener(this)
        ly_pay.setOnClickListener(this)

    }

    override fun initPresenter() {
        mPresenter = OrderPresenter(this)
        mPresenter?.getOrderDetails(orderId)
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_left -> finish()
            R.id.ly_right -> showShare()
            R.id.iv_look -> {
                var  bundle =Bundle()
                bundle.putString("id",orderId)
                jumpActivity(bundle,VideoListActivity::class.java)
              //  showPop(1)
            }
            R.id.tv_cancel_order -> showPop(0)
            R.id.tv_letter1->goToChat()
            R.id.ly_letter -> goToChat()
            R.id.ly_call -> call()
            R.id.tv_call1->call()
            R.id.tv_letter -> goToChat()
            R.id.tv_call -> call()
            R.id.ly_look_details ->  jumDetailedList()
            R.id.ly_look_details1 ->  jumDetailedList()
            R.id.ly_evaluate ->
            {
                var bundle =Bundle()
                bundle.putSerializable("key",orderData)
                jumpActivity(bundle, EvaluateActivity::class.java)
            }
            R.id.tv_pop_sure -> dismissPop()
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
            R.id.tv_pop_input_cancel -> goVideo()
            R.id.tv_pop_input_sure -> goVideo()
            R.id.ly_look_details2 -> jumDetailedList()
            R.id.ly_wx -> shareThree(SHARE_MEDIA.WEIXIN)
            R.id.ly_qq -> shareThree(SHARE_MEDIA.QQ)
            R.id.ly_sina -> shareThree(SHARE_MEDIA.SINA)
            R.id.tv_cancel -> mShareDialog?.dismiss()
            R.id.ly_pay -> {
                var bundle = Bundle()
                bundle.putString("order_num", orderData?.orderNum)
                bundle.putString("order_id", orderData?.id)
                bundle.putString("created_time", orderData?.createTime)
                bundle.putInt("order_type", 1)
                orderData?.orderSum?.let { bundle.putDouble("order_price", it) }
                jumpActivity(bundle, PayActivity::class.java)
            }
        }
    }
    private fun shareThree(type: SHARE_MEDIA){
        mShareDialog?.dismiss()
        val web = UMWeb(Configs.BASE_URL+orderData?.shareUrl)
        web.title = "订单：${orderData?.orderNum}"//标题
        web.setThumb(UMImage(this,R.mipmap.app_logo)) //缩略图
        web.description = "订单：${orderData?.orderNum}"//描述
        ShareAction(this).withMedia(web).setPlatform(type).share()
        if (mMecPresenter==null){
            mMecPresenter = MecAppPresenter(this)
        }
        mMecPresenter?.shareTo()
    }


    private fun showShare() {

        if (mShareDialog ==null){
            mShareDialog = BottomSheetDialog(this)
            mShareView = View.inflate(this, R.layout.dialog_share, null)
            mShareDialog?.setContentView(mShareView!!)

            mLyWx = mShareView?.findViewById(R.id.ly_wx)
            mLyQq = mShareView?.findViewById(R.id.ly_qq)
            mLySina = mShareView?.findViewById(R.id.ly_sina)
            mTvCancelShare = mShareView?.findViewById(R.id.tv_cancel)

            mLyWx?.setOnClickListener(this)
            mLyQq?.setOnClickListener(this)
            mLySina?.setOnClickListener(this)
            mTvCancelShare?.setOnClickListener(this)
        }
        mShareDialog?.show()

    }


    private fun jumDetailedList(){
        var bundle =Bundle()
        bundle.putString("id",orderData?.id)
        jumpActivity(bundle, DetailedListActivity::class.java)
    }

    private fun call() {
        //工程师电话没有
        if (orderData!=null&&orderData?.mecRepairEngineer!=null&& orderData?.mecRepairEngineer!!.size>0){
            openCall(orderData?.mecRepairEngineer!![0].phone)
        }
    }

    private fun goToChat() {
        if (orderData!=null&&orderData?.mecRepairEngineer!=null&& orderData?.mecRepairEngineer!!.size>0){
            if (!TextUtils.isEmpty(orderData?.mecRepairEngineer!![0].engineerImId)){
                NimUIKit.startP2PSession(this, orderData?.mecRepairEngineer!![0].engineerImId)
            }
        }

    }

    private fun goVideo(){
        PopUtils.dismissPop(this)
        jumpActivity(null,VideoListActivity::class.java)
    }

    private fun showPop(i: Int) {
        popIndex =i
        if (mPopwindow == null) {
            mPopwindow = this?.let {
                PopUtils.init(
                    this,
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
        } else {
            popInfo?.text = "视频查看是否加密？"
            popCancel?.text = "不加密"
            popSure?.text = "加密"
        }

        this?.let { PopUtils.showPopupWindow(ly_right, it) }

    }

    private fun dismissPop(){
        PopUtils.dismissPop(this)
        if (popIndex==0){
           mPresenter?.cancelOrder(orderId)
        }else{
            showPop()
        }
    }

    private fun showPop() {

        if (mInputPopwindow == null) {
            mInputPopwindow = this?.let {
                PopUtils.init(this,
                    it, R.layout.pop_input,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, object : PopUtils.onViewListener {
                        override fun getView(view: View?) {
                            popInputCancel = view?.findViewById(R.id.tv_pop_input_cancel)
                            popInputSure = view?.findViewById(R.id.tv_pop_input_sure)
                            popInputInfo = view?.findViewById(R.id.tv_pop_input_info)

                            popInputSure?.setOnClickListener(this@OrderDetailsActivity)
                            popInputCancel?.setOnClickListener(this@OrderDetailsActivity)
                        }

                    })
            }
        }

        this?.let { PopUtils.showPopupWindow(ly_right, it) }
    }

    override fun getView(view: View?) {
        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popInfo = view?.findViewById(R.id.tv_pop_info)
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }

    override fun showData(data: NetData?) {

        if (data is OrderDetailsBean){
            showOrderInfo(data.result)
        }else{
            ToastUtils.showText(data?.message)
            if (data?.code==200){
                finish()
            }
        }
    }

    private fun showOrderInfo(result: OrderDetailsData?) {

        if (result!=null){
            orderData =result
            if (!TextUtils.isEmpty(result?.orderNum)){
                tv_order_num.text = "订单号：${result?.orderNum}"
            }else{
                tv_order_num.text = ""
            }
            tv_order_state.text =result?.statusName
            tv_title.text = "${result?.statusName}订单"

            tv_ec_type.text = result?.productType
            tv_ec_brand.text  =result?.productBrand
            tv_ec_model.text =result?.productModel

            tv_user_name.text =result?.customerName
            tv_user_phone.text =result?.customerPhone

            tv_company_name.text =result?.companyName
            tv_company_address.text =result?.adress

            tv_order_type.text =result?.repairTypeName
            tv_progress.text =result?.progressName
            tv_created_time.text =result?.createTime
            tv_info.text =result?.orderDesc

            tv_all_price.text="维修金额：￥${result.orderSum}"

            iv_look.isSelected = result.isHasCamWeb=="1"

            if (result?.mecRepaireFactory!=null){
                tv_factory_name.text =result?.mecRepaireFactory?.name
                tv_score.text ="${result?.mecRepaireFactory?.star}分"
                ratingBar.rating = result?.mecRepaireFactory?.star?.toFloat()!!
            }
            if (result?.mecRepairEngineer!=null&&result.mecRepairEngineer.size>0){
                mMecRepairEngineerBean =result?.mecRepairEngineer[0]
                tv_worker_name.text =mMecRepairEngineerBean?.name
                  tv_worker_type.text =mMecRepairEngineerBean?.post_dictText
                tv_worker_time.text="${mMecRepairEngineerBean?.repairAge}年"
            }
        }

    }


    override fun showDataMore(data: NetData?) {
    }
}
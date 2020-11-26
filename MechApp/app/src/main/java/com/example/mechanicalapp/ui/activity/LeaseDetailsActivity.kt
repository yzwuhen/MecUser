package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.IsCollectBean
import com.example.mechanicalapp.ui.data.MecDetailsData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReCollect
import com.example.mechanicalapp.ui.mvp.impl.DetailsPresenter
import com.example.mechanicalapp.ui.mvp.v.MecDetailsView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_lease_details.*
import kotlinx.android.synthetic.main.activity_lease_details.iv_sr
import kotlinx.android.synthetic.main.activity_lease_details.ly_call
import kotlinx.android.synthetic.main.activity_lease_details.ly_chat
import kotlinx.android.synthetic.main.activity_lease_details.ly_user_info
import kotlinx.android.synthetic.main.activity_lease_details.tv_address
import kotlinx.android.synthetic.main.activity_lease_details.tv_browse
import kotlinx.android.synthetic.main.activity_lease_details.tv_browse_time
import kotlinx.android.synthetic.main.activity_lease_details.tv_collected
import kotlinx.android.synthetic.main.activity_lease_details.tv_details
import kotlinx.android.synthetic.main.activity_lease_details.tv_mec_brand
import kotlinx.android.synthetic.main.activity_lease_details.tv_mec_model
import kotlinx.android.synthetic.main.activity_lease_details.tv_mec_type
import kotlinx.android.synthetic.main.activity_lease_details.tv_report
import kotlinx.android.synthetic.main.activity_lease_details.tv_user_nick
import kotlinx.android.synthetic.main.activity_lease_details.tv_work_time
import kotlinx.android.synthetic.main.activity_mec_buy_details.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class LeaseDetailsActivity : BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener,
    MecDetailsView<MecDetailsData> {
    private var mShareDialog: BottomSheetDialog? = null
    private var mShareView: View? = null

    private var mLyWx: LinearLayout? = null
    private var mLyQq: LinearLayout? = null
    private var mLySina: LinearLayout? = null
    private var mTvCancelShare: TextView? = null

    private var popTvTitle: TextView? = null
    private var popTvInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null

    var mList: MutableList<BannerData>? = ArrayList<BannerData>()


    private var mPresenter: DetailsPresenter? = null
    private var intentType: Int? = 0
    private var mecId: String? = null
    private var mData:MecDetailsData?=null

    private var mReCollect =ReCollect()
    private var isCollect=false
    override fun getLayoutId(): Int {
        return R.layout.activity_lease_details
    }

    override fun initView() {
        super.initView()

        iv_right.setImageResource(R.mipmap.title_share)
        tv_title.text = "出租详情"
        iv_left.setOnClickListener(this)
        iv_right.setOnClickListener(this)
        tv_report.setOnClickListener(this)
        tv_collected.setOnClickListener(this)
        ly_chat.setOnClickListener(this)
        ly_call.setOnClickListener(this)
        tv_address.setOnClickListener(this)
        ly_user_info.setOnClickListener(this)

        intentType = intent.getIntExtra(Configs.MEC_Lease_DETAILS_TYPE, 0)
        mecId = intent.getStringExtra(Configs.MEC_ID)

        mReCollect.type=4
        mReCollect.storeId =mecId
    }

    override fun initPresenter() {
        mPresenter = DetailsPresenter(this)
        mPresenter?.getLeaseDetails(mecId)
        mPresenter?.judgeCollect(mecId,4)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_left -> finish()
            R.id.iv_right -> showShare()
            R.id.tv_report -> jumpActivity(null, ReportActivity::class.java)
            R.id.ly_call -> showPhone()
            R.id.ly_wx -> mShareDialog?.dismiss()
            R.id.ly_qq -> mShareDialog?.dismiss()
            R.id.ly_sina -> mShareDialog?.dismiss()
            R.id.tv_cancel -> mShareDialog?.dismiss()
            R.id.tv_pop_sure -> PopUtils.dismissPop(this)
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
            R.id.ly_user_info -> jumHomePage()
            R.id.tv_collected->collect()
        }
    }

    private fun collect() {
        if (TextUtils.isEmpty(App.getInstance().token)){
            ToastUtils.showText("请先登陆后再操作")
            return
        }
        if (isCollect){
            mPresenter?.delCollect(mReCollect)
        }else{
            mPresenter?.addCollect(mReCollect)
        }
    }

    private fun jumHomePage() {
        var bundle = Bundle()
        if (intentType == 0) {
            bundle.putInt(Configs.USER_HOME_PAGE, 3)
        } else {
            bundle.putInt(Configs.USER_HOME_PAGE, 2)
        }
        bundle.putInt(Configs.USER_HOME_PAGE_Index, 0)
        jumpActivity(bundle, UserHomePage::class.java)

    }

    private fun showPhone() {

        if (mPopwindow == null) {
            mPopwindow = this?.let {
                PopUtils.init(
                    this,
                    it, R.layout.pop_center_phone,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
        }

        this?.let { PopUtils.showPopupWindow(tv_title, it) }
    }

    private fun showShare() {

        if (mShareDialog == null) {
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

    override fun getView(view: View?) {

        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popTvTitle = view?.findViewById(R.id.tv_pop_title)
        popTvInfo = view?.findViewById(R.id.tv_pop_info)

        popTvTitle?.text=mData?.contactName
        popTvInfo?.text ="请问是否呼叫 ${mData?.contactPhone}"
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    override fun showData(data: MecDetailsData?) {
        if (data != null) {
            mData =data
            if (!TextUtils.isEmpty(data.pic)) {
                mList?.clear()
                for (index in data.pic.split(",")) {
                    var bannerData = BannerData()
                    bannerData.img = index
                    mList?.add(bannerData)
                }
                banner.adapter = ImageAdapter(mList)
                banner.indicator = CircleIndicator(this)
            }
            tv_details_title.text = data.tittle
            tv_browse.text = "浏览量：${data.viewNum}"
            tv_browse_time.text = DateUtils.dateDiffs(data.createTime, System.currentTimeMillis())

            tv_cost.text = "￥${data.price}/${data.priceUnit_dictText}"

            tv_address.text = "所在地：${data.address}"

            tv_mec_type.text = data.cateName
            tv_mec_brand.text = data.brandName
            tv_factory_time.text = data.facDate
            tv_mec_model.text = data.modelName
            tv_work_time.text = data.workTime
            tv_cost_way.text = data.priceUnit_dictText

            tv_details.text = data.briefDesc

            tv_user_nick.text = "昵称：${data.contactName}"
            if (data.isPerson == "1") {
                iv_sr.visibility = View.VISIBLE
            } else {
                iv_sr.visibility = View.GONE
            }

        }
    }

    override fun collectSuccess(netData: NetData?) {
        if (netData is IsCollectBean){
            if (netData.result ==1){
                isCollect =true
                tv_collected.text = "已收藏"
                tv_collected.isSelected = true
            }

        }else{
            if (netData != null && netData.code == 200) {
                if (!isCollect){
                    tv_collected.text = "已收藏"
                    tv_collected.isSelected = true
                }else{
                    tv_collected.text = "收藏"
                    tv_collected.isSelected = false
                }
                isCollect =!isCollect
            }
            ToastUtils.showText(netData?.message)
        }

    }
}
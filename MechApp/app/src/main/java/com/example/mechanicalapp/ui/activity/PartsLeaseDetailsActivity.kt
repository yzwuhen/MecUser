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
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReCollect
import com.example.mechanicalapp.ui.mvp.impl.DetailsPresenter
import com.example.mechanicalapp.ui.mvp.v.MecDetailsView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_parts_lease_details.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class PartsLeaseDetailsActivity : BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener,
    MecDetailsView<PartsDetailsData> {
    private var mShareDialog: BottomSheetDialog?=null
    private var mShareView: View?=null

    private var mLyWx: LinearLayout?=null
    private var mLyQq: LinearLayout?=null
    private var mLySina: LinearLayout?=null
    private var mTvCancelShare: TextView?=null

    private var popTvTitle: TextView?=null
    private var popTvInfo: TextView?=null
    private var popCancel: TextView?=null
    private var popSure: TextView?=null
    private var mPopwindow: PopupWindow?=null

    var mList: MutableList<BannerData>? = ArrayList<BannerData>()

    private var mPresenter: DetailsPresenter? = null
    private var partId=""
    private var mReCollect = ReCollect()
    private var isCollect=false
    private var mData:PartsDetailsData?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_parts_lease_details
    }

    override fun initView() {
        super.initView()

        iv_right.setImageResource(R.mipmap.title_share)
        tv_title.text="出租详情"
        iv_left.setOnClickListener(this)
        iv_right.setOnClickListener(this)
        tv_report.setOnClickListener(this)
        tv_collected.setOnClickListener(this)
        ly_chat.setOnClickListener(this)
        ly_call.setOnClickListener(this)
        tv_address.setOnClickListener(this)
        ly_user_info.setOnClickListener(this)


        partId = intent.getStringExtra(Configs.MEC_ID).toString()

        mReCollect.type = 0
        mReCollect.storeId = partId
    }

    override fun initPresenter() {
        mPresenter = DetailsPresenter(this)
        mPresenter?.getPartsLeaseDetails(partId)
        mPresenter?.judgeCollect(partId,4)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_left->finish()
            R.id.iv_right->showShare()
            R.id.tv_report->jumpActivity(null,ReportActivity::class.java)
            R.id.ly_call->showPhone()
            R.id.ly_wx->mShareDialog?.dismiss()
            R.id.ly_qq->mShareDialog?.dismiss()
            R.id.ly_sina->mShareDialog?.dismiss()
            R.id.tv_cancel->mShareDialog?.dismiss()
            R.id.tv_pop_sure-> PopUtils.dismissPop(this)
            R.id.tv_pop_cancel-> PopUtils.dismissPop(this)
            R.id.ly_user_info->jumHomePage()
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
        bundle.putInt(Configs.USER_HOME_PAGE,1)
        bundle.putInt(Configs.USER_HOME_PAGE_Index,0)
        bundle.putString(Configs.USER_HOME_PAGE_NAME,mData?.createBy)
        jumpActivity(bundle,UserHomePage::class.java)

    }
    private fun showPhone() {

        if (mPopwindow ==null){
            mPopwindow =  this?.let {
                PopUtils.init(this,
                    it, R.layout.pop_center_phone,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,true,this)
            }
        }

        this?.let { PopUtils.showPopupWindow(tv_title, it) }
    }

    private fun showShare() {

        if (mShareDialog ==null){
            mShareDialog = BottomSheetDialog(this)
            mShareView = View.inflate(this, R.layout.dialog_share,null)
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

    override fun showData(data: PartsDetailsData?) {
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

            tv_details_title.text = data.title
            tv_browse.text = "浏览量：${data.viewNum}"
            tv_browse_time.text = DateUtils.dateDiffs(data.createTime, System.currentTimeMillis())

            if (data.isTalk==1){
                tv_cost.text = "一口价:￥${data.price}/元"
            }else{
                tv_cost.text = "￥${data.price}/${data.priceUnit_dictText}"
            }


            tv_address.text = "所在地：${data.address}"

            ImageLoadUtils.loadCircle(this,iv_lease_user_pic,data.avatar)
            tv_lease_user_nick.text ="昵称：${data.contactName}"
            if (data.isPerson=="1"){
                tv_lease_user_sr.visibility =View.VISIBLE
            }else{
                tv_lease_user_sr.visibility =View.GONE
            }
         //   tv_mec_type.text =data.partsType
            tv_parts_brand.text =data.brand
            tv_parts_type.text =data.partsType
            tv_details.text = data.content

            tv_user_nick.text = "昵称：${data.realname}"
            ImageLoadUtils.loadCircle(this,iv_user_pic,data.avatar)

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
package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.view.PopUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_parts_lease_details.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class PartsLeaseDetailsActivity : BaseActivity<NetData>(), View.OnClickListener, PopUtils.onViewListener {
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


    private var intentType:Int?=0

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

        val bannerData = BannerData()
        bannerData.img =
            "https://t8.baidu.com/it/u=2247852322,986532796&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1600708280&t=2c8b3ed72148e0c4fb274061565e6723"

        mList?.add(bannerData)
        mList?.add(bannerData)

        banner.adapter = ImageAdapter(mList)
        banner.indicator = CircleIndicator(this)

        intentType = intent.getIntExtra(Configs.MEC_Lease_DETAILS_TYPE,0)

        if (intentType==1){
            ly_lease_user_info.visibility = View.VISIBLE
        }

    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
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
        }
    }
    private fun jumHomePage() {
        var bundle = Bundle()
        bundle.putInt(Configs.USER_HOME_PAGE,3)
        bundle.putInt(Configs.USER_HOME_PAGE_Index,0)
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
}
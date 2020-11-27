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
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.IsCollectBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.RecruitDetailsBean
import com.example.mechanicalapp.ui.data.request.ReCollect
import com.example.mechanicalapp.ui.mvp.impl.DetailsPresenter
import com.example.mechanicalapp.ui.mvp.v.MecDetailsView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_recruit_details.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class RecruitDetailsActivity  : BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener ,
    MecDetailsView<NetData> {
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

    private var mReCollect = ReCollect()
    private var isCollect=false
    private var id =""
    private var mPresenter :DetailsPresenter?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_recruit_details
    }

    override fun initView() {
        super.initView()

        iv_right.setImageResource(R.mipmap.title_share)
        tv_title.text="招聘详情"
        iv_left.setOnClickListener(this)
        iv_right.setOnClickListener(this)
        tv_report.setOnClickListener(this)
        tv_collected.setOnClickListener(this)
        ly_chat.setOnClickListener(this)
        ly_call.setOnClickListener(this)
        tv_address.setOnClickListener(this)
        ly_user_info.setOnClickListener(this)


        id = intent.getStringExtra("id").toString()
        mReCollect.type = 0
        mReCollect.storeId = id
    }

    override fun initPresenter() {
        mPresenter = DetailsPresenter(this)
        mPresenter?.getRecruitDetails(id)
        mPresenter?.judgeCollect(id,5)
    }

    private fun collect() {
        if (TextUtils.isEmpty(App.getInstance().token)) {
            ToastUtils.showText("请先登陆后再操作")
            return
        }
        if (isCollect) {
            mPresenter?.delCollect(mReCollect)
        } else {
            mPresenter?.addCollect(mReCollect)
        }

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
            R.id.tv_report->{
                var bundle =Bundle()
                bundle.putString("id",id)
                bundle.putInt("type",5)
                jumpActivity(bundle,ReportActivity::class.java)
            }
            R.id.ly_call->showPhone()
            R.id.ly_wx->mShareDialog?.dismiss()
            R.id.ly_qq->mShareDialog?.dismiss()
            R.id.ly_sina->mShareDialog?.dismiss()
            R.id.tv_cancel->mShareDialog?.dismiss()
            R.id.tv_pop_sure-> PopUtils.dismissPop(this)
            R.id.tv_pop_cancel-> PopUtils.dismissPop(this)
            R.id.ly_user_info->jumHomePage()
            R.id.tv_collected -> collect()
        }
    }
    private fun jumHomePage() {
        var bundle = Bundle()
        bundle.putInt(Configs.USER_HOME_PAGE,4)
        bundle.putInt(Configs.USER_HOME_PAGE_Index,1)
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

    override fun showData(data: NetData?) {

        if (data!=null&&data is RecruitDetailsBean&&data.result!=null){
            tv_details_title.text ="招聘${data.result.jobTittle}"
            tv_cost.text =data.result.price_dictText
            tv_browse.text ="浏览量:${data.result.viewNum}"
            tv_experience.text =data.result.jobEx_dictText

            tv_browse_time.text = DateUtils.dateDiffs(data.result.createTime, System.currentTimeMillis())
            tv_address.text = data.result.jobAddress

           tv_worker_type.text =data.result.cateName
            tv_recruit_num.text ="${data.result.needNumber}人"
            tv_details_experience.text =data.result.jobEx_dictText
            tv_pay.text =data.result.price_dictText

            tv_details.text =data.result.content


            tv_user_nick.text ="昵称："+data.result.contactName
            ImageLoadUtils.loadCircle(this,iv_user_pic,data.result.avatar)
            if (data.result.isPerson==1){
                iv_sr.visibility =View.VISIBLE
            }else{
                iv_sr.visibility =View.GONE
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
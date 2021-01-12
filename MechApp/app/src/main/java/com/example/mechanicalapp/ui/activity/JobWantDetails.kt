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
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReCollect
import com.example.mechanicalapp.ui.mvp.impl.DetailsPresenter
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.MecDetailsView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.umeng.socialize.ShareAction
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import kotlinx.android.synthetic.main.activity_job_want_details.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class JobWantDetails: BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener ,
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
    private var mPresenter : DetailsPresenter?=null
    private var mMecPresenter: MecAppPresenter?=null
    private var mData: RecruitDetailsData?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_job_want_details
    }

    override fun initView() {
        super.initView()

        iv_right.setImageResource(R.mipmap.title_share)
        tv_title.text="求职详情"
        iv_left.setOnClickListener(this)
        iv_right.setOnClickListener(this)
        tv_report.setOnClickListener(this)
        tv_collected.setOnClickListener(this)
        ly_chat.setOnClickListener(this)
        ly_call.setOnClickListener(this)
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
            R.id.ly_wx -> shareThree(SHARE_MEDIA.WEIXIN)
            R.id.ly_qq -> shareThree(SHARE_MEDIA.QQ)
            R.id.ly_sina -> shareThree(SHARE_MEDIA.SINA)
            R.id.tv_cancel->mShareDialog?.dismiss()
            R.id.tv_pop_sure-> PopUtils.dismissPop(this)
            R.id.tv_pop_cancel-> PopUtils.dismissPop(this)
            R.id.ly_user_info->jumHomePage()
            R.id.tv_collected -> collect()
        }
    }
    private fun shareThree(type: SHARE_MEDIA){
        mShareDialog?.dismiss()
        val web = UMWeb(Configs.BASE_URL+mData?.shareUrl)
        web.title = mData?.jobtitle//标题
        web.setThumb(UMImage(this,R.mipmap.app_logo)) //缩略图
        web.description = mData?.jobtitle//描述
        ShareAction(this).withMedia(web).setPlatform(type).share()
        if (mMecPresenter==null){
            mMecPresenter = MecAppPresenter(this)
        }
        mMecPresenter?.shareTo()
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

    private fun jumHomePage() {
        var bundle = Bundle()
            bundle.putInt(Configs.USER_HOME_PAGE,4)
            bundle.putInt(Configs.USER_HOME_PAGE_Index,1)
        bundle.putString(Configs.USER_HOME_PAGE_NAME,mData?.createBy)
        jumpActivity(bundle,UserHomePage::class.java)

    }

    override fun showData(data: NetData?) {

        if (data!=null&&data is RecruitDetailsBean &&data.result!=null){
            tv_goods_title.text ="求职${data.result.jobtitle}"

            tv_ask_user.text = data.result.contactName

            mData =data.result
            tv_browse.text ="浏览量:${data.result.viewNum}"
            tv_browse_time.text = DateUtils.dateDiffs(data.result.createTime, System.currentTimeMillis())



            //工种
            tv_worker_type.text =data.result.cateName
            //工作经验
            tv_work_experience.text =data.result.jobEx_dictText

            //是否随时上岗
            if (data.result.isOn=="1"){
                tv_is_work.text = "是"
            }else{
                tv_is_work.text = "否"
            }

            tv_birth.text =data.result.birthday
            //期望薪资
            tv_hope_money.text =data.result.price_dictText
            //居住地址
            tv_address.text = data.result.jobAddress


            tv_details.text =data.result.content

            tv_user_nick.text ="昵称："+data.result.contactName
            ImageLoadUtils.loadCircle(this,iv_ask_user_pic,data.result.avatar)
            ImageLoadUtils.loadCircle(this,iv_user_pic,data.result.avatar)
            if (data.result.isPerson==1){
                iv_sr.visibility =View.VISIBLE
                iv_ask_user_sr.visibility =View.VISIBLE
            }else{
                iv_sr.visibility =View.GONE
                iv_ask_user_sr.visibility =View.GONE
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
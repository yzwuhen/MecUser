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
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.MecDetailsView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.netease.nim.uikit.api.NimUIKit
import com.umeng.socialize.ShareAction
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import kotlinx.android.synthetic.main.activity_parts_ask_details.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class PartsAskDetailsActivity : BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener ,
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
    private var mMecPresenter: MecAppPresenter?=null
    private var mPresenter: DetailsPresenter? = null
    private var partId=""
    private var mReCollect = ReCollect()
    private var isCollect=false
    private var mData:PartsDetailsData?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_parts_ask_details
    }
    override fun initView() {
        super.initView()
        iv_right.setImageResource(R.mipmap.title_share)
        tv_title.text="求租详情"
        iv_left.setOnClickListener(this)
        iv_right.setOnClickListener(this)
        tv_report.setOnClickListener(this)
        tv_collected.setOnClickListener(this)
        ly_chat.setOnClickListener(this)
        ly_call.setOnClickListener(this)
        tv_address.setOnClickListener(this)
        ly_user_info.setOnClickListener(this)
        partId = intent.getStringExtra(Configs.MEC_ID).toString()
        mReCollect.type = 2
        mReCollect.storeId = partId
    }

    override fun initPresenter() {
        mPresenter = DetailsPresenter(this)
        mPresenter?.getPartsLeaseDetails(partId)
        mPresenter?.judgeCollect(partId,2)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_left->finish()
            R.id.iv_right->showShare()
            R.id.tv_report->{
                var bundle =Bundle()
                bundle.putString("id",partId)
                bundle.putInt("type",2)
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
            R.id.tv_collected->collect()
            R.id.tv_address->jumThreeMap(mData?.gpsLat,mData?.gpsLon,mData?.address)
            R.id.ly_chat->goToChat()
        }
    }
    private fun goToChat() {
        if (mData!=null&&mData?.imId!=null){
            if (!TextUtils.isEmpty(mData?.imId)){
                NimUIKit.startP2PSession(this, mData?.imId)
            }
        }
    }
    private fun shareThree(type: SHARE_MEDIA){
        mShareDialog?.dismiss()
        val web = UMWeb(Configs.BASE_URL+mData?.shareUrl)
        web.title = mData?.title//标题
        web.setThumb(UMImage(this,R.mipmap.app_logo)) //缩略图
        web.description = mData?.title//描述
        ShareAction(this).withMedia(web).setPlatform(type).share()
        if (mMecPresenter==null){
            mMecPresenter = MecAppPresenter(this)
        }
        mMecPresenter?.shareTo()
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
        bundle.putInt(Configs.USER_HOME_PAGE_Index,1)
        bundle.putString(Configs.USER_HOME_PAGE_NAME,mData?.createBy)
        jumpActivity(bundle,UserHomePage::class.java)

    }
    private fun showPhone() {
        if (mData==null||TextUtils.isEmpty(mData?.contactPhone)){
            ToastUtils.showText("该用户设置不可通过电话联系")
            return
        }
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

            tv_goods_title.text ="求租${data.title}"
            tv_browse.text = "浏览量：${data.viewNum}"
            tv_browse_time.text = DateUtils.dateDiffs(data.createTime, System.currentTimeMillis())


            tv_address.text = "所在地：${data.address}"

            ImageLoadUtils.loadImageCenterCrop(this,iv_ask_user_pic,data.avatar,R.mipmap.user_default)
            tv_ask_user.text ="昵称：${data.contactName}"
            if (data.isPerson=="1"){
                iv_ask_user_sr.visibility =View.VISIBLE
            }else{
                iv_ask_user_sr.visibility =View.GONE
            }

            tv_coast_money.text="${data.price}${data.priceUnit_dictText}"

            tv_parts_model.text =data.partsType
            tv_parts_brand.text =data.brand
            tv_mec_type.text =data.cateName
            tv_details.text = data.content

            tv_user_nick.text = "昵称：${data.realname}"
            ImageLoadUtils.loadImageCenterCrop(this,iv_user_pic,data.avatar,R.mipmap.user_default)

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
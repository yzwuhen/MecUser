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
import com.example.mechanicalapp.ui.data.BusinessDetails
import com.example.mechanicalapp.ui.data.IsCollectBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReCollect
import com.example.mechanicalapp.ui.mvp.impl.DetailsPresenter
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.MecDetailsView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.umeng.socialize.ShareAction
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener
import kotlinx.android.synthetic.main.activity_mec_buy_details.*
import kotlinx.android.synthetic.main.activity_mec_sell_details.*
import kotlinx.android.synthetic.main.activity_mec_sell_details.iv_sr
import kotlinx.android.synthetic.main.activity_mec_sell_details.ly_call
import kotlinx.android.synthetic.main.activity_mec_sell_details.ly_chat
import kotlinx.android.synthetic.main.activity_mec_sell_details.ly_user_info
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_address
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_browse
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_browse_time
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_collected
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_details
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_mec_brand
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_mec_model
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_mec_type
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_report
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_user_nick
import kotlinx.android.synthetic.main.activity_mec_sell_details.tv_work_time
import kotlinx.android.synthetic.main.layout_left_right_title.*

class MecSellDetails  : BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener,OnBannerListener<BannerData>,
    MecDetailsView<BusinessDetails> {
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
    private var isCollect=false
    var mList: MutableList<BannerData>? = ArrayList<BannerData>()

    private var mMecPresenter: MecAppPresenter?=null
    private var mPresenter: DetailsPresenter? = null
    private var intentType: Int? = 0
    private var mecId: String? = null
    private var mData :BusinessDetails?=null
    private var mReCollect = ReCollect()
    override fun getLayoutId(): Int {
        return R.layout.activity_mec_sell_details
    }

    override fun initView() {
        super.initView()

        iv_right.setImageResource(R.mipmap.title_share)
        tv_title.text = "出售详情"
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
        mReCollect.type=3
        mReCollect.storeId =mecId
    }

    override fun initPresenter() {
        mPresenter = DetailsPresenter(this)
        mPresenter?.getBusiness(mecId)
        mPresenter?.judgeCollect(mecId,3)
    }


    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_left -> finish()
            R.id.iv_right -> showShare()
            R.id.tv_report -> {
                var bundle =Bundle()
                bundle.putString("id",mecId)
                bundle.putInt("type",3)
                jumpActivity(bundle,ReportActivity::class.java)
            }
            R.id.ly_call -> showPhone()
            R.id.ly_wx -> shareThree(SHARE_MEDIA.WEIXIN)
            R.id.ly_qq -> shareThree(SHARE_MEDIA.QQ)
            R.id.ly_sina -> shareThree(SHARE_MEDIA.SINA)
            R.id.tv_cancel -> mShareDialog?.dismiss()
            R.id.tv_pop_sure -> PopUtils.dismissPop(this)
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
            R.id.ly_user_info -> jumHomePage()
            R.id.tv_collected->collect()
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
        if (intentType == 0) {
            bundle.putInt(Configs.USER_HOME_PAGE, 3)
        } else {
            bundle.putInt(Configs.USER_HOME_PAGE, 2)
        }
        bundle.putInt(Configs.USER_HOME_PAGE_Index, 0)
        bundle.putString(Configs.USER_HOME_PAGE_NAME,mData?.createBy)
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

    override fun showData(data: BusinessDetails?) {
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
                banner.setOnBannerListener(this)
            }
            tv_details_title.text =data.title
            tv_browse.text = "浏览量：${data.viewNum}"
            tv_browse_time.text = DateUtils.dateDiffs(data.createTime,System.currentTimeMillis())

            tv_cost.text ="￥${data.price}/元"

            tv_address.text="所在地：${data.address}"

            tv_mec_type.text=data.cateName
            tv_mec_brand.text =data.brandName
            tv_factory_time.text =data.facDate
            tv_mec_model.text =data.modelName
            tv_work_time.text =data.workTime
            tv_cost_way.text=data.paymentType_dictText

            tv_details.text =data.briefDesc

            tv_user_nick.text ="昵称：${data.contactName}"
            tv_lease_user_nick.text =data.contactName


            if (data.isNew == "1"){
               tv_label.visibility=View.VISIBLE
            }else{
               tv_label.visibility=View.GONE
            }

            if (data.isPerson=="1"){
                iv_sr.visibility = View.VISIBLE
                tv_lease_user_sr.visibility =View.VISIBLE
            }else{
                iv_sr.visibility = View.GONE
                tv_lease_user_sr.visibility =View.GONE
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

    override fun OnBannerClick(data: BannerData?, position: Int) {
        if (data?.img?.endsWith("mp4")!!){
            PictureSelector.create(this).externalPictureVideo(data.img);
        }
    }
}
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
import com.example.mechanicalapp.ui.data.FactoryDetailsBean
import com.example.mechanicalapp.ui.data.IsCollectBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReCollect
import com.example.mechanicalapp.ui.mvp.impl.DetailsPresenter
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.MecDetailsView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.umeng.socialize.ShareAction
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener
import kotlinx.android.synthetic.main.activity_factory_details.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class FactoryDetails :BaseCusActivity() , PopUtils.onViewListener,View.OnClickListener,OnBannerListener<BannerData>,
    MecDetailsView<NetData> {
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

    private var mMecPresenter: MecAppPresenter?=null
    private var mPresenter: DetailsPresenter? = null
    private var id: String? = null
    private var mData:FactoryDetailsBean.ResultBean?=null

    private var mReCollect = ReCollect()
    private var isCollect=false

    override fun getLayoutId(): Int {
        return R.layout.activity_factory_details
    }

    override fun initView() {
        super.initView()

        iv_right.setImageResource(R.mipmap.title_share)
        tv_title.text = "维修厂"
        iv_left.setOnClickListener(this)
        iv_right.setOnClickListener(this)
        tv_collected.setOnClickListener(this)
        ly_chat.setOnClickListener(this)
        ly_call.setOnClickListener(this)
        tv_address.setOnClickListener(this)

        id = intent.getStringExtra("id")

        mReCollect.type=4
        mReCollect.storeId =id
    }

    override fun initPresenter() {
        mPresenter = DetailsPresenter(this)
        mPresenter?.getFactoryDetails(id)
        mPresenter?.judgeCollect(id,1)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_left -> finish()
            R.id.iv_right -> showShare()
            R.id.tv_report -> {
                var bundle = Bundle()
                bundle.putString("id",id)
                bundle.putInt("type",1)
                jumpActivity(bundle, ReportActivity::class.java)
            }
            R.id.ly_call -> showPhone()
            R.id.ly_wx -> shareThree(SHARE_MEDIA.WEIXIN)
            R.id.ly_qq -> shareThree(SHARE_MEDIA.QQ)
            R.id.ly_sina -> shareThree(SHARE_MEDIA.SINA)
            R.id.tv_cancel -> mShareDialog?.dismiss()
            R.id.tv_pop_sure -> PopUtils.dismissPop(this)
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
            R.id.tv_collected->collect()
        }
    }
    private fun shareThree(type: SHARE_MEDIA){
        mShareDialog?.dismiss()
        val web = UMWeb(Configs.BASE_URL+mData?.shareUrl)
        web.title = mData?.companyName//标题
        web.setThumb(UMImage(this,R.mipmap.app_logo)) //缩略图
        web.description = mData?.companyName//描述
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

    override fun getView(view: View?) {

        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popTvTitle = view?.findViewById(R.id.tv_pop_title)
        popTvInfo = view?.findViewById(R.id.tv_pop_info)

        popTvTitle?.text=mData?.name
        popTvInfo?.text ="请问是否呼叫 ${mData?.responsePersonPhone}"
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
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


    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    override fun showData(data: NetData?) {
        if (data != null &&data is FactoryDetailsBean) {
            mData =data.result
            if (!TextUtils.isEmpty(mData?.factoryPicture)) {
                mList?.clear()
                for (index in mData?.factoryPicture?.split(",")!!) {
                    var bannerData = BannerData()
                    bannerData.img = index
                    mList?.add(bannerData)
                }
                banner.adapter = ImageAdapter(mList)
                banner.indicator = CircleIndicator(this)
                banner.setOnBannerListener(this)
            }

            tv_factory_name.text =mData?.name
            ratingBar.rating = mData?.star!!
            tv_type.text ="维修类型：${mData?.repaireType}"
            tv_address.text =mData?.address
            tv_details.text =mData?.introduction

            tv_browse.text ="浏览量：${mData?.viewNum}"
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
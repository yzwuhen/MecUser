package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReMecLease
import com.example.mechanicalapp.ui.mvp.impl.MyMecPresenter
import com.example.mechanicalapp.ui.mvp.v.MyMecDetailsView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_my_mec_details.*
import kotlinx.android.synthetic.main.activity_my_mec_details.banner
import kotlinx.android.synthetic.main.layout_title.*

class MyMecDetailsActivity : BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener,
    MyMecDetailsView {
    var mList: MutableList<BannerData>? = ArrayList<BannerData>()
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null
    private var mPresenter: MyMecPresenter? = null
    private var id: String = ""
    private var mData: MyMecDetailsBean.ResultBean? = null

    override fun getLayoutId(): Int {

        return R.layout.activity_my_mec_details
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "设备详情"


        ly_search.setOnClickListener(this)
        tv_edit.setOnClickListener(this)
        tv_del.setOnClickListener(this)

        tv_lease.setOnClickListener(this)
        tv_sell.setOnClickListener(this)
        tv_repair.setOnClickListener(this)

        id = intent.getStringExtra("id").toString()
    }

    override fun initPresenter() {
        mPresenter = MyMecPresenter(this)
        mPresenter?.getMecDetails(id)
    }

    override fun showData(netData: NetData?) {
        if (netData != null && netData is MyMecDetailsBean) {
            mData = netData.result
            showInfo(netData.result)
        } else {
            ToastUtils.showText(netData?.message)
            if (netData?.code == 200) {
                finish()
            }
        }
    }

    private fun showInfo(data: MyMecDetailsBean.ResultBean) {
        if (data != null) {

            if (!TextUtils.isEmpty(data?.pic)) {
                mList?.clear()
                for (index in data?.pic?.split(",")!!) {
                    var bannerData = BannerData()
                    bannerData.img = index
                    mList?.add(bannerData)
                }
                banner.adapter = ImageAdapter(mList)
                banner.indicator = CircleIndicator(this)
            }
            tv_mec_name.text = data.titile

            tv_work_time.text = "${data.workTime}小时"
            tv_mec_type.text = data.cateName
            tv_factory_time.text = data.facDate
            tv_mec_brand.text = data.brandName
            tv_but_time.text = data.purchaseDate
            tv_mec_model.text = data.modelName
            tv_mec_address.text = data.address
            tv_details.text = data.briefDesc


        }
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.ly_search -> jump()
            R.id.tv_edit -> finish()
            R.id.tv_del -> shoTipDialog()
            R.id.tv_lease -> lease()
            R.id.tv_sell -> sell()
            R.id.tv_repair -> repair()
            R.id.tv_pop_sure -> {
                PopUtils.dismissPop(this)
                del()
            }
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
        }
    }

    //删除
    private fun del() {
        mPresenter?.delMyMec(mData)
    }

    //报修
    private fun repair() {


    }

    //出售
    private fun sell() {

    }

    //出租
    private fun lease() {
//        var mReMecLease= ReMecLease()
//        mReMecLease.bussiessType = "1"
//        mReMecLease.pic =mData?.pic
//        mReMecLease.tittle =mData?.titile
//        mReMecLease.

    }

    private fun shoTipDialog() {
        if (mPopwindow == null) {
            mPopwindow = this?.let {
                PopUtils.init(
                    this,
                    it,
                    R.layout.pop_del_mec,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    true,
                    this
                )
            }
        }
        this?.let { PopUtils.showPopupWindow(ly_search, it) }

    }


    private fun jump() {
        var bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE, 6)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }


    override fun getView(view: View?) {
        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }
}
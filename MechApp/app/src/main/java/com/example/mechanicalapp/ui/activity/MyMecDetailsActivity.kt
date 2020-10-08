package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_my_mec_details.*
import kotlinx.android.synthetic.main.layout_title.*

class MyMecDetailsActivity:BaseActivity<NetData>(),View.OnClickListener ,PopUtils.onViewListener{
    var mList: MutableList<BannerData>? = ArrayList<BannerData>()
    private var popCancel:TextView?=null
    private var popSure:TextView?=null
    private var mPopwindow: PopupWindow?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_my_mec_details
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "设备详情"
        var bannerData: BannerData
        bannerData = BannerData()
        bannerData.img_path ="https://t9.baidu.com/it/u=2268908537,2815455140&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1601476836&t=43717528e86dbef35c5a6e035d0e8c55"

        mList?.add(bannerData)
        mList?.add(bannerData)

        banner.adapter = ImageAdapter(mList)
        banner.indicator = CircleIndicator(this)

        ly_search.setOnClickListener(this)
        tv_edit.setOnClickListener(this)
        tv_del.setOnClickListener(this)

        tv_lease.setOnClickListener(this)
        tv_sell.setOnClickListener(this)
        tv_repair.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.ly_search->jump()
            R.id.tv_edit->finish()
            R.id.tv_del->shoTipDialog()
            R.id.tv_lease->shoTipDialog()
            R.id.tv_sell->shoTipDialog()
            R.id.tv_repair->shoTipDialog()
            R.id.tv_pop_sure->PopUtils.dismissPop(this)
            R.id.tv_pop_cancel->PopUtils.dismissPop(this)
        }
    }

    private fun shoTipDialog() {

        if (mPopwindow ==null){
            mPopwindow =  this?.let {
                PopUtils.init(this,
                    it,R.layout.pop_del_mec,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,true,this)
            }
        }

        this?.let { PopUtils.showPopupWindow(ly_search, it) }

    }



    private fun jump() {

        var bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE,6)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }


    override fun getView(view: View?) {

        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)

        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }
}
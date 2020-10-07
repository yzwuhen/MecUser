package com.example.mechanicalapp.ui.fragment.home

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.activity.ReportActivity
import com.example.mechanicalapp.ui.activity.SearchCityActivity
import com.example.mechanicalapp.ui.activity.SearchMecActivity
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.mvp.impl.DemoPresenterImpl
import com.example.mechanicalapp.ui.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.inculde_search_title.*

class HomeFragment : BaseFragment<MutableList<BannerData>>(),View.OnClickListener{

    private var bannerView : BannerView ?=null
    private var itemMenu : ItemMenu ?=null

    override fun showLoading() {

    }

    override fun hiedLoading() {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        super.initView()

        nest_scroll

        bannerView = BannerView(mContext)
        itemMenu =ItemMenu(mContext)

        mPresenter = DemoPresenterImpl(this)

        ly_root.addView(bannerView)
        ly_root.addView(itemMenu)
        ly_root.addView(HotApparatusView(mContext))
        ly_root.addView(UserDemandKtView(mContext))
        ly_root.addView(BossDemandView(mContext))
        ly_root.addView(HosPartsView(mContext))

        tv_address.setOnClickListener(this)
        tv_search.setOnClickListener(this)

        mPresenter.request()
    }

    override fun onClick(view: View?) {

       if (view?.id ==R.id.tv_address){
           jumpActivity(null,SearchCityActivity::class.java)
       }
        else if (view?.id ==R.id.tv_search){
            jumpActivity(null,ReportActivity::class.java)
        }
    }

    override fun showData(listt: MutableList<BannerData>) {
        bannerView?.setData(listt)
    }
}
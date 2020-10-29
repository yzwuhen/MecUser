package com.example.mechanicalapp.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.HistorySearchActivity
import com.example.mechanicalapp.ui.activity.MapActivity
import com.example.mechanicalapp.ui.activity.SearchCityActivity
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.mvp.impl.DemoPresenterImpl
import com.example.mechanicalapp.ui.view.*
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import com.liaoinstan.springview.widget.SpringView.OnFreshListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.inculde_search_title.*

class HomeFragment : BaseFragment<MutableList<BannerData>>(), View.OnClickListener {

    private var bannerView: BannerView? = null
    private var itemMenu: ItemMenu? = null

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
        itemMenu = ItemMenu(mContext)

        mPresenter = DemoPresenterImpl(this)

        ly_root.addView(bannerView)
        ly_root.addView(itemMenu)
        ly_root.addView(HotApparatusView(mContext))
        ly_root.addView(UserDemandKtView(mContext))
        ly_root.addView(BossDemandView(mContext))
        ly_root.addView(HosPartsView(mContext))

        tv_address.setOnClickListener(this)
        tv_search.setOnClickListener(this)
        tv_map.setOnClickListener(this)
        mPresenter.request()
        spring_list.setType(SpringView.Type.FOLLOW)
        spring_list.setHeader(RefreshHeaderUtils.getHeaderView(context))


        spring_list.setListener(object : OnFreshListener {
            override fun onRefresh() {
                spring_list.setEnable(false)
              //  initData()
                closeRefreshView()
            }

            override fun onLoadmore() {}
        })

    }
    fun closeRefreshView() {
        spring_list.setEnable(true)
        spring_list.onFinishFreshAndLoad()
    }
    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.tv_address -> jumCity()
            R.id.tv_search -> jumpSearch()
            R.id.tv_map -> jumMap()
        }


    }
    private fun jumpSearch() {

        var bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE,9)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }

    private fun jumCity() {
        jumpActivityForReSult(
            Configs.CITY_RESULT_CODE,
            SearchCityActivity::class.java
        )
    }

    private fun jumMap() {
        if (isLocationEnabled(mContext)){
            jumpActivity(null, MapActivity::class.java)
        }else{
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(intent)
        }
    }

    override fun showData(listt: MutableList<BannerData>) {
        bannerView?.setData(listt)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (Configs.CITY_RESULT_CODE == resultCode) {
            showResult(requestCode, data?.getStringExtra(Configs.SCREEN_RESULT_Extra))

        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun showResult(requestCode: Int, extra: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.CITY_RESULT_CODE -> tv_address.text = extra
        }
    }
}
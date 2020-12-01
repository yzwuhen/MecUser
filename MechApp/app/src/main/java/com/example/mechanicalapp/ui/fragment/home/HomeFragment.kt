package com.example.mechanicalapp.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import com.amap.api.location.AMapLocation
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.HistorySearchActivity
import com.example.mechanicalapp.ui.activity.MapActivity
import com.example.mechanicalapp.ui.activity.SearchCityActivity
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.DemoPresenterImpl
import com.example.mechanicalapp.ui.mvp.v.HomeBaseView
import com.example.mechanicalapp.ui.view.*
import com.example.mechanicalapp.utils.GdMapUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import com.liaoinstan.springview.widget.SpringView.OnFreshListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.inculde_search_title.*

class HomeFragment : BaseCusFragment(), View.OnClickListener, HomeBaseView<NetData>,GdMapUtils.LocationListener {

    private var bannerView: BannerView? = null
    private var itemMenu: ItemMenu? = null

    private var mHotApparatusView: HotApparatusView? = null
    private var mUserDemandKtView: UserDemandKtView? = null
    private var mBossDemandView: BossDemandView? = null
    private var mHosPartsView: HosPartsView? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        super.initView()

        nest_scroll

        bannerView = BannerView(mContext)
        itemMenu = ItemMenu(mContext)

        mHotApparatusView = HotApparatusView(mContext)
        mUserDemandKtView = UserDemandKtView(mContext)

        mBossDemandView = BossDemandView(mContext)
        mHosPartsView = HosPartsView(mContext)

        mPresenter = DemoPresenterImpl(this)

        ly_root.addView(bannerView)
        ly_root.addView(itemMenu)
        ly_root.addView(mHotApparatusView)
        ly_root.addView(mUserDemandKtView)
        ly_root.addView(mBossDemandView)
        ly_root.addView(mHosPartsView)

        tv_address.setOnClickListener(this)
        tv_search.setOnClickListener(this)
        tv_map.setOnClickListener(this)
        mPresenter.request()
        spring_list.type=SpringView.Type.FOLLOW
        spring_list.header=RefreshHeaderUtils.getHeaderView(mContext)

        spring_list.setListener(object : OnFreshListener {
            override fun onRefresh() {

            //    closeRefreshView()
                if (mPresenter!=null){
                    spring_list.isEnable=false
                    mPresenter.request()
                }
            }
            override fun onLoadmore() {}
        })

        GdMapUtils.location(this)
    }
    fun closeRefreshView() {
        spring_list?.isEnable=true
        spring_list?.onFinishFreshAndLoad()
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
        bundle.putInt(Configs.HISTORY_TYPE,10)
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

    override fun showLoading() {

    }

    override fun hiedLoading() {
        closeRefreshView()
    }

    override fun err()  {
    }

    override fun showAd(adList: List<BannerData>) {
        bannerView?.setData(adList)
    }

    override fun showHotMec(hotMec: List<HotMechineCate>) {
        mHotApparatusView?.setData(hotMec)
    }

    override fun showParts(mecProds: List<HomePartsData>) {
        mHosPartsView?.setData(mecProds)
    }

    override fun showLease(list: List<MecLeaseData>) {
        mUserDemandKtView?.setLease(list)
    }

    override fun showUserRent(list: List<MecLeaseData>) {
        mUserDemandKtView?.setRent(list)
    }

    override fun showBossSell(list: List<MecSellData>) {
        mBossDemandView?.setSell(list)
    }

    override fun showBossBuy(list: List<MecSellData>) {
        mBossDemandView?.setBuy(list)
    }

    override fun locationSuccess(mapLocation: AMapLocation) {
        tv_address.text =mapLocation.city
    }

    override fun locationErr() {
    }

}
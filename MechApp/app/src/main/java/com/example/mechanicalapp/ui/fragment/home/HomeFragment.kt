package com.example.mechanicalapp.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
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
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import com.liaoinstan.springview.widget.SpringView.OnFreshListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.inculde_search_title.*

class HomeFragment : BaseCusFragment(), View.OnClickListener, HomeBaseView<NetData> {

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

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    override fun showAd(adList: List<BannerData>) {
        Log.e("sssss============", "sssssssss==============showAd===${adList.size}")
        bannerView?.setData(adList)
    }

    override fun showHotMec(hotMec: List<HotMechineCate>) {
        Log.e("sssss============", "sssssssss==============showHotMec===${hotMec.size}")
        mHotApparatusView?.setData(hotMec)
    }

    override fun showParts(mecProds: List<PartsData>) {
        Log.e("sssss============", "sssssssss==============showParts===${mecProds.size}")
        mHosPartsView?.setData(mecProds)
    }

    override fun showLease(list: List<MecRentOutData>) {
        Log.e("sssss============", "sssssssss==============showLease===${list.size}")
        mUserDemandKtView?.setLease(list)
    }

    override fun showUserRent(list: List<MecRentInData>) {
        Log.e("sssss============", "sssssssss==============showUserRent===${list.size}")
        mUserDemandKtView?.setRent(list)
    }

    override fun showBossSell(list: List<MecSellData>) {
        Log.e("sssss============", "sssssssss==============showBossSell===${list.size}")
        mBossDemandView?.setSell(list)
    }

    override fun showBossBuy(list: List<MecBuyData>) {
        Log.e("sssss============", "sssssssss==============showBossBuy===${list.size}")
        mBossDemandView?.setBuy(list)
    }

    override fun err() {


    }
}
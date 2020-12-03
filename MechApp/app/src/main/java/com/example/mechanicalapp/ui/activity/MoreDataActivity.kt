package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.BannerBean
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.fragment.MoreBuyFragment
import com.example.mechanicalapp.ui.fragment.MoreDataSellFragment
import com.example.mechanicalapp.ui.fragment.MoreDataFragment
import com.example.mechanicalapp.ui.fragment.MoreRentFragment
import com.example.mechanicalapp.ui.mvp.impl.BannerPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.google.android.material.appbar.AppBarLayout
import com.liaoinstan.springview.widget.SpringView
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_more_data.*
import kotlinx.android.synthetic.main.layout_more_data_title.*

class MoreDataActivity : BaseCusActivity(), View.OnClickListener,
    ViewPager.OnPageChangeListener, AppBarLayout.OnOffsetChangedListener, NetDataView<BannerBean> {

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    var mList: MutableList<BannerData> = ArrayList<BannerData>()
    private var mPresenter: BannerPresenter? = null
    private var imageAdapter: ImageAdapter? = null

    private var type: Int = 0
    private var position=0
    override fun getLayoutId(): Int {

        return R.layout.activity_more_data
    }


    override fun initView() {
        super.initView()

        type = intent.getIntExtra(Configs.MORE_VIEW_TYPE, 0)

        if (type == 1) {
            tv_screen_left.text = "出租"
            tv_screen_right.text = "求租"
            mFragmentList?.add(MoreDataFragment(type))
            mFragmentList?.add(MoreRentFragment(2))
        } else {
            tv_screen_left.text = "出售"
            tv_screen_right.text = "求购"
            mFragmentList?.add(MoreDataSellFragment())
            mFragmentList?.add(MoreBuyFragment())
        }




        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)
        cus_page.adapter = mTabPageAdapter
        tv_screen_right.setOnClickListener(this)
        tv_screen_left.setOnClickListener(this)

        tv_screen_left.performClick()


        imageAdapter = ImageAdapter(mList)
        banner.adapter = imageAdapter
        banner.indicator = CircleIndicator(this)


        iv_back.setOnClickListener(this)
        tv_search.setOnClickListener(this)
        tv_map.setOnClickListener(this)

        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)

        app_bar.addOnOffsetChangedListener(this)

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                mPresenter?.getBanner(type)
                refreshFregment()
            }

            override fun onLoadmore() {}
        })

    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }
    private fun refreshFregment() {
        if (type==1){
            (mFragmentList?.get(0) as MoreDataFragment).refresh()
            (mFragmentList?.get(1) as MoreRentFragment).refresh()
        }else{
            (mFragmentList?.get(0) as MoreDataSellFragment).refresh()
            (mFragmentList?.get(1) as MoreBuyFragment).refresh()
        }

    }
    override fun initPresenter() {

        mPresenter = BannerPresenter(this)
        mPresenter?.getBanner(type)

    }

    override fun showLoading() {

    }

    override fun hiedLoading() {
        closeRefreshView()
    }

    override fun err() {

    }

    fun showView(index: Int) {
        position =index
        cus_page.currentItem = index
        if (index == 0) {
            tv_screen_left?.isSelected = true
            tv_screen_right?.isSelected = false
        } else {

            tv_screen_left?.isSelected = false
            tv_screen_right?.isSelected = true
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_screen_left -> showView(0)
            R.id.tv_screen_right -> showView(1)
            R.id.iv_back -> finish()
            R.id.tv_search ->jumSearch()
            R.id.tv_map -> {
                if (type ==1){
                    jumpActivity(null, MapActivity::class.java)
                }else{
                    jumpActivity(null, MapMecBusinessActivity::class.java)
                }
            }

        }
    }

    private fun jumSearch() {
        var bundle =Bundle()
        if (type==1){
            //刚好 0是机械出租 1是机械求租
            bundle.putInt(Configs.HISTORY_TYPE,position)
        }else{
            bundle.putInt(Configs.HISTORY_TYPE,position+2)
        }
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }

    override fun onPageScrollStateChanged(state: Int) {


    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        showView(position)
    }

    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
        spring_list.isEnable = p1 == 0
    }

    override fun refreshUI(data: BannerBean?) {
        if (data != null && data.code == 200 && data.result != null && data.result?.records != null) {
            mList.clear()
            mList.addAll(data.result.records)
            imageAdapter?.notifyDataSetChanged()
        }
    }

    override fun loadMore(data: BannerBean?) {
    }
}
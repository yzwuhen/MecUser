package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.BannerBean
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.fragment.RecruitFragment
import com.example.mechanicalapp.ui.fragment.RentFragment
import com.example.mechanicalapp.ui.mvp.impl.BannerPresenter
import com.example.mechanicalapp.ui.mvp.impl.RecruitPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.mvp.v.WorkAboutView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.google.android.material.appbar.AppBarLayout
import com.liaoinstan.springview.widget.SpringView
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_more_data.*
import kotlinx.android.synthetic.main.layout_more_data_title.*

/**
 * 招聘
 */
class MoreRecruitActivity :BaseCusActivity(), View.OnClickListener,
    ViewPager.OnPageChangeListener, AppBarLayout.OnOffsetChangedListener, NetDataView<BannerBean> {

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    var mList: MutableList<BannerData> = ArrayList<BannerData>()
    var type: Int = 1

    private var mPresenter : BannerPresenter?=null
    private var imageAdapter:ImageAdapter ?=null

    private var mRecruitFragment =RecruitFragment()
    private var mRentFragment =RentFragment()
    override fun getLayoutId(): Int {

        return R.layout.activity_more_data
    }

    override fun initView() {
        super.initView()


        mFragmentList?.add(mRecruitFragment)
        mFragmentList?.add(mRentFragment)
        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)
        cus_page.adapter = mTabPageAdapter
        tv_screen_right.setOnClickListener(this)
        tv_screen_left.setOnClickListener(this)

        tv_screen_left.performClick()

        imageAdapter =ImageAdapter(mList)
        banner.adapter = imageAdapter
        banner.indicator = CircleIndicator(this)

        iv_back.setOnClickListener(this)
        tv_search.setOnClickListener(this)
        tv_map.setOnClickListener(this)

        tv_screen_left.text = "招聘1"
        tv_screen_right.text = "求职"
        cus_page.setTouchEvent(true)
        cus_page.offscreenPageLimit=2
        cus_page.addOnPageChangeListener(this)

        app_bar.addOnOffsetChangedListener(this)

        spring_list.type=SpringView.Type.FOLLOW
        spring_list.header=RefreshHeaderUtils.getHeaderView(this)

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable=false
                mPresenter?.getBanner(4)
                refreshFregment()
            }
            override fun onLoadmore() {}
        })


    }

    private fun refreshFregment() {
        mRecruitFragment.reFresh()
        mRentFragment.reFresh()
    }

    fun closeRefreshView() {
        spring_list.isEnable=true
        spring_list.onFinishFreshAndLoad()
    }


    override fun initPresenter() {
        mPresenter = BannerPresenter(this)
        mPresenter?.getBanner(4)
    }


    private fun showView(index: Int) {
        cus_page.currentItem = index
        if (index == 0) {
            type = 12
            tv_screen_left?.isSelected = true
            tv_screen_right?.isSelected = false
        } else {
            type = 13
            tv_screen_left?.isSelected = false
            tv_screen_right?.isSelected = true
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_screen_left -> showView(0)
            R.id.tv_screen_right -> showView(1)
            R.id.iv_back -> finish()
            R.id.tv_search -> jumAct()
            R.id.tv_map -> jumpActivity(null, MapActivity::class.java)

        }
    }

    private fun jumAct() {
        var bundle: Bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE, type)
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
        if (data!=null&&data.code==200&&data.result!=null&&data.result?.records!=null){
            mList.clear()
            mList.addAll(data.result.records)
            imageAdapter?.notifyDataSetChanged()
        }
    }

    override fun loadMore(data: BannerBean?) {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
        closeRefreshView()
    }

    override fun err() {
    }
}
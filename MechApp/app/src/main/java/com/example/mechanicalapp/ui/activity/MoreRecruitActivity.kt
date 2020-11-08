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
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.fragment.RecruitFragment
import com.example.mechanicalapp.ui.fragment.RentFragment
import com.example.mechanicalapp.ui.mvp.impl.RecruitPresenter
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
    ViewPager.OnPageChangeListener, AppBarLayout.OnOffsetChangedListener ,WorkAboutView{

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    var mList: MutableList<BannerData>? = ArrayList<BannerData>()
    var type: Int = 1
    //private var presenter: RecruitPresenter?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_more_data
    }

    init {
        mFragmentList?.add(RecruitFragment(1))
        mFragmentList?.add(RentFragment(2))
    }


    override fun initView() {
        super.initView()

        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)
        cus_page.adapter = mTabPageAdapter
        tv_screen_right.setOnClickListener(this)
        tv_screen_left.setOnClickListener(this)

        tv_screen_left.performClick()

        var bannerData: BannerData
        bannerData = BannerData()
        bannerData.img =
            "https://t9.baidu.com/it/u=2268908537,2815455140&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1601476836&t=43717528e86dbef35c5a6e035d0e8c55"

        mList?.add(bannerData)
        mList?.add(bannerData)

        banner.adapter = ImageAdapter(mList)
        banner.indicator = CircleIndicator(this)


        iv_back.setOnClickListener(this)
        tv_search.setOnClickListener(this)
        tv_map.setOnClickListener(this)

        tv_screen_left.text = "招聘1"
        tv_screen_right.text = "求职"
        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)

        app_bar.addOnOffsetChangedListener(this)

        spring_list.setType(SpringView.Type.FOLLOW)
        spring_list.setHeader(RefreshHeaderUtils.getHeaderView(this))

        spring_list.setListener(object : SpringView.OnFreshListener {
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


    override fun initPresenter() {

    }

    override fun showLoading() {

    }

    override fun hiedLoading() {

    }

    override fun showData(t: MutableList<StoreLeftBean>) {

    }

    private fun showView(index: Int) {
        cus_page.currentItem = index
        if (index == 0) {
            type = 1;
            tv_screen_left?.isSelected = true
            tv_screen_right?.isSelected = false
        } else {
            type = 2;
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
}
package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.fragment.RecruitFragment
import com.example.mechanicalapp.ui.fragment.RentFragment
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_more_data.*
import kotlinx.android.synthetic.main.layout_more_data_title.*

class MoreRecruitActivity : BaseActivity<NetData>() , View.OnClickListener {

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    var mList: MutableList<BannerData>? = ArrayList<BannerData>()
    var type :Int =1
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
        bannerData.img_path ="https://t9.baidu.com/it/u=2268908537,2815455140&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1601476836&t=43717528e86dbef35c5a6e035d0e8c55"

        mList?.add(bannerData)
        mList?.add(bannerData)

        banner.adapter = ImageAdapter(mList)
        banner.indicator = CircleIndicator(this)


        iv_back.setOnClickListener(this)
        tv_search.setOnClickListener(this)
        tv_map.setOnClickListener(this)

        tv_screen_left.text = "招聘1"
        tv_screen_right.text = "求职"
    }

    override fun initPresenter() {

    }

    override fun showLoading() {

    }

    override fun hiedLoading() {

    }

    override fun showData(t: NetData) {

    }

    private fun showView(index: Int) {
        cus_page.currentItem = index
        if (index == 0) {
            type =1;
            tv_screen_left?.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                0,
                R.drawable.tv_under_ine
            )
            tv_screen_right?.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        } else {
            type =2;
            tv_screen_left?.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            tv_screen_right?.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                0,
                R.drawable.tv_under_ine
            )
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_screen_left -> showView(0)
            R.id.tv_screen_right -> showView(1)
            R.id.iv_back -> finish()
            R.id.tv_search ->jumAct()

        }
    }
    private fun jumAct(){
        var bundle :Bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE,type)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }
}
package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.fragment.search.*
import kotlinx.android.synthetic.main.activity_search_all.*
import kotlinx.android.synthetic.main.layout_search_et.*

class SearchAllActivity:BaseCusActivity(),View.OnClickListener,ViewPager.OnPageChangeListener{
    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment> ()
    private var mTabPageAdapter: FragmentListPageAdapter?=null
    private var mTextViewList:MutableList<TextView>  =ArrayList<TextView>()

    override fun getLayoutId(): Int {

        return R.layout.activity_search_all
    }

    override fun initView() {
        super.initView()

        mTextViewList.add(tv_mec_rent)
        mTextViewList.add(tv_apparatus)
        mTextViewList.add(tv_parts)
        mTextViewList.add(tv_recruit)
        mTextViewList.add(tv_repair)


        mFragmentList?.add(SearchMecLeaseFragment())
        mFragmentList?.add(SearchMecDealFragment())
        mFragmentList?.add(SearchPartsFragment())
        mFragmentList?.add(SearchRecruitFragment())
        mFragmentList?.add(SearchFactoryFragment())


        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)
        cus_page.adapter=mTabPageAdapter

        tv_mec_rent.setOnClickListener(this)
        tv_apparatus.setOnClickListener(this)
        tv_parts.setOnClickListener(this)
        tv_recruit.setOnClickListener(this)
        tv_repair.setOnClickListener(this)
        iv_back.setOnClickListener(this)

        tv_mec_rent.performClick()

        cus_page.setTouchEvent(true)
        cus_page.offscreenPageLimit=5
        cus_page.addOnPageChangeListener(this)
    }

    override fun initPresenter() {
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.iv_back->finish()
            R.id.tv_mec_rent->showView(0)
            R.id.tv_apparatus->showView(1)
            R.id.tv_parts->showView(2)
            R.id.tv_recruit->showView(3)
            R.id.tv_repair->showView(4)
        }

    }

    private fun showView(index: Int) {
        cus_page.currentItem=index
        for (i in mTextViewList.indices){
            mTextViewList[i]?.isSelected = index ==i
        }

    }
    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        showView(position)
    }
}
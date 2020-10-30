package com.example.mechanicalapp.ui.fragment.search

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import kotlinx.android.synthetic.main.fragment_mec_leasing.*

class SearchRecruitFragment : BaseCusFragment() , View.OnClickListener, ViewPager.OnPageChangeListener  {
    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    private var mTextViewList: MutableList<TextView> = ArrayList<TextView>()

    init {
        mFragmentList?.add(SearchRecruit())
        mFragmentList?.add(SearchJobWant())
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_mec_leasing
    }

    override fun initView() {
        super.initView()

        tv_screen_left.text="招聘"
        tv_screen_right.text="求职"
        mTextViewList.add(tv_screen_left)
        mTextViewList.add(tv_screen_right)
        mTabPageAdapter = FragmentListPageAdapter(childFragmentManager,mFragmentList!!)

        cus_page.adapter = mTabPageAdapter


        tv_screen_left.setOnClickListener(this)
        tv_screen_right.setOnClickListener(this)

        tv_screen_left.performClick()


        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)
    }



    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_screen_left -> showView(0)
            R.id.tv_screen_right -> showView(1)
        }

    }


    private fun showView(index: Int) {
        cus_page.currentItem = index
        for (i in mTextViewList.indices) {
            mTextViewList[i]?.isSelected = index == i
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
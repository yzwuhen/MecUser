package com.example.mechanicalapp.ui.fragment

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment:BaseFragment<NetData>(),View.OnClickListener,ViewPager.OnPageChangeListener {
    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    private var mTextViewList: MutableList<TextView> = ArrayList<TextView>()
    override fun showLoading() {

    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_order
    }


    override fun initView() {
        super.initView()

        mFragmentList?.add(OrderListFragment(0))
        mFragmentList?.add(OrderListFragment(1))
        mFragmentList?.add(OrderListFragment(2))
        mFragmentList?.add(OrderListFragment(3))
        mFragmentList?.add(OrderListFragment(4))
        mFragmentList?.add(OrderListFragment(5))

        mTextViewList.add(tv_order1)
        mTextViewList.add(tv_order2)
        mTextViewList.add(tv_order3)
        mTextViewList.add(tv_order4)
        mTextViewList.add(tv_order5)
        mTextViewList.add(tv_order6)
        mTabPageAdapter = FragmentListPageAdapter(childFragmentManager,mFragmentList!!)

        cus_page.adapter = mTabPageAdapter


        tv_order1.setOnClickListener(this)
        tv_order2.setOnClickListener(this)
        tv_order3.setOnClickListener(this)
        tv_order4.setOnClickListener(this)
        tv_order5.setOnClickListener(this)
        tv_order6.setOnClickListener(this)


        tv_order1.performClick()
        cus_page.offscreenPageLimit =6
        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)
    }
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_order1 -> showView(0)
            R.id.tv_order2 -> showView(1)
            R.id.tv_order3 -> showView(2)
            R.id.tv_order4 -> showView(3)
            R.id.tv_order5 -> showView(4)
            R.id.tv_order6 -> showView(5)
        }

    }

    private fun showView(index: Int) {
        cus_page.currentItem = index
        for (i in mTextViewList.indices) {
            mTextViewList[i]?.isSelected = index == i
        }

    }
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        showView(position)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun err() {


    }
}
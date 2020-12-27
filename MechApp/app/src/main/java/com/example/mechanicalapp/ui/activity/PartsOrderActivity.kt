package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.fragment.PartsOrderAfterSaleFragment
import com.example.mechanicalapp.ui.fragment.PartsOrderFragment
import kotlinx.android.synthetic.main.activity_parts_order.*
import kotlinx.android.synthetic.main.layout_title.*

class PartsOrderActivity:BaseActivity<NetData>(),View.OnClickListener ,ViewPager.OnPageChangeListener{
    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    private var mTextViewList: MutableList<TextView> = ArrayList<TextView>()
    override fun getLayoutId(): Int {
        return R.layout.activity_parts_order
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "配件订单"
        mFragmentList?.add(PartsOrderFragment(0))
        mFragmentList?.add(PartsOrderFragment(1))
        mFragmentList?.add(PartsOrderFragment(2))
        mFragmentList?.add(PartsOrderFragment(3))
        mFragmentList?.add(PartsOrderAfterSaleFragment())

        mTextViewList.add(tv_order1)
        mTextViewList.add(tv_order2)
        mTextViewList.add(tv_order3)
        mTextViewList.add(tv_order4)
        mTextViewList.add(tv_order5)
        mTabPageAdapter = FragmentListPageAdapter(supportFragmentManager,mFragmentList!!)

        cus_page.adapter = mTabPageAdapter


        tv_order1.setOnClickListener(this)
        tv_order2.setOnClickListener(this)
        tv_order3.setOnClickListener(this)
        tv_order4.setOnClickListener(this)
        tv_order5.setOnClickListener(this)


        tv_order1.performClick()

      //  cus_page.offscreenPageLimit =5
        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.iv_back->finish()
            R.id.tv_order1 -> showView(0)
            R.id.tv_order2 -> showView(1)
            R.id.tv_order3 -> showView(2)
            R.id.tv_order4 -> showView(3)
            R.id.tv_order5 -> showView(4)
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
}
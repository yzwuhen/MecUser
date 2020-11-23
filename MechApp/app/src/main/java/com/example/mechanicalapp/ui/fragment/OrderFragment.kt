package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.adapter.OrderTitleAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.CodeBean
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.mvp.impl.OrderPresenter
import com.example.mechanicalapp.ui.mvp.v.OrderView
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : BaseCusFragment(), ViewPager.OnPageChangeListener, OnItemClickListener,
    OrderView<CodeBean> {
    private var mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    private var mList = ArrayList<CodeData>()
    private var mAdapter: OrderTitleAdapter? = null

    override fun showLoading() {

    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_order
    }


    override fun initView() {
        super.initView()

        mAdapter = OrderTitleAdapter(mContext, mList, this)

        var linearLayoutManager = GridLayoutManager(mContext,6)
     //   linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycle_list.layoutManager =linearLayoutManager
        recycle_list.adapter = mAdapter

        mPresenter = OrderPresenter(this)
        (mPresenter as OrderPresenter).getOrderTv()

    }

    private fun showView(index: Int) {
        cus_page.currentItem = index
        for (i in mList.indices) {
            mList[i]?.isSelect = index == i
        }
        mAdapter?.notifyDataSetChanged()
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

    override fun showData(data: CodeBean?) {
        if (data?.code == 200 && data?.result.isNotEmpty()) {
            mList.clear()
            var codeData =CodeData()
            codeData.itemText="全部"
            codeData.itemValue =""
            mList.add(codeData)
            mList.addAll(data?.result)
            mAdapter?.notifyDataSetChanged()
            addFragmentView()
        }
    }

    private fun addFragmentView() {
        mFragmentList?.clear()
        for (code in mList.iterator()) {
            mFragmentList?.add(OrderListFragment(code.itemValue))
        }
        mTabPageAdapter = FragmentListPageAdapter(childFragmentManager, mFragmentList!!)
        cus_page.adapter = mTabPageAdapter

        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)
        cus_page.offscreenPageLimit = mList.size
        showView(0)
    }

    override fun showDataMore(data: CodeBean?) {
    }

    override fun onItemClick(view: View, position: Int) {
        showView(position)
    }
}
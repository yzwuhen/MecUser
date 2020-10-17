package com.example.mechanicalapp.ui.fragment.myrelease

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.fragment_mec_leasing.*

class MyReleaseLease () : BaseFragment<NetData>(), View.OnClickListener {
    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    private var mTextViewList: MutableList<TextView> = ArrayList<TextView>()

    init {
        mFragmentList?.add(ReleaseLeaseFragment(0))
        mFragmentList?.add(MyReleaseAsk(0))
    }

    override fun showLoading() {


    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mec_leasing
    }

    override fun initView() {
        super.initView()
        mTextViewList.add(tv_screen_left)
        mTextViewList.add(tv_screen_right)
        mTabPageAdapter = FragmentListPageAdapter(childFragmentManager,mFragmentList!!)

        cus_page.adapter = mTabPageAdapter


        tv_screen_left.setOnClickListener(this)
        tv_screen_right.setOnClickListener(this)

        tv_screen_left.performClick()
    }

    override fun showData(t: NetData?) {
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
}
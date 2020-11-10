package com.example.mechanicalapp.ui.fragment.myrelease

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.fragment_mec_leasing.*
import kotlinx.android.synthetic.main.fragment_mec_leasing.cus_page

class MyReleaseSecondFragment : BaseFragment<NetData>(), View.OnClickListener ,ViewPager.OnPageChangeListener{
    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    private var mTextViewList: MutableList<TextView> = ArrayList<TextView>()

    init {
        mFragmentList?.add(ReleaseLeaseFragment(1))
        mFragmentList?.add(MyReleaseAsk(1))
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

        tv_screen_left.text ="出售"
        tv_screen_right.text ="求购"
        tv_screen_left.setOnClickListener(this)
        tv_screen_right.setOnClickListener(this)

        tv_screen_left.performClick()

        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)
    }

    override fun err()  {
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
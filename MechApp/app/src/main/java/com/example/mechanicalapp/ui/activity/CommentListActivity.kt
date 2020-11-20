package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.layout_title.*

class CommentListActivity : BaseActivity<NetData>() ,View.OnClickListener , ViewPager.OnPageChangeListener{

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment> ()
    private var mTabPageAdapter: FragmentListPageAdapter?=null
    private var mTextViewList:MutableList<TextView>  =ArrayList<TextView>()
    override fun getLayoutId(): Int {

        return R.layout.activity_comment

    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "全部评价"

        tv_comment1.setOnClickListener(this)
        tv_comment2.setOnClickListener(this)
        tv_comment3.setOnClickListener(this)
        tv_comment4.setOnClickListener(this)

        mTextViewList.add(tv_comment1)
        mTextViewList.add(tv_comment2)
        mTextViewList.add(tv_comment3)
        mTextViewList.add(tv_comment4)
        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)
        cus_page.adapter=mTabPageAdapter

        tv_comment1.performClick()

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

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
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
package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.fragment.EngineerFragment
import com.example.mechanicalapp.ui.fragment.OrderFragment
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.layout_search_tv.*

class OrderCenterActivity:BaseActivity<NetData>() ,View.OnClickListener,ViewPager.OnPageChangeListener{

    private var type:Int=0
    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment> ()
    private var mTabPageAdapter: FragmentListPageAdapter?=null
    private var mTextViewList:MutableList<TextView>  =ArrayList<TextView>()

    private var index=0
    override fun getLayoutId(): Int {

        return R.layout.activity_order
    }

    override fun initView() {
        super.initView()
        index =intent.getIntExtra("index",0)
        mTextViewList.add(tv_repair)
        mTextViewList.add(tv_engineer)

        iv_back.setOnClickListener(this)

        var bundle =Bundle()
        bundle.putInt("index",index)
        mFragmentList?.add(OrderFragment.getInstance(bundle))
        mFragmentList?.add(EngineerFragment.getInstance())

        mTabPageAdapter = FragmentListPageAdapter(supportFragmentManager, mFragmentList!!)
        cus_page.adapter=mTabPageAdapter



        ly_search.setOnClickListener(this)
        tv_repair.setOnClickListener(this)
        tv_engineer.setOnClickListener(this)
        tv_repair.performClick()
        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)

    }
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.iv_back->finish()
            R.id.ly_search->jump()
            R.id.tv_repair->showView(0)
            R.id.tv_engineer->showView(1)

        }

    }
    private fun jump() {

        var bundle = Bundle()
        if (type==0){
            bundle.putInt(Configs.HISTORY_TYPE,8)
        }else{
            bundle.putInt(Configs.HISTORY_TYPE,9)
        }

        jumpActivity(bundle, HistorySearchActivity::class.java)
    }

    private fun showView(index: Int) {

        type= index;
        cus_page.currentItem=index
        for (i in mTextViewList.indices){
            mTextViewList[i]?.isSelected = index ==i
        }

    }
    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        showView(position)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

}
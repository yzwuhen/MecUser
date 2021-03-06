package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.fragment.look.*
import kotlinx.android.synthetic.main.activity_my_collected.*
import kotlinx.android.synthetic.main.layout_left_right_title.*


class MyLookActivity : BaseActivity<NetData>(), View.OnClickListener ,ViewPager.OnPageChangeListener{

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment> ()
    private var mTabPageAdapter: FragmentListPageAdapter?=null
    private var mTextViewList:MutableList<TextView>  =ArrayList<TextView>()


    override fun getLayoutId(): Int {

        return R.layout.activity_my_collected
    }
    init {
        mFragmentList?.add(LookLeasingFragment())
        mFragmentList?.add(LookSecondHand())
        mFragmentList?.add(LookPartsFratment())
        mFragmentList?.add(LookRecruitFragment())
        mFragmentList?.add(LookFactoryFragment())
        mFragmentList?.add(LookGoodsFragment())
    }
    override fun initView() {
        super.initView()
        tv_title.text ="我最近查看过的"
        iv_right.visibility =View.GONE



        mTextViewList.add(tv_mec_rent)
        mTextViewList.add(tv_apparatus)
        mTextViewList.add(tv_parts)
        mTextViewList.add(tv_recruit)
        mTextViewList.add(tv_repair)
        mTextViewList.add(tv_goods)
        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)
        cus_page.adapter=mTabPageAdapter

        tv_mec_rent.setOnClickListener(this)
        tv_apparatus.setOnClickListener(this)
        tv_parts.setOnClickListener(this)
        tv_recruit.setOnClickListener(this)
        tv_repair.setOnClickListener(this)
        tv_goods.setOnClickListener(this)
        iv_left.setOnClickListener(this)

        tv_mec_rent.performClick()
        cus_page.offscreenPageLimit=6
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
        when(p0?.id){
            R.id.iv_left->finish()
            R.id.tv_mec_rent->showView(0)
            R.id.tv_apparatus->showView(1)
            R.id.tv_parts->showView(2)
            R.id.tv_recruit->showView(3)
            R.id.tv_repair->showView(4)
            R.id.tv_goods->showView(5)
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
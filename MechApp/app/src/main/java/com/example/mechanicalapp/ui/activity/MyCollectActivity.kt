package com.example.mechanicalapp.ui.activity

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.data.java.EventFresh
import com.example.mechanicalapp.ui.fragment.collect.*
import kotlinx.android.synthetic.main.activity_my_collected.*
import kotlinx.android.synthetic.main.layout_left_right_title.*
import org.greenrobot.eventbus.EventBus

class MyCollectActivity:BaseActivity<NetData>(),View.OnClickListener, ViewPager.OnPageChangeListener {

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment> ()
    private var mTabPageAdapter: FragmentListPageAdapter?=null
    private var mTextViewList:MutableList<TextView>  =ArrayList<TextView>()

    private var position:Int=0
    private var isShow:Boolean=false

    override fun getLayoutId(): Int {

        return R.layout.activity_my_collected
    }
    init {
        mFragmentList?.add(MecCollectLeasingFragment(1))
        mFragmentList?.add(CollectSecondHandFragment())
        mFragmentList?.add(CollectPartsFragment())
        mFragmentList?.add(CollectRecruitFragment())
        mFragmentList?.add(CollectFactoryFragment())
        mFragmentList?.add(CollectGoodsFragment())
    }
    override fun initView() {
        super.initView()
        tv_title.text ="我的收藏"
        iv_right.visibility =View.GONE
        tv_right.visibility = View.VISIBLE
        tv_right.text ="编辑"

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
        tv_right.setOnClickListener(this)
        iv_left.setOnClickListener(this)

        tv_mec_rent.performClick()

        cus_page.setTouchEvent(true)
        cus_page.offscreenPageLimit=6
        cus_page.addOnPageChangeListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.iv_left->finish()
            R.id.tv_right->edit()
            R.id.tv_mec_rent->showView(0)
            R.id.tv_apparatus->showView(1)
            R.id.tv_parts->showView(2)
            R.id.tv_recruit->showView(3)
            R.id.tv_repair->showView(4)
            R.id.tv_goods->showView(5)
        }

    }

    private fun showView(index: Int) {

        position = index
        cus_page.currentItem=index
        for (i in mTextViewList.indices){
            mTextViewList[i]?.isSelected = index ==i
        }

    }

    private fun edit() {

       var mEventFresh:EventFresh = EventFresh()
        mEventFresh.isShowCheck =!isShow
        isShow =!isShow
        if (isShow){
            tv_right.text ="完成"
        }else{
            tv_right.text ="编辑"
        }

        Log.v("sssssss","ssssssssssssssss$mEventFresh.isShowCheck")
        EventBus.getDefault().post(mEventFresh)
    }
    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        showView(position)
    }
}
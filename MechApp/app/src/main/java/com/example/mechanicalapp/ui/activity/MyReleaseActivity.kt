package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.fragment.myrelease.MyReleaseGoodsFragment
import com.example.mechanicalapp.ui.fragment.myrelease.MyReleaseLease
import com.example.mechanicalapp.ui.fragment.myrelease.MyReleaseRecruitFragment
import com.example.mechanicalapp.ui.fragment.myrelease.MyReleaseSecondFragment
import kotlinx.android.synthetic.main.activity_my_release.*
import kotlinx.android.synthetic.main.layout_title.*

class MyReleaseActivity:BaseActivity<NetData>(), View.OnClickListener {

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment> ()
    private var mTabPageAdapter: FragmentListPageAdapter?=null
    private var mTextViewList:MutableList<TextView>  =ArrayList<TextView>()

    private var position:Int=0

    override fun getLayoutId(): Int {

        return R.layout.activity_my_release
    }
    init {
        mFragmentList?.add(MyReleaseLease())
        mFragmentList?.add(MyReleaseSecondFragment())
        mFragmentList?.add(MyReleaseGoodsFragment())
        mFragmentList?.add(MyReleaseRecruitFragment())
    }
    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "我的发布"


        mTextViewList.add(tv_mec_rent)
        mTextViewList.add(tv_apparatus)
        mTextViewList.add(tv_parts)
        mTextViewList.add(tv_recruit)

        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)
        cus_page.adapter=mTabPageAdapter

        tv_mec_rent.setOnClickListener(this)
        tv_apparatus.setOnClickListener(this)
        tv_parts.setOnClickListener(this)
        tv_recruit.setOnClickListener(this)

        tv_mec_rent.performClick()
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.iv_back->finish()
            R.id.tv_mec_rent->showView(0)
            R.id.tv_apparatus->showView(1)
            R.id.tv_parts->showView(2)
            R.id.tv_recruit->showView(3)
        }

    }

    private fun showView(index: Int) {

        position = index
        cus_page.currentItem=index
        for (i in mTextViewList.indices){
            if (index ==i){
                mTextViewList[index]?.setCompoundDrawablesWithIntrinsicBounds(0,0,0, R.drawable.tv_under_ine)
            }else{
                mTextViewList[i]?.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            }
        }

    }

}
package com.example.mechanicalapp.ui.activity

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.java.EventFresh
import com.example.mechanicalapp.ui.fragment.collect.*
import kotlinx.android.synthetic.main.activity_more_data.cus_page
import kotlinx.android.synthetic.main.activity_my_collected.*
import kotlinx.android.synthetic.main.layout_left_right_title.*
import org.greenrobot.eventbus.EventBus

class MyCollectActivity:BaseActivity<NetData>(),View.OnClickListener {

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
        mFragmentList?.add(CollectGoodsFragment())
        mFragmentList?.add(CollectRecruitFragment())
        mFragmentList?.add(CollectFactoryFragment())
    }
    override fun initView() {
        super.initView()
        tv_title.text ="我的收藏"
        tv_right.visibility = View.VISIBLE
        iv_right.visibility = View.GONE
        tv_right.text ="编辑"


        mTextViewList.add(tv_mec_rent)
        mTextViewList.add(tv_apparatus)
        mTextViewList.add(tv_parts)
        mTextViewList.add(tv_recruit)
        mTextViewList.add(tv_repair)

        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)
        cus_page.adapter=mTabPageAdapter

        tv_mec_rent.setOnClickListener(this)
        tv_apparatus.setOnClickListener(this)
        tv_parts.setOnClickListener(this)
        tv_recruit.setOnClickListener(this)
        tv_repair.setOnClickListener(this)
        tv_right.setOnClickListener(this)
        iv_left.setOnClickListener(this)

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
            R.id.iv_left->finish()
            R.id.tv_right->edit()
            R.id.tv_mec_rent->showView(0)
            R.id.tv_apparatus->showView(1)
            R.id.tv_parts->showView(2)
            R.id.tv_recruit->showView(3)
            R.id.tv_repair->showView(4)
        }

    }

    private fun showView(index: Int) {

        position = index
        cus_page.currentItem=index
        for (i in mTextViewList.indices){
            if (index ==i){
                mTextViewList[index]?.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.tv_under_ine)
            }else{
                mTextViewList[i]?.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            }
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
}
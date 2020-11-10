package com.example.mechanicalapp.ui.activity

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.*
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.fragment.collect.*
import kotlinx.android.synthetic.main.activity_user_home_page.*
import kotlinx.android.synthetic.main.layout_title.*

/**
 * 个人主页 由详情跳转进入
 */
class UserHomePage : BaseActivity<NetData>(), View.OnClickListener {

    private var type: Int = 0
    private var mIndex: Int = 0
    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    private var mTextViewList: MutableList<TextView> = ArrayList<TextView>()

    override fun getLayoutId(): Int {
        return R.layout.activity_user_home_page
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "个人主页"


        type = intent.getIntExtra(Configs.USER_HOME_PAGE, 0)
        mIndex = intent.getIntExtra(Configs.USER_HOME_PAGE_Index, 0)

        if (type == 0) {
            mFragmentList?.add(MecCollectLeaseFragment(1))
            mFragmentList?.add(MecCollectAskRent(1))
            tv_screen_left.text = "出售"
            tv_screen_right.text = "求购"
        } else if (type == 1) {
            mFragmentList?.add(MecCollectLeaseFragment(2))
            mFragmentList?.add(MecCollectAskRent(2))
            tv_screen_left.text = "出租"
            tv_screen_right.text = "求租"
        } else if (type == 2) {
            mFragmentList?.add(CollectRecruit())
            mFragmentList?.add(CollectJobWant())
            tv_screen_left.text = "招聘"
            tv_screen_right.text = "求职"
        } else if (type == 3) {
            mFragmentList?.add(CollectPartsLease())
            mFragmentList?.add(CollectAskRent())
            tv_screen_left.text = "出租"
            tv_screen_right.text = "求租"
        }


        mTextViewList.add(tv_screen_left)
        mTextViewList.add(tv_screen_right)
        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)

        cus_page.adapter = mTabPageAdapter


        ly_screen_left.setOnClickListener(this)
        ly_screen_right.setOnClickListener(this)

        if (mIndex==0){
            ly_screen_left.performClick()
        }else{
            ly_screen_right.performClick()
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

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.ly_screen_left -> showView(0)
            R.id.ly_screen_right -> showView(1)
        }
    }

    private fun showView(index: Int) {
        Log.e("sssssssssss","sssssssssssssssssssssss===$index");
        cus_page.currentItem = index
        for (i in mTextViewList.indices) {
            if (index == i){
                mTextViewList[i]?.isSelected = true
                mTextViewList[i]?.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.tv_under_ine)
            }else{
                mTextViewList[i]?.isSelected = false
                mTextViewList[i]?.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            }

        }

    }
}
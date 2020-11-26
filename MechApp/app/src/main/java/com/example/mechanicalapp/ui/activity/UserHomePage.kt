package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.UserInfoBean
import com.example.mechanicalapp.ui.fragment.collect.*
import com.example.mechanicalapp.ui.fragment.user.*
import com.example.mechanicalapp.ui.mvp.impl.UserInfoPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_more_data.*
import kotlinx.android.synthetic.main.activity_user_home_page.*
import kotlinx.android.synthetic.main.activity_user_home_page.app_bar
import kotlinx.android.synthetic.main.activity_user_home_page.cus_page
import kotlinx.android.synthetic.main.activity_user_home_page.tv_screen_left
import kotlinx.android.synthetic.main.activity_user_home_page.tv_screen_right
import kotlinx.android.synthetic.main.layout_title.*

/**
 * 个人主页 由详情跳转进入
 */
class UserHomePage : BaseCusActivity(), View.OnClickListener , ViewPager.OnPageChangeListener,
    AppBarLayout.OnOffsetChangedListener,NetDataView<UserInfoBean>{

    private var user:String=""
    private var type: Int = 0
    private var mIndex: Int = 0
    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    private var mTextViewList: MutableList<TextView> = ArrayList<TextView>()

    private var mPresenter:UserInfoPresenter?=null

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
        user = intent.getStringExtra(Configs.USER_HOME_PAGE_NAME).toString()
        if (type == 2) {
            mFragmentList?.add(UserMecSellFragment(user,type))
            mFragmentList?.add(UserMecBuyFragment(user,type))
            tv_screen_left.text = "出售"
            tv_screen_right.text = "求购"
        } else if (type == 3) {
            mFragmentList?.add(UserMecLeaseFragment(user,type))
            mFragmentList?.add(UserMecRentFragment(user,type))
            tv_screen_left.text = "出租"
            tv_screen_right.text = "求租"
        } else if (type == 4) {
            mFragmentList?.add(UserRecruitFragment(user,type))
            mFragmentList?.add(UserJobWantFragment(user,type))
            tv_screen_left.text = "招聘"
            tv_screen_right.text = "求职"
        } else if (type == 1) {
            mFragmentList?.add(UserPartsLeaseFragment(user,type))
            mFragmentList?.add(UserPartsPartsAskFragment(user,type))
            tv_screen_left.text = "出租"
            tv_screen_right.text = "求租"
        }


        mTextViewList.add(tv_screen_left)
        mTextViewList.add(tv_screen_right)
        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)

        cus_page.adapter = mTabPageAdapter

        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)
        app_bar.addOnOffsetChangedListener(this)


        ly_screen_left.setOnClickListener(this)
        ly_screen_right.setOnClickListener(this)

        if (mIndex==0){
            ly_screen_left.performClick()
        }else{
            ly_screen_right.performClick()
        }

    }

    override fun initPresenter() {
        mPresenter = UserInfoPresenter(this)
        mPresenter?.getUserLease(user,type)
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
    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {

        spring_list.isEnable = p1 == 0
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        showView(position)
    }
    private fun showView(index: Int) {
        cus_page.currentItem = index
        for (i in mTextViewList.indices) {
            mTextViewList[i]?.isSelected = index == i

        }

    }

    override fun refreshUI(data: UserInfoBean?) {

        if (data!=null&&data.result!=null){
            tv_num1.text="(${data.result.mecMarketMechanicsNum})"
            tv_num2.text="(${data.result.mecMarketOldMechanicsNum})"
            tv_num3.text="(${data.result.mecMarketRedcruitNum})"
            tv_num4.text="(${data.result.mecMarketPartsNum})"

            ImageLoadUtils.loadCircle(this,iv_user_pic,data.result.avatar)

            tv_company.text =data.result.companyName
            tv_user_name.text =data.result.userName
            if (data.result.isPerson=="1"){
                iv_ser.visibility =View.VISIBLE
            }else{
                iv_ser.visibility =View.GONE
            }
        }

    }

    override fun loadMore(data: UserInfoBean?) {
    }
}
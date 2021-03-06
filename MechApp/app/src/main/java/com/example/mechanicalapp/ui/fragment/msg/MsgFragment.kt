package com.example.mechanicalapp.ui.fragment.msg

import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.activity.BlackListActivity
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.data.UserInfo
import com.example.mechanicalapp.ui.fragment.ChatEnFragment
import com.example.mechanicalapp.ui.fragment.ChatMsgFragment
import com.example.mechanicalapp.ui.fragment.ChatSysFragment
import com.example.mechanicalapp.ui.mvp.impl.UserInfoPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.mvp.v.UserView
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.fragment_msg.*

class MsgFragment:BaseCusFragment() ,View.OnClickListener,PopUtils.onViewListener, ViewPager.OnPageChangeListener,
    UserView {

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment> ()
    private var mTabPageAdapter: FragmentListPageAdapter?=null


    private var tvPopTip:TextView ?=null
    private var tvPopCancle:TextView ?=null
    private var tvPopSure :TextView?=null
    private var mPopwindow:PopupWindow?=null

    private var userInfo: UserInfo?=null
    override fun getLayoutId(): Int {

        return R.layout.fragment_msg
    }

    init {
        //   mFragmentList?.add(ConversationFragment())
       mFragmentList?.add(ChatMsgFragment())
        mFragmentList?.add(ChatEnFragment())
        mFragmentList?.add(ChatSysFragment())
    }
    override fun initView() {
        super.initView()

        mTabPageAdapter =
            activity?.supportFragmentManager?.let { FragmentListPageAdapter(it, mFragmentList!!) }
        cus_page.adapter=mTabPageAdapter

        ly_chat_msg.setOnClickListener(this)
        ly_eng_msg.setOnClickListener(this)
        ly_sys_msg.setOnClickListener(this)
        ly_right.setOnClickListener(this)
        iv_left.setOnClickListener(this)

        ly_chat_msg.performClick()

        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)

        userInfo = App.getInstance().userInfo

        mPresenter = UserInfoPresenter(mContext,this)
        privacyStatus()
    }
    override fun onClick(view: View?) {

        when(view?.id){
            R.id.ly_chat_msg->showPage(0)
            R.id.ly_eng_msg->showPage(1)
            R.id.ly_sys_msg->showPage(2)
            R.id.iv_left->jumpActivity(null,BlackListActivity::class.java)
            R.id.ly_right ->showTip()
            R.id.tv_pop_sure->{
                PopUtils.dismissPop(activity!!,mPopwindow!!)
                if (userInfo?.isPrivacy=="1"){
                    userInfo?.isPrivacy="0"
                }else{
                    userInfo?.isPrivacy="1"
                }
                (mPresenter as UserInfoPresenter).editUserInfo(userInfo)
                privacyStatus()
            }
            R.id.tv_pop_cancel->{
              PopUtils.dismissPop(activity!!,mPopwindow!!)
            }
        }

    }
    private fun privacyStatus(){

        iv_privacy.isSelected = userInfo?.isPrivacy=="1"
    }

    private fun showTip() {

        if (mPopwindow ==null){
            mPopwindow =  activity?.let {
                PopUtils.init(mContext,
                    it,R.layout.pop_privacy_tip,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,true,this)
            }
        }
        activity?.let { PopUtils.showPopupWindow(tv_right, it) }

        if (userInfo?.isPrivacy!="1"){
            tvPopCancle?.visibility =View.VISIBLE
            tvPopTip?.text ="您发帖中的联系电话对方将无法获取 只能通过在线聊天跟您联系！"
        }else{
            tvPopCancle?.visibility =View.GONE
            tvPopTip?.text ="由于对方隐私设置，暂时无法获取号码 您可以通过在线聊天沟通。"
        }
    }

    private fun showPage(position: Int) {

        cus_page.currentItem=position

        tv_chat_msg.isSelected = position==0
        tv_eng_msg.isSelected = position==1
        tv_sys_msg.isSelected = position==2
        if (position!=2){
            ly_right.visibility =View.VISIBLE
        }else{
            ly_right.visibility =View.GONE
        }
    }

    override fun getView(view: View?) {


        tvPopTip = view?.findViewById(R.id.tv_pop_tip)
        tvPopCancle = view?.findViewById(R.id.tv_pop_cancel)
        tvPopSure =view?.findViewById(R.id.tv_pop_sure)

        tvPopCancle?.setOnClickListener(this)
        tvPopSure?.setOnClickListener(this)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {


    }

    override fun onPageSelected(position: Int) {
        showPage(position)
    }

    override fun onPageScrollStateChanged(state: Int) {
    }


    override fun success(netData: NetData?) {

    }

    override fun showImg(netData: NetData?) {
    }

    override fun uploadFail(str: String) {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

}
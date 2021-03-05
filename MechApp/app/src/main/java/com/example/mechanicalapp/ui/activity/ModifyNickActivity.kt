package com.example.mechanicalapp.ui.activity

import android.text.TextUtils
import android.view.View
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.UserInfoPresenter
import com.example.mechanicalapp.ui.mvp.v.UserView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_modify_nick.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class ModifyNickActivity: BaseCusActivity() ,View.OnClickListener, UserView {

    private var mPresenter: UserInfoPresenter?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_modify_nick
    }

    override fun initView() {
        super.initView()
        iv_right.visibility = View.GONE
        tv_right.visibility =View.VISIBLE
        tv_right.text = "保存"
        tv_title.text="修改昵称"

        iv_left.setOnClickListener(this)
        ly_right.setOnClickListener(this)
        iv_del.setOnClickListener(this)

        et_nick.setText(App.getInstance().userInfo.realname)

    }

    override fun initPresenter() {

        mPresenter = UserInfoPresenter(this,this)
    }

    override fun success(netData: NetData?) {

        if (netData?.code==200){
            finish()
        }
        ToastUtils.showText(netData?.message)
    }

    override fun showImg(netData: NetData?) {

    }

    override fun uploadFail(str: String) {
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err()  {
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.iv_left->finish()
            R.id.ly_right ->keep()
            R.id.iv_del ->clearEt()
        }

    }

    private fun clearEt() {

        et_nick.text =null
    }

    private fun keep() {
        if (TextUtils.isEmpty(et_nick.text.toString())){
            ToastUtils.showText("请输入修改的昵称")
            return
        }
        App.getInstance().userInfo.realname =et_nick.text.toString()
        mPresenter?.editUserInfo(App.getInstance().userInfo)
        mPresenter?.upImNick(App.getInstance().userInfo.realname )
    }
}
package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.view.SidleView
import kotlinx.android.synthetic.main.activity_find_pwd.*
import kotlinx.android.synthetic.main.layout_title.*

class FindPwdActivity:BaseActivity<NetData>(),View.OnClickListener ,SidleView.SidleOutListener{
    override fun initPresenter() {

    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun getLayoutId(): Int {


        return R.layout.activity_find_pwd
    }

    override fun initView() {
        super.initView()

        tv_title.text = "找回密码"
        iv_back.setOnClickListener(this)
        tv_get_code.setOnClickListener(this)

        sidle_view.addSidleListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_get_code->getCodes()
        }
    }

    private fun getCodes() {


    }

    override fun isSidleOut() {

        jumpActivity(null,SettingActivity::class.java)
    }
}
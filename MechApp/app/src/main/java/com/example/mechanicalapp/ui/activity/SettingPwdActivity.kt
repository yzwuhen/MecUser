package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.layout_title.*

class SettingPwdActivity : BaseActivity<NetData>(), View.OnClickListener {
    override fun getLayoutId(): Int {


        return R.layout.activity_setting_pwd
    }

    override fun initView() {
        super.initView()
        tv_title.text = "找回密码"
        iv_back.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
        }
    }
}
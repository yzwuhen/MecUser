package com.example.mechanicalapp.ui.activity

import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData

class FindPwdActivity:BaseActivity<NetData>() {
    override fun initPresenter() {

    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun getLayoutId(): Int {


        return R.layout.activity_find_pwd
    }
}
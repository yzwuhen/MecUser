package com.example.mechanicalapp.ui.activity

import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean

class BlackListSettActivity:BaseActivity<NetData>() {
    override fun getLayoutId(): Int {


        return R.layout.activity_black_list_set
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }
}
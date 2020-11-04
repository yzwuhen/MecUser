package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.layout_search_title.*

class CloudBoxActivity :BaseActivity<NetData>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_cloud_box
    }

    override fun initView() {
        super.initView()

        iv_back.setOnClickListener(View.OnClickListener { finish() })
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }
}
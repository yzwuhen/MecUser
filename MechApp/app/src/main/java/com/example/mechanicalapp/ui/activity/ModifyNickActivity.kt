package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_modify_nick.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class ModifyNickActivity:BaseActivity<NetData>() ,View.OnClickListener{
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
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
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


    }
}
package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.layout_title.*

class AddressActivity:BaseActivity<NetData>() ,View.OnClickListener{
    override fun getLayoutId(): Int {

        return R.layout.activity_address
    }

    override fun initView() {
        super.initView()


        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        var type =intent.getIntExtra("address_type",0)
        if (type==0){
            tv_title.text = "添加地址"
        }else{
            tv_title.text = "编辑地址"
        }

    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_btn->submit()
        }
    }

    private fun submit() {


    }
}
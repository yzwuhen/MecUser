package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_modify_phone_get_code.*
import kotlinx.android.synthetic.main.layout_title.*

class ModifyPhoneGetCodeActivity:BaseActivity<NetData>() ,View.OnClickListener{
    override fun getLayoutId(): Int {

        return R.layout.activity_modify_phone_get_code
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text ="更改手机号"
        tv_next.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_next->jumpActivity(null,ModifyPhoneActivity::class.java)
        }
    }
}
package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_my_intergral.*
import kotlinx.android.synthetic.main.layout_title.*

class MyIntegralActivity : BaseActivity<NetData>(), View.OnClickListener {
    override fun getLayoutId(): Int {
        return R.layout.activity_my_intergral
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "我的积分"
        tv_sign.setOnClickListener(this)
        ly_integral.setOnClickListener(this)
        ly_integral_rule.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.iv_back -> finish()
            R.id.ly_integral -> jumpActivity(null, IntegralInfoActivity::class.java)
            R.id.ly_integral_rule -> jumpActivity(null, IntegralRuleActivity::class.java)
        }
    }
}
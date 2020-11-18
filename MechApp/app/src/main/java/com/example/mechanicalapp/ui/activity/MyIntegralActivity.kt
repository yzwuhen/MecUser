package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.IntegralBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.IntegralPresenter
import com.example.mechanicalapp.ui.mvp.v.IntegralView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_my_intergral.*
import kotlinx.android.synthetic.main.layout_title.*

class MyIntegralActivity : BaseCusActivity(), View.OnClickListener,IntegralView<IntegralBean> {


    private var mPresenter: IntegralPresenter?=null

    private var point:Int=0
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

        mPresenter = IntegralPresenter(this)
        mPresenter?.getIntegral()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.iv_back -> finish()
            R.id.tv_sign->signData()
            R.id.ly_integral -> {
                var bundle = Bundle()
                bundle.putInt("key",point)
                jumpActivity(bundle, IntegralInfoActivity::class.java)
            }
            R.id.ly_integral_rule -> jumpActivity(null, IntegralRuleActivity::class.java)
        }
    }

    private fun signData() {
        mPresenter?.sign()

    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err()  {
    }
    override fun showData(t: IntegralBean?) {
        if (t?.code==200&&t?.result!=null){
            point =t?.result.points
            tv_integral.text= t?.result.points.toString()
            tv_sign_day.text ="已连续签到${t.result.signInDay}天"
            if (t.result.isSignIn==0){
                tv_sign.text ="签到"
            }else{
                tv_sign.text="已签到"
                tv_sign.isEnabled= false
            }
        }
    }

    override fun showDataMore(t: IntegralBean?) {

    }

    override fun success(netData: NetData?) {
        ToastUtils.showText(netData?.message)
        if (netData?.code==200){
            tv_sign.text="已签到"
            tv_sign.isEnabled= false
        }
    }
}
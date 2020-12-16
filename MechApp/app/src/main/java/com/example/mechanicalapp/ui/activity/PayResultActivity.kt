package com.example.mechanicalapp.ui.activity

import android.graphics.Color
import android.view.View
import com.example.mechanicalapp.MainActivity
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_pay_result.*
import kotlinx.android.synthetic.main.layout_title.*

class PayResultActivity :BaseActivity<NetData>() ,View.OnClickListener{
    private var type=0
    override fun getLayoutId(): Int {

        return R.layout.activity_pay_result
    }

    override fun initView() {
        super.initView()
        type =intent.getIntExtra("type",0)
        tv_title.text ="支付结果"
        rl_title.setBackgroundColor(Color.parseColor("#FFB923"))
        if (type==0){
            tv_pay_tip.isSelected =true
            tv_pay_tip.text ="支付成功！"
        }else{
            tv_pay_tip.isSelected =false
            tv_pay_tip.text ="支付失败！"
        }
        ly_left.setOnClickListener(this)
        tv_pay_left.setOnClickListener(this)
        tv_pay_right.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.ly_left->finish()
            R.id.tv_pay_left->jumpActivity(null,PartsOrderActivity::class.java)
            R.id.tv_pay_right->jumpActivity(null,MainActivity::class.java)
        }

    }
}
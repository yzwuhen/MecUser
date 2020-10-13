package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_login_code.*
import kotlinx.android.synthetic.main.layout_title.*

class LoginCodeActivity : BaseActivity<NetData>(), View.OnClickListener {
    private var isCheck:Boolean=false
    override fun getLayoutId(): Int {

        return R.layout.activity_login_code
    }

    override fun initView() {
        super.initView()
        tv_title.text = "验证码登录"
        iv_back.setOnClickListener(this)
        tv_login.setOnClickListener(this)
        tv_check.setOnClickListener(this)
        tv_get_code.setOnClickListener(this)
        tv_register.setOnClickListener(this)
        tv_pwd_login.setOnClickListener(this)
        tv_agreement.setOnClickListener(this)
        tv_privacy.setOnClickListener(this)
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

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_login -> login()
            R.id.tv_check -> check()
            R.id.tv_get_code->getCodes()
            R.id.tv_register->register()
            R.id.tv_pwd_login->loginPwd()
            R.id.tv_agreement -> jumpActivity(null, AgreementActivity::class.java)
            R.id.tv_privacy -> jumpActivity(null, PrivacyActivity::class.java)
        }

    }

    private fun loginPwd() {

        jumpActivity(null,LoginPwdActivity::class.java)

    }

    private fun register() {

        jumpActivity(null,RegisterActivity::class.java)

    }

    private fun getCodes() {


    }

    private fun check() {
        isCheck =!isCheck
        if (isCheck){
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check_s,0,0,0)
        }else{
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check,0,0,0)
        }
    }

    private fun login() {
    }
}
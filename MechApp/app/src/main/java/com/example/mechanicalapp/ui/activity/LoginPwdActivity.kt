package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_login_pwd.*
import kotlinx.android.synthetic.main.layout_title.*

class LoginPwdActivity : BaseActivity<NetData>(), View.OnClickListener {

    private var isCheck: Boolean = false
    private var isEyes: Boolean = false
    override fun getLayoutId(): Int {

        return R.layout.activity_login_pwd
    }

    override fun initView() {
        super.initView()
        tv_title.text = "密码登录"
        iv_back.setOnClickListener(this)
        tv_login.setOnClickListener(this)
        tv_check.setOnClickListener(this)
        tv_register.setOnClickListener(this)
        tv_forget_pwd.setOnClickListener(this)
        iv_pwd.setOnClickListener(this)
        tv_code_login.setOnClickListener(this)
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
            R.id.iv_pwd -> checkPwd()
            R.id.tv_forget_pwd -> jumpActivity(null, FindPwdActivity::class.java)
            R.id.tv_register -> register()
            R.id.tv_code_login -> finish()
            R.id.tv_agreement -> jumpActivity(null, AgreementActivity::class.java)
            R.id.tv_privacy -> jumpActivity(null, PrivacyActivity::class.java)
        }

    }

    private fun checkPwd() {
        isEyes = !isEyes
        if (isEyes) {
            iv_pwd.setImageResource(R.mipmap.pw_s)
        } else {
            iv_pwd.setImageResource(R.mipmap.pw_n)
        }

    }

    private fun register() {

        jumpActivity(null, RegisterActivity::class.java)
    }

    private fun check() {
        isCheck = !isCheck
        if (isCheck) {
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check_s, 0, 0, 0)
        } else {
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check, 0, 0, 0)
        }
    }

    private fun login() {
    }
}
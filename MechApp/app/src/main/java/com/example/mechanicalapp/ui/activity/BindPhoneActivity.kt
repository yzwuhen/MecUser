package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.MainActivity
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_bind_phone.*
import kotlinx.android.synthetic.main.layout_title.*

class BindPhoneActivity : BaseActivity<NetData>(), View.OnClickListener {
    private var isCheck: Boolean = false
    private var isEyes1: Boolean = false
    private var isEyes2: Boolean = false
    override fun getLayoutId(): Int {

        return R.layout.activity_bind_phone
    }

    override fun initView() {
        super.initView()
        tv_title.text = "注册"
        iv_back.setOnClickListener(this)
        tv_bind.setOnClickListener(this)
        tv_check.setOnClickListener(this)
        tv_get_code.setOnClickListener(this)
        iv_pwd1.setOnClickListener(this)
        iv_pwd2.setOnClickListener(this)
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
            R.id.tv_check -> check()
            R.id.tv_get_code -> getCodes()
            R.id.tv_bind -> bindPhone()
            R.id.iv_pwd1 -> pwdCheck1()
            R.id.iv_pwd2 -> pwdCheck2()
            R.id.tv_login_in -> jumpActivity(null, MainActivity::class.java)
            R.id.tv_agreement -> jumpActivity(null, AgreementActivity::class.java)
            R.id.tv_privacy -> jumpActivity(null, PrivacyActivity::class.java)
        }

    }

    private fun pwdCheck2() {
        isEyes2 = !isEyes2
        if (isEyes2) {
            iv_pwd2.setImageResource(R.mipmap.pw_s)
        } else {
            iv_pwd2.setImageResource(R.mipmap.pw_n)
        }


    }

    private fun pwdCheck1() {
        isEyes1 = !isEyes1
        if (isEyes1) {
            iv_pwd1.setImageResource(R.mipmap.pw_s)
        } else {
            iv_pwd1.setImageResource(R.mipmap.pw_n)
        }

    }


    private fun bindPhone() {


    }

    private fun getCodes() {


    }

    private fun check() {
        isCheck = !isCheck
        if (isCheck) {
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check_s, 0, 0, 0)
        } else {
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check, 0, 0, 0)
        }
    }


}
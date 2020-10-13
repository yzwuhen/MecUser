package com.example.mechanicalapp.ui.activity

import android.content.Context
import android.telephony.TelephonyManager
import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_login_code.*
import kotlinx.android.synthetic.main.activity_login_third.*
import kotlinx.android.synthetic.main.activity_login_third.tv_agreement
import kotlinx.android.synthetic.main.activity_login_third.tv_check
import kotlinx.android.synthetic.main.activity_login_third.tv_login
import kotlinx.android.synthetic.main.activity_login_third.tv_privacy
import kotlinx.android.synthetic.main.layout_title.*
import java.lang.Exception

class LoginActivity : BaseActivity<NetData>(), View.OnClickListener {
    private var isCheck:Boolean=false
    var telephonyManager: TelephonyManager? = null

    override fun getLayoutId(): Int {

        return R.layout.activity_login_third

    }

    override fun initView() {
        super.initView()
        tv_title.text = "登录"
        iv_back.setOnClickListener(this)
        tv_login.setOnClickListener(this)
        ly_wx.setOnClickListener(this)
        ly_qq.setOnClickListener(this)
        tv_check.setOnClickListener(this)
        tv_agreement.setOnClickListener(this)
        tv_privacy.setOnClickListener(this)
        tv_other_login.setOnClickListener(this)

        telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?

        try {
            tv_phone.text = "本机号码${telephonyManager?.line1Number}"
        } catch (e: Exception) {

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

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_login -> login()
            R.id.ly_wx -> LoginWx()
            R.id.ly_qq -> LoginQQ()
            R.id.tv_check -> check()
            R.id.tv_other_login->otherLogin()
            R.id.tv_agreement -> jumpActivity(null, AgreementActivity::class.java)
            R.id.tv_privacy -> jumpActivity(null, PrivacyActivity::class.java)
        }
    }

    private fun otherLogin() {


        jumpActivity(null,LoginCodeActivity::class.java)
    }

    private fun check() {
        isCheck =!isCheck
        if (isCheck){
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check_s,0,0,0)
        }else{
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check,0,0,0)
        }

    }

    private fun LoginQQ() {


    }

    private fun LoginWx() {


    }

    private fun login() {


    }
}
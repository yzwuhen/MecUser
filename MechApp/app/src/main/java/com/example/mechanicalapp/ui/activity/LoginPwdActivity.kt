package com.example.mechanicalapp.ui.activity

import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import com.example.mechanicalapp.App
import com.example.mechanicalapp.MainActivity
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.UserInfo
import com.example.mechanicalapp.ui.mvp.impl.LoginCodePresenter
import com.example.mechanicalapp.ui.mvp.v.LoginCodeView
import com.example.mechanicalapp.utils.StringUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.RequestCallback
import com.netease.nimlib.sdk.auth.AuthService
import com.netease.nimlib.sdk.auth.LoginInfo
import kotlinx.android.synthetic.main.activity_login_pwd.*
import kotlinx.android.synthetic.main.layout_title.*


class LoginPwdActivity : BaseCusActivity(), View.OnClickListener, LoginCodeView,RequestCallback<LoginInfo>{

    private var isCheck: Boolean = false
    private var isEyes: Boolean = false
    private var phone: String? = null
    private var pwd: String? = null
    private var mPresenter: LoginCodePresenter? = null
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

        phone =intent.getStringExtra("phone")
        pwd =intent.getStringExtra("pwd")

        if (!TextUtils.isEmpty(phone)){
            et_phone.setText(phone)
            et_pwd.setText(pwd)
        }

//        et_phone.setText("13886943851")
//        et_pwd.setText("123456")
    }


    override fun initPresenter() {
        mPresenter = LoginCodePresenter(this, this)
    }

    override fun showLoading() {
        tv_login.isEnabled = false
        showLoadView()
    }

    override fun hiedLoading() {
        tv_login.isEnabled = true
        hideLoadingView()
    }

    override fun err() {
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
            et_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
        } else {
            iv_pwd.setImageResource(R.mipmap.pw_n)
            //密码不可见
            et_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance())
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

        if (verification()) {
            mPresenter?.loginPwd(phone, StringUtils.MD5(pwd))
        }
    }

    private fun verification(): Boolean {
        phone = et_phone.text.toString().trim()
        pwd = et_pwd.text.toString().trim()

        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showText("请输入手机号码")
            return false
        }
        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.showText("请输入密码")
            return false
        }
        if (!isCheck) {
            ToastUtils.showText("请先阅读并同意用户协议")
            return false
        }
        return true
    }

    override fun success(netData: NetData) {
        if (netData!=null&&netData is LoginCodeBean){
            if (netData.code == 200) {
                jumpActivity(null, MainActivity::class.java)
                App.getInstance().setUser(netData.result?.userInfo)
                App.getInstance().token = netData.result?.token
                logIm(netData.result?.userInfo)
             //   finish()
            } else {
                ToastUtils.showText(netData.message)
            }

        }
    }

    private fun logIm(userInfo: UserInfo?) {
        var mLoginInfo =LoginInfo(userInfo?.imId,userInfo?.imToken)
        NIMClient.getService(AuthService::class.java).login(mLoginInfo).setCallback(this)
    }

    override fun loginErr(exception: String?) {
        ToastUtils.showText(exception)
    }

    override fun onSuccess(param: LoginInfo?) {

    }

    override fun onFailed(code: Int) {
    }

    override fun onException(exception: Throwable?) {
    }

}
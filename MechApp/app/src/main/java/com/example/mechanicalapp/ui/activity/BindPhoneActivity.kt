package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.text.InputFilter
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.example.mechanicalapp.App
import com.example.mechanicalapp.MainActivity
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.base.WeakHandler
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReLoginThree
import com.example.mechanicalapp.ui.mvp.impl.LoginCodePresenter
import com.example.mechanicalapp.ui.mvp.v.LoginCodeView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_bind_phone.*
import kotlinx.android.synthetic.main.activity_bind_phone.et_phone
import kotlinx.android.synthetic.main.activity_bind_phone.et_pwd
import kotlinx.android.synthetic.main.activity_bind_phone.tv_agreement
import kotlinx.android.synthetic.main.activity_bind_phone.tv_check
import kotlinx.android.synthetic.main.activity_bind_phone.tv_privacy
import kotlinx.android.synthetic.main.activity_login_pwd.*
import kotlinx.android.synthetic.main.layout_title.*

class BindPhoneActivity : BaseCusActivity(), View.OnClickListener, LoginCodeView<NetData> {
    private var isCheck: Boolean = false
    private var isEyes1: Boolean = false
    private var isEyes2: Boolean = false

    private var phone:String?=null
    private var pwd1:String?=null
    private var pwd2:String?=null
    private var code:String?=null

    private var reLoginThree:ReLoginThree?=null
    private var mPresenter:LoginCodePresenter?=null

    private var sTime = 60
    private var handler = WeakHandler { msg ->
        when (msg.what) {
            1 -> downTime()
        }
        false
    }
    private fun downTime() {
        sTime--
        tv_get_code.setText(sTime.toString() + "s")
        if (sTime > 0) {
            handler.sendEmptyMessageDelayed(1, 1000)
        } else {
            tv_get_code.text="获取验证码"
            tv_get_code.isEnabled=true
            handler.removeCallbacksAndMessages(null)
        }
    }

    override fun getLayoutId(): Int {

        return R.layout.activity_bind_phone
    }

    override fun initView() {
        super.initView()
        tv_title.text = "绑定注册手机号"
        iv_back.setOnClickListener(this)
        tv_bind.setOnClickListener(this)
        tv_check.setOnClickListener(this)
        tv_get_code.setOnClickListener(this)
        iv_pwd1.setOnClickListener(this)
        iv_pwd2.setOnClickListener(this)
        tv_agreement.setOnClickListener(this)
        tv_privacy.setOnClickListener(this)
        tv_login_in.setOnClickListener(this)
        et_phone.filters=arrayOf(InputFilter.LengthFilter(11))

        reLoginThree =intent.getSerializableExtra("data") as ReLoginThree
    }

    override fun initPresenter() {
        mPresenter = LoginCodePresenter(this,this)
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_check -> check()
            R.id.tv_get_code -> getCodes()
            R.id.tv_bind -> bindPhone()
            R.id.iv_pwd1 -> pwdCheck1()
            R.id.iv_pwd2 -> pwdCheck2()
            R.id.tv_login_in -> {
                finish()
                jumpActivity(null, MainActivity::class.java)
            }
            R.id.tv_agreement -> jumpActivity(null, AgreementActivity::class.java)
            R.id.tv_privacy -> jumpActivity(null, PrivacyActivity::class.java)
        }

    }

    private fun pwdCheck2() {
        isEyes2 = !isEyes2
        if (isEyes2) {
            iv_pwd2.setImageResource(R.mipmap.pw_s)
            et_pwd.transformationMethod=HideReturnsTransformationMethod.getInstance()
        } else {
            iv_pwd2.setImageResource(R.mipmap.pw_n)
            et_pwd.transformationMethod= PasswordTransformationMethod.getInstance()
        }


    }

    private fun pwdCheck1() {
        isEyes1 = !isEyes1
        if (isEyes1) {
            iv_pwd1.setImageResource(R.mipmap.pw_s)
            et_pwd1.transformationMethod=HideReturnsTransformationMethod.getInstance()
        } else {
            iv_pwd1.setImageResource(R.mipmap.pw_n)
            et_pwd1.transformationMethod=PasswordTransformationMethod.getInstance()
        }

    }


    private fun bindPhone() {
        if (verification()){
            mPresenter?.bindPhone(reLoginThree)
        }

    }

    private fun getCodes() {
        sTime = 60
        handler.sendEmptyMessage(1)
        tv_get_code.isEnabled=false

    }
    private fun verification():Boolean{
        phone = et_phone.text.toString().trim()
        code = et_code.text.toString().trim()
        pwd1=et_pwd1.text.toString().trim()
        pwd2=et_pwd.text.toString().trim()
        if (TextUtils.isEmpty(phone)){
            ToastUtils.showText("请输入手机号码")
            return false
        }
        if (TextUtils.isEmpty(code)){
            ToastUtils.showText("请输入验证码")
            return false
        }
        if (TextUtils.isEmpty(pwd1)){
            ToastUtils.showText("请输入密码")
            return false
        }
        if (TextUtils.isEmpty(pwd2)){
            ToastUtils.showText("请再次输入密码")
            return false
        }
        if (pwd1!=pwd2){
            ToastUtils.showText("两次密码不一致")
            return false
        }

        if (!isCheck){
            ToastUtils.showText("请先阅读并同意用户协议")
            return false
        }
        reLoginThree?.captcha=code
        reLoginThree?.password=pwd2
        reLoginThree?.mobile =phone

        return true
    }

    private fun check() {
        isCheck = !isCheck
        if (isCheck) {
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check_s, 0, 0, 0)
        } else {
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check, 0, 0, 0)
        }
    }

    override fun loginSuccess(mLoginCodeBean: LoginCodeBean) {
        if (mLoginCodeBean.code==200){
            jumpActivity(null, MainActivity::class.java)
            // Hawk.put(Configs.TOKEN,mLoginCodeBean.result?.token)
            App.getInstance().setUser(mLoginCodeBean.result?.userInfo)
            App.getInstance().token=mLoginCodeBean.result?.token
            finish()
        }
        else{
            ToastUtils.showText(mLoginCodeBean.message)
        }
    }

    override fun loginErr(exception: String?) {
    }


}
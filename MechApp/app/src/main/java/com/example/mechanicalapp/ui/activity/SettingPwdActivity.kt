package com.example.mechanicalapp.ui.activity

import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReGetMsgCode
import com.example.mechanicalapp.ui.mvp.impl.LoginCodePresenter
import com.example.mechanicalapp.ui.mvp.v.LoginCodeView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_setting_pwd.*
import kotlinx.android.synthetic.main.layout_title.*

class SettingPwdActivity : BaseCusActivity(), View.OnClickListener, LoginCodeView {
    private var isEyes1: Boolean = false
    private var isEyes2: Boolean = false
    private var mReGetMsgCode = ReGetMsgCode()
    private var mPresenter: LoginCodePresenter? = null
    private var pwd: String? = null
    private var pwd1: String? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_setting_pwd
    }

    override fun initView() {
        super.initView()
        tv_title.text = "找回密码"
        iv_back.setOnClickListener(this)
        tv_sure.setOnClickListener(this)
        iv_pwd1.setOnClickListener(this)
        iv_pwd2.setOnClickListener(this)
        mReGetMsgCode = intent.getSerializableExtra("key") as ReGetMsgCode
    }

    override fun initPresenter() {
        mPresenter = LoginCodePresenter(this, this)
    }

    override fun success(netData: NetData) {
        if (netData.code==200){
            jumpActivity(null,LoginActivity::class.java)
            finish()
        }

    }

    override fun loginErr(exception: String?) {
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_sure -> sumbit()
            R.id.iv_pwd1 -> pwdCheck1()
            R.id.iv_pwd2 -> pwdCheck2()
        }
    }

    private fun pwdCheck2() {
        isEyes2 = !isEyes2
        if (isEyes2) {
            iv_pwd2.setImageResource(R.mipmap.pw_s)
            et_pwd.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            iv_pwd2.setImageResource(R.mipmap.pw_n)
            et_pwd.transformationMethod = PasswordTransformationMethod.getInstance()
        }


    }

    private fun pwdCheck1() {
        isEyes1 = !isEyes1
        if (isEyes1) {
            iv_pwd1.setImageResource(R.mipmap.pw_s)
            et_pwd1.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            iv_pwd1.setImageResource(R.mipmap.pw_n)
            et_pwd1.transformationMethod = PasswordTransformationMethod.getInstance()
        }

    }

    private fun sumbit() {
        pwd = et_pwd1.text.toString()
        pwd1 = et_pwd.text.toString()
        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.showText("请输入密码")
            return
        }
        if (TextUtils.isEmpty(pwd1)) {
            ToastUtils.showText("请再次输入密码")
            return
        }
        if (pwd != pwd1) {
            ToastUtils.showText("两次密码不一致")
            return
        }

        mReGetMsgCode.password = pwd
        mPresenter?.forgotPwd(mReGetMsgCode)
    }
}
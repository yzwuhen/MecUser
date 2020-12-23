package com.example.mechanicalapp.ui.activity

import android.text.TextUtils
import android.view.View
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.base.WeakHandler
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ResetPwd
import com.example.mechanicalapp.ui.mvp.impl.LoginCodePresenter
import com.example.mechanicalapp.ui.mvp.v.LoginCodeView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_modify_pwd.*
import kotlinx.android.synthetic.main.layout_title.*

class ModifyPwdActivity : BaseCusActivity(), View.OnClickListener, LoginCodeView{
    private var sTime = 60
    private var code: String? = null
    private var pwd: String? = null
    private var pwd1:String?=null
    private var mPresenter: LoginCodePresenter?=null
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
            tv_get_code.setText("获取验证码")
            tv_get_code.setEnabled(true)
            handler.removeCallbacksAndMessages(null)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_modify_pwd
    }

    override fun initView() {
        super.initView()
        ly_left.setOnClickListener(this)
        tv_title.text ="密码更换"
        tv_get_code.setOnClickListener(this)
        tv_rest_pwd.setOnClickListener(this)
        tv_phone.text="${App.getInstance().userInfo.phone.toString().substring(0,3)}******${App.getInstance().userInfo.phone.toString().substring(8,11)}"
    }

    override fun initPresenter() {
        mPresenter = LoginCodePresenter(this,this)
    }

    override fun success(netData: NetData) {
        if (netData.code==200){
            finish()
        }
        ToastUtils.showText(netData.message)

    }


    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ly_left->finish()
            R.id.tv_get_code->getCodes()
            R.id.tv_rest_pwd->retPwd()
        }

    }

    private fun retPwd() {

        if (verification()){

            var resetPwd= ResetPwd()
            resetPwd.mobile =App.getInstance().userInfo.phone
            resetPwd.captcha =code
            resetPwd.password =pwd
            mPresenter?.resetPwd(resetPwd)
        }

    }

    private fun verification(): Boolean {
        code = et_code.text.toString().trim()
        pwd = et_pwd.text.toString().trim()
        pwd1 = et_pwd1.text.toString().trim()
        if (TextUtils.isEmpty(code)) {
            ToastUtils.showText("请输入验证码")
            return false
        }
        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.showText("请输入密码")
            return false
        }
        if (TextUtils.isEmpty(pwd1)) {
            ToastUtils.showText("请再次输入密码")
            return false
        }
        if (pwd!=pwd1) {
            ToastUtils.showText("两次密码不一致")
            return false
        }
        return true
    }

    private fun getCodes() {
        sTime = 60
        handler.sendEmptyMessage(1)
        tv_get_code.setEnabled(false)
    }

    override fun loginErr(exception: String?) {

    }

    override fun err() {
    }
}
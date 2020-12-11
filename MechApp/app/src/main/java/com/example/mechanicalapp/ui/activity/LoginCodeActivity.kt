package com.example.mechanicalapp.ui.activity

import android.text.TextUtils
import android.view.View
import com.example.mechanicalapp.App
import com.example.mechanicalapp.MainActivity
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.base.WeakHandler
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReGetMsgCode
import com.example.mechanicalapp.ui.mvp.impl.LoginCodePresenter
import com.example.mechanicalapp.ui.mvp.v.LoginCodeView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_login_code.*
import kotlinx.android.synthetic.main.layout_title.*

class LoginCodeActivity : BaseCusActivity(), View.OnClickListener ,LoginCodeView{
    private var isCheck:Boolean=false
    private var mPresenter:LoginCodePresenter?=null
    private var phone:String?=null
    private var code:String?=null
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
                tv_get_code.setText("获取验证码")
                tv_get_code.setEnabled(true)
                handler.removeCallbacksAndMessages(null)
            }
    }


    override fun getLayoutId(): Int {

        return R.layout.activity_login_code
    }

    override fun initView() {
        super.initView()
        tv_title.text = "验证码登录"
        ly_left.setOnClickListener(this)
        tv_login.setOnClickListener(this)
        tv_check.setOnClickListener(this)
        tv_get_code.setOnClickListener(this)
        tv_register.setOnClickListener(this)
        tv_pwd_login.setOnClickListener(this)
        tv_agreement.setOnClickListener(this)
        tv_privacy.setOnClickListener(this)
//        et_phone.setText("13751773402")
//        et_code.setText("123456")

    }

    override fun initPresenter() {
        mPresenter = LoginCodePresenter(this,this)
    }

    override fun showLoading() {
        tv_login.isEnabled =false
        showLoadView()
    }

    override fun hiedLoading() {
        tv_login.isEnabled =true
        hideLoadingView()
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.ly_left -> finish()
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

        phone = et_phone.text.toString().trim()

        if (TextUtils.isEmpty(phone)){
            ToastUtils.showText("请输入手机号码")
            return
        }

        sTime = 60
        handler.sendEmptyMessage(1)
        tv_get_code.setEnabled(false)
        var mReGetMsgCode =ReGetMsgCode()
        mReGetMsgCode.mobile =phone
        mReGetMsgCode.smsmode="0"
        mPresenter?.getMsgCode(mReGetMsgCode)
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

        if (verification()){
            mPresenter?.loginCode(phone,code)
        }
    }

    private fun verification():Boolean{
        phone = et_phone.text.toString().trim()
        code = et_code.text.toString().trim()

        if (TextUtils.isEmpty(phone)){
            ToastUtils.showText("请输入手机号码")
            return false
        }
        if (TextUtils.isEmpty(code)){
            ToastUtils.showText("请输入验证码")
            return false
        }
        if (!isCheck){
            ToastUtils.showText("请先阅读并同意用户协议")
            return false
        }
        return true
    }

    override fun success(netData: NetData) {
        if (netData!=null &&netData is LoginCodeBean){
            if (netData.code==200){
                jumpActivity(null, MainActivity::class.java)
                // Hawk.put(Configs.TOKEN,mLoginCodeBean.result?.token)
                App.getInstance().setUser(netData.result?.userInfo)
                App.getInstance().token=netData.result?.token
                finish()
            }else{
                ToastUtils.showText(netData.message)
            }

        }

    }

    override fun loginErr(exception: String?) {

        ToastUtils.showText(exception)
    }


}
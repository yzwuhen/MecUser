package com.example.mechanicalapp.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.example.mechanicalapp.App
import com.example.mechanicalapp.MainActivity
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.LoginCodeBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReLoginThree
import com.example.mechanicalapp.ui.mvp.impl.LoginCodePresenter
import com.example.mechanicalapp.ui.mvp.v.LoginCodeView
import com.example.mechanicalapp.utils.ToastUtils
import com.mobile.auth.gatewayauth.PhoneNumberAuthHelper
import com.mobile.auth.gatewayauth.TokenResultListener
import com.mobile.auth.gatewayauth.model.TokenRet
import com.orhanobut.hawk.Hawk
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.UMShareConfig
import com.umeng.socialize.bean.SHARE_MEDIA
import kotlinx.android.synthetic.main.activity_login_third.*
import kotlinx.android.synthetic.main.layout_title.*


class LoginActivity : BaseCusActivity(), View.OnClickListener, LoginCodeView, UMAuthListener {
    private var isCheck: Boolean = false
    private var mPresenter: LoginCodePresenter? = null
    private var reLoginThree = ReLoginThree()

    var mAlicomAuthHelper: PhoneNumberAuthHelper? = null
    override fun getLayoutId(): Int {

        return R.layout.activity_login_third

    }

    @SuppressLint("HardwareIds")
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
        if (TextUtils.isEmpty(Hawk.get(Configs.THREE_PHONE))) {
            tv_phone.visibility = View.INVISIBLE
        } else {
            tv_phone.text = Hawk.get(Configs.THREE_PHONE)
        }

    }

    private fun auth() {
        if (mAlicomAuthHelper==null){
            mAlicomAuthHelper = PhoneNumberAuthHelper.getInstance(this, object : TokenResultListener {
                override fun onTokenSuccess(success: String?) {

                    val pTokenRet = TokenRet.fromJson(success)
                    if (pTokenRet.code == "600000") {
                        mAlicomAuthHelper?.quitLoginPage()
                        mAlicomAuthHelper?.hideLoginLoading()
                        Log.v("获取token 成功 ", "================${pTokenRet.token}")
                        mPresenter?.loginAli(pTokenRet.token)
                    }
                    Log.v("onTokenSuccess === ", "================$success")
                }
                override fun onTokenFailed(failed: String?) {
                    Log.v("onTokenFailed 失败 ", "================$failed")
                }
            })
            mAlicomAuthHelper?.setAuthSDKInfo("drnki1YtLe9L4+1S1HHSSgcZPiXwXcad2mYVO3OmiVjU/5pQZWFD7JpozZtwiLNIeZvjw/ZD4tRhbT0uAoI0e2z12kn/ONYjgpYa0oI3PNVTvP2Ir1Z0kuAA5SjhuPXY53YjRUgnhaVQLO+8SirvzJSJ7efbxqNBMRd3ZaYqubCNiy9Km4xCbS+HseMKitIyJmYu71LCBS3MHpoJAU17lmVwiGBcgv4F1KI/cs6b2kTa9yN1k3HDGHE3V/KDdNuelQedU7hYOdFSJkjqNhXTnujklHjh2VLkEw+t23iebr3aWY9RXdOnzzpR0fsAFfm8")
            mAlicomAuthHelper?.checkEnvAvailable(PhoneNumberAuthHelper.SERVICE_TYPE_LOGIN)
        }
        mAlicomAuthHelper?.getLoginToken(this, 5000)
    }

    override fun initPresenter() {
        mPresenter = LoginCodePresenter(this, this)
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
            R.id.tv_login -> login()
            R.id.ly_wx -> LoginWx()
            R.id.ly_qq -> LoginQQ()
            R.id.tv_check -> check()
            R.id.tv_other_login -> otherLogin()
            R.id.tv_agreement -> jumpActivity(null, AgreementActivity::class.java)
            R.id.tv_privacy -> jumpActivity(null, PrivacyActivity::class.java)
        }
    }

    private fun otherLogin() {


        jumpActivity(null, LoginCodeActivity::class.java)
    }

    private fun check() {
        isCheck = !isCheck
        if (isCheck) {
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check_s, 0, 0, 0)
        } else {
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check, 0, 0, 0)
        }

    }

    private fun LoginQQ() {
        val config = UMShareConfig()
        config.isNeedAuthOnGetUserInfo(true)
        UMShareAPI.get(this).setShareConfig(config)
        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, this)

    }

    private fun LoginWx() {
        if (!isCheck) {
            ToastUtils.showText("请先阅读并同意用户协议")
            return
        }
        val config = UMShareConfig()
        config.isNeedAuthOnGetUserInfo(true)
        UMShareAPI.get(this).setShareConfig(config)
        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, this)

    }

    private fun login() {
        if (!isCheck) {
            ToastUtils.showText("请先阅读并同意用户协议")
            return
        }
        if (TextUtils.isEmpty(Hawk.get(Configs.THREE_PHONE))) {
            auth()
        } else {
            //调一键登陆
        }

    }

    override fun onStart(p0: SHARE_MEDIA?) {

    }

    override fun onComplete(
        platform: SHARE_MEDIA?,
        action: Int,
        data: MutableMap<String, String>?
    ) {
        Log.v("sss", "==============================")

        if (platform == SHARE_MEDIA.QQ) {
            reLoginThree.type = "2"

        } else if (platform == SHARE_MEDIA.WEIXIN) {
            reLoginThree.type = "1"
            reLoginThree.thirdId = data?.get("openid")
            App.getInstance().userInfo.sex = 1
            App.getInstance().userInfo.avatar = data?.get("profile_image_url")
            App.getInstance().userInfo.realname = data?.get("name")
        }
        mPresenter?.loginThree(reLoginThree)
    }

    override fun onError(platform: SHARE_MEDIA?, action: Int, e: Throwable?) {
        Log.v("sss", "==============================$action")
    }

    override fun onCancel(platform: SHARE_MEDIA?, action: Int) {
    }

    override fun success(netData: NetData) {
        if (netData != null && netData is LoginCodeBean) {
            if (netData.code == 200) {
                jumpActivity(null, MainActivity::class.java)
                App.getInstance().setUser(netData.result?.userInfo)
                App.getInstance().token = netData.result?.token
                finish()
            } else if (netData.code == 201) {
                var bundle = Bundle()
                bundle.putSerializable("data", reLoginThree)
                jumpActivity(bundle, BindPhoneActivity::class.java)
                finish()
            } else {
                ToastUtils.showText(netData.message)
            }
        }

    }

    override fun loginErr(exception: String?) {
    }
}
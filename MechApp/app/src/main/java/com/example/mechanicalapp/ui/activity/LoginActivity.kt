package com.example.mechanicalapp.ui.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
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
import com.orhanobut.hawk.Hawk
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.UMShareConfig
import com.umeng.socialize.bean.SHARE_MEDIA
import kotlinx.android.synthetic.main.activity_login_third.*
import kotlinx.android.synthetic.main.layout_title.*


class LoginActivity : BaseCusActivity(), View.OnClickListener , LoginCodeView,UMAuthListener {
    private var isCheck:Boolean=false
    private var telephonyManager: TelephonyManager? = null
    private var mPresenter:LoginCodePresenter?=null
    private var reLoginThree =ReLoginThree()
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

        telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?

        try {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_SMS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_NUMBERS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            tv_phone.text = "本机号码${telephonyManager?.line1Number}"
        } catch (e: Exception) {

        }

    }

    override fun initPresenter() {
        mPresenter=  LoginCodePresenter(this,this)
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
        isCheck =!isCheck
        if (isCheck){
            tv_check.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.login_check_s, 0, 0, 0)
        }else{
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
        if (!isCheck){
            ToastUtils.showText("请先阅读并同意用户协议")
            return
        }
        val config = UMShareConfig()
        config.isNeedAuthOnGetUserInfo(true)
        UMShareAPI.get(this).setShareConfig(config)
        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, this)

    }

    private fun login() {


    }

    override fun onStart(p0: SHARE_MEDIA?) {

    }

    override fun onComplete(platform: SHARE_MEDIA?, action: Int, data: MutableMap<String, String>?) {
        Log.v("sss", "==============================")

        if (platform==SHARE_MEDIA.QQ){
            reLoginThree.type ="2"

        }else if (platform ==SHARE_MEDIA.WEIXIN){
            reLoginThree.type ="1"
            reLoginThree.thirdId=data?.get("openid")
            App.getInstance().userInfo.sex=1
            App.getInstance().userInfo.avatar=data?.get("profile_image_url")
            App.getInstance().userInfo.realname=data?.get("name")
        }
        mPresenter?.loginThree(reLoginThree)
    }

    override fun onError(platform: SHARE_MEDIA?, action: Int, e: Throwable?) {
        Log.v("sss", "==============================$action")
    }

    override fun onCancel(platform: SHARE_MEDIA?, action: Int) {
    }

    override fun success(netData: NetData) {
        if (netData!=null &&netData is LoginCodeBean){
            if (netData.code==200){
                jumpActivity(null, MainActivity::class.java)
                App.getInstance().setUser(netData.result?.userInfo)
                App.getInstance().token=netData.result?.token

                finish()
            }else if (netData.code==201){
                var bundle =Bundle()
                bundle.putSerializable("data",reLoginThree)
                jumpActivity(bundle, BindPhoneActivity::class.java)
                finish()
            }
            else{
                ToastUtils.showText(netData.message)
            }
        }

    }

    override fun loginErr(exception: String?) {
    }
}
package com.example.mechanicalapp.ui.activity

import android.text.TextUtils
import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.WeakHandler
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReGetMsgCode
import com.example.mechanicalapp.ui.mvp.impl.LoginCodePresenter
import com.example.mechanicalapp.ui.view.SidleView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_find_pwd.*
import kotlinx.android.synthetic.main.layout_title.*

class FindPwdActivity:BaseActivity<NetData>(),View.OnClickListener ,SidleView.SidleOutListener{

    private var mPresenter: LoginCodePresenter?=null
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

    override fun initPresenter() {

    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun getLayoutId(): Int {


        return R.layout.activity_find_pwd
    }

    override fun initView() {
        super.initView()

        tv_title.text = "找回密码"
        iv_back.setOnClickListener(this)
        tv_get_code.setOnClickListener(this)

        sidle_view.addSidleListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_get_code->getCodes()
        }
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
        var mReGetMsgCode = ReGetMsgCode()
        mReGetMsgCode.mobile =phone
        mReGetMsgCode.smsmode="0"
        mPresenter?.getMsgCode(mReGetMsgCode)
    }

    override fun isSidleOut() {

        jumpActivity(null,SettingPwdActivity::class.java)
    }
}
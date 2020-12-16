package com.example.mechanicalapp.wxapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.PayResultActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.tencent.mm.opensdk.modelbase.BaseReq
import com.tencent.mm.opensdk.modelbase.BaseResp
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
import com.tencent.mm.opensdk.openapi.WXAPIFactory

class WXPayEntryActivity : BaseCusActivity(), IWXAPIEventHandler {
    private var api: IWXAPI? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_wx_pay_result
    }

    override fun initView() {
        super.initView()
        api = WXAPIFactory.createWXAPI(this, Configs.WX_APP_ID)
        api?.handleIntent(intent, this)
    }

    override fun initPresenter() {
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        api?.handleIntent(intent, this)
    }


    override fun onReq(resp: BaseReq?) {
        Log.v("TAG", "onPayFinish,onReq=$resp");
    }

    override fun onResp(resp: BaseResp?) {
        Log.v("TAG", "onPayFinish,errCode=${resp?.errCode}");

        when (resp?.errCode) {
            0 -> {
                var bundle = Bundle()
                bundle.putInt("type", 0)
                jumpActivity(bundle, PayResultActivity::class.java)
            }
            -1 -> {
                var bundle = Bundle()
                bundle.putInt("type", 1)
                jumpActivity(bundle, PayResultActivity::class.java)
            }
        }
        finish()
    }

}
package com.example.mechanicalapp.ui.activity

import android.text.Html
import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.data.SysMsgData
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import kotlinx.android.synthetic.main.activity_msg_sys.*
import kotlinx.android.synthetic.main.layout_title.*

class SysMsgActivity:BaseActivity<NetData>() ,View.OnClickListener{

    private var msgData :SysMsgData?=null
    private var mPresenter :MecAppPresenter?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_msg_sys
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "消息详情"
        msgData =intent.getSerializableExtra("data") as SysMsgData

        tv_msg_title.text =msgData?.title
        tv_msg_info.text =Html.fromHtml(msgData?.content)
    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
        mPresenter?.getSysMsgDetails(msgData?.id)
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(p0: View?) {

        finish()
    }
}
package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.MsgPresenter
import com.example.mechanicalapp.ui.mvp.v.MsgView
import kotlinx.android.synthetic.main.activity_black_list_set.*
import kotlinx.android.synthetic.main.layout_title.*

class BlackListSettActivity:BaseCusActivity(),View.OnClickListener, MsgView<NetData> {
    private var account=""
    private var mPresenter :MsgPresenter<NetData>?=null
    private var isBlackList=true
    override fun getLayoutId(): Int {


        return R.layout.activity_black_list_set
    }

    override fun initView() {
        super.initView()

        account =intent.getStringExtra("id").toString()
        iv_switch.setOnClickListener(this)
        ly_left.setOnClickListener(this)
        iv_switch.isSelected =isBlackList

    }

    override fun initPresenter() {
        mPresenter = MsgPresenter(this)
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.ly_left->finish()
            R.id.iv_switch ->switch()
        }

    }

    private fun switch() {

        if (isBlackList){
            mPresenter?.removeBlackList(account)
        }else{
            mPresenter?.addBlackList(account)
        }

    }

    override fun refreshUI(t: NetData?) {

    }

    override fun success() {
        isBlackList =!isBlackList
        iv_switch.isSelected =isBlackList
    }
}
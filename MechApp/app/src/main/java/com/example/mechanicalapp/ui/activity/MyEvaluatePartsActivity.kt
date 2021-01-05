package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemChangeListener
import com.example.mechanicalapp.ui.adapter.EvaluateAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReEvaluateParts
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_evaluate_parts.*
import kotlinx.android.synthetic.main.layout_title.*

class MyEvaluatePartsActivity : BaseCusActivity(), View.OnClickListener, OnItemChangeListener,
    NetDataView<NetData> {


    private var orderId=""
    private var mEvaList =ArrayList<ReEvaluateParts>()
    private var mPresenter: MecAppPresenter?=null
    private var mAdapter : EvaluateAdapter?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_evaluate_parts
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_btn.setOnClickListener(this)
        tv_title.text = "我的评价"


        orderId =intent.getStringExtra("order_id").toString()

    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
        mPresenter?.getMyPartsEvaluate(orderId)
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_btn ->submit()
        }
    }

    private fun submit() {
       finish()
    }

    override fun onItemClick(view: View, position: Int, any: String) {
        when(view?.id){
            R.id.ratingBar->{
                mEvaList[position].star =any
            }
            R.id.tv_info->{
                mEvaList[position].content =any
            }
        }
    }

    override fun refreshUI(data: NetData?) {
        ToastUtils.showText(data?.message)
        if (data?.code==200){
            finish()
        }
    }

    override fun loadMore(data: NetData?) {
    }
}
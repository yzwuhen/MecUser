package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.LookEvaluateAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.EvaluateData
import com.example.mechanicalapp.ui.data.LookEvaluateBean
import com.example.mechanicalapp.ui.data.PartsOrderGoodsList
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import kotlinx.android.synthetic.main.activity_evaluate_parts.*
import kotlinx.android.synthetic.main.layout_title.*

class MyEvaluatePartsActivity : BaseCusActivity(), View.OnClickListener,
    NetDataView<LookEvaluateBean> {


    private var orderId=""
    private var orderItemList=ArrayList<EvaluateData>()
    private var mPresenter: MecAppPresenter?=null
    private var mAdapter : LookEvaluateAdapter?=null
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

        recycle_list.layoutManager = LinearLayoutManager(this)
        mAdapter =LookEvaluateAdapter(this,orderItemList)
        recycle_list.adapter = mAdapter

        tv_btn.text ="返回订单"
    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
        mPresenter?.getMyPartsEvaluate(orderId)
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
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


    override fun refreshUI(data: LookEvaluateBean?) {
        if (data!=null&&data.code==200){
            orderItemList.clear()
            if (data.result!=null&&data.result.size>0){
                orderItemList.addAll(data.result)
            }
            mAdapter?.notifyDataSetChanged()
        }

    }

    override fun loadMore(data: LookEvaluateBean?) {
    }
}
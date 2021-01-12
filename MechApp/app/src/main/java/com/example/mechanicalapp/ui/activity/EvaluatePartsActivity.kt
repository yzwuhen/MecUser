package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemChangeListener
import com.example.mechanicalapp.ui.adapter.EvaluateAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsOrderGoodsList
import com.example.mechanicalapp.ui.data.request.ReEvaluateParts
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_evaluate_parts.*
import kotlinx.android.synthetic.main.layout_title.*

class EvaluatePartsActivity: BaseCusActivity(), View.OnClickListener,OnItemChangeListener ,
    NetDataView<NetData> {

    private var orderItemList=ArrayList<PartsOrderGoodsList>()
    private var price=0.0
    private var num=0
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

        if (intent.getSerializableExtra("data") as List<PartsOrderGoodsList>?!=null){
            orderItemList.addAll(intent.getSerializableExtra("data") as List<PartsOrderGoodsList>)
        }

        price =intent.getDoubleExtra("price",0.0)
        num =intent.getIntExtra("num",0)
        orderId =intent.getStringExtra("id").toString()


        if (orderItemList.size>0){
            for (orderItem in orderItemList){
                var mReEvaluate =ReEvaluateParts()
                mReEvaluate.mecProductSkuId =orderItem.mecProductSkuId
                mReEvaluate.mecProductSkuName =orderItem.skuName
                mReEvaluate.mecOrderId =orderId
                mReEvaluate.mecOrderItemId =orderItem.id
                mReEvaluate.commentUserHeader = App.getInstance().userInfo.avatar
                mReEvaluate.commentUserName =App.getInstance().userInfo.realname
                mReEvaluate.commentUserPhone =App.getInstance().userInfo.phone
                mReEvaluate.commentUserId =App.getInstance().userInfo.id
                mEvaList.add(mReEvaluate)
            }
        }

        recycle_list.layoutManager =LinearLayoutManager(this)
        mAdapter =EvaluateAdapter(this,orderItemList,this)
        recycle_list.adapter = mAdapter
    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
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

        //未完成 提交数组
        mPresenter?.postPartsEvaluate(mEvaList)
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
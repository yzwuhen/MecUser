package com.example.mechanicalapp.ui.activity

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemChangeListener
import com.example.mechanicalapp.ui.adapter.EvaluateAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsOrderGoodsList
import kotlinx.android.synthetic.main.activity_evaluate_parts.*
import kotlinx.android.synthetic.main.item_order_evaluate.view.*
import kotlinx.android.synthetic.main.layout_title.*

class EvaluatePartsActivity: BaseActivity<NetData>(), View.OnClickListener,OnItemChangeListener {

    private var orderItemList=ArrayList<PartsOrderGoodsList>()
    private var price=0.0
    private var num=0
    private var orderId=""

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



        recycle_list.layoutManager =LinearLayoutManager(this)
        recycle_list.adapter = EvaluateAdapter(this,orderItemList,this)
    }

    override fun initPresenter() {
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


    }

    override fun onItemClick(view: View, position: Int, any: Any) {
        when(view?.id){
            R.id.ratingBar->{
                Log.v("ssss","ssss====== ${any}")
            }
            R.id.tv_info->{
                Log.v("ssss","ssss====== ${any}")
            }
        }
    }
}
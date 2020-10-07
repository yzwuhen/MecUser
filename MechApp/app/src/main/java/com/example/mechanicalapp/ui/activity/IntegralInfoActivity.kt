package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.IntegralAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_integral_info.*
import kotlinx.android.synthetic.main.layout_title.*

class IntegralInfoActivity : BaseActivity<NetData>() ,View.OnClickListener,OnItemClickListener{


    private var mIntegralAdapter :IntegralAdapter ?=null
    private var mList :MutableList<String> =ArrayList<String>()

    override fun getLayoutId(): Int {

        return R.layout.activity_integral_info
    }
    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "我的积分"
        mList.add("签到")
        mList.add("分享机械邦")
        mList.add("发布")
        mList.add("签到")
        mList.add("分享机械邦")
        mList.add("发布")
        mList.add("签到")
        mList.add("分享机械邦")
        mList.add("发布")


        mIntegralAdapter = IntegralAdapter(this,mList,this)
        recycle_list.layoutManager =LinearLayoutManager(this)
        recycle_list.adapter = mIntegralAdapter

    }
    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(p0: View?) {

        finish()
    }

    override fun onItemClick(view: View, position: Int) {


    }
}
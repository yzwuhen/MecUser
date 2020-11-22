package com.example.mechanicalapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.OrderDetailsActivity
import com.example.mechanicalapp.ui.adapter.OrderAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.OrderBean
import com.example.mechanicalapp.ui.data.OrderData
import com.example.mechanicalapp.ui.mvp.impl.OrderPresenter
import com.example.mechanicalapp.ui.mvp.v.OrderView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_spring_list.*


class OrderListFragment(var type: String) : BaseCusFragment(), OnItemClickListener,OrderView<OrderBean>{


    private var mAdapter: OrderAdapter? = null
    var mList: MutableList<OrderData> = ArrayList<OrderData>()

    override fun initView() {
        super.initView()
        mAdapter = OrderAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter
        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as OrderPresenter).resetPage()
                (mPresenter as OrderPresenter).getOrderList(type)
            }

            override fun onLoadmore() {
                (mPresenter as OrderPresenter).getOrderList(type)
            }
        })


        mPresenter = OrderPresenter( this)
        (mPresenter as OrderPresenter).getOrderList(type)


    }

    fun closeRefreshView() {
        spring_list?.isEnable=true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun hiedLoading() {
        closeRefreshView()
    }
    override fun showLoading() {
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }


    override fun onItemClick(view: View, position: Int) {
        var bundle =Bundle()
        bundle.putString("id",mList[position].id)
        bundle.putInt("status",mList[position].status)
        jumpActivity(bundle,OrderDetailsActivity::class.java)

    }

    override fun err() {


    }

    override fun showData(data: OrderBean?) {
        mList.clear()
        if (data?.code==200&& data?.result?.records?.isNotEmpty()!!){
            mList.addAll(data?.result?.records!!)
        }
        mAdapter?.notifyDataSetChanged()
    }

    override fun showDataMore(data: OrderBean?) {
        if (data?.code==200&& data?.result?.records?.isNotEmpty()!!){
            mList.addAll(data?.result?.records!!)
            mAdapter?.notifyDataSetChanged()
        }
    }
}
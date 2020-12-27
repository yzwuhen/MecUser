package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PreviewListAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.ListBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_details_list.*
import kotlinx.android.synthetic.main.layout_title.*

/**
 * 维修清单
 */
class DetailedListActivity:BaseCusActivity() ,View.OnClickListener,OnItemClickLevelListener,NetDataView<NetData>{


    private var mAdapter: PreviewListAdapter? = null
    private var mList = ArrayList<ListBean.ResultBean>()

    private var repairOrderId=""

    private var mPresenter:MecAppPresenter?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_details_list
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "查看清单"
        repairOrderId = intent.getStringExtra("id").toString()


        mAdapter = PreviewListAdapter(this, mList, this)
        recycle_list.layoutManager = LinearLayoutManager(this)
        recycle_list.adapter = mAdapter
        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                mPresenter?.getList(2, repairOrderId)
            }

            override fun onLoadmore() {
            }
        })
    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
        mPresenter?.getList(2, repairOrderId)
    }

    private fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }
    override fun err()  {
    }

    override fun onClick(v: View?) {

        finish()
    }

    override fun onItemClick(view: View, position: Int, childPosition: Int) {
        when (view.id) {
            R.id.iv_right_list -> {
                mList[position].data[childPosition].isShow =
                    !mList[position].data[childPosition].isShow
                mAdapter?.refreshAdapter(position, childPosition)
            }

        }

    }
    override fun refreshUI(netData: NetData?) {
        if (netData != null && netData is ListBean &&netData.result!=null) {
            mList.clear()
            mAdapter?.clearAdapter()
            mList.addAll(netData.result)
            mAdapter?.notifyDataSetChanged()
            if (mList.size>0){
                var price=0
                for (data in mList){
                    price +=data.total
                }
                tv_all_money.text="￥${price}"
            }
        }
    }

    override fun loadMore(data: NetData?) {
    }
}
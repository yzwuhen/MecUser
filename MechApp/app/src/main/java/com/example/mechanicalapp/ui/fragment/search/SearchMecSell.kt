package com.example.mechanicalapp.ui.fragment.search

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.LeaseDetailsActivity
import com.example.mechanicalapp.ui.adapter.BossSellAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.MecSellData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.SellPresenter
import com.example.mechanicalapp.ui.mvp.v.MecSellView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_search_all_result.*

class SearchMecSell (var type:Int): BaseCusFragment() , OnItemClickListener, MecSellView<NetData> {


    private var mAdapter: BossSellAdapter? = null
    private var mList: MutableList<MecSellData> = ArrayList<MecSellData>()
    override fun getLayoutId(): Int {
        return R.layout.fragment_search_all_result
    }

    override fun initView() {
        super.initView()


        mAdapter = BossSellAdapter(mContext, mList, type, this)

        recycle_list.layoutManager = LinearLayoutManager(mContext)
        recycle_list.adapter = mAdapter


        spring_list.type= SpringView.Type.FOLLOW
        spring_list.header= RefreshHeaderUtils.getHeaderView(mContext)
        // spring_list.footer=RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable =false
                //  initData()
                closeRefreshView()
            }

            override fun onLoadmore() {
                //     closeRefreshView()
            }
        })

        mPresenter = SellPresenter(mContext,this)
        (mPresenter as SellPresenter).getSellList(1)
    }

    fun closeRefreshView() {
        spring_list.isEnable =true
        spring_list.onFinishFreshAndLoad()
    }

    override fun onItemClick(view: View, position: Int) {
        var bundle = Bundle()
        bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, 0)
        jumpActivity(bundle, LeaseDetailsActivity::class.java)
    }

    override fun refreshUI(list: List<MecSellData>) {
        mList.clear()
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()

    }

    override fun loadMore(list: List<MecSellData>) {
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }
}
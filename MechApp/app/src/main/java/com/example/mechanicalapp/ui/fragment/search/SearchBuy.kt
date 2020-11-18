package com.example.mechanicalapp.ui.fragment.search

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.AskDetailsActivity
import com.example.mechanicalapp.ui.adapter.BossBuyAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.MecBuyData
import com.example.mechanicalapp.ui.data.MecSellData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.MecBuyPresenter
import com.example.mechanicalapp.ui.mvp.impl.MecLeaseListPresenter
import com.example.mechanicalapp.ui.mvp.v.MecBuyView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_search_all_result.*

class SearchBuy : BaseCusFragment(), OnItemClickListener, MecBuyView<NetData> {


    var mList: MutableList<MecSellData> = ArrayList<MecSellData>()
    private var mAdapter: BossBuyAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_search_all_result
    }

    override fun initView() {
        super.initView()

        mAdapter = BossBuyAdapter(mContext, mList, this)

        recycle_list.layoutManager = LinearLayoutManager(mContext)
        recycle_list.adapter = mAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        // spring_list.footer=RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                //  initData()
                closeRefreshView()
            }

            override fun onLoadmore() {
                //     closeRefreshView()
            }
        })
        mPresenter = MecBuyPresenter(mContext, this)
        (mPresenter as MecBuyPresenter).getBuyList(2)
    }

    fun closeRefreshView() {
        spring_list.isEnable = true
        spring_list.onFinishFreshAndLoad()
    }

    override fun onItemClick(view: View, position: Int) {
        var bundle = Bundle()
        bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, 0)
        jumpActivity(bundle, AskDetailsActivity::class.java)
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
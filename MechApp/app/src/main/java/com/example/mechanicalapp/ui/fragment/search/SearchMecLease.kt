package com.example.mechanicalapp.ui.fragment.search

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.LeaseDetailsActivity
import com.example.mechanicalapp.ui.adapter.UserDemandAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.MecLeaseData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.MecLeaseListPresenter
import com.example.mechanicalapp.ui.mvp.v.MecLeaseView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_search_all_result.*

class SearchMecLease(var type:Int):BaseCusFragment() ,OnItemClickListener, MecLeaseView<NetData>{


    private var mAdapter: UserDemandAdapter? = null
    private var mLeaseList: MutableList<MecLeaseData> = ArrayList<MecLeaseData>()
    override fun getLayoutId(): Int {
       return R.layout.fragment_search_all_result
    }

    override fun initView() {
        super.initView()


        mAdapter = UserDemandAdapter(mContext, mLeaseList, type, this)

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

        mPresenter = MecLeaseListPresenter(mContext,this)
        (mPresenter as MecLeaseListPresenter).setTitle("机械")
        (mPresenter as MecLeaseListPresenter).getLeaseList(1)
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

    override fun refreshUI(list: List<MecLeaseData>) {
        mLeaseList.clear()
        mLeaseList.addAll(list)
        mAdapter?.notifyDataSetChanged()

    }

    override fun loadMore(list: List<MecLeaseData>) {
        mLeaseList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }
}
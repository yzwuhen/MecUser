package com.example.mechanicalapp.ui.fragment.look

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.LeaseDetailsActivity
import com.example.mechanicalapp.ui.adapter.LookLeaseAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_spring_list.*



class LookLease(var type: Int) : BaseFragment<NetData>(), OnItemClickListener {


    private var mAdapter: LookLeaseAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()
    override fun showLoading() {

    }

    init {
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
    }

    override fun initView() {
        super.initView()
        mAdapter = LookLeaseAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter

        spring_list.setType(SpringView.Type.FOLLOW)
        spring_list.setHeader(RefreshHeaderUtils.getHeaderView(mContext))

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.setEnable(false)
                //  initData()
                closeRefreshView()
            }

            override fun onLoadmore() {}
        })

    }

    fun closeRefreshView() {
        spring_list.setEnable(true)
        spring_list.onFinishFreshAndLoad()
    }



    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }

    override fun showData(t: NetData?) {
    }

    override fun onItemClick(view: View, position: Int) {
        val bundle = Bundle()
        bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, type)
        jumpActivity(bundle, LeaseDetailsActivity::class.java)
    }
}
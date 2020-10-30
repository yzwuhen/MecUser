package com.example.mechanicalapp.ui.fragment.search

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.GoodsDetailsActivity
import com.example.mechanicalapp.ui.activity.PartsAskDetailsActivity
import com.example.mechanicalapp.ui.adapter.PartsAdapter
import com.example.mechanicalapp.ui.adapter.PartsAskAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_search_all_result.*

class SearchPartsAsk  : BaseCusFragment() , OnItemClickListener {


    var mList: MutableList<String> = ArrayList<String>()
    private var mAdapter: PartsAskAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_search_all_result
    }

    override fun initView() {
        super.initView()
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = PartsAskAdapter(mContext, mList, this)

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

    }

    fun closeRefreshView() {
        spring_list.isEnable =true
        spring_list.onFinishFreshAndLoad()
    }

    override fun onItemClick(view: View, position: Int) {
        var bundle = Bundle()
        bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, 0)
        jumpActivity(bundle, PartsAskDetailsActivity::class.java)
    }
}
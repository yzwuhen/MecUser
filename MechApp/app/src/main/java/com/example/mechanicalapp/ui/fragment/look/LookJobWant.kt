package com.example.mechanicalapp.ui.fragment.look

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.JobWantAdapter
import com.example.mechanicalapp.ui.adapter.LookJobWantAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.layout_spring_list.*

class LookJobWant  : BaseFragment<NetData>() , OnItemClickListener {


    private var mAdapter: LookJobWantAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()
    override fun showLoading() {


    }

    init {
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

    }

    override fun initView() {
        super.initView()

        mAdapter = LookJobWantAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter


    }



    override fun hiedLoading() {

    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }

    override fun showData(t: NetData?) {

    }

    override fun onItemClick(view: View, position: Int) {


    }
}
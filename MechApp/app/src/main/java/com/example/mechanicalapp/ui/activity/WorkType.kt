package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktapp.views.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.EcTypeLeftAdapter
import com.example.mechanicalapp.ui.adapter.WorkTypeAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_ec_type.*

class WorkType : BaseActivity<NetData>(), OnItemClickListener {


    private var mLeftAdapter: EcTypeLeftAdapter? = null
    private var mRightAdapter: WorkTypeAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()

    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }


    override fun initView() {
        super.initView()

        mList.add("所有工种")
        mList.add("其他工种")
        mList.add("通用工种")
        mList.add("驾驶员")
        mList.add("通用工种")
        mList.add("其他工种")
        mList.add("管理工种")


        mLeftAdapter = EcTypeLeftAdapter(this, mList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter


        mRightAdapter = WorkTypeAdapter(this, mList, this)
        recycler_list_right.layoutManager = GridLayoutManager(this,2)
        recycler_list_right.addItemDecoration(MyDecoration(2))
        recycler_list_right.adapter = mRightAdapter

    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }



    override fun onItemClick(view: View, position: Int) {
    }
}
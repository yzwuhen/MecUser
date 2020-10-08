package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.OtherAdapter
import com.example.mechanicalapp.ui.adapter.PartsDetailsListAdapter
import com.example.mechanicalapp.ui.adapter.TravelAdapter
import com.example.mechanicalapp.ui.adapter.WorkTimeAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_details_list.*
import kotlinx.android.synthetic.main.layout_title.*

/**
 * 维修清单
 */
class DetailedListActivity:BaseActivity<NetData>() ,View.OnClickListener,OnItemClickListener{

    private var mPartsDetailsListAdapter: PartsDetailsListAdapter? = null
    private var mWorkTimeAdapter: WorkTimeAdapter? = null
    private var mTravelAdapter: TravelAdapter? = null
    private var mOtherAdapter: OtherAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()

    override fun getLayoutId(): Int {
        return R.layout.activity_details_list
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "查看清单"
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mPartsDetailsListAdapter = PartsDetailsListAdapter(this, mList, this)
        recycler_parts.layoutManager = LinearLayoutManager(this)
        recycler_parts.adapter = mPartsDetailsListAdapter


        mWorkTimeAdapter = WorkTimeAdapter(this, mList, this)
        recycler_work.layoutManager = LinearLayoutManager(this)
        recycler_work.adapter = mWorkTimeAdapter

        mTravelAdapter = TravelAdapter(this, mList, this)
        recycler_travel.layoutManager = LinearLayoutManager(this)
        recycler_travel.adapter = mTravelAdapter

        mOtherAdapter = OtherAdapter(this, mList, this)
        recycler_other.layoutManager = LinearLayoutManager(this)
        recycler_other.adapter = mOtherAdapter
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(v: View?) {

        finish()
    }

    override fun onItemClick(view: View, position: Int) {


    }
}
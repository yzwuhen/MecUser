package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.EngineerAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.EngListBean
import com.example.mechanicalapp.ui.data.EngineerData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.SideBarView
import kotlinx.android.synthetic.main.fragment_engineer.*

class EngineerFragment :BaseCusFragment(), SideBarView.OnClickListener,OnItemClickListener,NetDataView<NetData>{

    private var mEngListAdapter : EngineerAdapter?=null
    private var mCityLinearLayoutManager : LinearLayoutManager?=null
    private var mMecAppPresenter :MecAppPresenter?=null

    private var mEngList :MutableList<EngineerData> =ArrayList<EngineerData>()
    private val items = listOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Z"
    )

    override fun initView() {
        super.initView()

        mCityLinearLayoutManager = LinearLayoutManager(mContext)
        mCityLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL


        mEngListAdapter = EngineerAdapter(mContext, mEngList,this)

        ry_left.layoutManager = mCityLinearLayoutManager

        ry_left.adapter =mEngListAdapter

        sb_letter.setContentDataList(items)
        sb_letter.setEqualItemSpace(true)
        sb_letter.setOnSidleClickListener(this)

        mMecAppPresenter = MecAppPresenter(this)
        mMecAppPresenter?.getEngList()
    }

    override fun onItemDown(position: Int, itemContent: String?) {

    }

    override fun onItemMove(position: Int, itemContent: String?) {

    }

    override fun onItemUp(position: Int, itemContent: String?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_engineer
    }

    override fun onItemClick(view: View, position: Int) {


    }

    override fun refreshUI(data: NetData?) {
        if (data!=null&&data is EngListBean){
            mEngList.clear()
            data?.result?.records?.let { mEngList.addAll(it) }
            mEngListAdapter?.notifyDataSetChanged()
        }

    }

    override fun loadMore(data: NetData?) {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }


}
package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.EngineerAdapter
import com.example.mechanicalapp.ui.adapter.EngineerParentAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.SideBarView
import kotlinx.android.synthetic.main.activity_search_city.*
import kotlinx.android.synthetic.main.fragment_engineer.*
import kotlinx.android.synthetic.main.fragment_engineer.sb_letter

class EngineerFragment :BaseCusFragment(), SideBarView.OnClickListener,OnItemClickListener,OnItemClickLevelListener,NetDataView<NetData>{

    private var mEngListAdapter : EngineerParentAdapter?=null
    private var mCityLinearLayoutManager : LinearLayoutManager?=null
    private var mMecAppPresenter :MecAppPresenter?=null

    private var mEngList =ArrayList<EngLetterParentData>()
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


        mEngListAdapter = EngineerParentAdapter(mContext, mEngList,this)

        ry_left.layoutManager = mCityLinearLayoutManager

        ry_left.adapter =mEngListAdapter


        sb_letter.setContentDataList(items)
        sb_letter.setEqualItemSpace(true)
        sb_letter.setOnSidleClickListener(this)

        mMecAppPresenter = MecAppPresenter(this)
        mMecAppPresenter?.getEngList()
    }

    override fun onItemDown(position: Int, itemContent: String?) {
        if (mEngList.size>10){
            for (index in mEngList.indices){
                if (itemContent==mEngList[index].key){
                    ry_city.scrollToPosition(index)
                }
            }
        }
    }

    override fun onItemMove(position: Int, itemContent: String?) {
        if (mEngList.size>10){
            for (index in mEngList.indices){
                if (itemContent==mEngList[index].key){
                    ry_city.scrollToPosition(index)
                }
            }
        }
    }

    override fun onItemUp(position: Int, itemContent: String?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_engineer
    }

    override fun onItemClick(view: View, position: Int) {


    }

    override fun refreshUI(data: NetData?) {
        if (data!=null&&data is EngListLetterBean){
            mEngList.clear()

            if (data.result!=null&&data.result.size>0){
                for (res in data.result){
                    if (res.size==2&&res[1].data!=null&&res[1].data.size>0){
                        var engLetterParentData=EngLetterParentData()
                        engLetterParentData.key =res[0].key
                        engLetterParentData.data =res[1].data
                        mEngList.add(engLetterParentData)
                    }
                }
            }
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

    override fun onItemClick(view: View, position: Int, childPosition: Int) {


    }


}
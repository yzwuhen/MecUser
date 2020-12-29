package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.BlackListAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.MsgPresenter
import com.example.mechanicalapp.ui.mvp.v.MsgView
import com.example.mechanicalapp.ui.view.SideBarView
import com.netease.nimlib.sdk.msg.model.RecentContact
import kotlinx.android.synthetic.main.activity_search_city.*
import kotlinx.android.synthetic.main.layout_search_title.iv_back
import kotlinx.android.synthetic.main.layout_title.*

class BlackListActivity:BaseCusActivity() , OnItemClickListener,View.OnClickListener ,SideBarView.OnClickListener,MsgView<List<String>>{

    private var mBlackListAdapter : BlackListAdapter?=null
    private var mCityLinearLayoutManager : LinearLayoutManager?=null

    private var mBlackList = ArrayList<String>()
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

    private var mPresenter:MsgPresenter<List<String>>?=null

    override fun getLayoutId(): Int {
        return R.layout.activity_black_list;
    }

    override fun initView() {
        super.initView()

        tv_title.text="黑名单通讯录"

        mCityLinearLayoutManager = LinearLayoutManager(this)
        mCityLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL


        mBlackListAdapter = BlackListAdapter(this, mBlackList as MutableList<String>,this)

        ry_city.layoutManager = mCityLinearLayoutManager

        ry_city.adapter =mBlackListAdapter

        sb_letter.setContentDataList(items)
        sb_letter.setEqualItemSpace(true)
        sb_letter.setOnSidleClickListener(this)

        iv_back.setOnClickListener(this)
    }

    override fun initPresenter() {
        mPresenter = MsgPresenter<List<String>>(this)

    }

    override fun onResume() {
        super.onResume()
        mPresenter?.getBlackList()
    }

    override fun onClick(view: View?) {
        if (view?.id== R.id.iv_back){
            finish()
        }
    }

    override fun onItemDown(position: Int, itemContent: String?) {
    }

    override fun onItemMove(position: Int, itemContent: String?) {
    }

    override fun onItemUp(position: Int, itemContent: String?) {
    }
    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.ly_city_root->{
                var  bundle =Bundle()
               bundle.putString("id",mBlackList[position])
                jumpActivity(bundle,BlackListSettActivity::class.java)
            }
        }
    }

    override fun refreshUI(t: List<String>?) {
        mBlackList.clear()
        if (t!=null){
            mBlackList.addAll(t)
        }
        mBlackListAdapter?.notifyDataSetChanged()
        if (mBlackList.size==0){
            showEmptyView()
        }
    }

    override fun success() {

    }
}
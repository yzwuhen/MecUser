package com.example.mechanicalapp.ui.activity

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.BlackListAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.SideBarView
import kotlinx.android.synthetic.main.activity_search_city.*
import kotlinx.android.synthetic.main.layout_search_title.iv_back
import kotlinx.android.synthetic.main.layout_title.*

class BlackListActivity:BaseActivity<NetData>() , OnItemClickListener,View.OnClickListener ,SideBarView.OnClickListener{

    private var mBlackListAdapter : BlackListAdapter?=null
    private var mCityLinearLayoutManager : LinearLayoutManager?=null

    private var mCityList :MutableList<String> ?=null
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


    override fun getLayoutId(): Int {
        return R.layout.activity_black_list;
    }

    override fun initView() {
        super.initView()

        tv_title.text="黑名单通讯录"

        mCityLinearLayoutManager = LinearLayoutManager(this)
        mCityLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL


        mCityList = ArrayList<String>()
        mCityList?.add("陈生")
        mCityList?.add("陈生")
        mCityList?.add("陈生")
        mCityList?.add("陈生")
        mCityList?.add("陈阿斯顿")
        mCityList?.add("戴文")
        mCityList?.add("戴文")
        mCityList?.add("戴尔")
        mCityList?.add("阿迪斯")
        mCityList?.add("阿斯顿")
        mCityList?.add("戴文")
        mCityList?.add("戴文")
        mCityList?.add("戴尔")
        mCityList?.add("阿迪斯")
        mCityList?.add("阿斯顿")


        mBlackListAdapter = BlackListAdapter(this, mCityList as MutableList<String>,this)

        ry_city.layoutManager = mCityLinearLayoutManager

        ry_city.adapter =mBlackListAdapter

        sb_letter.setContentDataList(items)
        sb_letter.setEqualItemSpace(true)
        sb_letter.setOnSidleClickListener(this)

        iv_back.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }


    override fun onClick(view: View?) {
        if (view?.id== R.id.iv_back){
            finish()
        }


    }

    override fun onItemDown(position: Int, itemContent: String?) {
        Log.v("sssss","onItemDown====$position")
    }

    override fun onItemMove(position: Int, itemContent: String?) {
        Log.v("sssss","onItemMove====$position")
    }

    override fun onItemUp(position: Int, itemContent: String?) {
        Log.v("sssss","onItemUp====$position")
    }
    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.ly_city_root->jumpActivity(null,BlackListSettActivity::class.java)
        }
    }
}
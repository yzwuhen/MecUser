package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.EngineerAdapter
import com.example.mechanicalapp.ui.adapter.LetterAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.fragment_engineer.*

class EngineerFragment :BaseFragment<NetData>(),OnItemClickListener{

    private var mBlackListAdapter : EngineerAdapter?=null
    private var mLetterAdapter : LetterAdapter?=null
    private var mCityLinearLayoutManager : LinearLayoutManager?=null
    private var mLetterLinearLayoutManager : LinearLayoutManager?=null

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

    override fun initView() {
        super.initView()

        mCityLinearLayoutManager = LinearLayoutManager(mContext)
        mCityLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL


        mLetterLinearLayoutManager = LinearLayoutManager(mContext)
        mLetterLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL

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

        mLetterAdapter = LetterAdapter(mContext, items,this)

        mBlackListAdapter = EngineerAdapter(mContext, mCityList as MutableList<String>,this)

        ry_left.layoutManager = mCityLinearLayoutManager
        ry_letter.layoutManager = mLetterLinearLayoutManager

        ry_left.adapter =mBlackListAdapter
        ry_letter.adapter = mLetterAdapter
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_engineer
    }

    override fun onItemClick(view: View, position: Int) {


    }

    override fun err() {


    }


}
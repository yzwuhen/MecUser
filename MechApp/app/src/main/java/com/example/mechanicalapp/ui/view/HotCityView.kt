package com.example.mechanicalapp.ui.view

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.HotCityAdapter
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import kotlinx.android.synthetic.main.layout_hot_city.view.*

class HotCityView(
    var mContext: Context,
    var mOnItemClickListener: OnItemClickLevelListener,
    var viewType: Int
) :FrameLayout(mContext) , OnItemClickListener {
    private var mList :MutableList<String> = ArrayList<String>()
    var mAdapter : HotCityAdapter?=null
    init {
        val view = inflate(mContext, R.layout.layout_hot_city, null)
        addView(view)

        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = HotCityAdapter(mContext,mList,this)
        rv_hot_city.layoutManager = GridLayoutManager(mContext,4)
        rv_hot_city.adapter = mAdapter

    }


    override fun onItemClick(view: View, position: Int) {
        mOnItemClickListener.onItemClick(view,viewType,position)
    }
}
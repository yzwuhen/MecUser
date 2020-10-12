package com.example.mechanicalapp.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.ktapp.views.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.GoodsDetailsActivity
import com.example.mechanicalapp.ui.activity.MoreDataActivity
import com.example.mechanicalapp.ui.activity.MorePartsActivity
import com.example.mechanicalapp.ui.activity.PartsLeaseDetailsActivity
import com.example.mechanicalapp.ui.adapter.HotPartsAdapter
import kotlinx.android.synthetic.main.layout_hot_parts.view.*

class HosPartsView(var mContext: Context) : LinearLayout(mContext) , OnItemClickListener {
    private var mList :MutableList<String> = ArrayList<String>()
    var mAdapter : HotPartsAdapter?=null
    init {
        orientation = VERTICAL;
        val view = inflate(mContext, R.layout.layout_hot_parts, null)
        addView(view)

        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = HotPartsAdapter(mContext,mList,this)
        recy_hot_parts.addItemDecoration(MyDecoration(2))
        recy_hot_parts.layoutManager = GridLayoutManager(mContext,2)
        recy_hot_parts.adapter = mAdapter

        tv_parts_more.setOnClickListener(View.OnClickListener { jumAct() })
    }


    override fun onItemClick(view: View, position: Int) {
        jumAct1()
    }
    private fun jumAct1() {
        val intent = Intent()
        intent.setClass(mContext, GoodsDetailsActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        mContext.startActivity(intent)
    }
    private fun jumAct() {
        val intent = Intent()
        intent.setClass(mContext, MorePartsActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        mContext.startActivity(intent)
    }
}
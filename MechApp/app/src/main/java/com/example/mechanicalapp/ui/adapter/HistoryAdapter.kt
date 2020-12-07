package com.example.mechanicalapp.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.widget.FlowLayout
import com.example.mechanicalapp.ui.widget.TagAdapter


class HistoryAdapter(var mList: MutableList<String>,var mOnItemClickListener: OnItemClickListener) : TagAdapter<String>(mList) {
    var ly :View ?=null
    var tv :TextView ?=null
    var iv:ImageView ?=null
    override fun getView(parent: FlowLayout?, position: Int, t: String?): View {
        ly = View.inflate(parent!!.context,R.layout.item_search_tv,null)
        tv = ly?.findViewById(R.id.tv_history_tv)
        iv =ly?.findViewById(R.id.iv_del)
        tv?.text ="$t"

        iv?.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(iv!!,position) })
        tv?.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(tv!!,position) })
        return (ly as View?)!!
    }
}
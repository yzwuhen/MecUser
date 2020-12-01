package com.example.mechanicalapp.ui.adapter

import android.view.View
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.widget.FlowLayout
import com.example.mechanicalapp.ui.widget.TagAdapter


class HistoryAdapter(var mList: MutableList<String>) : TagAdapter<String>(mList) {
    var ly :View ?=null
    var tv :TextView ?=null
    override fun getView(parent: FlowLayout?, position: Int, t: String?): View {
        ly = View.inflate(parent!!.context,R.layout.item_search_tv,null)
        tv = ly?.findViewById(R.id.tv_history_tv)
        tv?.text ="$t"
        return (ly as View?)!!
    }
}
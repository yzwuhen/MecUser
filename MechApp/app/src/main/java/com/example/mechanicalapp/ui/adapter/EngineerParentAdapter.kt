package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.EngLetterParentData
import kotlinx.android.synthetic.main.item_type_right.view.*

class EngineerParentAdapter (
    var mContext: Context,
    var mList: List<EngLetterParentData>,
    private var mOnItemClickLevelListener: OnItemClickLevelListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EngineerParentVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_type_right,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_type.text = "${mList[position].key}"
        var mRightAdapter = EngineerAdapter(
            mContext,
            mList[position].data,
            position,
            mOnItemClickLevelListener
        )
        holder.itemView.item_recycler.layoutManager =LinearLayoutManager(mContext)
        holder.itemView.item_recycler.adapter = mRightAdapter
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class EngineerParentVh(itemView: View) :
        RecyclerView.ViewHolder(itemView)
}
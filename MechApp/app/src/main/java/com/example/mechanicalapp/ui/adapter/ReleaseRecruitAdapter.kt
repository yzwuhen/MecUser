package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_release_recruit.view.*

class ReleaseRecruitAdapter  (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReleaseRecruitVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_release_recruit, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

        return mList.size
    }



    class ReleaseRecruitVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })
            itemView.tv_del.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.tv_del,adapterPosition) })
            itemView.tv_refresh.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.tv_refresh,adapterPosition) })
            itemView.tv_down.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.tv_down,adapterPosition) })
        }
    }
}
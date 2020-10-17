package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_release_job_want.view.*

class ReleaseJobWantAdapter (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var isShow:Boolean=false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ReleaseJobWantVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_release_job_want, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isShow){
            holder.itemView.ly_check.visibility = View.VISIBLE
        }else{
            holder.itemView.ly_check.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    fun showCheck(showCheck: Boolean) {
        isShow = showCheck

    }


    class ReleaseJobWantVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })
            itemView.tv_del.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.tv_del,adapterPosition) })
            itemView.tv_refresh.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.tv_refresh,adapterPosition) })
            itemView.tv_down.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.tv_down,adapterPosition) })
        }
    }
}
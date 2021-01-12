package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.IntegralData
import kotlinx.android.synthetic.main.item_integral.view.*

class IntegralAdapter (var mContext: Context, var mList:MutableList<IntegralData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return IntegralVh(View.inflate(parent.context, R.layout.item_integral,null))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_integral_info.text =mList[position].updateAction

        holder.itemView.tv_time.text =mList[position].createTime
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class IntegralVh (itemView: View): RecyclerView.ViewHolder(itemView)
}
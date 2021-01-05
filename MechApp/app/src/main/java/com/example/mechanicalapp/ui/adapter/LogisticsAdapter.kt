package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.LogisticsData
import kotlinx.android.synthetic.main.item_logistics.view.*

class LogisticsAdapter (var mContext: Context, var mList: List<LogisticsData.TracesBean>, var mOnItemClickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LogisticsAdapterVh(LayoutInflater.from(mContext).inflate(R.layout.item_logistics, parent, false), mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_logistics_info.text = mList[position].acceptStation
        holder.itemView.tv_time.text =mList[position].acceptTime
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class LogisticsAdapterVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
     init {
         itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
     }
    }
}
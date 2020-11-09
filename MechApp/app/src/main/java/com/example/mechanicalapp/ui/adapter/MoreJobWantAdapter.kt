package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.RecruitData
import com.example.mechanicalapp.utils.DateUtils
import kotlinx.android.synthetic.main.item_more_job_want.view.*

class MoreJobWantAdapter (var mContext: Context, var mList:MutableList<RecruitData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MoreJobWantVh(LayoutInflater.from(mContext).inflate(R.layout.item_more_job_want,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_job_info.text=mList[position].jobTittle
        if (mList[position].price>0){
            holder.itemView.tv_label.visibility =View.GONE
            holder.itemView.tv_salary.visibility =View.VISIBLE
            holder.itemView.tv_salary.text =mList[position].price_dictText
        }else{
            holder.itemView.tv_label.visibility =View.VISIBLE
            holder.itemView.tv_salary.visibility =View.GONE
        }

        //   holder.itemView.tv_recruit_exp.text =mList[position].

        holder.itemView.tv_age.text ="${mList[position].needNumber}岁"
        holder.itemView.tv_job_seekers.text="求职者·${mList[position].contactName}"
        holder.itemView.tv_time.text =DateUtils.dateDiffs(mList[position].updateTime,System.currentTimeMillis())
    }

    override fun getItemCount(): Int {

        return mList.size
    }



    class MoreJobWantVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.data.RecruitData
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_job_want.view.*



class JobWantAdapter  (var mContext: Context, var mList:MutableList<RecruitData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var isShow:Boolean=false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return JobWantVh(View.inflate(parent.context, R.layout.item_job_want,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isShow){
            holder.itemView.ly_check.visibility =View.VISIBLE
            holder.itemView.iv_check.isSelected =mList[position].isSelect
        }else{
            holder.itemView.ly_check.visibility =View.GONE
        }

        holder.itemView.tv_job_info.text=mList[position].jobtitle
        if (mList[position].price>0){
            holder.itemView.tv_label.visibility =View.GONE
            holder.itemView.tv_salary.visibility =View.VISIBLE
            holder.itemView.tv_salary.text =mList[position].price_dictText
        }else{
            holder.itemView.tv_label.visibility =View.VISIBLE
            holder.itemView.tv_salary.visibility =View.GONE
        }

        //   holder.itemView.tv_recruit_exp.text =mList[position].
        ImageLoadUtils.loadCircle(mContext,holder.itemView.iv_job_pic,mList[position].avatar)
        holder.itemView.tv_age.text ="${mList[position].needNumber}岁"
        holder.itemView.tv_job_seekers.text="求职者·${mList[position].contactName}"
        holder.itemView.tv_time.text = DateUtils.dateDiffs(mList[position].updateTime,System.currentTimeMillis())
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    fun showCheck(showCheck: Boolean) {
        isShow = showCheck

    }


    class JobWantVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.root_view,adapterPosition) })
            itemView.ly_check.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_check,adapterPosition) })
        }
    }
}
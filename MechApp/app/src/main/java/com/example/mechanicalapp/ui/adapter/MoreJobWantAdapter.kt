package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amap.api.location.CoordinateConverter
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.RecruitData
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.GdMapUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_more_job_want.view.*


class MoreJobWantAdapter (var mContext: Context, var mList:MutableList<RecruitData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MoreJobWantVh(LayoutInflater.from(mContext).inflate(R.layout.item_more_job_want,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_job_info.text =mList[position].jobTittle
        holder.itemView.tv_address.text =mList[position].city

        if (mList[position].price_dictText=="面议"){
            holder.itemView.tv_salary.visibility =View.GONE
            holder.itemView.tv_label.visibility =View.VISIBLE
        }else{
            holder.itemView.tv_salary.visibility =View.VISIBLE
            holder.itemView.tv_label.visibility =View.GONE
            holder.itemView.tv_salary.text =mList[position].price_dictText
        }
        holder.itemView.tv_recruit_exp.text =mList[position].jobEx_dictText

        holder.itemView.tv_distance.text ="距离：${
            StringUtils.getDistance(
                CoordinateConverter.calculateLineDistance(
                    App.getInstance().thisPoint,
                    GdMapUtils.getPoint(mList[position].gpsLat, mList[position].gpsLon)
                )
            )
        }km"
        holder.itemView.tv_job_seekers.text ="${mList[position].realname}·求职者 "


        ImageLoadUtils.loadCircle(mContext,holder.itemView.iv_job_pic,mList[position].avatar)
        holder.itemView.tv_time.text = DateUtils.dateDiffs(mList[position].updateTime, System.currentTimeMillis())

        holder.itemView.tv_sex.text =mList[position].sex_dictText

        if (TextUtils.isEmpty(mList[position].birthday)){
            holder.itemView.tv_age.text="0岁"
        }else{
            holder.itemView.tv_age.text="${DateUtils.getAge(DateUtils.strToDate(mList[position].birthday))}岁"
        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }



    class MoreJobWantVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
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
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_look_recruit.view.*

class LookRecruitAdapter  (var mContext: Context, var mList:MutableList<RecruitData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LookRecruitVh(LayoutInflater.from(mContext).inflate(R.layout.item_look_recruit,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_recruit_title.text =mList[position].jobtitle
        holder.itemView.tv_recruit_address.text =mList[position].city
         holder.itemView.tv_recruit_exp.text =mList[position].jobEx_dictText
        holder.itemView.tv_recruit_num.text="${mList[position].needNumber}人"
        holder.itemView.tv_recruit_distance.text ="距离：${
            StringUtils.getDistance(
                CoordinateConverter.calculateLineDistance(
                    App.getInstance().thisPoint,
                    GdMapUtils.getPoint(mList[position].gpsLat, mList[position].gpsLon)
                )
            )
        }km"
        holder.itemView.tv_recruit_user.text ="${mList[position].realname}·招聘"

        if (mList[position].isPerson=="1"){
            holder.itemView.iv_ser.visibility =View.VISIBLE
        }else{
            holder.itemView.iv_ser.visibility =View.GONE
        }

        holder.itemView.tv_recruit_time.text = DateUtils.dateDiffs(mList[position].updateTime, System.currentTimeMillis())

    }

    override fun getItemCount(): Int {

        return mList.size
    }



    class LookRecruitVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
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
import com.example.mechanicalapp.ui.data.MecLeaseData
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.GdMapUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_more_user_rent.view.*

class MoreUserRentAdapter  (var mContext: Context, var mList:MutableList<MecLeaseData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MoreUserRentVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_more_user_rent, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_rent_user_nick.text =mList[position].contactName

        holder.itemView.tv_rent_address_data.text="${mList[position].city} | 租用时间：${mList[position].tenancy}天"

        holder.itemView.tv_rent_equipment.text =mList[position].title

        holder.itemView.tv_rent_distance.text = "距离：${StringUtils.getDistance(
            CoordinateConverter.calculateLineDistance(
                App.getInstance().thisPoint,
                GdMapUtils.getPoint(mList[position].gpsLat, mList[position].gpsLon)
            )
        )}km"
        holder.itemView.tv_rent_time.text = DateUtils.dateDiffs(mList[position].updateTime,System.currentTimeMillis())

        if (mList[position].isPerson=="1"){
            holder.itemView.iv_rent_sr.visibility =View.VISIBLE
        }else{
            holder.itemView.iv_rent_sr.visibility =View.GONE
        }

        if (mList[position].priceUnit=="3"){
            holder.itemView.tv_rent_price.visibility =View.VISIBLE
            holder.itemView.tv_rent.visibility =View.GONE
        }else{
            holder.itemView.tv_rent_price.visibility =View.GONE
            holder.itemView.tv_rent.visibility =View.VISIBLE
            holder.itemView.tv_rent.text ="￥${mList[position].price}/${mList[position].priceUnit_dictText}"
        }

        ImageLoadUtils.loadCircle(mContext,holder.itemView.iv_rent_user,mList[position].avatar)

    }

    override fun getItemCount(): Int {

        return mList.size
    }


    class MoreUserRentVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })
        }
    }
}
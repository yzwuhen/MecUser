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
import com.example.mechanicalapp.ui.data.PartsData
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.GdMapUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_look_parts_ask.view.*

class LookPartsAskAdapter (
    var mContext: Context,
    var mList: MutableList<PartsData>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LookPartsAskVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_look_parts_ask,parent,false),mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ImageLoadUtils.loadImageCenterCrop(
            mContext, holder.itemView.iv_pic,
            StringUtils.getImgStr(mList[position].pic), R.mipmap.ic_launcher
        )

        holder.itemView.tv_title.text = mList[position].title

        holder.itemView.tv_address_data.text =
            "${mList[position].city} | ${mList[position].partsType}"

        holder.itemView.tv_distance.text = "距离：${
            StringUtils.getDistance(
                CoordinateConverter.calculateLineDistance(
                    App.getInstance().thisPoint,
                    GdMapUtils.getPoint(mList[position].gpsLat, mList[position].gpsLon)
                )
            )
        }km"



        if (mList[position].isPerson ==1) {
            holder.itemView.iv_sr.visibility = View.VISIBLE
        } else {
            holder.itemView.iv_sr.visibility = View.GONE
        }

        if (mList[position].isEnterprise == "1") {
            holder.itemView.iv_qy.visibility = View.VISIBLE
        } else {
            holder.itemView.iv_qy.visibility = View.GONE
        }

        holder.itemView.tv_rent.text =
            "￥${mList[position].price}/${mList[position].priceUnit_dictText}"

        holder.itemView.tv_time.text =
            DateUtils.dateDiffs(mList[position].updateTime, System.currentTimeMillis())
    }

    override fun getItemCount(): Int {

        return mList.size
    }


    class LookPartsAskVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView,
                    adapterPosition
                )
            })
        }
    }
}
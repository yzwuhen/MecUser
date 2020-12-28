package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amap.api.location.CoordinateConverter
import com.bumptech.glide.Glide
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.PartsData
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.GdMapUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_parts.view.*

/**
 * 配件Adapter
 */
class PartsAdapter (var mContext: Context, var mList:MutableList<PartsData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isShow:Boolean=false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PartsVh(LayoutInflater.from(mContext).inflate(R.layout.item_parts,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isShow){
            holder.itemView.ly_check.visibility =View.VISIBLE
            holder.itemView.iv_check.isSelected =mList[position].isSelect
        }else{
            holder.itemView.ly_check.visibility =View.GONE
        }

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



        if (mList[position].isPerson == 1) {
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


    fun showCheck(showCheck: Boolean) {
        isShow = showCheck

    }

    class PartsVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.root_view,adapterPosition) })
            itemView.ly_check.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_check,adapterPosition) })
        }
    }
}
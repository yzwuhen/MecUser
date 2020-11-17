package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amap.api.location.CoordinateConverter.calculateLineDistance
import com.amap.api.location.DPoint
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.MecLeaseData
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.GdMapUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_release_lease.view.*

class ReleaseLeaseAdapter (var mContext: Context, var mList:MutableList<MecLeaseData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ReleaseLeaseVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_release_lease, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_pic,mList[position].pic,R.mipmap.ic_launcher)

        holder.itemView.tv_title.text =mList[position].tittle

        holder.itemView.tv_address_data.text="${mList[position].city} | ${mList[position].facDate}"

        holder.itemView.tv_distance.text="距离：${StringUtils.getDistance(calculateLineDistance(App.getInstance().thisPoint ,GdMapUtils.getPoint(mList[position].gpsLat,mList[position].gpsLon)))}km"

        if (mList[position].isNew == "1"){
            holder.itemView.tv_label.visibility=View.VISIBLE
        }else{
            holder.itemView.tv_label.visibility=View.GONE
        }

        if (mList[position].isPerson == "1"){
            holder.itemView.iv_sr.visibility=View.VISIBLE
        }else{
            holder.itemView.iv_sr.visibility=View.GONE
        }
        //是否上架
        if (mList[position].isOn == "1"){
            holder.itemView.tv_down.text="下架"
        }else{
            holder.itemView.tv_down.text="重新上架"
        }

        if (mList[position].isEnterprise == "1"){
            holder.itemView.iv_qy.visibility=View.VISIBLE
        }else{
            holder.itemView.iv_qy.visibility=View.GONE
        }
        holder.itemView.tv_work_time.text="工作时长${mList[position].workTime}"

        holder.itemView.tv_rent.text="￥${mList[position].price}/${mList[position].priceUnit_dictText}"

        holder.itemView.tv_time.text= DateUtils.dateDiffs(mList[position].updateTime,System.currentTimeMillis())

        if (DateUtils.getUserDate("yyyy-mm-dd")==mList[position].createTime){
            holder.itemView.tv_new_up.visibility =View.VISIBLE
        }else{
            holder.itemView.tv_new_up.visibility =View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }


    class ReleaseLeaseVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })
            itemView.tv_del.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.tv_del,adapterPosition) })
            itemView.tv_refresh.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.tv_refresh,adapterPosition) })
            itemView.tv_down.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.tv_down,adapterPosition) })
        }
    }
}
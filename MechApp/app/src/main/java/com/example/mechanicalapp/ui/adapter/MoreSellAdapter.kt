package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.MecSellData
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_more_sell.view.*

class MoreSellAdapter  (var mContext: Context, var mList:MutableList<MecSellData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isShow:Boolean=false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MoreSellVh(LayoutInflater.from(mContext).inflate(R.layout.item_more_sell,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_pic,mList[position].pic, R.mipmap.ic_launcher)

        holder.itemView.tv_title.text =mList[position].title

        holder.itemView.tv_address_data.text="${mList[position].city} | ${mList[position].facDate}"

        holder.itemView.tv_distance.text="距离：${mList[position].gpsLon}"

        if (mList[position].isNew == "0"){
            holder.itemView.tv_label.visibility= View.VISIBLE
        }else{
            holder.itemView.tv_label.visibility= View.GONE
        }

        if (DateUtils.getUserDate("yyyy-mm-dd")==mList[position].createTime){
            holder.itemView.tv_new_pic.visibility =View.VISIBLE
        }else{
            holder.itemView.tv_new_pic.visibility =View.INVISIBLE
        }

        if (mList[position].isPerson == "1"){
            holder.itemView.iv_sr.visibility= View.VISIBLE
        }else{
            holder.itemView.iv_sr.visibility= View.GONE
        }

        if (mList[position].isEnterprise == "1"){
            holder.itemView.iv_qy.visibility= View.VISIBLE
        }else{
            holder.itemView.iv_qy.visibility= View.GONE
        }

        holder.itemView.tv_rent.text="￥${mList[position].price}"

        holder.itemView.tv_time.text= DateUtils.dateDiffs(mList[position].updateTime,System.currentTimeMillis())
    }

    override fun getItemCount(): Int {

        return mList.size
    }



    class MoreSellVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })

        }
    }
}
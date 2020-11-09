package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.data.HomePartsData
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_hot_parts.view.*

class HotPartsAdapter (var mContext: Context, var mList:MutableList<HomePartsData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HotPartVh(View.inflate(parent.context, R.layout.item_hot_parts,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_goods_pic,mList[position].img.split(",")[0],R.mipmap.ic_launcher)
        holder.itemView.tv_goods_title.text = mList[position].title
        holder.itemView.tv_goods_price.text ="￥${mList[position].price}"
        holder.itemView.tv_pay_num.text="${mList[position].scale}人付款"


    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class HotPartVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
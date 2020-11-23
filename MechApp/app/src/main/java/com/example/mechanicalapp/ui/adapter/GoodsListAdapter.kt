package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.GoodsData
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_goods_list.view.*

class GoodsListAdapter (var mContext: Context, var mList:MutableList<GoodsData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HotPartVh(View.inflate(parent.context, R.layout.item_goods_list,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_goods_pic, StringUtils.getImgStr(mList[position].img),R.mipmap.ic_launcher)
        holder.itemView.tv_goods_title.text =mList[position].title
        holder.itemView.tv_goods_price.text ="￥${mList[position].price}"
        holder.itemView.tv_pay_num.text ="已售${mList[position].scale}件"
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
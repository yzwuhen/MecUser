package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.GoodsDetails
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_sure_order_goods.view.*

class SureOrderGoodsAdapter  (var mContext: Context, var mList:MutableList<GoodsDetails.SkuListBean>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SureOrderGoodsVh(LayoutInflater.from(mContext).inflate(R.layout.item_sure_order_goods,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_goods_pic,mList[position].picture,R.mipmap.ic_launcher)

        holder.itemView.tv_attr.text =mList[position].name
        holder.itemView.tv_title.text ="￥${mList[position].mecProductName}"
        holder.itemView.tv_price.text ="￥${mList[position].price}"
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class SureOrderGoodsVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
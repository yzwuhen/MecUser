package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.ShopCarData
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_shop_car.view.*

class ShopCarAdapter (var mContext: Context, var mList:MutableList<ShopCarData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var isShowCheck=false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShopCarVh(View.inflate(parent.context, R.layout.item_shop_car,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_goods_pic,StringUtils.getImgStr(mList[position].picture),R.mipmap.ic_launcher)

        holder.itemView.tv_title.text =mList[position].productName
        holder.itemView.tv_attr.text =mList[position].skuName
        holder.itemView.tv_price.text ="￥${mList[position].price}"
        holder.itemView.tv_num.text ="${mList[position].quantity}"
        holder.itemView.iv_check.isSelected =mList[position].isSelect
    }

    override fun getItemCount(): Int {

        return mList.size
    }


    class ShopCarVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {

            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })
            itemView.tv_attr.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.tv_attr,adapterPosition) })
            itemView.ly_reduce.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_reduce,adapterPosition) })
            itemView.ly_add.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_add,adapterPosition) })
            itemView.tv_num.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.tv_num,adapterPosition) })
            itemView.ly_check.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_check,adapterPosition) })
        }
    }
}
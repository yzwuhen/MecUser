package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.PartsOrderData
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_parts_order_child.view.*

class PartsOrderChildAdapter (
    var mContext: Context,
    var mList: MutableList<PartsOrderData.OrderItemListBean>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PartsOrderChildVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_parts_order_child, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_title.text =mList[position].prodName
        holder.itemView.tv_num.text = "x${mList[position].quantity}"
        holder.itemView.tv_attr.text =mList[position].skuName
        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_pic,
            StringUtils.getImgStr(mList[position].productSkuImg),R.mipmap.ic_launcher)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class PartsOrderChildVh(itemView: View) :
        RecyclerView.ViewHolder(itemView)
}
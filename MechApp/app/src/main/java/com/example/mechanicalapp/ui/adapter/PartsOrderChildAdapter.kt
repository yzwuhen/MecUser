package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.PartsOrderGoodsList
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_parts_order_child.view.*

/**
 *  mOnItemClickListener 可以为空  订单详情和订单申请退款用到了但是不需要回调
 *  订单列表用到了 需要回调，不然列表点击时没反应
 *
 */
class PartsOrderChildAdapter (
    var mContext: Context,
    var mList: List<PartsOrderGoodsList>,
    var  parentPosition:Int,
    var mOnItemClickListener: OnItemClickListener?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PartsOrderChildVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_parts_order_child, parent, false),parentPosition,mOnItemClickListener
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
    class PartsOrderChildVh(itemView: View,parentPosition: Int, onItemClickListener: OnItemClickListener?) :
        RecyclerView.ViewHolder(itemView){
        init {
            if (onItemClickListener!=null){
                itemView.setOnClickListener(View.OnClickListener { onItemClickListener.onItemClick(itemView.item_child_root,parentPosition) })
            }
        }
    }
}
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
import kotlinx.android.synthetic.main.item_look_goods.view.*
class LookGoodsAdapter (var mContext: Context, var mList:MutableList<GoodsData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LookGoodsVh(View.inflate(parent.context, R.layout.item_look_goods,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_goods_pic, StringUtils.getImgStr(mList[position].img),R.mipmap.ic_launcher)

        holder.itemView.tv_title.text =mList[position].title
        holder.itemView.tv_price.text ="￥${mList[position].price}"
    }

    override fun getItemCount(): Int {

        return mList.size
    }


    class LookGoodsVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {

            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.FactoryData
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_mec_factory_shop.view.*

class MecFactoryShopAdapter (var mContext: Context, var mList:MutableList<FactoryData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MecFactoryShopVh( LayoutInflater.from(mContext).inflate(R.layout.item_mec_factory_shop,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.iv_check.isSelected =mList[position].isSelect

        holder.itemView.tv_item_title.text =mList[position].name
        holder.itemView.tv_address.text ="${mList[position].address}  |"
        holder.itemView.tv_introduce.text ="简介：${mList[position].introduction}"
        holder.itemView.tv_score.text ="${mList[position].star}分"

        ImageLoadUtils.loadImage(mContext,holder.itemView.iv_item_pic,mList[position].factoryPicture,R.mipmap.ic_launcher)
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class MecFactoryShopVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_item_mec_factory,adapterPosition) })
        }
    }
}
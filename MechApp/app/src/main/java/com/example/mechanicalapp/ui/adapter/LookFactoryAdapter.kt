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
import kotlinx.android.synthetic.main.item_look_factory.view.*
import kotlinx.android.synthetic.main.item_look_factory.view.iv_item_pic
import kotlinx.android.synthetic.main.item_look_factory.view.tv_address
import kotlinx.android.synthetic.main.item_look_factory.view.tv_introduce
import kotlinx.android.synthetic.main.item_look_factory.view.tv_item_title
import kotlinx.android.synthetic.main.item_mec_factory.view.*

class LookFactoryAdapter  (var mContext: Context, var mList:MutableList<FactoryData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MecFactoryVh(  LayoutInflater.from(mContext).inflate(R.layout.item_look_factory, parent, false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_item_title.text =mList[position].name
        holder.itemView.tv_address.text ="${mList[position].address}  |"
        holder.itemView.tv_introduce.text ="简介：${mList[position].introduction}"

        ImageLoadUtils.loadImage(mContext,holder.itemView.iv_item_pic,mList[position].factoryPicture,R.mipmap.ic_launcher)
    }

    override fun getItemCount(): Int {

        return mList.size
    }


    class MecFactoryVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
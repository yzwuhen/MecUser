package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_shop_car.view.*

class ShopCarAdapter (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShopCarVh(View.inflate(parent.context, R.layout.item_shop_car,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        holder.itemView.tv_text = mList[position]
      //  holder.itemView.tv_attr.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(holder.itemView.tv_attr,position) })
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class ShopCarVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {

            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })
            itemView.tv_attr.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.tv_attr,adapterPosition) })
//            itemView.setOnLongClickListener(View.OnLongClickListener {  })
        }
    }
}
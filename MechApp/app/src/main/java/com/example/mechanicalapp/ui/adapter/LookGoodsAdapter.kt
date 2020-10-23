package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_look_goods.view.*

class LookGoodsAdapter (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LookGoodsVh(View.inflate(parent.context, R.layout.item_look_goods,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position%3==0){
            holder.itemView.tv_date.visibility =View.VISIBLE
        }else{
            holder.itemView.tv_date.visibility =View.GONE
        }
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
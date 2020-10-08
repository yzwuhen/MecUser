package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_address.view.*

class MyAddressAdapter (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyAddressVh(LayoutInflater.from(mContext).inflate(R.layout.item_address,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position==0){
            holder.itemView.tv_check.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_check_s,0,0,0)
        }else{
            holder.itemView.tv_check.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_fff_cacaca,0,0,0)
        }

    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class MyAddressVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_root,adapterPosition) })
            itemView.tv_check.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick( itemView.tv_check,adapterPosition) })
            itemView.tv_edit.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.tv_edit,adapterPosition) })
            itemView.tv_del.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick( itemView.tv_del,adapterPosition) })
        }
    }
}
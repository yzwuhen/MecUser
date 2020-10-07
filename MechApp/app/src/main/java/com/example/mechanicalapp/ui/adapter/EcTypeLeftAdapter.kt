package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import kotlinx.android.synthetic.main.item_ec_type_left.view.*

class EcTypeLeftAdapter (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EcTypeLeftVh(View.inflate(parent.context, R.layout.item_ec_type_left,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_type.text = mList[position]
        holder.itemView.tv_type.isSelected = position==2
        if (position ==2){
            holder.itemView.tv_type.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tv_h_50,0,0,0)
        }else{
            holder.itemView.tv_type.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
        }

    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class EcTypeLeftVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
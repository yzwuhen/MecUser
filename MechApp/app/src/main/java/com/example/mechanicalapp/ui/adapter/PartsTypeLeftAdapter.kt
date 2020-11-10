package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_ec_type_left.view.*

class PartsTypeLeftAdapter  (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PartsTypeLeftVh(View.inflate(parent.context, R.layout.item_ec_type_left,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_type.text = mList[position]
        holder.itemView.tv_type.isSelected = position ==2

    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class PartsTypeLeftVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.tv_type,adapterPosition) })
        }
    }
}
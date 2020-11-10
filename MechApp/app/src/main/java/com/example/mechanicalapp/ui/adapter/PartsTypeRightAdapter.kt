package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_ec_type_right.view.*

class PartsTypeRightAdapter (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PartsTypeRightVh(LayoutInflater.from(mContext).inflate(R.layout.item_ec_type_right,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_type_name.text = mList[position]
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class PartsTypeRightVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.ly_type.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_type,adapterPosition) })
        }
    }
}
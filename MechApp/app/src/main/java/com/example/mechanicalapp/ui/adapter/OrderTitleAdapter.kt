package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.CodeData
import kotlinx.android.synthetic.main.item_order_tv.view.*

class OrderTitleAdapter(
    var mContext: Context,
    var mList: List<CodeData>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return OrderTitleVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_order_tv, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_text.text = mList[position].itemText
        holder.itemView.tv_text.isSelected =mList[position].isSelect
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class OrderTitleVh(
        itemView: View,
        mOnItemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView,
                    adapterPosition
                )
            })
        }
    }
}
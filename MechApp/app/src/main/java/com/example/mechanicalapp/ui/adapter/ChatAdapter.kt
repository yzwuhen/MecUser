package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.`interface`.OnItemLongClick

class ChatAdapter(var mContext: Context, var mList: MutableList<String>, var mOnItemClickListener: OnItemClickListener, var mOnItemLongClick: OnItemLongClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ChatVh(LayoutInflater.from(mContext).inflate(R.layout.item_chat, parent, false), mOnItemClickListener, mOnItemLongClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ChatVh(itemView: View, mOnItemClickListener: OnItemClickListener,var  mOnItemLongClick: OnItemLongClick) : RecyclerView.ViewHolder(itemView),View.OnLongClickListener {
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView, adapterPosition) })
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {

            mOnItemLongClick.onItemLongClick(itemView, adapterPosition)
            return true
        }
    }
}
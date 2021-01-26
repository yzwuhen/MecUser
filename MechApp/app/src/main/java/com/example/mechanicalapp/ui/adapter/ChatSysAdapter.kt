package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.SysMsgData
import kotlinx.android.synthetic.main.item_chat_sys.view.*

class ChatSysAdapter (var mContext: Context, var mList:MutableList<SysMsgData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ChatVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_chat_sys, parent, false),mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_title.text = mList[position].title
        holder.itemView.tv_msg.text =Html.fromHtml(mList[position].content)
        holder.itemView.tv_time.text =
            mList[position]?.createTime
        if (mList[position].isRead=="1"){
            holder.itemView.tv_title.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
        }else{
            holder.itemView.tv_title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_red,0,0,0)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ChatVh(itemView: View, mOnItemClickListener: OnItemClickListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
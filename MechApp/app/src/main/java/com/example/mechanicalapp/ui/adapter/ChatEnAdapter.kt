package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.`interface`.OnItemLongClick
import com.netease.nim.uikit.common.util.sys.TimeUtil
import com.netease.nimlib.sdk.msg.model.RecentContact
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatEnAdapter (var mContext: Context, var mList: MutableList<RecentContact>, var mOnItemClickListener: OnItemClickListener, var mOnItemLongClick: OnItemLongClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ChatEnVh(LayoutInflater.from(mContext).inflate(R.layout.item_chat_en, parent, false), mOnItemClickListener, mOnItemLongClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_user_nick.text = mList[position]?.contactId
        holder.itemView.tv_msg.text = mList[position]?.content
        if (mList[position]?.unreadCount!! >0){
            holder.itemView.tv_msg_num.visibility =View.VISIBLE
        }else{
            holder.itemView.tv_msg_num.visibility = View.GONE
        }
        holder.itemView.tv_msg_num.text =mList[position]?.unreadCount.toString()

        holder.itemView.tv_time.text =
            mList[position]?.time?.let { TimeUtil.getTimeShowString(it, true) };
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ChatEnVh(itemView: View, mOnItemClickListener: OnItemClickListener,var  mOnItemLongClick: OnItemLongClick) : RecyclerView.ViewHolder(itemView),View.OnLongClickListener {
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_chat_root, adapterPosition) })
            itemView.setOnLongClickListener(this)
        }
        override fun onLongClick(v: View?): Boolean {

            mOnItemLongClick.onItemLongClick(itemView, adapterPosition)
            return true
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.CommentData
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentAdapter  (var mContext: Context, var mlist:MutableList<CommentData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommentVh(LayoutInflater.from(mContext).inflate(R.layout.item_comment,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_comment_pic,mlist[position].commentUserHeader,R.mipmap.ic_launcher)
        holder.itemView.tv_comment_user_name.text =mlist[position].commentUserName
        holder.itemView.tv_buy_info.text ="${mlist[position].mecProductSkuName}"
        holder.itemView.tv_comment.text =mlist[position].content
        holder.itemView.ratingBar.rating =mlist[position].star

    }

    override fun getItemCount(): Int {

        return mlist.size
    }

    class CommentVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
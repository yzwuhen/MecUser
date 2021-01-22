package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.FactoryCommentData
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_factory_comment.view.*

class FactoryCommentAdapter  (var mContext: Context, var mlist:MutableList<FactoryCommentData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommentVh(LayoutInflater.from(mContext).inflate(R.layout.item_factory_comment,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_comment_pic,mlist[position].customerHeadPic,
            R.mipmap.ic_launcher)
        holder.itemView.tv_comment_user_name.text =mlist[position].customerName
        holder.itemView.tv_comment.text =mlist[position].commentContent
        holder.itemView.comment_ratingBar.rating =mlist[position].starLevel

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
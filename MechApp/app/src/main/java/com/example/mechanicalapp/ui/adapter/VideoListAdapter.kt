package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.CameraListData
import kotlinx.android.synthetic.main.item_video_list.view.*

class VideoListAdapter (var mContext: Context, var mList:MutableList<CameraListData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VideoListVh(LayoutInflater.from(mContext).inflate(R.layout.item_video_list,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(mContext)
            .load("https://t8.baidu.com/it/u=2247852322,986532796&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1600708280&t=2c8b3ed72148e0c4fb274061565e6723")
            .into(holder.itemView.iv_pic)
        if (position%2==0) {
            holder.itemView.iv_state.setImageResource(R.mipmap.pause_icon)
        } else {
            holder.itemView.iv_state.setImageResource(R.mipmap.play_icon)
        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class VideoListVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import kotlinx.android.synthetic.main.item_user_demand.view.*

class UserDemandAdapter(var mContext:Context,var mList:MutableList<String>,var type:Int,var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isShow:Boolean=false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return UserDemandVh(LayoutInflater.from(mContext).inflate(R.layout.item_user_demand,parent,false),type,mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (isShow){
            holder.itemView.ly_check.visibility =View.VISIBLE
        }else{
            holder.itemView.ly_check.visibility =View.GONE
        }
        Glide.with(mContext).load("https://t8.baidu.com/it/u=2247852322,986532796&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1600708280&t=2c8b3ed72148e0c4fb274061565e6723").into(  holder.itemView.iv_pic);
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    fun showCheck(showCheck: Boolean) {
        isShow = showCheck

    }

    class UserDemandVh(itemView: View, type:Int,mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
            if (type==1){
                itemView.tv_new_pic.visibility =View.GONE
            }
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItmeClickTyleListener

class SpecAdapter  (var mContext: Context, var mList:MutableList<String>,var type:Int, var mOnItemClickListener: OnItmeClickTyleListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SpecVh(LayoutInflater.from(mContext).inflate(R.layout.item_spec,parent,false),mOnItemClickListener,type)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class SpecVh(itemView: View, mOnItemClickListener: OnItmeClickTyleListener,type:Int) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition,type) })
        }
    }
}
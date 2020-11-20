package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.Spec
import kotlinx.android.synthetic.main.activity_goods_details.view.*

class SpecAdapter  (var mContext: Context, var mList:MutableList<Spec>,var type:Int, var mOnItemClickListener: OnItemClickLevelListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SpecVh(LayoutInflater.from(mContext).inflate(R.layout.item_spec,parent,false),mOnItemClickListener,type)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_specs.text =mList[position].specName
        holder.itemView.tv_specs.isSelected =mList[position].isSelect
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class SpecVh(itemView: View, mOnItemClickListener: OnItemClickLevelListener, type:Int) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition,type) })
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.HotCodeData
import kotlinx.android.synthetic.main.item_hot_code.view.*

class HotCodeAdapter  (var mContext: Context, var mList:List<HotCodeData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return HotCodeVh(View.inflate(parent.context, R.layout.item_hot_code, null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_code.text=mList[position].name
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class HotCodeVh(itemView: View, mOnItemClickListener: OnItemClickListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView.root_view,adapterPosition)})
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_parts_details_list.view.*

class TravelAdapter (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TravelVh(LayoutInflater.from(mContext).inflate(R.layout.item_tarvel,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position%2==0){
            holder.itemView.tv_text_right1.setCompoundDrawablesWithIntrinsicBounds(0,0,
                R.mipmap.tip_up,0)
            holder.itemView.ly_info.visibility= View.VISIBLE
        }else{
            holder.itemView.tv_text_right1.setCompoundDrawablesWithIntrinsicBounds(0,0,
                R.mipmap.tip_down,0)
            holder.itemView.ly_info.visibility= View.GONE
        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class TravelVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
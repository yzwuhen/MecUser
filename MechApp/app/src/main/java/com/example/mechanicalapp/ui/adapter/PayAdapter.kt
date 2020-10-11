package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.PayData
import kotlinx.android.synthetic.main.item_pay.view.*

class PayAdapter (var mContext: Context, var mList:MutableList<PayData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PayVh(LayoutInflater.from(mContext).inflate(R.layout.item_pay,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_pay_name.text=mList[position].mText
        holder.itemView.tv_pay_name.setCompoundDrawablesWithIntrinsicBounds(mList[position].mIcon,0,0,0)
        holder.itemView.iv_check.isSelected=mList[position].isCheck
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class PayVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
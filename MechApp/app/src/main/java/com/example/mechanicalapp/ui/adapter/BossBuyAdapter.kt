package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.MecBuyData
import kotlinx.android.synthetic.main.item_user_rent.view.*

class BossBuyAdapter (var mContext: Context, var mList:MutableList<MecBuyData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isShow:Boolean=false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  BossBuyVh(View.inflate(parent.context, R.layout.item_user_rent,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isShow){
            holder.itemView.ly_check.visibility = View.VISIBLE
        }else{
            holder.itemView.ly_check.visibility = View.GONE
        }

        holder.itemView.tv_rent_user_nick.text =mList[position].createBy

        holder.itemView.tv_rent_address_data.text="${mList[position].city} | ${mList[position].facDate} "


    }

    override fun getItemCount(): Int {

        return mList.size
    }
    fun showCheck(showCheck: Boolean) {
        isShow = showCheck

    }

    class BossBuyVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}
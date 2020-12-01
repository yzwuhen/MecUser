package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.MecSellData
import com.example.mechanicalapp.utils.DateUtils
import kotlinx.android.synthetic.main.item_collect_buy.view.*

class CollectBuyAdapter  (var mContext: Context, var mList:MutableList<MecSellData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isShow:Boolean=false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MoreSellVh(LayoutInflater.from(mContext).inflate(R.layout.item_collect_buy,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if (isShow){
            holder.itemView.ly_check.visibility = View.VISIBLE
            holder.itemView.iv_check.isSelected =mList[position].isSelect
        }else{
            holder.itemView.ly_check.visibility = View.GONE
        }

        holder.itemView.tv_rent_user_nick.text =mList[position].contactName
        holder.itemView.tv_rent_address_data.text="${mList[position].city} | ${mList[position].facDate}"

        holder.itemView.tv_rent_equipment.text =mList[position].title

        holder.itemView.tv_rent_time.text =DateUtils.dateDiffs(mList[position].updateTime,System.currentTimeMillis())
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    fun showCheck(showCheck: Boolean) {
        isShow = showCheck

    }

    class MoreSellVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.root_view,adapterPosition) })
            itemView.ly_check.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_check,adapterPosition) })
        }
    }
}
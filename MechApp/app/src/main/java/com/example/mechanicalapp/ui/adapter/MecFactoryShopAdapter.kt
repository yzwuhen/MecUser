package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_mec_factory_shop.view.*

class MecFactoryShopAdapter (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MecFactoryShopVh(View.inflate(parent.context, R.layout.item_mec_factory_shop,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position ==1){
            holder.itemView.iv_check.setImageResource(R.drawable.circle_check_s)
        }else{
            holder.itemView.iv_check.setImageResource(R.drawable.circle_fff_cacaca)
        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class MecFactoryShopVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_item_mec_factory,adapterPosition) })
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.request.ReAddress
import kotlinx.android.synthetic.main.item_address.view.*

class MyAddressAdapter(
    var mContext: Context,
    var mList: MutableList<ReAddress>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyAddressVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_address, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_check.isSelected = mList[position].isDefault == 1
        holder.itemView.tv_name.text =mList[position].name
        holder.itemView.tv_phone.text =mList[position].phone
        holder.itemView.tv_address.text ="${mList[position].area}${mList[position].adress}"
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class MyAddressVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.ly_root,
                    adapterPosition
                )
            })
            itemView.tv_check.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_check,
                    adapterPosition
                )
            })
            itemView.tv_edit.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_edit,
                    adapterPosition
                )
            })
            itemView.tv_del.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_del,
                    adapterPosition
                )
            })
        }
    }
}
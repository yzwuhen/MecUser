package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_order.view.*

class OrderAdapter(
    var mContext: Context,
    var mList: MutableList<String>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isShow: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return OrderVh(
            View.inflate(parent.context, R.layout.item_order, null),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 1) {
            holder.itemView.tv_order_state.text = "待上门"
            holder.itemView.tv_order_num.text = "订单号：123456789774"
        } else if (position == 1) {
            holder.itemView.tv_order_state.text = "进行中"
            holder.itemView.tv_order_num.text = "订单号：123456789774"
        } else if (position == 1) {
            holder.itemView.tv_order_state.text = "待付款"
            holder.itemView.tv_order_num.text = ""
        }

    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class OrderVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView,
                    adapterPosition
                )
            })
        }
    }
}
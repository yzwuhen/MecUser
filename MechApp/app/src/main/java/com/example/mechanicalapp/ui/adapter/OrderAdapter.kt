package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.OrderData
import kotlinx.android.synthetic.main.item_order.view.*

class OrderAdapter(
    var mContext: Context,
    var mList: MutableList<OrderData>,
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
        holder.itemView.tv_order_state.text = mList[position].status_dictText
        if (!TextUtils.isEmpty(mList[position].orderNum)){
            holder.itemView.tv_order_num.text = "订单号：${mList[position].orderNum}"
        }else{
            holder.itemView.tv_order_num.text = ""
        }

        holder.itemView.tv_ec_type.text =mList[position].productType
        holder.itemView.tv_user_name.text = mList[position].customerName
        holder.itemView.tv_phone.text =mList[position].customerPhone
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
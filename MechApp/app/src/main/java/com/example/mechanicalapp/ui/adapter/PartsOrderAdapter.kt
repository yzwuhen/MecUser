package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.OrderData
import com.example.mechanicalapp.ui.data.PartsOrderData
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_parts_order.view.*

class PartsOrderAdapter(
    var mContext: Context,
    var mList: MutableList<PartsOrderData>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PartsOrderVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_parts_order, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_order_state.text = mList[position].status_dictText

        when (mList[position].status) {
            0 -> {
                holder.itemView.tv_order_num.text = "订单号：${mList[position].orderNum}"
                holder.itemView.ly_bottom.visibility = View.VISIBLE
                holder.itemView.tv_look_logistics.visibility = View.GONE
                holder.itemView.tv_apply_refund.visibility = View.GONE
                holder.itemView.tv_cancel_order.visibility = View.VISIBLE
                holder.itemView.tv_confirm.visibility = View.GONE
                holder.itemView.tv_pay.visibility = View.VISIBLE
                holder.itemView.tv_evaluate.visibility = View.GONE
                holder.itemView.tv_look_evaluate.visibility = View.GONE
                holder.itemView.tv_input_odd_num.visibility = View.GONE
                holder.itemView.tv_cancel_sale.visibility = View.GONE
            }
            1 -> {
                holder.itemView.tv_order_num.text = "订单号：${mList[position].orderNum}"
                holder.itemView.ly_bottom.visibility = View.VISIBLE
                holder.itemView.tv_look_logistics.visibility = View.GONE
                holder.itemView.tv_apply_refund.visibility = View.VISIBLE
                holder.itemView.tv_cancel_order.visibility = View.GONE
                holder.itemView.tv_confirm.visibility = View.GONE
                holder.itemView.tv_pay.visibility = View.GONE
                holder.itemView.tv_evaluate.visibility = View.GONE
                holder.itemView.tv_look_evaluate.visibility = View.GONE
                holder.itemView.tv_input_odd_num.visibility = View.GONE
                holder.itemView.tv_cancel_sale.visibility = View.GONE

            }
            2 -> {
                holder.itemView.tv_order_num.text = ""
                holder.itemView.ly_bottom.visibility = View.VISIBLE
                holder.itemView.tv_look_logistics.visibility = View.VISIBLE
                holder.itemView.tv_apply_refund.visibility = View.VISIBLE
                holder.itemView.tv_cancel_order.visibility = View.GONE
                holder.itemView.tv_confirm.visibility = View.VISIBLE
                holder.itemView.tv_pay.visibility = View.GONE
                holder.itemView.tv_evaluate.visibility = View.GONE
                holder.itemView.tv_look_evaluate.visibility = View.GONE
                holder.itemView.tv_input_odd_num.visibility = View.GONE
                holder.itemView.tv_cancel_sale.visibility = View.GONE
            }
            3 -> {
                holder.itemView.tv_order_num.text = ""
                holder.itemView.ly_bottom.visibility = View.VISIBLE
                holder.itemView.tv_look_logistics.visibility = View.GONE
                holder.itemView.tv_apply_refund.visibility = View.GONE
                holder.itemView.tv_cancel_order.visibility = View.GONE
                holder.itemView.tv_confirm.visibility = View.GONE
                holder.itemView.tv_pay.visibility = View.GONE
                holder.itemView.tv_evaluate.visibility = View.VISIBLE
                holder.itemView.tv_look_evaluate.visibility = View.GONE
                holder.itemView.tv_input_odd_num.visibility = View.GONE
                holder.itemView.tv_cancel_sale.visibility = View.GONE
            }
            4 -> {
                holder.itemView.tv_order_num.text = ""
                holder.itemView.ly_bottom.visibility = View.VISIBLE
                holder.itemView.tv_look_logistics.visibility = View.GONE
                holder.itemView.tv_apply_refund.visibility = View.GONE
                holder.itemView.tv_cancel_order.visibility = View.GONE
                holder.itemView.tv_confirm.visibility = View.GONE
                holder.itemView.tv_pay.visibility = View.GONE
                holder.itemView.tv_evaluate.visibility = View.GONE
                holder.itemView.tv_look_evaluate.visibility = View.VISIBLE

                holder.itemView.tv_input_odd_num.visibility = View.GONE
                holder.itemView.tv_cancel_sale.visibility = View.GONE
            }
            5 -> {
                holder.itemView.tv_order_num.text = ""
                holder.itemView.ly_bottom.visibility = View.GONE
            }
        }

        holder.itemView.recycle_list_item.layoutManager =LinearLayoutManager(mContext)
        var mPartsOrderChildAdapter = PartsOrderChildAdapter(mContext,mList[position].orderItemList)
        holder.itemView.recycle_list_item.adapter =mPartsOrderChildAdapter

        holder.itemView.tv_money.text ="￥${mList[position].amount}"
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class PartsOrderVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.ly_root,
                    adapterPosition
                )
            })
            itemView.recycle_list_item.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(
                itemView.ly_root,
                adapterPosition
            ) })
            itemView.tv_look_logistics.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_look_logistics,
                    adapterPosition
                )
            })
            itemView.tv_apply_refund.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_apply_refund,
                    adapterPosition
                )
            })
            itemView.tv_cancel_order.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_cancel_order,
                    adapterPosition
                )
            })
            itemView.tv_confirm.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_confirm,
                    adapterPosition
                )
            })
            itemView.tv_pay.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_pay,
                    adapterPosition
                )
            })
            itemView.tv_evaluate.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_evaluate,
                    adapterPosition
                )
            })
            itemView.tv_look_evaluate.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_look_evaluate,
                    adapterPosition
                )
            })

            itemView.tv_input_odd_num.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_input_odd_num,
                    adapterPosition
                )
            })

            itemView.tv_cancel_sale.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_cancel_sale,
                    adapterPosition
                )
            })
        }
    }
}
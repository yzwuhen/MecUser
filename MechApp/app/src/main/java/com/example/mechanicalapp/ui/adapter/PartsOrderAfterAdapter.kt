package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.PartsOrderData
import kotlinx.android.synthetic.main.item_parts_order_after.view.*

class PartsOrderAfterAdapter (
    var mContext: Context,
    var mList: MutableList<PartsOrderData>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PartsOrderAfterVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_parts_order_after, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_order_state.text = mList[position].status_dictText
        holder.itemView.tv_order_num.text = "订单号：${mList[position].orderNum}"
        // 0售后中 1 售后成功  2售后失败 3 售后关闭
        when (mList[position].status) {
            0 -> {
                holder.itemView.tv_state_test.visibility=View.VISIBLE
                //deliveryStatus 0 审核中  1商家审核通过 2商家审核不通过 3买家寄回物品中 4 买家寄回物品完成 5同意退款 6 退款完成
                if (mList[position].deliveryStatus==0){
                    //审核中只显示取消售后
                    holder.itemView.ly_bottom.visibility = View.VISIBLE
                    holder.itemView.tv_state_test.text ="审核中"
                    holder.itemView.tv_input_odd_num.visibility =View.GONE
                }else if (mList[position].deliveryStatus==2){
                    holder.itemView.ly_bottom.visibility = View.GONE
                    holder.itemView.tv_state_test.text ="审核不通过"
                }
                else{
                    if (TextUtils.isEmpty(mList[position].deliverycorpCode)){
                        holder.itemView.ly_bottom.visibility = View.VISIBLE
                        holder.itemView.tv_state_test.text ="等待买家回寄商品"
                    }else{
                        holder.itemView.ly_bottom.visibility = View.GONE
                        holder.itemView.tv_state_test.text ="等待物流退货"
                    }
                }

            }
            1 -> {
                holder.itemView.ly_bottom.visibility = View.GONE
                holder.itemView.tv_state_test.visibility=View.VISIBLE
                holder.itemView.tv_state_test.text ="退款金额已原路返回"

            }
            2 -> {
                holder.itemView.ly_bottom.visibility = View.GONE
                holder.itemView.tv_state_test.visibility=View.GONE
            }
            3 -> {
                holder.itemView.tv_state_test.visibility=View.GONE
                holder.itemView.ly_bottom.visibility = View.GONE
            }

        }
        holder.itemView.recycle_list_item.layoutManager = LinearLayoutManager(mContext)
        var mPartsOrderChildAdapter = PartsOrderChildAdapter(mContext,mList[position].orderItemList,position,mOnItemClickListener)
        holder.itemView.recycle_list_item.adapter =mPartsOrderChildAdapter

        holder.itemView.tv_money.text ="￥${mList[position].amount}"
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class PartsOrderAfterVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.ly_root,
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
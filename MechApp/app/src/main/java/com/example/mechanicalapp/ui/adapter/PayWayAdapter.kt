package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.CodeData
import kotlinx.android.synthetic.main.item_pop_pay_way.view.*

class PayWayAdapter (
    var mContext: Context,
    var mList: MutableList<CodeData>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PopWayVh(
            View.inflate(parent.context, R.layout.item_pop_pay_way, null),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_pay_way.text = mList[position].itemText
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class PopWayVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.tv_pay_way,
                    adapterPosition
                )
            })
        }
    }
}
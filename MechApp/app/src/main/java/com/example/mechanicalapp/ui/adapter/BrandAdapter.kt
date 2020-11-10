package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.data.BrandData
import kotlinx.android.synthetic.main.item_city.view.*

class BrandAdapter(
    var mContext: Context,
    var mList: MutableList<BrandData>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return BrandVh(View.inflate(parent.context, R.layout.item_city, null), mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_city.text = mList[position].brandName

        if (position == 0) {
            holder.itemView.tv_letter.visibility = View.VISIBLE
            holder.itemView.tv_letter.text = mList[position].brandFirst
        } else {
            if (mList[position].brandFirst == mList[position - 1].brandFirst) {
                holder.itemView.tv_letter.visibility = View.GONE
            } else {
                holder.itemView.tv_letter.visibility = View.VISIBLE
                holder.itemView.tv_letter.text = mList[position].brandFirst
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class BrandVh(
        itemView: View,
        mOnItemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.ly_city_root.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.ly_city_root,
                    adapterPosition
                )
            })
        }
    }
}
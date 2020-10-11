package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_engineer.view.*

class SearchResultEngineer (
    var mContext: Context,
    var mList: MutableList<String>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return SearchResultEngineerVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_engineer, parent, false),
            mOnItemClickListener
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_text1.text = mList[position]

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class SearchResultEngineerVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener?.onItemClick(
                    itemView.ly_city_root,
                    adapterPosition
                )
            })
        }
    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.EngineerData
import kotlinx.android.synthetic.main.item_engineer.view.*

class EngineerAdapter(
    var mContext: Context,
    var mList: MutableList<EngineerData>,
    var parentPosition:Int,
    var mOnItemClickListener: OnItemClickLevelListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return EngineerVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_engineer, parent, false),parentPosition,
            mOnItemClickListener
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_text1.text = mList[position].name
        holder.itemView.tv_text2.text ="工种:${mList[position].post_dictText}"

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class EngineerVh(itemView: View,var parentIndex:Int, mOnItemClickListener: OnItemClickLevelListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener?.onItemClick(
                    itemView.ly_city_root,
                    parentIndex,
                    adapterPosition
                )
            })
        }
    }
}
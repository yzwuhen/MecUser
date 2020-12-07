package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.StoreChildBean
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_ec_type_right.view.*

class StoreRightChildAdapter(
    var mContext: Context,
    var mList: List<StoreChildBean>,
    var parentPosition: Int,
    var mOnItemClickListener: OnItemClickLevelListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StoreRightChildVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_ec_type_right, parent, false),parentPosition,
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_type_name.text = mList[position].name
        ImageLoadUtils.loadImage(
            mContext,
            holder.itemView.iv_pic,
            mList[position].icon,
            R.mipmap.ic_launcher
        )
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class StoreRightChildVh(itemView: View,var parentPosition: Int, mOnItemClickListener: OnItemClickLevelListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.ly_type.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.ly_type,
                    parentPosition,
                    adapterPosition
                )
            })
        }
    }
}
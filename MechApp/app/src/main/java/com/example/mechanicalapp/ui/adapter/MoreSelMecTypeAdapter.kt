package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.MecTypeChildData
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_more_sel_type_right.view.*

class MoreSelMecTypeAdapter(
    var mContext: Context,
    var mList: List<MecTypeChildData>,
    var parentPosition: Int,
    var mOnItemClickListener: OnItemClickLevelListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MoreSelMecTypeVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_more_sel_type_right, parent, false),
            parentPosition,
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.iv_check.isSelected = mList[position].isSelect
        holder.itemView.tv_type_name.text = mList[position].name
        ImageLoadUtils.loadImageCenterCrop(
            mContext,
            holder.itemView.iv_pic,
            mList[position].pictures,
            R.mipmap.ic_launcher
        )
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class MoreSelMecTypeVh(
        itemView: View,
        parentPosition: Int,
        mOnItemClickListener: OnItemClickLevelListener
    ) : RecyclerView.ViewHolder(itemView) {
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
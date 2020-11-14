package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_pic.view.*

class PicAdapter(
    var mContext: Context,
    var mList: List<String>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return PicVh(LayoutInflater.from(mContext).inflate(R.layout.item_pic, parent, false),
            mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mList.isEmpty()) {
            holder.itemView.iv_del.visibility = View.GONE
            holder.itemView.iv_pic.setImageResource(R.mipmap.add_pic_n)
        } else {
            if (mList.size < 3) {
                if (position == mList.size) {
                    holder.itemView.iv_del.visibility = View.GONE
                    holder.itemView.iv_pic.setImageResource(R.mipmap.add_pic_n)
                } else {
                    holder.itemView.iv_del.visibility = View.VISIBLE
                    ImageLoadUtils.loadImageCenterCrop(
                        mContext,
                        holder.itemView.iv_pic,
                        mList[position],
                        R.mipmap.add_pic_n
                    )
                }
            } else {
                holder.itemView.iv_del.visibility = View.VISIBLE
                ImageLoadUtils.loadImageCenterCrop(
                    mContext,
                    holder.itemView.iv_pic,
                    mList[position],
                    R.mipmap.add_pic_n
                )
            }

        }

    }

    override fun getItemCount(): Int {
        if (mList.isEmpty()) {
            return 1
        } else if (mList.size < 3) {
            return mList.size + 1
        } else {
            return mList.size
        }
    }
}

class PicVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
    RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener(View.OnClickListener {
            mOnItemClickListener.onItemClick(
                itemView.iv_pic,
                adapterPosition
            )
        })
        itemView.iv_del.setOnClickListener(View.OnClickListener {
            mOnItemClickListener.onItemClick(
                itemView.iv_del,
                adapterPosition
            )
        })
    }
}

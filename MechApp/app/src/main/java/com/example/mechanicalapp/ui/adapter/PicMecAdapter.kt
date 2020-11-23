package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_pic.view.*

class PicMecAdapter(
    var mContext: Context,
    var mList: List<String>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return PicMecVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_pic, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.iv_del.visibility = View.GONE
        ImageLoadUtils.loadImageCenterCrop(
            mContext,
            holder.itemView.iv_pic,
            mList[position],
            R.mipmap.add_pic_n
        )
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}

class PicMecVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
    RecyclerView.ViewHolder(itemView) {
}

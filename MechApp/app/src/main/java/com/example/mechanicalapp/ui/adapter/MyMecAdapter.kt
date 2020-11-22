package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.MecData
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import kotlinx.android.synthetic.main.item_my_mec.view.*

class MyMecAdapter(
    var mContext: Context,
    var mList: MutableList<MecData>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyMecVh(
            View.inflate(parent.context, R.layout.item_my_mec, null),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(
            mContext,
            holder.itemView.iv_pic,
            StringUtils.getImgStr(mList[position].pic),
            R.mipmap.ic_launcher
        )
        holder.itemView.tv_text.text = mList[position].titile

    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class MyMecVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView,
                    adapterPosition
                )
            })
        }
    }
}
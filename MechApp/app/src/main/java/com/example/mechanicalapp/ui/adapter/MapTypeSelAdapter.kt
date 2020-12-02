package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_my_mec.view.*

class MapTypeSelAdapter(
    var mContext: Context,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mList =intArrayOf(R.mipmap.type_sel_1,R.mipmap.type_sel_2,R.mipmap.type_sel_3,R.mipmap.type_sel_4,R.mipmap.type_sel_5)
    private var mStrList = arrayOf("出租求租","出售求购","配件出租求租","求职招聘","维修厂")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MapTypeSelVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_map_type_sel,parent,false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(
            mContext,
            holder.itemView.iv_pic,
            mList[position],
            R.mipmap.ic_launcher
        )
        holder.itemView.tv_text.text = mStrList[position]

    }

    override fun getItemCount(): Int {

        return 5
    }

    class MapTypeSelVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
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
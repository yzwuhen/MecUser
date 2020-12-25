package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_pic.view.*

class RefundPicAdapter (
    var mContext: Context,
    var mList: List<String>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return RefundPicVh(View.inflate(mContext, R.layout.item_pic,null),mOnItemClickListener)
//        return PicVh(LayoutInflater.from(mContext).inflate(R.layout.item_pic, parent, false),
//            mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

                    holder.itemView.iv_del.visibility = View.GONE
                    if (mList[position].endsWith("mp4")){
                        ImageLoadUtils.loadVideo(mContext,holder.itemView.iv_pic,mList[position])
                        holder.itemView.iv_video.visibility = View.VISIBLE
                    }else{
                        ImageLoadUtils.loadImageCenterCrop(
                            mContext,
                            holder.itemView.iv_pic,
                            mList[position],
                            R.mipmap.add_pic_n
                        )
                        holder.itemView.iv_video.visibility = View.GONE
                    }

    }

    override fun getItemCount(): Int {
            return mList.size
    }
}

class RefundPicVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
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

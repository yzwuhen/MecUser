package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.request.ReAddList
import kotlinx.android.synthetic.main.item_preview_work_time.view.*

class PreviewWorkTimeAdapter(
    var mContext: Context,
    var mList: MutableList<ReAddList>,
    var parentPosition:Int,
    var mOnItemClickListener: OnItemClickLevelListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WorkTimeVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_preview_work_time, parent, false),parentPosition,
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if (mList[position].isShow) {
            holder.itemView.iv_right_list.setImageResource(R.mipmap.tip_up)
            holder.itemView.ly_info.visibility = View.VISIBLE
        } else {
            holder.itemView.iv_right_list.setImageResource(R.mipmap.tip_down)
            holder.itemView.ly_info.visibility = View.GONE
        }
        holder.itemView.tv_text_left1.text =mList[position].name
        holder.itemView.tv_all_money.text ="￥${mList[position].aoumt}"

        holder.itemView.tv_text_left2.text ="单价：${mList[position].repairPrice}"
        holder.itemView.tv_text_right2.text= "工时${mList[position].repairHours}"
        holder.itemView.tv_put_time.text ="提交时间${mList[position].createTime}"
        holder.itemView.tv_remarks.text =mList[position].remark
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class WorkTimeVh(itemView: View,var parentPosition: Int,mOnItemClickListener: OnItemClickLevelListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.iv_right_list.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.iv_right_list,parentPosition,
                    adapterPosition
                )
            })
        }
    }
}
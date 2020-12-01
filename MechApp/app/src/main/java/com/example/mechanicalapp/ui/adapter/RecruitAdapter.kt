package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.data.RecruitData
import com.example.mechanicalapp.utils.DateUtils
import kotlinx.android.synthetic.main.item_recruit.view.*

class RecruitAdapter(
    var mContext: Context,
    var mList: MutableList<RecruitData>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isShow: Boolean = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecruitVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_recruit, parent, false),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isShow) {
            holder.itemView.ly_check.visibility = View.VISIBLE
            holder.itemView.iv_check.isSelected = mList[position].isSelect
        } else {
            holder.itemView.ly_check.visibility = View.GONE
        }

        holder.itemView.tv_recruit_title.text = mList[position].jobtitle
        if (mList[position].price > 0) {
            holder.itemView.tv_label.visibility = View.GONE
            holder.itemView.tv_label1.visibility = View.VISIBLE
            holder.itemView.tv_label1.text = mList[position].price_dictText
        } else {
            holder.itemView.tv_label.visibility = View.VISIBLE
            holder.itemView.tv_label1.visibility = View.GONE
        }

        holder.itemView.tv_recruit_address.text = mList[position].city
        //   holder.itemView.tv_recruit_exp.text =mList[position].

        holder.itemView.tv_recruit_num.text = "${mList[position].needNumber}人"
        holder.itemView.tv_recruit_user.text = "${mList[position].contactName}·招聘者"
        holder.itemView.tv_recruit_time.text =
            DateUtils.dateDiffs(mList[position].updateTime, System.currentTimeMillis())
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    fun showCheck(showCheck: Boolean) {
        isShow = showCheck

    }

    class RecruitVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.root_view,
                    adapterPosition
                )
            })
            itemView.ly_check.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView.ly_check,
                    adapterPosition
                )
            })
        }
    }
}
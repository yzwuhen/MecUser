package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.ReportBean
import kotlinx.android.synthetic.main.item_screen.view.*

class ReportPopAdapter (
    var mContext: Context,
    var mList: MutableList<ReportBean.ResultBean.RecordsBean>,
    var mOnItemClickListener: OnItemClickListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ScreentVh(View.inflate(parent.context, R.layout.item_screen,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_screen.text =mList[position].reportReasonId_dictText
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class ScreentVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.tv_screen,adapterPosition) })
        }
    }
}
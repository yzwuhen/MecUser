package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.ListBean
import kotlinx.android.synthetic.main.item_repair_list.view.*


class PreviewListAdapter  (var mContext: Context, var mList:MutableList<ListBean.ResultBean>, var mOnItemClickListener: OnItemClickLevelListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mListAdapter = ArrayList<RecyclerView.Adapter<RecyclerView.ViewHolder>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TravelVh(LayoutInflater.from(mContext).inflate(R.layout.item_repair_list,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_type_name.text =mList[position].type
        holder.itemView.tv_type_money.text ="小计：￥${mList[position].total}"
        if (position==0){
            mListAdapter.add(PreviewPartsAdapter(mContext, mList[position].data,position, mOnItemClickListener))
            holder.itemView.recycle_list_item.layoutManager = LinearLayoutManager(mContext)
            holder.itemView.recycle_list_item.adapter = mListAdapter[0]
        }else if (position==1){
            mListAdapter.add(PreviewWorkTimeAdapter(mContext, mList[position].data, position,mOnItemClickListener))
            holder.itemView.recycle_list_item.layoutManager = LinearLayoutManager(mContext)
            holder.itemView.recycle_list_item.adapter = mListAdapter[1]
        }
        else if (position==2){
            mListAdapter.add(PreviewTravelListAdapter(mContext, mList[position].data,position, mOnItemClickListener))
            holder.itemView.recycle_list_item.layoutManager = LinearLayoutManager(mContext)
            holder.itemView.recycle_list_item.adapter = mListAdapter[2]
        }
        else if (position==3){
            mListAdapter.add(PreviewOtherAdapter(mContext, mList[position].data,position, mOnItemClickListener))
            holder.itemView.recycle_list_item.layoutManager = LinearLayoutManager(mContext)
            holder.itemView.recycle_list_item.adapter = mListAdapter[3]
        }

    }
    fun clearAdapter(){
        mListAdapter.clear()
    }
    fun refreshAdapter(parentPosition:Int,childPosition:Int){
        mListAdapter[parentPosition].notifyItemChanged(childPosition)
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class TravelVh(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}
package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.item_type_right.view.*

class StoreRightAdapter (
    var mContext: Context,
    var mList: MutableList<StoreLeftBean>,
    private var mOnItemClickLevelListener: OnItemClickLevelListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StoreRightVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_type_right,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mList[position].children.size>0){
            holder.itemView.tv_type.text = "${mList[position].name}"
            var mRightAdapter = StoreRightChildAdapter(
                mContext,
                mList[position].children,
                position,
                mOnItemClickLevelListener
            )
            holder.itemView.item_recycler.layoutManager = GridLayoutManager(mContext, 3)
            holder.itemView.item_recycler.adapter = mRightAdapter
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class StoreRightVh(itemView: View) :
        RecyclerView.ViewHolder(itemView)
}
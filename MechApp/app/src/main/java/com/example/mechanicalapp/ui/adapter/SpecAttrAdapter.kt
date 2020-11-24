package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.GoodsDetails
import kotlinx.android.synthetic.main.item_spec_attr.view.*

class SpecAttrAdapter(
    var mContext: Context,
    var mList: MutableList<GoodsDetails.SkuNameListBean>,
    var mOnItemClickListener: OnItemClickLevelListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SpecAttrVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_spec_attr, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_spec.text = mList[position].typeName


        holder.itemView.recycle_list.layoutManager = GridLayoutManager(mContext, 4)

        var mSpecAdapter1 =
            SpecAdapter(mContext, mList[position].getmSpecList(), position, mOnItemClickListener)

        holder.itemView.recycle_list.adapter = mSpecAdapter1
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class SpecAttrVh(itemView: View) : RecyclerView.ViewHolder(itemView)
}
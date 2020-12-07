package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.HomeCityData
import kotlinx.android.synthetic.main.item_city_child.view.*

class CityChildAdapter (
    var mContext: Context, var parentPosition:Int,
    var mList:List<HomeCityData>, var mOnItemClickListener: OnItemClickLevelListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return CityChildVh(View.inflate(parent.context, R.layout.item_city_child,null),parentPosition,mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_city.text =mList[position].name

    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class CityChildVh(itemView: View,var parentPosition: Int, mOnItemClickListener: OnItemClickLevelListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_city_root,parentPosition,adapterPosition) })
        }
    }
}
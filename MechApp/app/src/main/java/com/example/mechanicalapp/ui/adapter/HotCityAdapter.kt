package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.data.HomeCityData
import kotlinx.android.synthetic.main.item_hot_city.view.*

class HotCityAdapter (var mContext: Context, var mList:List<HomeCityData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return HotCityVh(View.inflate(parent.context, R.layout.item_hot_city, null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_city_name.text=mList[position].name
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class HotCityVh(itemView: View, mOnItemClickListener: OnItemClickListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener {  mOnItemClickListener.onItemClick(itemView,adapterPosition)})
        }
    }
}
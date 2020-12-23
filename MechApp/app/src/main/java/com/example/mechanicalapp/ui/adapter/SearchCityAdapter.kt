package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.HomeCityData
import kotlinx.android.synthetic.main.item_city_child.view.*

class SearchCityAdapter  (
    var mContext: Context,
    var mList:List<HomeCityData>, var mOnItemClickListener: OnItemClickListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return SearchCityVh(View.inflate(parent.context, R.layout.item_city_child,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_city.text =mList[position].name

    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class SearchCityVh(itemView: View, mOnItemClickListener: OnItemClickListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(itemView.ly_city_root,adapterPosition) })
        }
    }
}
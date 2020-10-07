package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.view.HotCityView
import com.example.mechanicalapp.R
import kotlinx.android.synthetic.main.item_city.view.*


class CityAdapter  (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0){
            return LocalVh(View.inflate(parent.context, R.layout.item_locat_view,null))
        }
        else if (viewType == 1){
            return NewLocalVh(View.inflate(parent.context, R.layout.item_new_local_view,null))
        }else if (viewType ==2){
            return HotCityVh(HotCityView(mContext))
        }

        return CityVh(View.inflate(parent.context, R.layout.item_city,null))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        holder.itemView.tv_letter.text ="广州"
        if (position>2){
            holder.itemView.tv_city.text =mList[position]
            if (position%5==3){
                holder.itemView.tv_letter.visibility =View.VISIBLE
            }else{
                holder.itemView.tv_letter.visibility =View.GONE
            }
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class LocalVh (itemView: View): RecyclerView.ViewHolder(itemView)
    class NewLocalVh (itemView: View): RecyclerView.ViewHolder(itemView)
    class HotCityVh (itemView: View): RecyclerView.ViewHolder(itemView)
    class CityVh (itemView: View): RecyclerView.ViewHolder(itemView)
}
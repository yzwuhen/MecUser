package com.example.mechanicalapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amap.api.services.core.PoiItem
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_map_address.view.*

class LocationAddressAdapter(
    var mList: List<PoiItem>,
    var onItemclickListener: OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LocationAddressVh(
            onItemclickListener,
            LayoutInflater.from(parent.context).inflate(R.layout.item_map_address, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_address.text =
            "${mList[position].provinceName}${mList[position].cityName} ${mList[position].adName}"
        holder.itemView.tv_address_road.text = mList[position].title

    }

    override fun getItemCount(): Int {
        return mList.size;
    }

    class LocationAddressVh(onItemClickListener: OnItemClickListener, itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { onItemClickListener.onItemClick(itemView.tv_address,adapterPosition) })
        }
    }
}
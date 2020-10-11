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
    var items: List<PoiItem>,
    var onItemclickListener: OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LocationAddressVh(
            LayoutInflater.from(parent.context).inflate(R.layout.item_map_address, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_address.text =
            "${items[position].provinceName}${items[position].cityName} ${items[position].adName}${items[position].businessArea}${items[position].title}"
       // holder.itemView.tv_address_road.text =items[position].typeDes
//            holder.itemView.setOnClickListener(View.OnClickListener {
//                onItemclickListener?.onItemClick(position)
//            })
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    class LocationAddressVh(var itemViews: View) : RecyclerView.ViewHolder(itemViews)
}
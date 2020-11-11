package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.data.MecTypeChildData
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_ec_type_right.view.*

class PartsTypeRightAdapter (var mContext: Context, var mList:MutableList<MecTypeChildData>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PartsTypeRightVh(LayoutInflater.from(mContext).inflate(R.layout.item_ec_type_right,parent,false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_type_name.text = mList[position].cateName
        ImageLoadUtils.loadImage(mContext,holder.itemView.iv_pic,mList[position].cateLogo,R.mipmap.ic_launcher)
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class PartsTypeRightVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.ly_type.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.ly_type,adapterPosition) })
        }
    }
}
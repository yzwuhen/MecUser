package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import kotlinx.android.synthetic.main.item_letter.view.*

class LetterAdapter (var mContext: Context, var mList:List<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LetterVh(LayoutInflater.from(mContext).inflate(R.layout.item_letter,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_letter.text =mList[position]
    }

    override fun getItemCount(): Int {
      return mList.size
    }

    class LetterVh (itemView:View):RecyclerView.ViewHolder(itemView){

    }
}
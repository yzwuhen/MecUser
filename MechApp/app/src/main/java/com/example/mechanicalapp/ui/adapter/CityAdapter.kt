package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.view.HotCityView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.data.CityListBean
import com.example.mechanicalapp.ui.data.HomeCityData
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.item_city.view.*
import kotlinx.android.synthetic.main.item_locat_view.view.*
import kotlinx.android.synthetic.main.item_new_local_view.view.*


class CityAdapter(
    var mContext: Context, var mList: ArrayList<List<CityListBean.ResultBean.GroupListBean>>,
    var mHostList:List<HomeCityData>, var mOnItemClickListener: OnItemClickLevelListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var homeCityData :HomeCityData?=null
    init {
        if (Hawk.contains(Configs.VISIT)){
            homeCityData =Hawk.get(Configs.VISIT) as HomeCityData
        }else{
            homeCityData =App.getInstance().homeCityData
        }
    }

    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0){
            return LocalVh(View.inflate(parent.context, R.layout.item_locat_view,null),mOnItemClickListener)
        }
        else if (viewType == 1){
            return NewLocalVh(View.inflate(parent.context, R.layout.item_new_local_view,null),mOnItemClickListener)
        }else if (viewType ==2){
            return HotCityVh(HotCityView(mContext,mOnItemClickListener,viewType,mHostList))
        }

        return CityVh(View.inflate(parent.context, R.layout.item_city,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if (position==0){
            holder.itemView.tv_city_name.text=App.getInstance().homeCityData.name
        }

        if (position==1){
            holder.itemView.tv_visit.text=homeCityData?.name
        }

        if (position>2){
            holder.itemView.tv_letter.text =mList[position-3][0].key
            holder.itemView.recycle_list_item.layoutManager =LinearLayoutManager(mContext)
            holder.itemView.recycle_list_item.adapter =CityChildAdapter(mContext,position,mList[position-3][1].data,mOnItemClickListener)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class LocalVh(itemView: View, mOnItemClickListener: OnItemClickLevelListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,0,0) })
        }
    }
    class NewLocalVh(itemView: View, mOnItemClickListener: OnItemClickLevelListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.tv_visit.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,1,1) })
        }
    }
    class HotCityVh (itemView: View): RecyclerView.ViewHolder(itemView)
    class CityVh(itemView: View, mOnItemClickListener: OnItemClickLevelListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,3,adapterPosition) })
        }
    }
}
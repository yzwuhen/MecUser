package com.example.mechanicalapp.ui.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.MoreDataActivity
import com.example.mechanicalapp.ui.adapter.UserDemandAdapter
import com.example.mechanicalapp.ui.adapter.UserRentAdapter
import kotlinx.android.synthetic.main.layout_boss_denmand.view.*

class BossDemandView (var mContext: Context) : LinearLayout(mContext), OnItemClickListener, View.OnClickListener {

    private var mAdapter: UserDemandAdapter? = null
    private var mRentAdapter : UserRentAdapter?=null
    var mList: MutableList<String> = ArrayList<String>()
    var type:Int = 0
    init {
        orientation = VERTICAL;
        val view = inflate(mContext, R.layout.layout_boss_denmand, null)
        addView(view)

        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = UserDemandAdapter(mContext, mList, this)

        mRentAdapter = UserRentAdapter(mContext,mList,this)

        recycler_demand.layoutManager = LinearLayoutManager(mContext)
        recycler_demand.adapter = mAdapter

        tv_lease.setOnClickListener(this)
        tv_rent.setOnClickListener(this)
        tv_rent_more.setOnClickListener(this)

    }


    override fun onClick(v: View?) {

        if (v?.id == R.id.tv_lease){
            if (type !=0){
                type = 0
                recycler_demand.adapter = mAdapter
                tv_lease.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.tv_under_ine)
                tv_lease.paint.isFakeBoldText = true
                tv_rent.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                tv_rent.paint.isFakeBoldText = false
                tv_rent.setTextColor(Color.parseColor("#B5B5B5"))
                tv_lease.setTextColor(Color.parseColor("#222222"))

                tv_rent.textSize =13f
                tv_lease.textSize=16f
            }
        }
        else if (v?.id == R.id.tv_rent){
            if (type !=1){
                type = 1
                recycler_demand.adapter = mRentAdapter
                tv_rent.paint.isFakeBoldText = true
                tv_lease.paint.isFakeBoldText = false
                tv_rent.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.tv_under_ine)
                tv_lease.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)


                tv_lease.setTextColor(Color.parseColor("#B5B5B5"))
                tv_rent.setTextColor(Color.parseColor("#222222"))

                tv_lease.textSize =13f
                tv_rent.textSize=16f
            }
        }
        else if (v?.id==R.id.tv_rent_more){
            jumAct(2)
        }
    }
    private fun jumAct(type: Int) {
        val intent = Intent()
        val bundle = Bundle()
        bundle.putInt(Configs.MORE_VIEW_TYPE,type)
        intent.setClass(mContext, MoreDataActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        mContext.startActivity(intent)
    }

    override fun onItemClick(view: View, position: Int) {

    }


}
package com.example.mechanicalapp.ui.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.UserDemandAdapter
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.AskDetailsActivity
import com.example.mechanicalapp.ui.activity.LeaseDetailsActivity
import com.example.mechanicalapp.ui.activity.MoreDataActivity
import com.example.mechanicalapp.ui.adapter.UserRentAdapter
import com.example.mechanicalapp.ui.data.MecLeaseData
import com.example.mechanicalapp.ui.data.MecRentData
import kotlinx.android.synthetic.main.layout_user_demand.view.*

class UserDemandKtView(var mContext: Context) : LinearLayout(mContext), OnItemClickListener,View.OnClickListener {

    var mAdapter: UserDemandAdapter? = null
    var mRentAdapter :UserRentAdapter ?=null
    var mLeaseList: MutableList<MecLeaseData> = ArrayList<MecLeaseData>()
    var mRentList: MutableList<MecRentData> = ArrayList<MecRentData>()
    var type:Int = 0
    init {
        orientation = VERTICAL;
        val view = inflate(mContext, R.layout.layout_user_demand, null)
        addView(view)


        mAdapter = UserDemandAdapter(mContext, mLeaseList, 0,this)

        mRentAdapter = UserRentAdapter(mContext,mRentList,this)

        recycler_demand.layoutManager = LinearLayoutManager(mContext)
        recycler_demand.adapter = mAdapter

        tv_lease.setOnClickListener(this)
        tv_rent.setOnClickListener(this)
        tv_demand_more.setOnClickListener(this)
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
        else if (v?.id==R.id.tv_demand_more){
            jumAct(0)
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

    private fun jumDetails() {
        val intent = Intent()
        val bundle = Bundle()

        if (type==0){
            bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE,0)
            intent.setClass(mContext, LeaseDetailsActivity::class.java)
        }
        else{
            bundle.putInt(Configs.MEC_ASK_DETAILS_TYPE,0)
            intent.setClass(mContext, AskDetailsActivity::class.java)
        }
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        mContext.startActivity(intent)
    }


    override fun onItemClick(view: View, position: Int) {

        jumDetails()
    }

    //出
    fun setLease(list: List<MecLeaseData>) {
        mLeaseList.clear()
        mLeaseList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    //求
    fun setRent(list: List<MecRentData>) {
        mLeaseList.clear()
        mRentList.addAll(list)
        mRentAdapter?.notifyDataSetChanged()

    }
}
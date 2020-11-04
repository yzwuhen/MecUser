package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.ReleaseAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_release.*

class ReleaseActivity :BaseActivity<NetData>() ,View.OnClickListener,OnItemClickListener{




    override fun getLayoutId(): Int {


        return R.layout.activity_release
    }

    override fun initView() {
        super.initView()




        recycle_list.layoutManager= GridLayoutManager(this, 4)
        recycle_list.adapter= ReleaseAdapter(this!!, this)

        iv_close.setOnClickListener(this)
        iv_release.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_close->finish()
            R.id.iv_release->jumpActivity(null,CreateRepairActivity::class.java)
        }
    }

    override fun onItemClick(view: View, position: Int) {

        when(position){
            0->jumpActivity(null,EcLeaseActivity::class.java)
            1->jumpActivity(null,EcSellActivity::class.java)
            2->jumpActivity(null,PartsRentalActivity::class.java)
            3->jumpActivity(null,RecruitActivity::class.java)
            4->jumpActivity(null,AskingRentActivity::class.java)
            5->jumpActivity(null,EcBuyActivity::class.java)
            6->jumpActivity(null,AskingRentPatsActivity::class.java)
            7->jumpActivity(null,JobWantActivity::class.java)
        }
    }
}
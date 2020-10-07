package com.example.mechanicalapp.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.SearchCityActivity
import com.example.mechanicalapp.ui.activity.SearchMecActivity
import kotlinx.android.synthetic.main.layout_hot_apparatus.view.*

class HotApparatusView(var mContext :Context) :FrameLayout(mContext),View.OnClickListener {
    var hView : View?=null
    init {
        this.clipChildren=false;
        this.clipToPadding =false;
        val view = LinearLayout.inflate(mContext, R.layout.layout_hot_apparatus, null)
        addView(view)

        cd_digger.setOnClickListener(this)
        cd_rotary_machine.setOnClickListener(this)
        cd_bulldozer.setOnClickListener(this)
        cd_truck_crane.setOnClickListener(this)
        cd_bc.setOnClickListener(this)
        cd_zzj.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.cd_digger->jumAct(0)
            R.id.cd_rotary_machine ->jumAct(1)
            R.id.cd_bulldozer ->jumAct(2)
            R.id.cd_truck_crane ->jumAct(3)
            R.id.cd_bc ->jumAct(4)
            R.id.cd_zzj ->jumAct(5)
        }

    }

    private fun jumAct(type: Int) {

//        val intent = Intent()
//        val bundle =Bundle()
//        bundle.putInt(Configs.SEARCH_TYPE,type)
//        intent.setClass(mContext, SearchMecActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//        if (bundle != null) {
//            intent.putExtras(bundle)
//        }
//        mContext.startActivity(intent)
    }
}
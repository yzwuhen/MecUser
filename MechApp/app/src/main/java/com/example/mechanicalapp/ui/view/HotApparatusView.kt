package com.example.mechanicalapp.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.SearchAllActivity
import com.example.mechanicalapp.ui.data.HotMechineCate
import kotlinx.android.synthetic.main.layout_hot_apparatus.view.*

class HotApparatusView(var mContext :Context) :FrameLayout(mContext),View.OnClickListener {
    var hView : View?=null
    var list= listOf<String>("挖掘机","旋挖机","推土机","汽车吊","泵车","装载机")
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

    private fun jumAct(index: Int) {
        var bundle: Bundle = Bundle()
        bundle.putString(Configs.SEARCH_RESULT_TITLE,list[index])
        val intent = Intent()
        intent.setClass(mContext, SearchAllActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        mContext.startActivity(intent)
    }

    fun setData(hotMec: List<HotMechineCate>) {


    }
}
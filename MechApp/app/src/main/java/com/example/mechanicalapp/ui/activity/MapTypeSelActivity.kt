package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.provider.Settings
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MapTypeSelAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import kotlinx.android.synthetic.main.activity_map_sel_type.*
import kotlinx.android.synthetic.main.layout_title.*

/**
 * 首页跳转地图 选择类型
 */
class MapTypeSelActivity : BaseCusActivity() ,View.OnClickListener,OnItemClickListener{
    override fun getLayoutId(): Int {
        return R.layout.activity_map_sel_type
    }

    override fun initView() {
        super.initView()

        tv_title.text="请选择类型"
        iv_back.setOnClickListener(this)
        recycle_list.layoutManager =GridLayoutManager(this,3)
        recycle_list.adapter = MapTypeSelAdapter(this,this)
    }

    override fun initPresenter() {
    }

    override fun onClick(p0: View?) {
        finish()
    }

    override fun onItemClick(view: View, position: Int) {

        if (isLocationEnabled(this)){
            when(position){
                0-> jumpActivity(null, MapActivity::class.java)
                1->jumpActivity(null,MapMecBusinessActivity::class.java)
                2->jumpActivity(null,MapPartsActivity::class.java)
                3->jumpActivity(null,MapJobAboutActivity::class.java)
                4->jumpActivity(null,MapFactoryActivity::class.java)
            }

        }else{
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(intent)
        }
    }
}
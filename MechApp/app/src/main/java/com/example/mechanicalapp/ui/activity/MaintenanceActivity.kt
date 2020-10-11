package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MecFactoryShopAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.activity_maintenance.*
import kotlinx.android.synthetic.main.fragment_more_data.*
import kotlinx.android.synthetic.main.layout_left_right_title.tv_title
import kotlinx.android.synthetic.main.layout_title.*

class MaintenanceActivity : BaseActivity<NetData>(),View.OnClickListener ,PopUtils.onViewListener,OnItemClickListener{

    var popRecy : RecyclerView?=null
    private var mScreenAdapter : ScreenAdapter?=null

    private var mStringList :MutableList<String> = ArrayList<String>()


    private var mMecFactoryShopAdapter : MecFactoryShopAdapter?=null
    var mList: MutableList<String> = ArrayList<String>()

    override fun getLayoutId(): Int {

        return R.layout.activity_maintenance
    }

    override fun initView() {
        super.initView()

        tv_title.text ="维修厂"

        iv_back.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_parts_type.setOnClickListener(this)
        ly_sort.setOnClickListener(this)
        tv_submit.setOnClickListener(this)


        mStringList?.add("智能排序")
        mStringList?.add("最新上架")
        mStringList?.add("最新上架")
        mStringList?.add("工作时长最短")



        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mMecFactoryShopAdapter = MecFactoryShopAdapter(this,mList,this)

        recycle_list.layoutManager =LinearLayoutManager(this)
        recycle_list.adapter = mMecFactoryShopAdapter
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(view: View?) {
      when(view?.id){
          R.id.iv_back->finish()
          R.id.ly_ec_type ->jumpActivityForReSult(
              Configs.EC_TYPE_RESULT_CODE,
              EcType::class.java
          )
          R.id.ly_parts_type ->jumpActivityForReSult(
              Configs.EC_TYPE_RESULT_CODE,
              EcType::class.java
          )
          R.id.ly_sort ->showPop()
          R.id.tv_submit->toResult()
      }
    }

    private fun toResult() {

            var intent  = Intent()
            var bundle = Bundle()
            bundle.putString(Configs.SCREEN_RESULT_Extra,"广州市莹宝维修中心")
            intent.putExtras(bundle)
            setResult(Configs.EC_MODEL_RESULT_CODE,intent)
            finish()
    }

    private fun showPop() {
        this?.let { PopUtils.init(this, it,this) }
        PopUtils.showPopupWindow(tv_screen1)
    }

    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(this, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.tv_screen->tv_sort.text=mStringList[position]
            R.id.ly_item_mec_factory->setSelect()
        }
    }

    private fun setSelect() {


    }
}
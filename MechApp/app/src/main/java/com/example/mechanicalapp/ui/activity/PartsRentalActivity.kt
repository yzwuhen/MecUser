package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.adapter.PopWayAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.activity_parts_rental.*
import kotlinx.android.synthetic.main.layout_title.*

class PartsRentalActivity : BaseActivity<NetData>(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener {

    private var mPicAdapter : PicAdapter?=null

    private var mPicList :MutableList<String> ?=null

    private var mStringList :MutableList<String> = ArrayList<String>()
    private var popRecy : RecyclerView?=null
    private var mPopWayAdapter : PopWayAdapter?=null



    override fun getLayoutId(): Int {

        return R.layout.activity_parts_rental
    }

    override fun initView() {
        super.initView()

        mPicList = ArrayList<String>()
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")
        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>,this)
        ry_pic.layoutManager = GridLayoutManager(this,3)
        ry_pic.adapter = mPicAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text ="配件出租"
        tv_no_element.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        mStringList?.add("元/月")
        mStringList?.add("元/台班")
        mStringList?.add("元/小时")
        mStringList?.add("面议")
        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>,this)


    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    override fun onItemClick(view: View, position: Int) {
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_no_element->showInput()
            R.id.ly_ec_type -> jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcType::class.java
            )
            R.id.ly_ec_brand -> jumpActivityForReSult(
                Configs.EC_BRAND_RESULT_CODE,
                Brand::class.java
            )
            R.id.ly_ec_model -> jumpActivityForReSult(
                Configs.EC_MODEL_RESULT_CODE,
                EcModel::class.java
            )
            R.id.ly_address->jumpActivity(null,AddressSelActivity::class.java)
        }
    }



    private fun showInput() {

        this?.let { PopUtils.init(it,
            R.layout.pop_way,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT, this) }
        PopUtils.showPopupWindow(tv_no_element)
    }


    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mPopWayAdapter = PopWayAdapter(this,mStringList,this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mPopWayAdapter
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        showResult(requestCode, data?.getStringExtra(Configs.SCREEN_RESULT_Extra))
        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showResult(requestCode: Int, extra: String?) {
        if (extra.isNullOrEmpty()){
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> et_ec_type.text = extra
            Configs.EC_BRAND_RESULT_CODE -> et_ec_brand.text = extra
            Configs.EC_MODEL_RESULT_CODE -> et_ec_model.text = extra
        }

    }
}
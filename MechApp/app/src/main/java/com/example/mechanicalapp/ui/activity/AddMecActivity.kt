package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.MyMecPresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import kotlinx.android.synthetic.main.activity_add_mec.*
import kotlinx.android.synthetic.main.layout_title.*
import java.util.*
import kotlin.collections.ArrayList

class AddMecActivity:BaseCusActivity(),View.OnClickListener,OnItemClickListener,
    OnTimeSelectListener ,BaseView<NetData>{


    private var mPicAdapter: PicAdapter? = null
    private var mPicList: MutableList<String> = ArrayList<String>()

    private var mPresenter: MyMecPresenter?=null

    override fun getLayoutId(): Int {

        return R.layout.activity_add_mec

    }

    override fun initView() {
        super.initView()

        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>, this)
        ry_pic.layoutManager = GridLayoutManager(this, 3)
        ry_pic.adapter = mPicAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "添加设备"
        ly_production_time.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        ly_buy_time.setOnClickListener(this)
    }

    override fun initPresenter() {
        mPresenter = MyMecPresenter(this)
        mPresenter?.getMecList()
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.ly_production_time -> showTime()
            R.id.ly_buy_time->showTime()
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
        }
    }
    private fun showTime() {
        val mTimePickerView = TimePickerBuilder(this, this).build()
        mTimePickerView.show()
    }



    override fun onItemClick(view: View, position: Int) {


    }

    override fun onTimeSelect(p0: Date?, p1: View?) {


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
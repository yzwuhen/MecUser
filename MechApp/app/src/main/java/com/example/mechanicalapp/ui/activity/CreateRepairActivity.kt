package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_repair.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class CreateRepairActivity :BaseActivity<NetData>(),View.OnClickListener,OnItemClickListener{


    override fun getLayoutId(): Int {

        return R.layout.activity_repair
    }

    override fun initView() {
        super.initView()

        iv_left.setOnClickListener(this)
        ly_right.setOnClickListener(this)
        tv_title.text ="创建维修单"

        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        ly_mec_factory.setOnClickListener(this)

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
            R.id.ly_mec_factory->jumpActivityForReSult(
                Configs.FACTORY_RESULT_CODE,
                MaintenanceActivity::class.java
            )
//            R.id.ly_right->
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        showResult(requestCode, data?.getStringExtra(Configs.EC_RESULT_Extra))
        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showResult(requestCode: Int, extra: String?) {
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> et_ec_type.text = extra
            Configs.EC_BRAND_RESULT_CODE -> et_ec_brand.text = extra
            Configs.EC_MODEL_RESULT_CODE -> et_ec_model.text = extra
            Configs.FACTORY_RESULT_CODE -> et_mec_factory.text = extra
        }

    }

    override fun onItemClick(view: View, position: Int) {


    }
}
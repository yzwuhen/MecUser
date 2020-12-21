package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReFactoryOrder
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.FactoryOrderView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_repair.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class CreateRepairActivity : BaseCusActivity(), View.OnClickListener, OnItemClickListener,
    TextWatcher, PopUtils.onViewListener,
    FactoryOrderView<NetData> {


    private var mBean = ReFactoryOrder()
    private var mPresenter: AddManagePresenterImpl? = null


    private var popTvTitle: TextView? = null
    private var popTvInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null


    override fun getLayoutId(): Int {

        return R.layout.activity_repair
    }

    override fun initView() {
        super.initView()

        ly_left.setOnClickListener(this)
        ly_right.setOnClickListener(this)
        tv_title.text = "创建维修单"

        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        ly_mec_factory.setOnClickListener(this)
        tv_submit.setOnClickListener(this)
        et_contacts.addTextChangedListener(this)
        et_phone.addTextChangedListener(this)
        et_company_name.addTextChangedListener(this)
        et_input.addTextChangedListener(this)

        mPresenter = AddManagePresenterImpl(this, this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    private fun showPhone() {

        if (mPopwindow == null) {
            mPopwindow = this?.let {
                PopUtils.init(
                    this,
                    it, R.layout.pop_center_phone,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
        }

        this?.let { PopUtils.showPopupWindow(tv_title, it) }
    }

    override fun getView(view: View?) {

        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popTvTitle = view?.findViewById(R.id.tv_pop_title)
        popTvInfo = view?.findViewById(R.id.tv_pop_info)
        popTvTitle?.text = ""
        popTvInfo?.text = "请问是否呼叫 400-989-654"
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.ly_left -> finish()
            R.id.ly_mec_factory -> jumpActivityForReSult(
                Configs.FACTORY_RESULT_CODE,
                MaintenanceActivity::class.java
            )
            R.id.ly_ec_type -> jumpActivityForResult(
                Configs.EC_TYPE_RESULT_CODE,
                1,
                EcType::class.java
            )
            R.id.ly_ec_brand -> jumpActivityForResult(
                Configs.EC_BRAND_RESULT_CODE,
                1,
                Brand::class.java
            )
            R.id.ly_ec_model -> jumpActivityForResult(
                Configs.EC_MODEL_RESULT_CODE,
                1,
                EcModel::class.java
            )
            R.id.ly_address -> jumpActivityForResult(
                Configs.ADDRESS_RESULT_CODE,
                1,
                AddressSelActivity::class.java
            )
            R.id.tv_submit -> submit()
            R.id.tv_pop_sure ->{
                openCall("400989564")
                PopUtils.dismissPop(this)
            }
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
            R.id.ly_right -> showPhone()
//            R.id.ly_right->
        }
    }

    private fun submit() {

        if (checkInfo()) {
            mPresenter?.addFactoryOrder(mBean)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == Configs.ADDRESS_RESULT_CODE) {
            data?.getStringExtra(Configs.SCREEN_RESULT_Extra)?.let {
                showAddress(
                    it,
                    data?.getStringExtra(Configs.SCREEN_RESULT_ID),
                    data?.getStringExtra(Configs.CITY_NAME),
                    data?.getDoubleExtra(Configs.CITY_LAT, 0.0),
                    data?.getDoubleExtra(Configs.CITY_LOT, 0.0)
                )
            }
        } else if (requestCode == Configs.FACTORY_RESULT_CODE) {
            showFactoryInfo(
                data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
                data?.getStringExtra(Configs.SCREEN_RESULT_ID),
                data?.getStringExtra(Configs.FACTORY_ADDRESS)
            )
        } else {
            showResult(
                requestCode,
                data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
                data?.getStringExtra(Configs.SCREEN_RESULT_ID)
            )
        }

        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showFactoryInfo(
        stringExtra: String?,
        stringExtra1: String?,
        stringExtra2: String?
    ) {

        et_mec_factory.text = stringExtra
        mBean.repairFactoryName = stringExtra
        mBean.repairFactoryId = stringExtra1
        mBean.repairFactoryAddress = stringExtra2
    }

    private fun showAddress(
        address: String,
        cityId: String?,
        city: String?,
        lat: Double,
        lot: Double
    ) {
        et_address.text = address
        //   mBean.city = city
        mBean.adress = address
        mBean.lat = lat.toString()
        mBean.lng = lot.toString()
    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                et_ec_type.text = extra
                mBean.productType = extra
                mBean.productTypeId = extraId
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                et_ec_brand.text = extra
                mBean.productBrand = extra
                mBean.productBrandId = extraId
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                et_ec_model.text = extra
                mBean.productModel = extra
                mBean.productModelId = extraId
            }
        }

    }

    override fun onItemClick(view: View, position: Int) {


    }


    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {

        changeBtn()
    }

    private fun changeBtn() {
        tv_submit.isSelected = checkInfo()
    }

    private fun checkInfo(): Boolean {


        if (TextUtils.isEmpty(mBean.repairFactoryName)) {
            return false
        }
//        if (TextUtils.isEmpty(mBean.productType)) {
//            return false
//        }
//        if (TextUtils.isEmpty(mBean.productBrand)) {
//            return false
//        }
//
//        if (TextUtils.isEmpty(mBean.productModel)) {
//            return false
//        }
        if (TextUtils.isEmpty(mBean.adress)) {
            return false
        }


        if (TextUtils.isEmpty(et_phone.text.toString().trim())) {
            return false
        }
        mBean.customerPhone = et_phone.text.toString().trim()

        if (TextUtils.isEmpty(et_contacts.text.toString().trim())) {
            return false
        }
        mBean.customerName = et_contacts.text.toString().trim()


//        if (TextUtils.isEmpty(et_company_name.text.toString().trim())) {
//            return false
//        }
        mBean.companyName = et_company_name.text.toString().trim()
//


        mBean.orderDesc = et_input.text.toString().trim()

        return true
    }

    override fun showData(netData: NetData) {

        ToastUtils.showText(netData?.message)
        if (netData?.code == 200) {
            finish()
        }
    }


}
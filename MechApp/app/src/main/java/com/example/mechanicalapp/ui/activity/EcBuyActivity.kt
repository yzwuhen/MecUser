package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecBusiness
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.ReleaseView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_ec_buy.*
import kotlinx.android.synthetic.main.layout_title.*

class EcBuyActivity : BaseCusActivity(), View.OnClickListener,TextWatcher,
    ReleaseView<List<CodeData>> {



    private var mPresenter: AddManagePresenterImpl? = null
    private var mReMecBusiness = ReMecBusiness()

    override fun getLayoutId(): Int {

        return R.layout.activity_ec_buy
    }

    override fun initView() {
        super.initView()


        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        tv_submit.setOnClickListener(this)
        tv_title.text = "机械求购"

        mReMecBusiness.bussiessType = "2"//出售

        mPresenter = AddManagePresenterImpl(this, this)


        et_ec_name.addTextChangedListener(this)
        et_work_time.addTextChangedListener(this)

        et_phone.addTextChangedListener(this)
        et_name.addTextChangedListener(this)
        et_price.addTextChangedListener(this)
        et_input.addTextChangedListener(this)

    }

    override fun initPresenter() {
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
            R.id.tv_submit->submit()
        }
    }

    private fun submit() {

        if (checkInfo()) {
            (mPresenter as AddManagePresenterImpl).addMecBusiness(mReMecBusiness)
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
        } else {
            showResult(
                requestCode,
                data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
                data?.getStringExtra(Configs.SCREEN_RESULT_ID)
            )
        }

        super.onActivityResult(requestCode, resultCode, data)

    }
    private fun showAddress(
        address: String,
        cityId: String?,
        city: String?,
        lat: Double,
        lot: Double
    ) {
        et_address.text = address
        mReMecBusiness.city = city
        mReMecBusiness.address = address
        mReMecBusiness.gpsLat = lat.toString()
        mReMecBusiness.gpsLon = lot.toString()
    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                et_ec_type.text = extra
                mReMecBusiness.cateName = extra
                mReMecBusiness.cateId = extraId
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                et_ec_brand.text = extra
                mReMecBusiness.brandName = extra
                mReMecBusiness.brandId = extraId
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                et_ec_model.text = extra
                mReMecBusiness.modelName = extra
                mReMecBusiness.modelId = extraId
            }
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {

        changeBtn()
    }


    private fun changeBtn() {
        tv_submit.isSelected = checkInfo()
    }

    private fun checkInfo(): Boolean {

        if (TextUtils.isEmpty(et_ec_name.text.toString().trim())) {
            return false
        }
        mReMecBusiness.title = et_ec_name.text.toString().trim()


        if (TextUtils.isEmpty(mReMecBusiness.address)) {
            return false
        }

        if (TextUtils.isEmpty(mReMecBusiness.cateName)) {
            return false
        }
        if (TextUtils.isEmpty(mReMecBusiness.brandName)) {
            return false
        }
        if (TextUtils.isEmpty(mReMecBusiness.modelName)) {
            return false
        }

        if (TextUtils.isEmpty(et_work_time.text.toString().trim())) {
            return false
        }
        mReMecBusiness.workTime = et_work_time.text.toString().trim()

        if (TextUtils.isEmpty(et_phone.text.toString().trim())) {
            return false
        }
        mReMecBusiness.contactPhone = et_phone.text.toString().trim()

        if (TextUtils.isEmpty(et_name.text.toString().trim())) {
            return false
        }
        mReMecBusiness.contactName = et_name.text.toString().trim()

        if (TextUtils.isEmpty(et_price.text.toString().trim())) {
            return false
        }
        mReMecBusiness.price = et_price.text.toString().trim()

        mReMecBusiness.briefDesc =et_input.text.toString().trim()

        return true
    }

    override fun showImg(netData: NetData?) {
    }

    override fun uploadFail(str: String) {

        ToastUtils.showText(str)
    }

    override fun showSuccess(netData: NetData?) {
        ToastUtils.showText(netData?.message)
        if (netData?.code==200){
            finish()
        }
    }

    override fun showData(t: List<CodeData>) {
    }
}
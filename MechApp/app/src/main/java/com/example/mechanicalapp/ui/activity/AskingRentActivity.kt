package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.InputFilter
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PopWayAdapter
import com.example.mechanicalapp.ui.adapter.YearsAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecLease
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.MecMecAskRentView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_ask_rent.*
import kotlinx.android.synthetic.main.layout_title.*
import java.lang.Exception

class AskingRentActivity : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener, MecMecAskRentView, TextWatcher {


    private var mStringList: MutableList<CodeData> = ArrayList<CodeData>()
    private var popRecy: RecyclerView? = null
    private var mPopWayAdapter: PopWayAdapter? = null

    private var mButtDialog: BottomSheetDialog? = null

    private var mDialogView: View? = null
    private var mRecyDialog: RecyclerView? = null
    private var mYears: MutableList<CodeData> = ArrayList<CodeData>()
    private var mYearsAdapter: YearsAdapter? = null
    private var mSure: TextView? = null
    private var mCancel: TextView? = null

    private var mReMecLease = ReMecLease()
    private var mPresenter: AddManagePresenterImpl? = null

    private var index = -1
    override fun getLayoutId(): Int {

        return R.layout.activity_ask_rent
    }

    override fun initView() {
        super.initView()



        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "机械求租"
        tv_way.setOnClickListener(this)
        ly_rent_time.setOnClickListener(this)
        ly_production_time.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        tv_submit.setOnClickListener(this)

        mReMecLease.bussiessType = "2"
        mPresenter = AddManagePresenterImpl(this, this)

        (mPresenter as AddManagePresenterImpl).getBillMethod()
        (mPresenter as AddManagePresenterImpl).getYearsTime()


        et_ec_name.addTextChangedListener(this)
        et_way.addTextChangedListener(this)
        et_ec_num.addTextChangedListener(this)
        et_work_time.addTextChangedListener(this)
        et_name.addTextChangedListener(this)
        et_phone.addTextChangedListener(this)
        et_input.addTextChangedListener(this)
        et_input.filters=arrayOf(InputFilter.LengthFilter(200))
    }

    override fun initPresenter() {
    }

    override fun showYears(t: List<CodeData>) {
        mYears.clear()
        mYears.addAll(t)

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

        mStringList.clear()
        mStringList.addAll(t)
        if (mStringList.size > 0) {
            tv_way?.text = mStringList[0].itemText
            mReMecLease.priceUnit = mStringList[0].itemValue
        }
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

    override fun onItemClick(view: View, position: Int) {
        when (view?.id) {
            R.id.tv_screen -> {
                tv_way?.text = mStringList[position].itemText
                mReMecLease.priceUnit = mStringList[position].itemValue
                PopUtils.dismissPop()
            }
            R.id.tv_text -> {
                if (index != -1) {
                    mYears[index].isSelect = false
                }
                mYears[position].isSelect = true
                mYearsAdapter?.notifyDataSetChanged()
                index = position
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_way -> showInput()
            R.id.ly_production_time -> showDialog()
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
            R.id.tv_finish -> selectTime()
            R.id.tv_cancel -> cancleTime()
            R.id.tv_submit->submit()
        }
    }
    private fun submit() {
        if (checkInfo()){
            (mPresenter as AddManagePresenterImpl).addMecLease(mReMecLease)
        }
    }

    private fun cancleTime() {
        mButtDialog?.dismiss()
    }

    private fun selectTime() {
        mButtDialog?.dismiss()
        try {
            et_production_time.text = mYears[index].itemText
            mReMecLease.facTime = mYears[index].itemValue
        }catch (e:Exception){

        }
    }

    private fun showInput() {

        this?.let {
            PopUtils.init(
                it,
                R.layout.pop_way,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, this
            )
        }
        PopUtils.showPopupWindow(tv_way)
    }

    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mPopWayAdapter = PopWayAdapter(this, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mPopWayAdapter
    }

    private fun showDialog() {
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(this)

            mDialogView = View.inflate(this, R.layout.dialog_selsec_years, null)
            mButtDialog?.setContentView(mDialogView!!)
            mRecyDialog = mDialogView?.findViewById(R.id.recycler_years)

            mRecyDialog?.layoutManager = GridLayoutManager(this, 3)

            mSure = mDialogView?.findViewById(R.id.tv_finish)
            mCancel = mDialogView?.findViewById(R.id.tv_cancel)
            mYearsAdapter = YearsAdapter(this, mYears, this)
            mRecyDialog?.adapter = mYearsAdapter
            mSure?.setOnClickListener(this)
            mCancel?.setOnClickListener(this)
        }

        mButtDialog?.show()
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
        mReMecLease.city = city
        mReMecLease.address = address
        mReMecLease.gpsLat = lat
        mReMecLease.gpsLon = lot
    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                et_ec_type.text = extra
                mReMecLease.cateName = extra
                mReMecLease.cateId = extraId
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                et_ec_brand.text = extra
                mReMecLease.brandName = extra
                mReMecLease.brandId = extraId
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                et_ec_model.text = extra
                mReMecLease.modelName = extra
                mReMecLease.modelId = extraId
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
        mReMecLease.title = et_ec_name.text.toString().trim()

        if (TextUtils.isEmpty(et_way.text.toString().trim())) {
            return false
        }
        mReMecLease.price = et_way.text.toString().trim()

        if (TextUtils.isEmpty(mReMecLease.cateName)) {
            return false
        }
        if (TextUtils.isEmpty(mReMecLease.brandName)) {
            return false
        }
        if (TextUtils.isEmpty(mReMecLease.modelName)) {
            return false
        }
        if (TextUtils.isEmpty(mReMecLease.facTime)) {
            return false
        }


        if (TextUtils.isEmpty(et_ec_num.text.toString().trim())) {
            return false
        }
        mReMecLease.mecUnit = et_ec_num.text.toString().trim()

        if (TextUtils.isEmpty(et_work_time.text.toString().trim())) {
            return false
        }
        mReMecLease.tenancy = et_work_time.text.toString().trim()



        if (TextUtils.isEmpty(et_name.text.toString().trim())) {
            return false
        }
        mReMecLease.contactName = et_name.text.toString().trim()


        if (TextUtils.isEmpty(et_phone.text.toString().trim())) {
            return false
        }
        mReMecLease.contactPhone = et_phone.text.toString().trim()

        if (TextUtils.isEmpty(et_address.text.toString().trim())) {
            return false
        }
        mReMecLease.address = et_address.text.toString().trim()
        mReMecLease.briefDesc = et_input.text.toString().trim()
        tv_tip.text="${et_input.text.length}/200"
        return true
    }
}
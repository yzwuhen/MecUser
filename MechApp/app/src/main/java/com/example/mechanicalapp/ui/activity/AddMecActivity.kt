package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.bigkoo.pickerview.view.TimePickerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReAddMec
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.impl.AddMecPresenter
import com.example.mechanicalapp.ui.mvp.v.PersonCerView
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.GlideEngine
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_add_mec.*
import kotlinx.android.synthetic.main.layout_title.*
import java.util.*
import kotlin.collections.ArrayList

class AddMecActivity : BaseCusActivity(), View.OnClickListener, OnItemClickListener, TextWatcher,
    OnTimeSelectListener, PersonCerView {


    private var mPicAdapter: PicAdapter? = null
    private var mPicList: MutableList<String> = ArrayList<String>()

    private var mPresenter: AddMecPresenter? = null
    private var reAddMec = ReAddMec()

    private var mButtDialog: BottomSheetDialog? = null
    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null
    private var mTimePickerView: TimePickerView? = null

    private var timeType = 0
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
        ly_address.setOnClickListener(this)
        tv_submit.setOnClickListener(this)

        et_ec_name.addTextChangedListener(this)
        et_work_time.addTextChangedListener(this)
        et_input.addTextChangedListener(this)
    }

    override fun initPresenter() {
        mPresenter = AddMecPresenter(this, this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.ly_production_time -> showTime(0)
            R.id.ly_buy_time -> showTime(1)
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
            R.id.tv_dialog_item1 -> setItem()
            R.id.tv_dialog_item2 -> setItem1()
            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
            R.id.tv_submit->submit()
        }
    }
    private fun submit() {
        if (checkInfo()){
            for (str in mPicList){
                reAddMec.pic ="$str,"
            }
            reAddMec.pic= reAddMec.pic.substring(0,reAddMec.pic.length-1)
            (mPresenter as AddMecPresenter).addMec(reAddMec)
        }
    }

    private fun setItem1() {
        mButtDialog?.dismiss()
        verifyStoragePermissions(this)
    }

    private fun setItem() {
        mButtDialog?.dismiss()
        takePoto()
    }


    private fun takePoto() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openCamera(PictureMimeType.ofImage())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: MutableList<LocalMedia?>) {
                    mPresenter?.upLoadFile(result[0]?.realPath.toString())
                }

                override fun onCancel() {
                }
            });
    }

    private fun takePicture() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofAll())
            .imageEngine(GlideEngine.createGlideEngine())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                    mPresenter?.upLoadFile(result[0]?.realPath.toString())
                }

                override fun onCancel() {
                    // 取消
                }
            })
    }

    override fun hasPermissions() {
        super.hasPermissions()
        takePicture()
    }

    private fun showTime(type: Int) {
        timeType = type
        if (mTimePickerView == null) {
            mTimePickerView = TimePickerBuilder(this, this).build()
        }

        mTimePickerView?.show()
    }


    override fun onItemClick(view: View, position: Int) {
        if (position == mPicList?.size) {
            showDialogType()
        }

    }

    private fun showDialogType() {
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(this)
            mDialogView = View.inflate(this, R.layout.dialog_user_data_buttom, null)
            mButtDialog?.setContentView(mDialogView!!)
            mDialogTv1 = mDialogView?.findViewById(R.id.tv_dialog_item1)
            mDialogTv2 = mDialogView?.findViewById(R.id.tv_dialog_item2)
            mDialogTv3 = mDialogView?.findViewById(R.id.tv_dialog_item3)
        }
        mDialogTv1?.setOnClickListener(this)
        mDialogTv2?.setOnClickListener(this)
        mDialogTv3?.setOnClickListener(this)

        mButtDialog?.show()
    }

    override fun onTimeSelect(date: Date?, p1: View?) {

        if (timeType == 0) {
            reAddMec.facDate = DateUtils.dateToStr(date)
            et_production_time.text = DateUtils.dateToStr(date)
        } else {
            reAddMec.purchaseDate = DateUtils.dateToStr(date)
            et_buy_time.text = DateUtils.dateToStr(date)
        }

        changeBtn()
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
        reAddMec.city = city
        reAddMec.address = address
        reAddMec.gpsLat = lat
        reAddMec.gpsLon = lot
    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                et_ec_type.text = extra
                reAddMec.cateName = extra
                reAddMec.cateId = extraId
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                et_ec_brand.text = extra
                reAddMec.brandName = extra
                reAddMec.brandId = extraId
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                et_ec_model.text = extra
                reAddMec.modelName = extra
                reAddMec.modelId = extraId
            }

        }

    }

    override fun success(netData: NetData?) {
        ToastUtils.showText(netData?.message)
        if (netData?.code == 200) {
            finish()
        }
    }

    override fun showImg(netData: NetData?) {
        if (netData != null && netData.code == 200) {
            mPicList?.add(netData.message)
            mPicAdapter?.notifyDataSetChanged()
            changeBtn()
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
        reAddMec.titile = et_ec_name.text.toString().trim()


        if (TextUtils.isEmpty(reAddMec.cateName)) {
            return false
        }
        if (TextUtils.isEmpty(reAddMec.brandName)) {
            return false
        }
        if (TextUtils.isEmpty(reAddMec.modelName)) {
            return false
        }

        if (TextUtils.isEmpty(et_work_time.text.toString().trim())) {
            return false
        }
        reAddMec.workTime = et_work_time.text.toString().trim()

        if (TextUtils.isEmpty(reAddMec.address)) {
            return false
        }

        if (TextUtils.isEmpty(reAddMec.facDate)) {
            return false
        }

        if (TextUtils.isEmpty(reAddMec.purchaseDate)) {
            return false
        }

        reAddMec.briefDesc = et_input.text.toString().trim()

        if (mPicList.size == 0) {
            return false
        }
        return true
    }

    override fun uploadFail(str: String) {

        ToastUtils.showText(str)
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }


}
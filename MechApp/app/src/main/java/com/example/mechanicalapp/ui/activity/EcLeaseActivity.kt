package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.adapter.PopWayAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecLease
import com.example.mechanicalapp.ui.mvp.impl.AddMecManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.impl.UpdateFilePresenterImpl
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.GlideEngine
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_ec_lease.*
import kotlinx.android.synthetic.main.layout_title.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * 机械出租
 */
class EcLeaseActivity : BaseActivity<NetData>(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener, OnTimeSelectListener,TextWatcher {

    private var mPicAdapter: PicAdapter? = null

    private var mPicList: MutableList<String> =ArrayList<String>()

    private var mStringList: MutableList<String> = ArrayList<String>()
    private var popRecy: RecyclerView? = null
    private var mPopWayAdapter: PopWayAdapter? = null


    private var mReMecLease = ReMecLease()

    private var strPic: String = ""
    private var mButtDialog: BottomSheetDialog? = null

    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null

    private var mPresenter: AddMecManagePresenterImpl?=null
    private var mUpLoadFilePresenter :UpdateFilePresenterImpl?=null

    override fun getLayoutId(): Int {

        return R.layout.activity_ec_lease
    }

    override fun initView() {
        super.initView()
        mPicAdapter = PicAdapter(this, mPicList, this)
        var mLinearLayoutManager =LinearLayoutManager(this)
        mLinearLayoutManager.orientation =LinearLayoutManager.HORIZONTAL
        ry_pic.layoutManager = mLinearLayoutManager
        ry_pic.adapter = mPicAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "机械出租"
        tv_way.setOnClickListener(this)
        ly_production_time.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        ly_address.setOnClickListener(this)

        mStringList?.add("元/月")
        mStringList?.add("元/台班")
        mStringList?.add("元/小时")
        mStringList?.add("面议")

        mReMecLease.bussiessType ="1"

        mPresenter = AddMecManagePresenterImpl(this,this)
        mUpLoadFilePresenter = UpdateFilePresenterImpl(this,this)


        et_ec_name.addTextChangedListener(this)
        et_way.addTextChangedListener(this)
        et_work_time.addTextChangedListener(this)
        et_phone.addTextChangedListener(this)
        et_name.addTextChangedListener(this)
        et_production_time.addTextChangedListener(this)
        et_address.addTextChangedListener(this)
        et_input.addTextChangedListener(this)

    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

    override fun onItemClick(view: View, position: Int) {
        when(view?.id){
            R.id.tv_screen->{
                tv_way?.text = mStringList[position]
                PopUtils.dismissPop()
            }
            R.id.iv_del->{
                mPicList?.removeAt(position)
                mPicAdapter?.notifyDataSetChanged()
            }
            R.id.iv_pic->{
                if (position==mPicList?.size){
                    showDialogType()
                }
            }
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_way -> showInput()
            R.id.ly_production_time -> showTime()
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

        }
    }

    private fun setItem1() {
        mButtDialog?.dismiss()
        verifyStoragePermissions(this)
    }

    private fun setItem() {
        mButtDialog?.dismiss()
       // verifyStoragePermissions(this)
        takePoto()
    }

    private fun showTime() {
        val mTimePickerView = TimePickerBuilder(this, this).build()
        mTimePickerView.show()
    }


    private fun showInput() {

        this?.let {
            PopUtils.init(
                it,
                R.layout.pop_way,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                this
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

    override fun onTimeSelect(date: Date?, v: View?) {

        mReMecLease.facDate=DateUtils.dateToStr(date)
        et_production_time.text =DateUtils.dateToStr(date)
      //  Log.e("yz_mec", "======${DateUtils.dateToStr(date)}")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        showResult(
            requestCode,
            data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
            data?.getStringExtra(Configs.SCREEN_RESULT_ID)
        )
        super.onActivityResult(requestCode, resultCode, data)

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
            Configs.ADDRESS_RESULT_CODE->{
                et_address.text =extra
                mReMecLease.city = extra
            }
        }

    }

    private fun takePoto(){
        PictureSelector.create(this)
            .openCamera(PictureMimeType.ofImage())
            .forResult(object :OnResultCallbackListener<LocalMedia?>{
                override fun onResult(result: MutableList<LocalMedia?>) {
                    mUpLoadFilePresenter?.upLoadFile(result[0]?.realPath.toString())
                    mPicList?.add(result[0]?.realPath.toString())
                    mPicAdapter?.notifyDataSetChanged()
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
                  //  imgUrl = result[0]?.path.toString()
                    mUpLoadFilePresenter?.upLoadFile(result[0]?.realPath.toString())
                    mPicList?.add(result[0]?.realPath.toString())
                    mPicAdapter?.notifyDataSetChanged()

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

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {
        Log.e("yz_mec","================="+et_ec_name.text.toString())
        checkInfo()
    }

    private fun checkInfo() {
        if (!TextUtils.isEmpty(et_ec_name.text.toString().trim())){
            mReMecLease.tittle =et_ec_name.text.toString().trim()
        }

        if (!TextUtils.isEmpty(et_way.text.toString().trim())){
            mReMecLease.price =et_way.text.toString().trim()
        }

        if (!TextUtils.isEmpty(et_ec_type.text.toString().trim())){
            mReMecLease.cateName =et_ec_type.text.toString().trim()
        }

        if (!TextUtils.isEmpty(et_ec_brand.text.toString().trim())){
            mReMecLease.brandName =et_ec_brand.text.toString().trim()
        }

        if (!TextUtils.isEmpty(et_ec_model.text.toString().trim())){
            mReMecLease.modelName =et_ec_model.text.toString().trim()
        }

        if (!TextUtils.isEmpty(et_work_time.text.toString().trim())){
            mReMecLease.workTime =et_work_time.text.toString().trim()
        }

        if (!TextUtils.isEmpty(et_phone.text.toString().trim())){
            mReMecLease.contactPhone =et_phone.text.toString().trim()
        }

        if (!TextUtils.isEmpty(et_name.text.toString().trim())){
            mReMecLease.contactName =et_name.text.toString().trim()
        }

        if (!TextUtils.isEmpty(et_production_time.text.toString().trim())){
            mReMecLease.facDate =et_production_time.text.toString().trim()
        }
        if (!TextUtils.isEmpty(et_address.text.toString().trim())){
            mReMecLease.city =et_address.text.toString().trim()
        }

//        if (!TextUtils.isEmpty(et_input.text.toString().trim())){
//            mReMecLease.tenancy =et_input.text.toString().trim()
//        }


    }

}
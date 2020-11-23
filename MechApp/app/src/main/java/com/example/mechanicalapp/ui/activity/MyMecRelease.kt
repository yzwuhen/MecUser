package com.example.mechanicalapp.ui.activity

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicMecAdapter
import com.example.mechanicalapp.ui.adapter.PopWayAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecLease
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.ReleaseView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_my_mec_release.*
import kotlinx.android.synthetic.main.layout_title.*

class MyMecRelease : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener, TextWatcher, ReleaseView<List<CodeData>> {

    private var mPicAdapter: PicMecAdapter? = null

    private var mPicList: MutableList<String> = ArrayList<String>()

    private var mStringList: MutableList<CodeData> = ArrayList<CodeData>()
    private var popRecy: RecyclerView? = null
    private var mPopWayAdapter: PopWayAdapter? = null

    private var mReMecLease = ReMecLease()

    private var mPresenter: AddManagePresenterImpl? = null

    override fun getLayoutId(): Int {

        return R.layout.activity_my_mec_release
    }

    override fun initView() {
        super.initView()
        mPicAdapter = PicMecAdapter(this, mPicList, this)
        var mLinearLayoutManager = LinearLayoutManager(this)
        mLinearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        ry_pic.layoutManager = mLinearLayoutManager
        ry_pic.adapter = mPicAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "机械出租"
        tv_way.setOnClickListener(this)
        tv_submit.setOnClickListener(this)

        mPresenter = AddManagePresenterImpl(this, this)
        (mPresenter as AddManagePresenterImpl).getBillMethod()
        et_way.addTextChangedListener(this)
        mReMecLease = intent.getSerializableExtra("data") as ReMecLease
        showInfo()
    }

    private fun showInfo() {
        et_ec_name.text =mReMecLease.tittle
        et_ec_type.text =mReMecLease.cateName
        et_ec_brand.text =mReMecLease.brandName
        et_ec_model.text =mReMecLease.modelName
        et_work_time.text =mReMecLease.workTime
        et_phone.text =mReMecLease.contactPhone
        et_name.text =mReMecLease.contactName
        et_production_time.text =mReMecLease.facDate
        et_address.text =mReMecLease.address
        et_input.text =mReMecLease.briefDesc
        if (!TextUtils.isEmpty(mReMecLease.pic)){
            for (str in mReMecLease.pic.split(",")){
                mPicList.add(str)
            }
            mPicAdapter?.notifyDataSetChanged()
        }

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
        ToastUtils.showText("请求失败")
    }

    override fun onItemClick(view: View, position: Int) {
        when (view?.id) {
            R.id.tv_screen -> {
                tv_way?.text = mStringList[position].itemText
                mReMecLease.priceUnit = mStringList[position].itemValue
                PopUtils.dismissPop()
            }
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_way -> showInput()
            R.id.tv_submit->submit()

        }
    }

    private fun submit() {
        if (checkInfo()){
            for (str in mPicList){
                mReMecLease.pic +="$str,"
            }
            mReMecLease.pic= mReMecLease.pic.substring(0,mReMecLease.pic.length-1)
            (mPresenter as AddManagePresenterImpl).addMecLease(mReMecLease)
        }
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

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {
        changeBtn()
    }

    private fun changeBtn() {
        tv_submit.isSelected =checkInfo()
    }

    private fun checkInfo(): Boolean {
        if (TextUtils.isEmpty(et_way.text.toString().trim())) {
            return false
        }
        mReMecLease.price = et_way.text.toString().trim()
        return true
    }

    override fun showImg(netData: NetData?) {

    }

    override fun uploadFail(str: String) {

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
        if (mStringList.size>0){
            tv_way?.text = mStringList[0].itemText
            mReMecLease.priceUnit = mStringList[0].itemValue
        }
    }

}
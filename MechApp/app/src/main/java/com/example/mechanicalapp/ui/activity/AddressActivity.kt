package com.example.mechanicalapp.ui.activity

import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import com.contrarywind.listener.OnItemSelectedListener
import com.contrarywind.view.WheelView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.CityWheelAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CityData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReAddress
import com.example.mechanicalapp.ui.mvp.impl.AddressPresenterImpl
import com.example.mechanicalapp.ui.mvp.v.AddressView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.layout_title.*
import java.lang.Exception

class AddressActivity : BaseCusActivity(), View.OnClickListener, AddressView {

    private var mPresenter: AddressPresenterImpl? = null
    private var mPopwindow: PopupWindow? = null
    private var dialogCancel: TextView? = null
    private var dialogSure: TextView? = null
    private var dialogWheel1: WheelView? = null
    private var dialogWheel2: WheelView? = null
    private var dialogWheel3: WheelView? = null

    private var mList1 = ArrayList<CityData>()
    private var mList2 = ArrayList<CityData>()
    private var mList3 = ArrayList<CityData>()
    private var adapter1: CityWheelAdapter? = null
    private var adapter2: CityWheelAdapter? = null
    private var adapter3: CityWheelAdapter? = null


    private var reAddress = ReAddress()
    private var type = 0

    override fun getLayoutId(): Int {

        return R.layout.activity_address
    }

    override fun initView() {
        super.initView()


        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        type = intent.getIntExtra("address_type", 0)
        if (type == 0) {
            tv_title.text = "添加地址"
        } else {
            tv_title.text = "编辑地址"

            reAddress = intent.getSerializableExtra("data") as ReAddress
            showAddress()
        }

        ly_sel_address.setOnClickListener(this)
        tv_btn.setOnClickListener(this)
        tv_default.setOnClickListener(this)
    }

    private fun showAddress() {
        et_user_name.setText(reAddress.name)
        et_user_phone.setText(reAddress.phone)
        et_take_goods_address.text = reAddress.area
        et_address_details.setText(reAddress.adress)
        tv_default.isSelected = reAddress.isDefault == 1
    }

    override fun initPresenter() {

        mPresenter = AddressPresenterImpl(this)
        mPresenter?.getCity()
    }

    override fun showCity(list: List<CityData>) {
        mList1.clear()
        mList1.addAll(list)

    }

    override fun showData(netData: NetData?) {

        ToastUtils.showText(netData?.message)
        if (netData?.code == 200) {
            finish()
        }

    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_btn -> submit()
            R.id.ly_sel_address -> showCityDialog()
            R.id.tv_cancel -> PopUtils.dismissPop(this)
            R.id.tv_sure -> selCity()
            R.id.tv_default -> checkDefault()
        }
    }

    private fun checkDefault() {
        //修正
        if (reAddress.isDefault == 0) {
            tv_default.isSelected = true
            reAddress.isDefault = 1
        } else {
            tv_default.isSelected = false
            reAddress.isDefault = 0
        }
    }

    private fun selCity() {
        PopUtils.dismissPop(this)

        try {
            reAddress.area =
                "${mList1[dialogWheel1?.currentItem!!].name},${mList2[dialogWheel2?.currentItem!!].name},${mList3[dialogWheel3?.currentItem!!].name}"
            reAddress.areaId = mList3[dialogWheel3?.currentItem!!].code
            et_take_goods_address.text = reAddress.area
        } catch (e: Exception) {

        }
    }

    private fun showCityDialog() {

        if (mPopwindow == null) {
            mPopwindow = this?.let {
                PopUtils.init(
                    this,
                    it, R.layout.dialog_city_sel,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, object : PopUtils.onViewListener {
                        override fun getView(view: View?) {

                            dialogCancel = view?.findViewById(R.id.tv_cancel)
                            dialogSure = view?.findViewById(R.id.tv_sure)
                            dialogWheel1 = view?.findViewById(R.id.wheelview1)
                            dialogWheel2 = view?.findViewById(R.id.wheelview2)
                            dialogWheel3 = view?.findViewById(R.id.wheelview3)

                            dialogCancel?.setOnClickListener(this@AddressActivity)
                            dialogSure?.setOnClickListener(this@AddressActivity)


                            if (mList1[0].children.isNotEmpty()) {
                                mList2.clear()
                                mList2.addAll(mList1[0].children)
                            }
                            if (mList2.isNotEmpty()) {
                                mList3.clear()
                                mList3.addAll(mList2[0].children)
                            }

                            adapter1 = CityWheelAdapter(mList1)
                            adapter2 = CityWheelAdapter(mList2)
                            adapter3 = CityWheelAdapter(mList3)

                            dialogWheel1?.adapter = adapter1
                            dialogWheel2?.adapter = adapter2
                            dialogWheel3?.adapter = adapter3

                            dialogWheel1?.setOnItemSelectedListener(mCallBack1)
                            dialogWheel2?.setOnItemSelectedListener(mCallBack2)
                            dialogWheel3?.setOnItemSelectedListener(mCallBack3)

                        }
                    }
                )
            }
        }
        this?.let { PopUtils.showPopupWindow(tv_btn, it) }
    }

    private fun submit() {
        if (TextUtils.isEmpty(et_user_name.text.toString())) {
            ToastUtils.showText("请输入联系人姓名")
            return
        }
        reAddress.name = et_user_name.text.toString()


        if (TextUtils.isEmpty(et_user_phone.text.toString())) {
            ToastUtils.showText("请输入您的手机号码")
            return
        }
        reAddress.phone = et_user_phone.text.toString()

        if (TextUtils.isEmpty(et_take_goods_address.text.toString())) {
            ToastUtils.showText("请选择地区")
            return
        }

        if (TextUtils.isEmpty(et_address_details.text.toString())) {
            ToastUtils.showText("请输入详细地址")
            return
        }
        reAddress.adress = et_address_details.text.toString()

        if (type == 0) {
            mPresenter?.addAddress(reAddress)
        } else {
            mPresenter?.editAddress(reAddress)
        }

    }

    private var mCallBack1 = OnItemSelectedListener { index ->
        mList2.clear()
        mList2.addAll(mList1[index].children)
        mList3.clear()
        mList3.addAll(mList2[0].children)
        updateAdapter()

    }

    private fun updateAdapter() {
        dialogWheel2?.adapter = CityWheelAdapter(mList2)
        updateAdapter1()
    }

    private fun updateAdapter1() {
        dialogWheel3?.adapter = CityWheelAdapter(mList3)
    }

    private var mCallBack2 = OnItemSelectedListener { index ->
        mList3.clear()
        mList3.addAll(mList2[index].children)
        updateAdapter1()
    }
    private var mCallBack3 = OnItemSelectedListener {
    }
}


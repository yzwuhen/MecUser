package com.example.mechanicalapp.ui.activity

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PayWayAdapter
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.adapter.PicMecAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecBusiness
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.ReleaseView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_my_mec_sell.*
import kotlinx.android.synthetic.main.layout_title.*

class MyEcSellActivity : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    TextWatcher, ReleaseView<List<CodeData>> {

    private var mPicAdapter: PicMecAdapter? = null

    private var mPicList: MutableList<String> = ArrayList<String>()


    private var mPayWayList: MutableList<CodeData> = ArrayList<CodeData>()
    private var mPopPayWay: RecyclerView? = null
    private var mPayWayAdapter: PayWayAdapter? = null

    private var mReMecBusiness = ReMecBusiness()


    private var mPresenter: AddManagePresenterImpl? = null


    override fun getLayoutId(): Int {

        return R.layout.activity_my_mec_sell
    }

    override fun initView() {
        super.initView()

        mPicAdapter = PicMecAdapter(this, mPicList, this)
        ry_pic.layoutManager = GridLayoutManager(this, 3)
        ry_pic.adapter = mPicAdapter



        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "机械出售"

        ly_pay_way.setOnClickListener(this)

        tv_submit.setOnClickListener(this)

        mPresenter = AddManagePresenterImpl(this, this)
        et_way.addTextChangedListener(this)

        (mPresenter as AddManagePresenterImpl).getPayWay()

        mReMecBusiness = intent.getSerializableExtra("data") as ReMecBusiness
        showInfo()
    }

    private fun showInfo() {
        et_ec_name.text = mReMecBusiness.tittle

        if (mReMecBusiness.isNew=="1"){
            tv_yes.isSelected =true
        }else{
            tv_no.isSelected =true
        }
        et_ec_type.text =mReMecBusiness.cateName
        et_ec_brand.text =mReMecBusiness.brandName
        et_ec_model.text =mReMecBusiness.modelName
        et_work_time.text =mReMecBusiness.workTime

        et_production_time.text =mReMecBusiness.facDate
        et_name.text =mReMecBusiness.contactName
        et_phone.text =mReMecBusiness.contactPhone
        et_address.text =mReMecBusiness.address
        et_input.text =mReMecBusiness.briefDesc

        if (!TextUtils.isEmpty(mReMecBusiness.pic)){
            for (str in mReMecBusiness.pic.split(",")){
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
            R.id.tv_pay_way -> {
                pay_way?.text = mPayWayList[position].itemText
                mReMecBusiness.paymentType = mPayWayList[position].itemValue
                PopUtils.dismissPop()
                changeBtn()
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.ly_pay_way -> showPayWay()
            R.id.tv_submit -> sumbit()
        }
    }

    private fun sumbit() {
        if (checkInfo()) {
            (mPresenter as AddManagePresenterImpl).addMecBusiness(mReMecBusiness)
        }
    }


    //支付方式
    private fun showPayWay() {
        this?.let {
            PopUtils.init(it,
                R.layout.pop_layout_pay_way,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, object : PopUtils.onViewListener {
                    override fun getView(view: View?) {
                        mPopPayWay = view?.findViewById(R.id.pop_recycler_list)
                        mPayWayAdapter =
                            PayWayAdapter(this@MyEcSellActivity, mPayWayList, this@MyEcSellActivity)
                        mPopPayWay?.layoutManager = LinearLayoutManager(this@MyEcSellActivity)
                        mPopPayWay?.adapter = mPayWayAdapter
                    }
                }
            )
        }
        PopUtils.showPopupWindow(ly_pay_way)
    }


    private fun changeBtn() {
        tv_submit.isSelected = checkInfo()
    }

    private fun checkInfo(): Boolean {


        if (TextUtils.isEmpty(et_way.text.toString().trim())) {
            return false
        }
        mReMecBusiness.price = et_way.text.toString().trim()

        //付款方式
        if (TextUtils.isEmpty(mReMecBusiness.paymentType)) {
            return false
        }

        return true
    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        changeBtn()
    }

    override fun showSuccess(netData: NetData?) {

        ToastUtils.showText(netData?.message)
        if (netData?.code == 200) {
            finish()
        }
    }

    override fun showImg(netData: NetData?) {

    }

    override fun uploadFail(str: String) {
    }

    //支付方式
    override fun showData(t: List<CodeData>) {
        mPayWayList.clear()
        mPayWayList.addAll(t)
    }

}
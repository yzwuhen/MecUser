package com.example.mechanicalapp.ui.activity

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PartsOrderChildAdapter
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsOrderGoodsList
import com.example.mechanicalapp.ui.data.ShopCarData
import com.example.mechanicalapp.ui.data.request.ReApplyRefund
import com.example.mechanicalapp.ui.mvp.impl.ApplyRefundPresenter
import com.example.mechanicalapp.ui.mvp.v.ApplyRefundView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.GlideEngine
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_apply_refund.*
import kotlinx.android.synthetic.main.activity_apply_refund.ry_pic
import kotlinx.android.synthetic.main.activity_ec_lease.*
import kotlinx.android.synthetic.main.item_parts_order.view.*
import kotlinx.android.synthetic.main.layout_title.*
import java.io.File

class ApplyRefundActivity : BaseCusActivity(), View.OnClickListener ,OnItemClickListener,TextWatcher,
    ApplyRefundView {

    private var mPicAdapter: PicAdapter? = null

    private var mPicList: MutableList<String> =ArrayList<String>()

    private var orderItemList: List<PartsOrderGoodsList>? = null

    private var price=0.0
    private var num=0
    private var orderId=""

    private var mButtDialog: BottomSheetDialog? = null
    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null

    private var mPresenter:ApplyRefundPresenter?=null
    private var mReApplyRefund  = ReApplyRefund()
    private var mIsOk=false

    override fun getLayoutId(): Int {

        return R.layout.activity_apply_refund
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "申请退款"

        mPicAdapter = PicAdapter(this, mPicList, this)
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.HORIZONTAL
        ry_pic.layoutManager =layoutManager
        ry_pic.adapter = mPicAdapter


        orderItemList = intent.getSerializableExtra("data") as List<PartsOrderGoodsList>?
        price =intent.getDoubleExtra("price",0.0)
        num =intent.getIntExtra("num",0)
        orderId =intent.getStringExtra("id").toString()

        recycle_list.layoutManager = LinearLayoutManager(this)
        var mPartsOrderChildAdapter = orderItemList?.let { PartsOrderChildAdapter(this, it,0,null) }
        recycle_list.adapter =mPartsOrderChildAdapter

        tv_all_nun.text ="共${num}件商品"
        tv_money.text ="￥${price}"


        mReApplyRefund.mecOrderId = orderId

        tv_info.addTextChangedListener(this)

        tv_btn.setOnClickListener(this)
    }

    override fun initPresenter() {
        mPresenter = ApplyRefundPresenter(this,this)
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

    private fun takePoto() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openCamera(PictureMimeType.ofImage())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: MutableList<LocalMedia?>) {
                    if (File(result[0]?.realPath.toString()).exists()){
                        mPresenter?.upLoadFile(result[0]?.realPath.toString())
                    }else{
                        mPresenter?.upLoadFile(result[0]?.path.toString())
                    }
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
                    if (File(result[0]?.realPath.toString()).exists()){
                        mPresenter?.upLoadFile(result[0]?.realPath.toString())
                    }else{
                        mPresenter?.upLoadFile(result[0]?.path.toString())
                    }
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


    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back -> finish()
            R.id.tv_btn->submit()
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
        takePoto()
    }
    private fun submit() {

        if (mPicList.size>0){
            mReApplyRefund.imgs=""
            for (str in mPicList){
                mReApplyRefund.imgs +="$str,"
            }
            mReApplyRefund.imgs=mReApplyRefund.imgs.substring(0,mReApplyRefund.imgs.length-1)
        }
        mPresenter?.applyRefund(mReApplyRefund)
    }

    override fun onItemClick(view: View, position: Int) {

        when (view?.id) {

            R.id.iv_del -> {
                mPicList?.removeAt(position)
                mPicAdapter?.notifyDataSetChanged()
            }
            R.id.iv_pic -> {
                if (position == mPicList?.size) {
                    showDialogType()
                }
            }
        }
    }

    override fun successData(date: NetData?) {
        ToastUtils.showText(date?.message)
        if (date?.code==200){
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

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {
        changeBtn()
    }
    private fun changeBtn() {
        mIsOk =checkInfo()
        tv_btn.isSelected =mIsOk
        tv_btn.isEnabled =mIsOk
    }
    private fun checkInfo() :Boolean{
        if (TextUtils.isEmpty(tv_info.text.toString().trim())){
            return false
        }
        mReApplyRefund.backReason = tv_info.text.toString().trim()
//        if (mPicList.size==0){
//            return false
//        }
        return true
    }
}
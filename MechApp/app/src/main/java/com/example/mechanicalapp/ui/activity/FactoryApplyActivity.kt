package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.view.View
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_ec_lease.*
import kotlinx.android.synthetic.main.activity_factory_apply.*
import kotlinx.android.synthetic.main.activity_factory_apply.tv_submit
import kotlinx.android.synthetic.main.item_job_want.*
import kotlinx.android.synthetic.main.layout_title.*

class FactoryApplyActivity:BaseActivity<NetData>(),View.OnClickListener {

    private var mButtDialog: BottomSheetDialog?=null

    private var mDialogView:View ?= null
    private var mDialogTv1: TextView?= null
    private var mDialogTv2: TextView?= null
    private var mDialogTv3: TextView?= null
    override fun getLayoutId(): Int {

        return R.layout.activity_factory_apply

    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "维修厂入驻"

        ly_mec_type.setOnClickListener(this)
        ly_parts_type.setOnClickListener(this)
        iv_license_pic.setOnClickListener(this)
        iv_factory_pic.setOnClickListener(this)
        tv_submit.setOnClickListener(this)

    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.ly_mec_type -> jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                MoreSelectMecType::class.java
            )
            R.id.ly_parts_type -> jumpActivityForReSult(
                Configs.PARTS_RESULT_CODE,
                MoreSelPartsType::class.java
            )
            R.id.iv_license_pic->showDialogType()
            R.id.iv_factory_pic->showDialogType()
            R.id.tv_dialog_item1->setItem()
            R.id.tv_dialog_item2->setItem()
            R.id.tv_dialog_item3->mButtDialog?.dismiss()
        }
    }
    private fun setItem() {
        mButtDialog?.dismiss()

    }

    private fun showDialogType(){
        if (mButtDialog ==null){
            mButtDialog = BottomSheetDialog(this)
            mDialogView = View.inflate(this,R.layout.dialog_user_data_buttom,null)
            mButtDialog?.setContentView(mDialogView!!)
            mDialogTv1 = mDialogView?.findViewById(R.id.tv_dialog_item1)
            mDialogTv2 = mDialogView?.findViewById(R.id.tv_dialog_item2)
            mDialogTv3 = mDialogView?.findViewById(R.id.tv_dialog_item3)
        }

            mDialogTv1?.text ="拍照"
            mDialogTv2?.text ="从相册选择"

        mDialogTv1?.setOnClickListener(this)
        mDialogTv2?.setOnClickListener(this)
        mDialogTv3?.setOnClickListener(this)

        mButtDialog?.show()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        showResult(requestCode, data?.getStringExtra(Configs.EC_RESULT_Extra))
        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showResult(requestCode: Int, extra: String?) {
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> tv_mec_type.text = extra
            Configs.PARTS_RESULT_CODE -> tv_parts_type.text = extra

        }

    }
}
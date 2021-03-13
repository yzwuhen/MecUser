package com.example.mechanicalapp.ui.activity

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.adapter.ReportPopAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.ReportBean
import com.example.mechanicalapp.ui.data.ReportData
import com.example.mechanicalapp.ui.data.request.ReReport
import com.example.mechanicalapp.ui.mvp.impl.ReportPresenter
import com.example.mechanicalapp.ui.mvp.v.ReportView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.GlideEngine
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_report.*
import kotlinx.android.synthetic.main.layout_search_et.iv_back
import kotlinx.android.synthetic.main.layout_title.*
import java.io.File

class ReportActivity:BaseCusActivity() , OnItemClickListener,View.OnClickListener,
    PopUtils.onViewListener ,TextWatcher, ReportView {

    private var mPicAdapter :PicAdapter?=null

    private var mPicList :MutableList<String> = ArrayList<String>()
    private var mStringList :MutableList<ReportData> = ArrayList<ReportData>()
    private var popRecy : RecyclerView?=null
    private var mScreenAdapter : ReportPopAdapter?=null


    private var mButtDialog: BottomSheetDialog? = null

    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null

    private var id=""
    private var type =0
    private var mPresenter :ReportPresenter?=null
    private var reReport =ReReport()
    override fun getLayoutId(): Int {

        return R.layout.activity_report
    }

    override fun initView() {
        super.initView()

        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>,this)
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation =RecyclerView.HORIZONTAL
        ry_pic.layoutManager =layoutManager
        ry_pic.adapter = mPicAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text ="举报"
        tv_report_reason.setOnClickListener(this)
        tv_submit.setOnClickListener(this)
        et_input.addTextChangedListener(this)

        id = intent.getStringExtra("id").toString()
        type =intent.getIntExtra("type",0)
        reReport.reportId =id
        reReport.type =type
    }

    override fun initPresenter() {
        mPresenter = ReportPresenter(this,this)
        mPresenter?.getReportList()
    }

    override fun showSuccess(netData: NetData?) {
        if (netData!=null &&netData is ReportBean){
            if (netData.result!=null&&netData.result.records!=null){
                mStringList.clear()
                mStringList.addAll(netData.result.records)
            }
        }else{
            ToastUtils.showText(netData?.message)
            if (netData?.code==200){
                finish()
            }
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

    override fun err()  {
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_report_reason->showInput()
            R.id.tv_dialog_item1 -> setItem()
            R.id.tv_dialog_item2 -> setItem1()
            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
            R.id.tv_submit->submit()
        }
    }

    private fun submit() {
        if (checkInfo()){
            for (str in mPicList){
                reReport.pic +="$str,"
            }
            reReport.pic= reReport.pic.substring(0,reReport.pic.length-1)
            (mPresenter as ReportPresenter).report(reReport)
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
    private fun showInput() {

        this?.let { PopUtils.init(this, it,this) }
        PopUtils.showPopupWindow(tv_report_reason)
    }

    override fun getView(view: View?) {

        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ReportPopAdapter(this,mStringList,this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {
        when (view?.id) {

            R.id.tv_screen->{
                PopUtils.dismissPop(this)
                reReport.reportId =mStringList[position].id
                tv_report_reason.text =mStringList[position].name
            }
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
        changeBtn()
    }

    private fun changeBtn() {

        tv_submit.isSelected =checkInfo()
    }

    private fun checkInfo(): Boolean {

        if (TextUtils.isEmpty(reReport.reportId)){
            return false
        }
        if (TextUtils.isEmpty(et_input.text.toString())){
            return false
        }
        reReport.reportReasonContent =et_input.text.toString()
        if (mPicList.size==0){
            return false
        }
      return true
    }
}
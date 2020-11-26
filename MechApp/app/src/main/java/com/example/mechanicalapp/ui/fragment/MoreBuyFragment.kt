package com.example.mechanicalapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.`interface`.ProgressListener
import com.example.mechanicalapp.ui.activity.*
import com.example.mechanicalapp.ui.adapter.MoreBuyAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.MecBuyData
import com.example.mechanicalapp.ui.data.MecSellData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.MecBuyPresenter
import com.example.mechanicalapp.ui.mvp.impl.MecLeaseListPresenter
import com.example.mechanicalapp.ui.mvp.impl.SellPresenter
import com.example.mechanicalapp.ui.mvp.v.MecBuyView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.ui.view.TwoWayProgressBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_more_data.*

class MoreBuyFragment : BaseCusFragment(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener, ProgressListener, MecBuyView<NetData> {
    var mAdapter: MoreBuyAdapter? = null
    var mList: MutableList<MecSellData> = ArrayList<MecSellData>()

    var popRecy: RecyclerView? = null
    var mScreenAdapter: ScreenAdapter? = null

    private var mStringList: MutableList<String> = ArrayList<String>()

    private var mButtDialog: BottomSheetDialog? = null
    private var mDialogView: View? = null

    private var mDialogTvRest: TextView? = null
    private var mDialogTvSure: TextView? = null
    private var mProgress1: TwoWayProgressBar? = null
    private var mProgress2: TwoWayProgressBar? = null
    private var mProgress3: TwoWayProgressBar? = null

    private var list1: MutableList<String> = ArrayList<String>()
    private var list2: MutableList<String> = ArrayList<String>()
    private var list3: MutableList<String> = ArrayList<String>()


    override fun initView() {
        super.initView()

        mAdapter = MoreBuyAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter



        mStringList?.add("智能排序")
        mStringList?.add("最新上架")
        mStringList?.add("最新上架")
        mStringList?.add("工作时长最短")


        ly_screen1.setOnClickListener(this)
        ly_screen2.setOnClickListener(this)
        ly_screen3.setOnClickListener(this)
        ly_screen4.setOnClickListener(this)
        ly_screen5.setOnClickListener(this)

        mPresenter = MecBuyPresenter(mContext, this)
        (mPresenter as MecBuyPresenter).getBuyList(2)
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_more_data
    }

    private fun showInput() {

        activity?.let { PopUtils.init(mContext, it, this) }
        PopUtils.showPopupWindow(tv_screen1)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ly_screen1 -> jumpActivityForResult(
                Configs.EC_TYPE_RESULT_CODE,
                0,
                EcModel::class.java
            )
            R.id.ly_screen2 -> jumpActivityForResult(
                Configs.EC_BRAND_RESULT_CODE,
                0,
                Brand::class.java
            )
            R.id.ly_screen3 -> jumpActivityForResult(
                Configs.EC_MODEL_RESULT_CODE,
                0,
                EcType::class.java
            )
            R.id.ly_screen4 -> showInput()
            R.id.ly_screen5 -> showDialogType()
            R.id.tv_sure -> mButtDialog?.dismiss()
            R.id.tv_reset -> mButtDialog?.dismiss()
        }
    }

    private fun showDialogType() {
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(mContext)
            mDialogView = View.inflate(mContext, R.layout.dialog_screen, null)
            mButtDialog?.setContentView(mDialogView!!)

            mDialogTvRest = mDialogView?.findViewById(R.id.tv_reset)
            mDialogTvSure = mDialogView?.findViewById(R.id.tv_sure)


            list1.add("￥0")
            list1.add("￥10")
            list1.add("￥20")
            list1.add("￥30")
            list1.add("￥40")
            list1.add("￥50")
            list1.add("不限")

            list2.add("0")
            list2.add("1")
            list2.add("2")
            list2.add("3")
            list2.add("4")
            list2.add("5")
            list2.add("6")
            list2.add("7")
            list2.add("8")
            list2.add("9")
            list2.add("10")
            list2.add("不限")

            list3.add("0")
            list3.add("2000")
            list3.add("4000")
            list3.add("8000")
            list3.add("12000")
            list3.add("不限")

            mProgress1 = mDialogView?.findViewById(R.id.progress1)
            mProgress2 = mDialogView?.findViewById(R.id.progress2)
            mProgress3 = mDialogView?.findViewById(R.id.progress3)


            mProgress1?.setTextList(list1)
            mProgress2?.setTextList(list2)
            mProgress3?.setTextList(list3)

            mProgress1?.addProgressListener(this)
            mProgress2?.addProgressListener(this)
            mProgress3?.addProgressListener(this)

            mDialogTvRest?.setOnClickListener(this)
            mDialogTvSure?.setOnClickListener(this)
        }



        mButtDialog?.show()
    }

    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(mContext, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(mContext)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {
        var bundle = Bundle()
        bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, 1)
        bundle.putString(Configs.MEC_ID, mList[position].id)
        jumpActivity(bundle, MecBuyDetails::class.java)
    }

    override fun progress(leftPos: Double, rightPos: Double) {

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
                tv_screen1.text = extra
                (mPresenter as MecBuyPresenter)?.setCateId(extraId)
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                tv_screen2.text = extra
                (mPresenter as MecBuyPresenter)?.setBrandId(extraId)
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                tv_screen3.text = extra
                (mPresenter as MecBuyPresenter)?.setModelId(extraId)
            }

        }
        refresh()
    }

     fun refresh() {
         (mPresenter as MecBuyPresenter).resetPage()
        (mPresenter as MecBuyPresenter).getBuyList(2)
    }

    override fun refreshUI(list: List<MecSellData>) {
        mList.clear()
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(list: List<MecSellData>) {
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun err() {
    }
}
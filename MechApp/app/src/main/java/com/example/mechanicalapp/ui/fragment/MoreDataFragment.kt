package com.example.mechanicalapp.ui.fragment

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.ProgressListener
import com.example.mechanicalapp.ui.activity.Brand
import com.example.mechanicalapp.ui.activity.EcModel
import com.example.mechanicalapp.ui.activity.EcType
import com.example.mechanicalapp.ui.activity.LeaseDetailsActivity
import com.example.mechanicalapp.ui.adapter.MoreUserDemanAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.ui.view.TwoWayProgressBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_more_data.*


class MoreDataFragment(var type:Int): BaseFragment<NetData>(), OnItemClickListener,View.OnClickListener,
    PopUtils.onViewListener,ProgressListener {
    var mAdapter: MoreUserDemanAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()

    var popRecy :RecyclerView?=null
    private var mScreenAdapter :ScreenAdapter ?=null

    private var mStringList :MutableList<String> = ArrayList<String>()

    private var mButtDialog: BottomSheetDialog?=null
    private var mDialogView:View?=null

    private var mDialogTvRest:TextView?=null
    private var mDialogTvSure:TextView?=null
    private var mProgress1:TwoWayProgressBar?=null
    private var mProgress2:TwoWayProgressBar?=null
    private var mProgress3:TwoWayProgressBar?=null

    private var list1:MutableList<String> =ArrayList<String>()
    private var list2:MutableList<String> =ArrayList<String>()
    private var list3:MutableList<String> =ArrayList<String>()


    init {
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
    }

    override fun initView() {
        super.initView()

        mAdapter = MoreUserDemanAdapter(mContext, mList, type,this)
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
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_more_data
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    private fun showDialogType(){
        if (mButtDialog ==null){
            mButtDialog = BottomSheetDialog(mContext)
            mDialogView = View.inflate(mContext,R.layout.dialog_screen,null)
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

    private fun showInput() {

        activity?.let { PopUtils.init(mContext, it,this) }
        PopUtils.showPopupWindow(tv_screen1)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.ly_screen1 ->jumpActivity(null,EcModel::class.java)
            R.id.ly_screen2->jumpActivity(null,Brand::class.java)
            R.id.ly_screen3->jumpActivity(null,EcType::class.java)
                R.id.ly_screen4->showInput()
            R.id.ly_screen5->showDialogType()
            R.id.tv_sure->mButtDialog?.dismiss()
            R.id.tv_reset->mButtDialog?.dismiss()
        }
    }

    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(mContext, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(mContext)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {
        jumpActivity(null,LeaseDetailsActivity::class.java)
    }

    override fun progress(leftPos: Double, rightPos: Double) {


    }
}
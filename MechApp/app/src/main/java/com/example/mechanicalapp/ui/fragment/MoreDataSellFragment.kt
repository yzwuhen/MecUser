package com.example.mechanicalapp.ui.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.`interface`.ProgressListener
import com.example.mechanicalapp.ui.activity.Brand
import com.example.mechanicalapp.ui.activity.EcModel
import com.example.mechanicalapp.ui.activity.EcType
import com.example.mechanicalapp.ui.activity.MecSellDetails
import com.example.mechanicalapp.ui.adapter.MoreSellAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.MecSellData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReScreenData
import com.example.mechanicalapp.ui.mvp.impl.MecLeaseListPresenter
import com.example.mechanicalapp.ui.mvp.impl.SellPresenter
import com.example.mechanicalapp.ui.mvp.v.MecSellView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.ui.view.TwoWayProgressBar
import kotlinx.android.synthetic.main.fragment_more_data.*
import kotlin.math.ceil

class MoreDataSellFragment : BaseCusFragment(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener, ProgressListener, MecSellView<NetData> {
    var mAdapter: MoreSellAdapter? = null
    var mList: MutableList<MecSellData> = ArrayList<MecSellData>()

    var popRecy: RecyclerView? = null
    private var mScreenAdapter: ScreenAdapter? = null

    private var mStringList: MutableList<String> = ArrayList<String>()

    private var mReScreenData: ReScreenData?=null
    private var mScreenPop : PopupWindow?=null
    private var mDialogTvRest: TextView? = null
    private var mDialogTvSure: TextView? = null
    private var mProgress1: TwoWayProgressBar? = null
    private var mProgress2: TwoWayProgressBar? = null
    private var mProgress3: TwoWayProgressBar? = null
    private var mTvProgress1: TextView? = null
    private var mTvProgress2: TextView? = null
    private var mTvProgress3: TextView? = null

    private var list1: MutableList<String> = ArrayList<String>()
    private var list2: MutableList<String> = ArrayList<String>()
    private var list3: MutableList<String> = ArrayList<String>()


    override fun initView() {
        super.initView()

        mAdapter = MoreSellAdapter(mContext, mList, this)
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

        mPresenter = SellPresenter(mContext, this)
        (mPresenter as SellPresenter).getSellList("1")
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_more_data
    }
    private fun showDialogType() {
        if (mReScreenData==null){
            mReScreenData = ReScreenData()
        }
        if (mScreenPop == null) {
            mScreenPop= activity?.let {
                PopUtils.init(mContext,
                    it,R.layout.dialog_screen,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,true,false,object :PopUtils.onViewListener{
                        override fun getView(view: View?) {
                            mDialogTvRest = view?.findViewById(R.id.tv_reset)
                            mDialogTvSure = view?.findViewById(R.id.tv_sure)


                            mTvProgress1 =view?.findViewById(R.id.tv_progress1)
                            mTvProgress2 =view?.findViewById(R.id.tv_progress2)
                            mTvProgress3 =view?.findViewById(R.id.tv_progress3)


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
                            list3.add("6000")
                            list3.add("8000")
                            list3.add("不限")

                            mProgress1 = view?.findViewById(R.id.progress1)
                            mProgress2 = view?.findViewById(R.id.progress2)
                            mProgress3 = view?.findViewById(R.id.progress3)


                            mProgress1?.setTextList(list1)
                            mProgress2?.setTextList(list2)
                            mProgress3?.setTextList(list3)

                            mProgress1?.addProgressListener(this@MoreDataSellFragment)
                            mProgress2?.addProgressListener(this@MoreDataSellFragment)
                            mProgress3?.addProgressListener(this@MoreDataSellFragment)

                            mDialogTvRest?.setOnClickListener(this@MoreDataSellFragment)
                            mDialogTvSure?.setOnClickListener(this@MoreDataSellFragment)
                        }

                    })
            }
        }
        showScreenPop(tv_screen1)
    }
    private fun showScreenPop(parent: View) {
        if (mScreenPop?.isShowing==false) {
            val location = IntArray(2)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                mScreenPop?.showAsDropDown(
                    parent,
                    Gravity.BOTTOM,
                    location[0],
                    location[1]
                )
            } else {
                mScreenPop?.showAtLocation(parent, Gravity.BOTTOM, 0, 0)
            }
            activity?.let { PopUtils.backgroundAlpha(0.5f, it) }
        }else{
            mScreenPop?.dismiss()
        }
    }

    private fun disScreenPop(){
        mScreenPop?.dismiss()
        activity?.let { PopUtils.backgroundAlpha(1f, it) }
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
                EcType::class.java
            )
            R.id.ly_screen2 -> jumpActivityForResult(
                Configs.EC_BRAND_RESULT_CODE,
                0,
                Brand::class.java
            )
            R.id.ly_screen3 -> jumpActivityForResult(
                Configs.EC_MODEL_RESULT_CODE,
                0,
                EcModel::class.java
            )
            R.id.ly_screen4 -> showInput()
            R.id.ly_screen5 -> showDialogType()
            R.id.tv_sure -> {
                (mPresenter as SellPresenter)?.setScreen(mReScreenData)
                disScreenPop()
            }
            R.id.tv_reset ->   {
                (mPresenter as SellPresenter)?.setScreen(null)
                mReScreenData =null
                mProgress1?.reset()
                mProgress2?.reset()
                mProgress3?.reset()
                mTvProgress1?.text ="不限"
                mTvProgress2?.text ="不限"
                mTvProgress3?.text ="不限"
            }
        }
    }

    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(mContext, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(mContext)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {
        when(view?.id){
            R.id.tv_screen->{
                tv_screen4.text=mStringList[position]
                (mPresenter as MecLeaseListPresenter).setSort(position)
                PopUtils.dismissPop()
            }
            R.id.item_root->{
                var bundle =Bundle()
                bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, 1)
                bundle.putString(Configs.MEC_ID, mList[position].id)
                jumpActivity(bundle, MecSellDetails::class.java)
            }
        }
    }

    override fun progress(leftPos: Double, rightPos: Double,isUp:Boolean,view: View) {

        when(view?.id){
            R.id.progress1->{
                if (rightPos==0.0){
                    if (isUp){
                        mReScreenData?.priceStart =ceil((1-leftPos)*60).toInt().toString()
                        mReScreenData?.priceEnd =null
                    }
                    mTvProgress1?.text ="不限"
                }else{
                    if (isUp){
                        mReScreenData?.priceStart =ceil((1-leftPos)*60).toInt().toString()
                        mReScreenData?.priceEnd =ceil((1-rightPos)*60).toInt().toString()
                    }
                    mTvProgress1?.text ="￥${ceil((1-rightPos)*60).toInt()}"
                }

            }
            R.id.progress2->{
                if (rightPos==0.0){
                    mTvProgress2?.text ="不限"
                    if (isUp){
                        mReScreenData?.engAgeStart = ceil((1-leftPos)*10).toInt().toString()
                        mReScreenData?.engAgeEnd =null
                    }
                }else{
                    if (isUp){
                        mReScreenData?.engAgeStart = ceil((1-leftPos)*10).toInt().toString()
                        mReScreenData?.engAgeEnd =ceil((1-rightPos)*10).toInt().toString()
                    }
                    mTvProgress2?.text ="${ceil((1-rightPos)*10).toInt()}年"
                }
            }
            R.id.progress3->{
                if (rightPos==0.0){
                    if (isUp){
                        mReScreenData?.workTimeStart =(ceil((1-leftPos)*5).toInt()*2000).toString()
                        mReScreenData?.workTimeEnd = null
                    }
                    mTvProgress3?.text="不限"
                }else{
                    if (isUp){
                        mReScreenData?.workTimeStart =(ceil((1-leftPos)*5).toInt()*2000).toString()
                        mReScreenData?.workTimeEnd = (ceil((1-rightPos)*5).toInt()*2000).toString()
                    }
                    mTvProgress3?.text ="${ceil((1-rightPos)*5).toInt()*2000}小时"
                }
            }
        }
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
                (mPresenter as SellPresenter)?.setCateId(extraId)
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                tv_screen2.text = extra
                (mPresenter as SellPresenter)?.setBrandId(extraId)
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                tv_screen3.text = extra
                (mPresenter as SellPresenter)?.setModelId(extraId)
            }

        }
        refresh()
    }

    fun refresh() {
        (mPresenter as SellPresenter).resetPage()
        (mPresenter as SellPresenter).getSellList("1")
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
package com.example.mechanicalapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amap.api.location.DPoint
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.JobWantDetails
import com.example.mechanicalapp.ui.activity.RecruitDetailsActivity
import com.example.mechanicalapp.ui.activity.SearchCityActivity
import com.example.mechanicalapp.ui.activity.WorkType
import com.example.mechanicalapp.ui.adapter.MoreJobWantAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.adapter.ScreenDataAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.RecruitPresenter
import com.example.mechanicalapp.ui.mvp.v.WorkAboutView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_more_data.*


class RentFragment:BaseCusFragment(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener,WorkAboutView {
    var mAdapter: MoreJobWantAdapter? = null
    var mList: MutableList<RecruitData> = ArrayList<RecruitData>()

    private var popRecy: RecyclerView? = null
    var mScreenAdapter: ScreenDataAdapter? = null
    private var mStringList: MutableList<ScreenData> = ArrayList<ScreenData>()

    override fun initView() {
        super.initView()

        mAdapter = MoreJobWantAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter



        var screen1 = ScreenData()
        screen1.screen = "智能排序"
        screen1.isSelect =true
        var screen2 = ScreenData()
        screen2.screen = "距离近到远"
        var screen3 = ScreenData()
        screen3.screen = "更新时间"

        mStringList.add(screen1)
        mStringList.add(screen2)
        mStringList.add(screen3)



        ly_screen1.setOnClickListener(this)
        ly_screen2.setOnClickListener(this)
        ly_screen3.setOnClickListener(this)

        spring_list.type=SpringView.Type.FOLLOW
        spring_list.header=RefreshHeaderUtils.getHeaderView(mContext)

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable=false
                //  initData()
                closeRefreshView()
            }

            override fun onLoadmore() {
                (mPresenter as RecruitPresenter)?.getRecruitList(1)
            }
        })
        mPresenter = RecruitPresenter(mContext,this)
        (mPresenter as RecruitPresenter)?.getRecruitList(2)
    }

    fun closeRefreshView() {
        spring_list?.isEnable=true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun refreshRecruitUI(list: List<RecruitData>) {
        mList.clear()
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadRecruitMore(list: List<RecruitData>) {
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun err() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_recruit
    }



    private fun showInput() {

        activity?.let { PopUtils.init(mContext, it, this) }
        PopUtils.showPopupWindow(tv_screen1)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ly_screen1 ->{
                jumpActivityForReSult(
                    Configs.CITY_RESULT_CODE,
                    SearchCityActivity::class.java
                )
            }
            R.id.ly_screen2 -> jumpActivityForResult(
                Configs.WORK_TYPE_RESULT_CODE,
                1,
                WorkType::class.java
            )
            R.id.ly_screen3 -> showInput()
        }
    }


    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenDataAdapter(mContext, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(mContext)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {
        when (view?.id) {
            R.id.tv_screen -> {
                for (index in mStringList.indices) {
                    mStringList[index].isSelect = index == position
                }
                activity?.let { PopUtils.dismissPop(it) }
                tv_screen3.text = mStringList[position].screen
                (mPresenter as RecruitPresenter)?.setScreen(position)
                reFresh()
            }
            R.id.item_root->{

                var bundle = Bundle()
                bundle.putString("id", mList[position].id)
                jumpActivity(bundle,JobWantDetails::class.java)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==Configs.CITY_RESULT_CODE){
            if (data?.getSerializableExtra(Configs.SCREEN_RESULT_Extra)!=null){
                showResultAddress(requestCode, data?.getSerializableExtra(Configs.SCREEN_RESULT_Extra)as HomeCityData)
            }
        }else{

        showResult(
            requestCode,
            data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
            data?.getStringExtra(Configs.SCREEN_RESULT_ID)
        )}
        super.onActivityResult(requestCode, resultCode, data)

    }
    private fun showResultAddress(requestCode: Int, homeCityData: HomeCityData) {
        tv_screen3.text = homeCityData.name
        if (TextUtils.isEmpty(homeCityData.name)) {
            tv_screen1.text = "地区"
            (mPresenter as RecruitPresenter)?.setCity(null)
        } else {
            tv_screen1.text = homeCityData.name
            (mPresenter as RecruitPresenter)?.setCity(homeCityData.name)
        }

    }



    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {

        when (requestCode) {
            Configs.WORK_TYPE_RESULT_CODE -> {
                if (TextUtils.isEmpty(extra)) {
                    tv_screen2.text = "不限"
                } else {
                    tv_screen2.text = extra
                }
                (mPresenter as RecruitPresenter)?.workType(extra, extraId)
            }
        }
        reFresh()
    }


    fun reFresh() {
        (mPresenter as RecruitPresenter)?.resetPage()
        (mPresenter as RecruitPresenter)?.getRecruitList(2)
    }
}
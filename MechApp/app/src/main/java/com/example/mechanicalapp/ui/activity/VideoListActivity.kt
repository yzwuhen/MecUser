package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.VideoListAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CameraListBean
import com.example.mechanicalapp.ui.data.CameraListData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import kotlinx.android.synthetic.main.fragment_more_data.*
import kotlinx.android.synthetic.main.layout_title.*

class VideoListActivity : BaseCusActivity(), OnItemClickListener, View.OnClickListener ,NetDataView<CameraListBean>{
    var mAdapter: VideoListAdapter? = null
    var mList = ArrayList<CameraListData>()
    var mPresenter : MecAppPresenter?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_video_list
    }

    override fun initView() {
        super.initView()


        mAdapter = VideoListAdapter(this, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(this)
        recycler_list.adapter = mAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "视频查看"
    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
        mPresenter?.getCameraList()
    }



    override fun onItemClick(view: View, position: Int) {
        var bundle = Bundle()
            bundle.putString("id",mList[position].id)
          jumpActivity(bundle, VideoPlayerActivity::class.java)
    }

    override fun onClick(v: View?) {
        finish()
    }

    override fun refreshUI(data: CameraListBean?) {

        mList.clear()
        if (data?.result!=null&&data?.result.records!=null&&data?.result.records.size>0){
            mList.addAll(data?.result.records)
        }
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(data: CameraListBean?) {
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }
}
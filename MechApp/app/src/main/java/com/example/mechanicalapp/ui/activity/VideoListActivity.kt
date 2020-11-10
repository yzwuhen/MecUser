package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.VideoListAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.fragment_more_data.*
import kotlinx.android.synthetic.main.layout_title.*

class VideoListActivity:BaseActivity<NetData>(),OnItemClickListener,View.OnClickListener {
    var mAdapter: VideoListAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()
    override fun getLayoutId(): Int {
        return R.layout.activity_video_list
    }

    override fun initView() {
        super.initView()
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = VideoListAdapter(this, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(this)
        recycler_list.adapter = mAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "视频查看"
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onItemClick(view: View, position: Int) {


    }

    override fun onClick(v: View?) {

        finish()

    }
}
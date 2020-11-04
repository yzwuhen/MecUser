package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.CommentAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.layout_title.*

class CommentListActivity : BaseActivity<NetData>() ,View.OnClickListener,OnItemClickListener{

    private var mAdapter:CommentAdapter?=null
    private var mList:MutableList<String> =ArrayList<String>()

    override fun getLayoutId(): Int {

        return R.layout.activity_comment

    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "全部评价"

        tv_comment1.setOnClickListener(this)
        tv_comment2.setOnClickListener(this)
        tv_comment3.setOnClickListener(this)
        tv_comment4.setOnClickListener(this)


        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = CommentAdapter(this,mList,this)
        recycler_list.layoutManager =LinearLayoutManager(this)
        recycler_list.adapter = mAdapter

    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
        }
    }

    override fun onItemClick(view: View, position: Int) {


    }
}
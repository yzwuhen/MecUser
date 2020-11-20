package com.example.mechanicalapp.ui.fragment.commect

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.CommentAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.CommentPresenter
import com.example.mechanicalapp.ui.mvp.impl.PresenterImpl
import com.example.mechanicalapp.ui.mvp.v.CommentView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_comment.*

class FragmentComment(private var type:Int,private var id:String): BaseCusFragment(), OnItemClickListener, View.OnClickListener,
    CommentView{


    private var mAdapter: CommentAdapter?=null
    private var mList:MutableList<String> =ArrayList<String>()

    override fun getLayoutId(): Int {
        return R.layout.fragment_comment
    }

    override fun initView() {
        super.initView()
        mAdapter = CommentAdapter(mContext,mList,this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as CommentPresenter).resetPage()
                getData()
            }

            override fun onLoadmore() {
                getData()
            }
        })


        mPresenter = CommentPresenter(this)
        getData()
    }

    private fun getData(){
        if (type==0 ){
            (mPresenter as CommentPresenter).getCommentAll(id)
        }else if (type==1){
            (mPresenter as CommentPresenter).getCommentGoods(id)
        }
        else if (type==2){
            (mPresenter as CommentPresenter).getCommentMiddle(id)
        }
        else if (type==3){
            (mPresenter as CommentPresenter).getCommentMiddle(id)
        }
    }

    fun closeRefreshView() {
        spring_list.isEnable = true
        spring_list.onFinishFreshAndLoad()
    }

    override fun onItemClick(view: View, position: Int) {
    }

    override fun onClick(p0: View?) {
    }

    override fun refreshUI(list: List<NetData>?) {

    }

    override fun loadMore(list: List<NetData>?) {
    }

    override fun showLoading() {

    }

    override fun hiedLoading() {
    }

    override fun err() {
    }


}
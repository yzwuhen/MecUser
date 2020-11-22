package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.FragmentListPageAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CommentNumBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.fragment.commect.FragmentComment
import com.example.mechanicalapp.ui.mvp.impl.CommentPresenter
import com.example.mechanicalapp.ui.mvp.v.CommentNumView
import com.example.mechanicalapp.ui.mvp.v.CommentView
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.layout_title.*

class CommentListActivity : BaseCusActivity(), View.OnClickListener, ViewPager.OnPageChangeListener,
    CommentNumView {

    private val mFragmentList: MutableList<Fragment>? = ArrayList<androidx.fragment.app.Fragment>()
    private var mTabPageAdapter: FragmentListPageAdapter? = null
    private var mTextViewList: MutableList<TextView> = ArrayList<TextView>()
    private var id = ""
    private var mPresenter: CommentPresenter? = null
    override fun getLayoutId(): Int {

        return R.layout.activity_comment

    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "全部评价"

        id = intent.getStringExtra("id").toString()

        mFragmentList?.add(FragmentComment(0, id))
        mFragmentList?.add(FragmentComment(1, id))
        mFragmentList?.add(FragmentComment(2, id))
        mFragmentList?.add(FragmentComment(3, id))

        tv_comment1.setOnClickListener(this)
        tv_comment2.setOnClickListener(this)
        tv_comment3.setOnClickListener(this)
        tv_comment4.setOnClickListener(this)

        mTextViewList.add(tv_comment1)
        mTextViewList.add(tv_comment2)
        mTextViewList.add(tv_comment3)
        mTextViewList.add(tv_comment4)
        mTabPageAdapter = FragmentListPageAdapter(this.supportFragmentManager, mFragmentList!!)
        cus_page.adapter = mTabPageAdapter

        tv_comment1.performClick()

        cus_page.setTouchEvent(true)
        cus_page.addOnPageChangeListener(this)
        mPresenter = CommentPresenter(this)
        mPresenter?.getCommentNum(id)
    }

    override fun initPresenter() {
    }

    override fun showData(commentNumBean: CommentNumBean?) {
        if (commentNumBean != null && commentNumBean.result != null) {
            tv_comment1.text = "全部（${commentNumBean.result.total}）"
            tv_comment2.text = "好评（${commentNumBean.result.goodCount}）"
            tv_comment3.text = "中评（${commentNumBean.result.midCount}）"
            tv_comment4.text = "差评（${commentNumBean.result.badCount}）"
        }

    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_comment1 -> showView(0)
            R.id.tv_comment2 -> showView(1)
            R.id.tv_comment3 -> showView(2)
            R.id.tv_comment4 -> showView(3)
        }
    }

    private fun showView(index: Int) {

        cus_page.currentItem = index
        for (i in mTextViewList.indices) {
            mTextViewList[i]?.isSelected = index == i
        }


    }

    override fun onPageScrollStateChanged(state: Int) {


    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        showView(position)
    }
}
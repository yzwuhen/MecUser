package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.*
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.layout_more_data_title.*
import kotlinx.android.synthetic.main.layout_search_result.*

/**
 * 搜索器械
 */
class SearchMecActivity : BaseActivity<NetData>() , OnItemClickListener, View.OnClickListener{

    private var mAdapter: UserDemandAdapter? = null
    private var mRentAdapter : UserRentAdapter?=null
    private var mRecruitAdapter :RecruitAdapter ?=null
    private var mJobWantAdapter :JobWantAdapter ?=null
    private var mMecFactoryAdapter :MecFactoryAdapter ?=null

    var mList: MutableList<String> = ArrayList<String>()

    private val leftOfString: Array<String> = arrayOf("出租","出售","出租","招聘")
    private val rigthOfString: Array<String> = arrayOf("求租","求购","求租","求职")

    private var mTltieList: MutableList<TextView> = ArrayList<TextView>()

    private var mType: Int ?=0
    private var mUserAndStoreType :Int ?=0
    override fun getLayoutId(): Int {
        return R.layout.activity_search_mec
    }

    init {
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = UserDemandAdapter(this, mList, this)

        mRentAdapter = UserRentAdapter(this,mList,this)

        mRecruitAdapter = RecruitAdapter(this,mList,this)

        mJobWantAdapter = JobWantAdapter(this,mList,this)

        mMecFactoryAdapter = MecFactoryAdapter(this,mList,this)
    }

    override fun initView() {
        super.initView()

        mType = intent.getIntExtra(Configs.SEARCH_TYPE,0)



        rv_search.layoutManager = LinearLayoutManager(this)
        tv_screen_left.setOnClickListener(this)
        tv_screen_right.setOnClickListener(this)
        tv_screen_left.performClick()

        tv_mec_rent.setOnClickListener(this)
        tv_apparatus.setOnClickListener(this)
        tv_parts.setOnClickListener(this)
        tv_recruit.setOnClickListener(this)
        tv_repair.setOnClickListener(this)

        tv_search.setOnClickListener(this)
        mTltieList.add(tv_mec_rent)
        mTltieList.add(tv_apparatus)
        mTltieList.add(tv_parts)
        mTltieList.add(tv_recruit)
        mTltieList.add(tv_repair)

//        tv_mec_rent.performClick()
        changeView(mType!!)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.tv_screen_left->showAdapter(0)
            R.id.tv_screen_right -> showAdapter(1)
            R.id.tv_mec_rent ->changeView(0)
            R.id.tv_apparatus ->changeView(1)
            R.id.tv_parts ->changeView(2)
            R.id.tv_recruit ->changeView(3)
            R.id.tv_repair ->changeView(4)
            R.id.tv_search->jumAct()
        }

    }

    private fun changeView(type: Int) {

        mType =type

        for (index in mTltieList.withIndex()){
            if (index.index == mType){
                index.value.isSelected =true
                index.value.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.tv_under_ine)
            }else{
                index.value.isSelected =false
                index.value.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            }
        }

        if (type==4){
            rl_screen.visibility = View.GONE
        }else{
            if (rl_screen.visibility ==  View.GONE){
                rl_screen.visibility = View.VISIBLE
            }
            tv_screen_left.text =leftOfString[type!!]
            tv_screen_right.text =rigthOfString[type!!]
        }
        refreshAdapter()

    }

    private fun showAdapter(position:Int){

        if (position==0){
            mUserAndStoreType= position
            refreshAdapter()
            tv_screen_left.isSelected =true
            tv_screen_right.isSelected = false
        }else{
            mUserAndStoreType= position
            refreshAdapter()
            tv_screen_left.isSelected =false
            tv_screen_right.isSelected = true
        }
    }

    private fun refreshAdapter(){
        if (mUserAndStoreType==0){
            if (mType==0||mType==1||mType==2){
                rv_search.adapter = mAdapter
            }
            else if (mType ==3){
                rv_search.adapter = mRecruitAdapter
            }
            else{
                rv_search.adapter = mMecFactoryAdapter
            }
        }else{
            if (mType==0||mType==1||mType==2){
                rv_search.adapter = mRentAdapter
            }
            else if (mType ==3){
                rv_search.adapter = mJobWantAdapter
            }
            else{
                rv_search.adapter = mMecFactoryAdapter
            }
        }

    }

    override fun onItemClick(view: View, position: Int) {

    }

    private fun jumAct(){
        var bundle : Bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE,0)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }
}
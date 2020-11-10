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
import com.example.mechanicalapp.ui.data.*
import kotlinx.android.synthetic.main.layout_more_data_title.*
import kotlinx.android.synthetic.main.layout_search_result.*

/**
 * 搜索器械
 */
class SearchMecActivity : BaseActivity<NetData>(), OnItemClickListener, View.OnClickListener {

    private var mAdapter: UserDemandAdapter? = null
    private var mBossAdapter: UserDemandAdapter? = null
    var mPartsAdapter: PartsAdapter? = null//配件出租
    var mPartsAskAdapter: PartsAskAdapter? = null//配件求租
    private var mRentAdapter: UserRentAdapter? = null//机械求租 求购
    private var mRecruitAdapter: RecruitAdapter? = null//招聘
    private var mJobWantAdapter: JobWantAdapter? = null//求职
    private var mMecFactoryAdapter: MecFactoryAdapter? = null//维修厂

    var mList: MutableList<String> = ArrayList<String>()
    var mRentList: MutableList<MecLeaseData> = ArrayList<MecLeaseData>()
    var mLeaseList: MutableList<MecLeaseData> = ArrayList<MecLeaseData>()
    var mFactoryList: MutableList<FactoryData> = ArrayList<FactoryData>()

    private val leftOfString: Array<String> = arrayOf("出租", "出售", "出租", "招聘")
    private val rigthOfString: Array<String> = arrayOf("求租", "求购", "求租", "求职")

    private var mTltieList: MutableList<TextView> = ArrayList<TextView>()

    private var mType: Int = 0
    private var mUserAndStoreType: Int? = 0
    override fun getLayoutId(): Int {
        return R.layout.activity_search_mec
    }

    init {
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = UserDemandAdapter(this, mLeaseList, 0, this)
        mBossAdapter = UserDemandAdapter(this, mLeaseList, 1, this)

        mPartsAdapter = PartsAdapter(this, mList, this)
        mPartsAskAdapter = PartsAskAdapter(this, mList, this)

        mRentAdapter = UserRentAdapter(this, mRentList, this)

        mRecruitAdapter = RecruitAdapter(this, mList, this)

        mJobWantAdapter = JobWantAdapter(this, mList, this)

        mMecFactoryAdapter = MecFactoryAdapter(this, mFactoryList, this)
    }

    override fun initView() {
        super.initView()

        mType = intent.getIntExtra(Configs.SEARCH_TYPE, 0)



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

    override fun err()  {
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.tv_screen_left -> showAdapter(0)
            R.id.tv_screen_right -> showAdapter(1)
            R.id.tv_mec_rent -> changeView(0)
            R.id.tv_apparatus -> changeView(1)
            R.id.tv_parts -> changeView(2)
            R.id.tv_recruit -> changeView(3)
            R.id.tv_repair -> changeView(4)
            R.id.tv_search -> jumAct()
        }

    }

    private fun changeView(type: Int) {

        mType = type

        for (index in mTltieList.withIndex()) {
            if (index.index == mType) {
                index.value.isSelected = true
                index.value.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    0,
                    R.drawable.tv_under_ine
                )
            } else {
                index.value.isSelected = false
                index.value.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            }
        }

        if (type == 4) {
            rl_screen.visibility = View.GONE
        } else {
            if (rl_screen.visibility == View.GONE) {
                rl_screen.visibility = View.VISIBLE
            }
            tv_screen_left.text = leftOfString[type!!]
            tv_screen_right.text = rigthOfString[type!!]
        }
        refreshAdapter()

    }

    private fun showAdapter(position: Int) {

        if (position == 0) {
            mUserAndStoreType = position
            refreshAdapter()
            tv_screen_left.isSelected = true
            tv_screen_right.isSelected = false
        } else {
            mUserAndStoreType = position
            refreshAdapter()
            tv_screen_left.isSelected = false
            tv_screen_right.isSelected = true
        }
    }

    private fun refreshAdapter() {
        if (mUserAndStoreType == 0) {
            if (mType == 0) {
                rv_search.adapter = mAdapter
            } else if (mType == 1) {
                rv_search.adapter = mBossAdapter
            } else if (mType == 2) {
                rv_search.adapter = mPartsAdapter
            } else if (mType == 3) {
                rv_search.adapter = mRecruitAdapter
            } else {
                rv_search.adapter = mMecFactoryAdapter
            }
        } else {
            if (mType == 0 || mType == 1) {
                rv_search.adapter = mRentAdapter
            } else if (mType == 2) {
                rv_search.adapter = mPartsAskAdapter
            } else if (mType == 3) {
                rv_search.adapter = mJobWantAdapter
            } else {
                rv_search.adapter = mMecFactoryAdapter
            }
        }

    }

    override fun onItemClick(view: View, position: Int) {
        val bundle = Bundle()
        if (mUserAndStoreType == 0) {
            if (mType == 0) {
                bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, 0)
                jumpActivity(bundle, LeaseDetailsActivity::class.java)
            } else if (mType == 1) {
                bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, 1)
                jumpActivity(bundle, LeaseDetailsActivity::class.java)
            } else if (mType == 2) {
                jumpActivity(null, GoodsDetailsActivity::class.java)
            } else if (mType == 3) {
                jumpActivity(null, RecruitDetailsActivity::class.java)
            }else{
                jumpActivity(null,CreateRepairActivity::class.java)
            }
        } else {
            if (mType == 0 || mType == 1) {
                bundle.putInt(Configs.MEC_ASK_DETAILS_TYPE, mType)
                jumpActivity(bundle, AskDetailsActivity::class.java)
            } else if (mType == 2) {
                jumpActivity(null, PartsAskDetailsActivity::class.java)
            } else if (mType == 3) {
                jumpActivity(null, JobWantDetails::class.java)
            }else{
                jumpActivity(null,CreateRepairActivity::class.java)
            }
        }
    }

    private fun jumAct() {
        var bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE, 0)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }
}
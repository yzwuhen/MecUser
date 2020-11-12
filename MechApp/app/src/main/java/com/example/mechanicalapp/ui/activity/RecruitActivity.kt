package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktapp.views.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.YearsAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.data.request.ReWorkAbout
import com.example.mechanicalapp.ui.mvp.impl.AddMecManagePresenterImpl
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_recruit.*
import kotlinx.android.synthetic.main.layout_title.*

class RecruitActivity : BaseActivity<NetData>(), View.OnClickListener, OnItemClickListener {

    private var mButtDialog: BottomSheetDialog? = null
    private var mDialogView: View? = null
    private var mRecyDialog: RecyclerView? = null
    private var mYearsAdapter: YearsAdapter? = null
    private var mYears: MutableList<String> = ArrayList<String>()


    private var mSalaryDialog: BottomSheetDialog? = null
    private var mSalaryDialogView: View? = null
    private var mRecySalaryDialog: RecyclerView? = null
    private var mSalary: YearsAdapter? = null
    private var mSalaryList: MutableList<String> = ArrayList<String>()

    private var mReBean = ReWorkAbout()
    private var mPresenter: AddMecManagePresenterImpl? = null

    override fun getLayoutId(): Int {

        return R.layout.activity_recruit
    }

    override fun initView() {
        super.initView()


        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "发布招聘"


        ly_work_type.setOnClickListener(this)
        ly_work_experience.setOnClickListener(this)
        ly_salary.setOnClickListener(this)
        ly_address.setOnClickListener(this)

        mYears?.add("一年以上")
        mYears?.add("两年以上")
        mYears?.add("三年以上")
        mYears?.add("四年以上")
        mYears?.add("五年以上")
        mYears?.add("不限")

        mSalaryList?.add("3000-5000/月")
        mSalaryList?.add("5000-8000/月")
        mSalaryList?.add("8000-15000/月")
        mSalaryList?.add("15000以上/月")
        mSalaryList?.add("面议")
    }

    override fun initPresenter() {
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
            R.id.ly_work_type -> jumpActivity(null, WorkType::class.java)
            R.id.ly_work_experience -> showExperience()
            R.id.ly_salary -> showSalary()
            R.id.ly_address -> jumpActivity(null, AddressSelActivity::class.java)
        }
    }

    private fun showExperience() {
        mButtDialog = BottomSheetDialog(this)

        mDialogView = View.inflate(this, R.layout.dialog_selsec_years, null)
        mButtDialog?.setContentView(mDialogView!!)
        mRecyDialog = mDialogView?.findViewById(R.id.recycler_years)

        mRecyDialog?.layoutManager = GridLayoutManager(this, 3)
        mRecyDialog?.addItemDecoration(MyDecoration(3))
        mRecyDialog?.adapter = YearsAdapter(this, mYears, this)
        mButtDialog?.show()


    }

    private fun showSalary() {
        mSalaryDialog = BottomSheetDialog(this)

        mSalaryDialogView = View.inflate(this, R.layout.dialog_selsec_years, null)
        mSalaryDialog?.setContentView(mSalaryDialogView!!)
        mRecySalaryDialog = mSalaryDialogView?.findViewById(R.id.recycler_years)

        mRecySalaryDialog?.layoutManager = GridLayoutManager(this, 3)
        mRecySalaryDialog?.addItemDecoration(MyDecoration(3))
        mRecySalaryDialog?.adapter = YearsAdapter(this, mSalaryList, object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {

            }

        })
        mSalaryDialog?.show()

    }

    override fun onItemClick(view: View, position: Int) {

    }

}
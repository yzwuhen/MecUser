package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.YearsAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReWorkAbout
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.RecruitView
import com.example.mechanicalapp.utils.DateUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_job_want.*
import kotlinx.android.synthetic.main.layout_title.*
import java.util.*
import kotlin.collections.ArrayList

class JobWantActivity : BaseCusActivity(), View.OnClickListener, OnItemClickListener,
    OnTimeSelectListener, RecruitView, TextWatcher {

    private var mButtDialog: BottomSheetDialog? = null
    private var mDialogView: View? = null
    private var mRecyDialog: RecyclerView? = null
    private var mWorkTimeAdapter: YearsAdapter? = null
    private var mExpList: MutableList<CodeData> = ArrayList<CodeData>()
    private var mWorkSure: TextView? = null
    private var mWorkCancle: TextView? = null


    private var mSalaryDialog: BottomSheetDialog? = null
    private var mSalaryDialogView: View? = null
    private var mRecySalaryDialog: RecyclerView? = null
    private var mSalaryAdapter: YearsAdapter? = null
    private var mSalaryLists: MutableList<CodeData> = ArrayList<CodeData>()
    private var mSalarySure: TextView? = null
    private var mSalaryCancle: TextView? = null

    private var mReBean = ReWorkAbout()
    private var mPresenter: AddManagePresenterImpl? = null
    private var dialogType: Int = 0
    private var mWorkIndex: Int = -1
    private var mSalaryIndex: Int = -1
    override fun getLayoutId(): Int {

        return R.layout.activity_job_want
    }

    override fun initView() {
        super.initView()


        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "发布求职"


        ly_work_type.setOnClickListener(this)
        ly_work_experience.setOnClickListener(this)
        ly_salary.setOnClickListener(this)
        ly_birth_day.setOnClickListener(this)
        tv_submit.setOnClickListener(this)
        tv_yes.setOnClickListener(this)
        tv_no.setOnClickListener(this)

        et_post_name.addTextChangedListener(this)
        et_contacts.addTextChangedListener(this)
        et_phone.addTextChangedListener(this)
        et_input.addTextChangedListener(this)

        mReBean.recruitType = "2"
         mReBean.isReady ="1"
        tv_yes.isSelected =true

        mPresenter = AddManagePresenterImpl(this, this)
        (mPresenter as AddManagePresenterImpl).getWorkExp()
        (mPresenter as AddManagePresenterImpl).getWages()
    }

    override fun initPresenter() {
    }

    override fun showWorkExp(mlist: List<CodeData>) {
        mExpList.clear()
        mExpList.addAll(mlist)
    }

    override fun showWages(mWagesList: List<CodeData>) {
        mSalaryLists.clear()
        mSalaryLists.addAll(mWagesList)
    }

    override fun showSuccess(netData: NetData?) {
        ToastUtils.showText(netData?.message)
        if (netData?.code == 200) {
            finish()
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
            R.id.ly_work_type -> jumpActivityForReSult(
                Configs.WORK_TYPE_RESULT_CODE,
                WorkType::class.java
            )
            R.id.ly_work_experience -> showExperience()
            R.id.ly_salary -> showSalary()
            R.id.ly_birth_day -> showTime()
            R.id.tv_finish -> selectWork()
            R.id.tv_cancel -> cancleWork()
            R.id.tv_salary_finish -> selectSalary()
            R.id.tv_salary_cancel -> cancleSalary()
            R.id.tv_submit -> submit()
            R.id.tv_yes -> {
                tv_yes.isSelected = true
                tv_no.isSelected = false
                // mReBean.isTalk = "1"
            }
            R.id.tv_no -> {
                tv_yes.isSelected = false
                tv_no.isSelected = true
                //  mReBean.isTalk = "2"
            }
        }
    }

    private fun submit() {
        if (checkInfo()) {
            (mPresenter as AddManagePresenterImpl).addWorkAbout(mReBean)
        }
    }

    private fun cancleSalary() {
        mSalaryDialog?.dismiss()
    }

    private fun selectSalary() {
        mSalaryDialog?.dismiss()
        if (mSalaryIndex > 0) {
            et_salary.text = mSalaryLists[mSalaryIndex].itemText
            mReBean.price = mSalaryLists[mSalaryIndex].itemValue
        }
    }

    private fun cancleWork() {
        mButtDialog?.dismiss()
    }

    private fun selectWork() {
        mButtDialog?.dismiss()
        if (mWorkIndex > 0) {
            et_work_experience.text = mExpList[mWorkIndex].itemText
            mReBean.jobEx = mExpList[mWorkIndex].itemValue
        }
    }

    private fun showExperience() {
        dialogType = 0
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(this)

            mDialogView = View.inflate(this, R.layout.dialog_selsec_years, null)
            mButtDialog?.setContentView(mDialogView!!)
            mRecyDialog = mDialogView?.findViewById(R.id.recycler_years)

            mRecyDialog?.layoutManager = GridLayoutManager(this, 3)

            mWorkTimeAdapter = YearsAdapter(this, mExpList, this)
            mRecyDialog?.adapter = mWorkTimeAdapter

            mWorkSure = mDialogView?.findViewById(R.id.tv_finish)
            mWorkCancle = mDialogView?.findViewById(R.id.tv_cancel)
            mWorkSure?.setOnClickListener(this)
            mWorkCancle?.setOnClickListener(this)


        }
        mButtDialog?.show()


    }

    private fun showSalary() {
        dialogType = 1
        if (mSalaryDialog == null) {
            mSalaryDialog = BottomSheetDialog(this)

            mSalaryDialogView = View.inflate(this, R.layout.dialog_select_salary, null)
            mSalaryDialog?.setContentView(mSalaryDialogView!!)
            mRecySalaryDialog = mSalaryDialogView?.findViewById(R.id.recycler_salary)

            mRecySalaryDialog?.layoutManager = GridLayoutManager(this, 3)
            mSalaryAdapter = YearsAdapter(this, mSalaryLists, this)

            mRecySalaryDialog?.adapter = mSalaryAdapter

            mSalarySure = mSalaryDialogView?.findViewById(R.id.tv_salary_finish)
            mSalaryCancle = mSalaryDialogView?.findViewById(R.id.tv_salary_cancel)
            mSalarySure?.setOnClickListener(this)
            mSalaryCancle?.setOnClickListener(this)
        }
        mSalaryDialog?.show()

    }


    private fun showTime() {

        val mTimePickerView = TimePickerBuilder(this, this).build()
        mTimePickerView.show()
    }


    override fun onItemClick(view: View, position: Int) {
        if (dialogType == 0) {
            if (mWorkIndex != -1) {
                mExpList[mWorkIndex].isSelect = false
            }
            mExpList[position].isSelect = true
            mWorkTimeAdapter?.notifyDataSetChanged()
            mWorkIndex = position
        } else {
            if (mSalaryIndex != -1) {
                mSalaryLists[mSalaryIndex].isSelect = false
            }
            mSalaryLists[position].isSelect = true
            mSalaryAdapter?.notifyDataSetChanged()
            mSalaryIndex = position
        }
    }

    override fun onTimeSelect(date: Date?, v: View?) {
        mReBean.birthday = DateUtils.dateToStr(date)
        et_birthday.text = DateUtils.dateToStr(date)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(p0: Editable?) {

        changeBtn()
    }

    private fun changeBtn() {
        tv_submit.isSelected = checkInfo()
    }

    private fun checkInfo(): Boolean {

        if (TextUtils.isEmpty(et_post_name.text.toString().trim())) {
            return false
        }
        mReBean.jobtitle = et_post_name.text.toString().trim()



        if (TextUtils.isEmpty(mReBean.cateName)) {
            return false
        }

        if (TextUtils.isEmpty(mReBean.jobEx)) {
            return false
        }

        if (TextUtils.isEmpty(mReBean.price)) {
            return false
        }
        if (TextUtils.isEmpty(mReBean.birthday)) {
            return false
        }


        if (TextUtils.isEmpty(et_phone.text.toString().trim())) {
            return false
        }
        mReBean.contactPhone = et_phone.text.toString().trim()

        if (TextUtils.isEmpty(et_contacts.text.toString().trim())) {
            return false
        }
        mReBean.contactName = et_contacts.text.toString().trim()

        mReBean.content = et_input.text.toString().trim()


        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Configs.WORK_TYPE_RESULT_CODE) {
            data?.getStringExtra(Configs.SCREEN_RESULT_Extra)?.let {
                showResult(
                    it,
                    data?.getStringExtra(Configs.SCREEN_RESULT_ID)!!
                )
            }
        }

        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showResult(it: String, stringExtra: String) {
        et_work_type.text = it
        mReBean.cateName = it
        mReBean.cateId = stringExtra
    }

}
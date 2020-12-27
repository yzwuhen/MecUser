package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.ui.view.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.EcTypeLeftAdapter
import com.example.mechanicalapp.ui.adapter.LeftWorkAdapter
import com.example.mechanicalapp.ui.adapter.WorkTypeAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.MecTypeView
import com.example.mechanicalapp.ui.mvp.v.TypeView
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.item_work_type.view.*

class WorkType : BaseCusActivity(), OnItemClickListener, TypeView<NetData>,View.OnClickListener{


    private var mLeftAdapter: LeftWorkAdapter? = null
    private var mRightAdapter: WorkTypeAdapter? = null
    private var mRightList: MutableList<WorkTypeData> = ArrayList<WorkTypeData>()
    var mLeftList: MutableList<WorkTypeBean.ResultBean> = ArrayList<WorkTypeBean.ResultBean>()

    private var mPresenter: AddManagePresenterImpl ?=null
    private var index:Int=0

    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }


    override fun initView() {
        super.initView()


        mLeftAdapter = LeftWorkAdapter(this, mLeftList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter


        mRightAdapter = WorkTypeAdapter(this, mRightList, this)
        recycler_list_right.layoutManager = GridLayoutManager(this,2)
        recycler_list_right.addItemDecoration(MyDecoration(2))
        recycler_list_right.adapter = mRightAdapter

        mPresenter = AddManagePresenterImpl(this,this)
        (mPresenter as AddManagePresenterImpl).getWorkType()

        tv_unlimited.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err()  {
    }



    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.tv_type->{
                if (index!=position){
                    mLeftList[index].isSelect =false
                    mLeftAdapter?.notifyItemChanged(index)
                    mLeftList[position].isSelect =true
                    mLeftAdapter?.notifyItemChanged(position)

                    mRightList.clear()
                    mRightList.addAll(mLeftList[position].childList)
                    mRightAdapter?.notifyDataSetChanged()
                    index = position
                }
            }
            R.id.tv_text->callback(mRightList[position].cateName,mRightList[position].id)
        }
    }

    private fun callback(cateName: String?, id: String?) {

        var intent  = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra,cateName)
        bundle.putString(Configs.SCREEN_RESULT_ID,id)
        intent.putExtras(bundle)
        setResult(Configs.WORK_TYPE_RESULT_CODE,intent)
        finish()
    }

    override fun onClick(p0: View?) {

        callback(null,null)
    }

    override fun refreshLeftUI(data: NetData?) {
        if (data!=null&&data is WorkTypeBean &&data.result!=null){
            mLeftList.clear()
            mLeftList.addAll(data.result)
            mLeftAdapter?.notifyDataSetChanged()

            if (mLeftList.size>0){
                mLeftList[0].isSelect=true
            }
            mRightList.clear()
            mRightList.addAll(mLeftList[0].childList)
            mRightAdapter?.notifyDataSetChanged()
        }
    }
}
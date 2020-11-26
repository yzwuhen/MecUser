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
import com.example.mechanicalapp.ui.adapter.WorkTypeAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.MecTypeChildData
import com.example.mechanicalapp.ui.data.MecTypeParentData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.AddManagePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.MecTypeView
import kotlinx.android.synthetic.main.activity_ec_type.*

class WorkType : BaseCusActivity(), OnItemClickListener, MecTypeView<NetData>,View.OnClickListener{


    private var mLeftAdapter: EcTypeLeftAdapter? = null
    private var mRightAdapter: WorkTypeAdapter? = null
    private var mRightList: MutableList<MecTypeChildData> = ArrayList<MecTypeChildData>()
    var mLeftList: MutableList<MecTypeParentData> = ArrayList<MecTypeParentData>()

    private var mPresenter: AddManagePresenterImpl ?=null
    private var index:Int=0

    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }


    override fun initView() {
        super.initView()


        mLeftAdapter = EcTypeLeftAdapter(this, mLeftList, this)
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
                    (mPresenter as AddManagePresenterImpl)?.getWorkTypeChildList(mLeftList[position].id)
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

    override fun refreshLeftUI(list: List<MecTypeParentData>) {
        mLeftList.clear()
        mLeftList.addAll(list)
        mLeftList[0].isSelect =true
        mLeftAdapter?.notifyDataSetChanged()
    }

    override fun loadLeftMore(list: List<MecTypeParentData>) {
        mLeftList.addAll(list)
        mLeftAdapter?.notifyDataSetChanged()
    }

    override fun refreshRightUI(list: MutableList<MecTypeChildData>) {
        mRightList.clear()
        mRightList.addAll(list)
        mRightAdapter?.notifyDataSetChanged()
    }

    override fun loadRightMore(list: List<MecTypeChildData>) {
        mRightList.addAll(list)
        mRightAdapter?.notifyDataSetChanged()
    }

    override fun onClick(p0: View?) {

        callback(null,null)
    }
}
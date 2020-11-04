package com.example.mechanicalapp.ui.fragment.mine

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.*
import com.example.mechanicalapp.ui.adapter.MineMenuAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseFragment<NetData>(), OnItemClickListener, View.OnClickListener {

    private var mineMenuAdapter: MineMenuAdapter? = null

    override fun showLoading() {

    }

    override fun hiedLoading() {

    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_mine
    }


    override fun initView() {
        super.initView()

        mineMenuAdapter = MineMenuAdapter(mContext, this)
        recycle_list.layoutManager = GridLayoutManager(mContext, 4)
        recycle_list.adapter = mineMenuAdapter

        tv_edit.setOnClickListener(this)
        ly_integral.setOnClickListener(this)
        ly_collected.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        ly_release.setOnClickListener(this)
        iv_user_pic.setOnClickListener(this)
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    override fun onItemClick(view: View, position: Int) {

        when (position) {
            0 -> jumpActivity(null, PersonalCertification::class.java)
            1 -> jumpActivity(null, CompanyCertifyActivity::class.java)
            2 -> jumpActivity(null, MyMecListActivity::class.java)
            3 -> jumpActivity(null, MyLookActivity::class.java)
            4 -> jumpActivity(null, OrderCenterActivity::class.java)
            5 -> jumpActivity(null, PartsOrderActivity::class.java)
            6 -> jumpActivity(null, FactoryApplyActivity::class.java)
            7 -> jumpActivity(null, SettingActivity::class.java)
            9 -> jumpActivity(null, SuggestActivity::class.java)
        }
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.iv_user_pic -> jumpActivity(null, LoginActivity::class.java)
            R.id.tv_edit -> jumpActivity(null, UserDataActivity::class.java)
            R.id.ly_address -> jumpActivity(null, MyAddressActivity::class.java)
            R.id.ly_integral -> jumpActivity(null, MyIntegralActivity::class.java)
            R.id.ly_collected -> jumpActivity(null, MyCollectActivity::class.java)
            R.id.ly_release -> jumpActivity(null, MyReleaseActivity::class.java)
        }

    }
}
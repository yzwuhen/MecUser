package com.example.mechanicalapp.ui.fragment.release

import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean

class ReleaseFragment : BaseFragment<NetData>() {
    override fun getLayoutId(): Int {

        return R.layout.fragment_release
    }

    override fun initView() {
        super.initView()
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hiedLoading() {
        TODO("Not yet implemented")
    }

    override fun err()  {
        TODO("Not yet implemented")
    }
}
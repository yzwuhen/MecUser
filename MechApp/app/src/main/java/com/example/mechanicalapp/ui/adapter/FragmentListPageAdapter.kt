package com.example.mechanicalapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentListPageAdapter(
    var fm: FragmentManager,
    var mFragmentList: List<Fragment>
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position];
    }

    override fun getCount(): Int {
        if (mFragmentList == null) {
            return 0
        } else {
            return mFragmentList.size
        }
    }

}
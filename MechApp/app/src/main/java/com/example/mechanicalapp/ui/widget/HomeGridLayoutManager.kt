package com.example.mechanicalapp.ui.widget

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager

class HomeGridLayoutManager(var mContext: Context,var spanCounts:Int) : GridLayoutManager(mContext, spanCounts) {

    override fun canScrollVertically(): Boolean {
        return false
    }
}
package com.example.mechanicalapp.ui.widget

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class HomeLayoutManager(var mContext: Context) : LinearLayoutManager(mContext) {

    override fun canScrollVertically(): Boolean {
        return false
    }
}
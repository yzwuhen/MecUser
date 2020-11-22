package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.CommentData
import com.example.mechanicalapp.ui.data.NetData

interface CommentView :BaseView<NetData> {
    fun refreshUI(list: List<CommentData>?)
    fun loadMore(list: List<CommentData>?)
}
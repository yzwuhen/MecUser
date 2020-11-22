package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.CommentNumBean
import com.example.mechanicalapp.ui.data.NetData

interface CommentNumView :BaseView<NetData> {
    fun showData(commentNumBean: CommentNumBean?)
}
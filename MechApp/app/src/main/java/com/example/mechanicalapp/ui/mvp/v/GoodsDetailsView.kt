package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.CommentData
import com.example.mechanicalapp.ui.data.GoodsDetails

interface GoodsDetailsView :MecDetailsView<GoodsDetails> {
    fun comment(mlist: List<CommentData>?)
}
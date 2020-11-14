package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData

interface RecruitView:BaseView<NetData> {
    fun showWorkExp(mList: List<CodeData>)
    fun showWages(mList:  List<CodeData>)
    fun showSuccess(netData: NetData?)
}
package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.RecruitData

/**
 * 工作相关得 == 招聘 求职
 */
interface WorkAboutView:BaseView<NetData> {
    fun refreshRecruitUI(list: List<RecruitData>)
    fun loadRecruitMore(list: List<RecruitData>)

    fun err()
}
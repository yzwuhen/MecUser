package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.MecTypeChildBean
import com.example.mechanicalapp.ui.data.MecTypeChildData
import com.example.mechanicalapp.ui.data.MecTypeParentData
import com.example.mechanicalapp.ui.data.NetData


interface MecTypeView<T>:BaseView<NetData> {
    fun refreshLeftUI(list: List<MecTypeParentData>)
    fun loadLeftMore(list: List<MecTypeParentData>)
    fun refreshRightUI(list: MutableList<MecTypeChildData>)
    fun loadRightMore(list: List<MecTypeChildData>)
}
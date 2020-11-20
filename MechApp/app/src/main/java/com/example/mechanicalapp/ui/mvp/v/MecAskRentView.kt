package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.CodeData

interface MecMecAskRentView :ReleaseView<List<CodeData>> {
    fun showYears(t:List<CodeData>)//工厂年限
}
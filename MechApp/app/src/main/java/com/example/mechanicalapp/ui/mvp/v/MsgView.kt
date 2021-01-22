package com.example.mechanicalapp.ui.mvp.v

interface MsgView<T>  {
    fun refreshChartUI(t: T?)
    fun successChart()
}
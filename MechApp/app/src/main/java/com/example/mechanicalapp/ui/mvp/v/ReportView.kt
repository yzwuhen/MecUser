package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface ReportView :UpLoadFileView {
    fun showSuccess(netData: NetData?)
}
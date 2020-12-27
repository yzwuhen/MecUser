package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface ApplyRefundView :UpLoadFileView {
    fun successData(date:NetData?)
}
package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface ReleaseView <T> :UpLoadFileView {
    fun showSuccess(netData: NetData?)
    fun showData(t:T)
}
package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface UpLoadFileView :BaseView<NetData> {
    fun showImg(netData: NetData?)
    fun uploadFail(str:String)
}
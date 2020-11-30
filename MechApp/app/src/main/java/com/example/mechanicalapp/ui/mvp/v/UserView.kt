package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.NetData

interface UserView :UpLoadFileView  {
    fun success(netData: NetData?)
}
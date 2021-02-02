package com.example.mechanicalapp.ui.activity

import android.util.Log
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.ezvizuikit.open.EZUIError
import com.ezvizuikit.open.EZUIKit
import com.ezvizuikit.open.EZUIPlayer
import kotlinx.android.synthetic.main.activity_video_player.*
import java.util.*

class VideoPlayerActivity :BaseCusActivity(),EZUIPlayer.EZUIPlayerCallBack {
    override fun getLayoutId(): Int {
       return R.layout.activity_video_player
    }

    override fun initView() {
        super.initView()

        //初始化EZUIKit
        EZUIKit.initWithAppKey(application,"ca60c005fe454770ac6fd81fd03a6164")
        //设置授权token
        EZUIKit.setAccessToken("at.7s7w4rupcnedrna15mopp2bd5l1z6ou8-230dlfhljb-0szc66x-uapwqfhvl")
        //设置播放回调callback
        player_ui.setCallBack(this)
        //设置播放参数
        player_ui.setUrl("https://hls01open.ys7.com/openlive/6e0b2be040a943489ef0b9bb344b96b8.hd.m3u8")
    }

    override fun initPresenter() {
    }

    override fun onPlaySuccess() {

    }

    override fun onPlayFail(p0: EZUIError?) {
        Log.v("ssss","sssssssss=============${p0?.errorString}")
    }

    override fun onVideoSizeChange(p0: Int, p1: Int) {
    }

    override fun onPrepared() {
        player_ui.startPlay()
    }

    override fun onPlayTime(p0: Calendar?) {
    }

    override fun onPlayFinish() {
    }

    override fun onStop() {
        super.onStop()
        player_ui.stopPlay()
    }

    override fun onDestroy() {
        super.onDestroy()
        player_ui.releasePlayer();
    }
}
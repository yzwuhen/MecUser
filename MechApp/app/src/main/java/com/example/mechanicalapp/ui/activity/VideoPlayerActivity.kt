package com.example.mechanicalapp.ui.activity

import android.util.Log
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.ezvizuikit.open.EZUIError
import com.ezvizuikit.open.EZUIKit
import com.ezvizuikit.open.EZUIPlayer
import kotlinx.android.synthetic.main.activity_video_player.*
import java.util.*

class VideoPlayerActivity :BaseCusActivity(),EZUIPlayer.EZUIPlayerCallBack ,NetDataView<NetData>{
    private var mPresenter : MecAppPresenter?=null

    override fun getLayoutId(): Int {
       return R.layout.activity_video_player
    }

    override fun initView() {
        super.initView()

        //初始化EZUIKit
        EZUIKit.initWithAppKey(application,"ca60c005fe454770ac6fd81fd03a6164")
        //设置授权token
        EZUIKit.setAccessToken("at.9t81asxt304xxzmh5ctk4sft1mzr2qm8-86s6azs902-0bcfppm-ypdvqz0yp")
        //设置播放回调callback
        player_ui.setCallBack(this)
        //设置播放参数
        player_ui.setUrl("ezopen://open.ys7.com/E82901339/1.live")

    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
        mPresenter?.getAccessToken()
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

    override fun refreshUI(data: NetData?) {

    }

    override fun loadMore(data: NetData?) {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }
}
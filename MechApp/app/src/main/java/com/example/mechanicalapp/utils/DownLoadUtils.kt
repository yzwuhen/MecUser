package com.example.mechanicalapp.utils

import android.app.DownloadManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.mechanicalapp.App
import java.io.File
import java.io.IOException

class DownLoadUtils {

    private var downLoadId :Long=0
    private   var mDownloadManager:DownloadManager ?=null
    private var pathstr: String? = null
    private lateinit var mContext:Context

    open fun startDownLoad(context: Context,url:String?) {
        mContext =context
        mDownloadManager  = context.getSystemService(Service.DOWNLOAD_SERVICE) as DownloadManager
        var  mUri = Uri.parse(url)
        var request = DownloadManager.Request(mUri)
        //下载的本地路径，表示设置下载地址为SD卡的Download文件夹，文件名为mobileqq_android.apk。
        //    request.setDestinationInExternalPublicDir("Download", "mecApp.apk");
//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
//        request.setTitle("下载");
//        request.setDescription("apk正在下载")
//        request.setAllowedOverRoaming(false)
        val file = File(context.externalCacheDir, "mecApp.apk")
        request.setDestinationUri(Uri.fromFile(file))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            request.setRequiresDeviceIdle(false)
            request.setRequiresCharging(false)
        }
        request.setMimeType("application/vnd.android.package-archive");
        pathstr = file.absolutePath
        //添加到下载队列进行下载, 此方法会返回一个下载id  可用于查询下载进度
        downLoadId= mDownloadManager?.enqueue(request)!!

        context.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }

    //广播监听下载的各个状态
    private val receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            checkStatus()
        }
    }

    //检查下载状态
    private fun checkStatus() {
        val query = DownloadManager.Query()
        //通过下载的id查找
        query.setFilterById(downLoadId)
        val cursor: Cursor = mDownloadManager?.query(query) as Cursor
        if (cursor.moveToFirst()) {
            var status: Int = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
            when (status) {
                DownloadManager.STATUS_PAUSED -> {
                }
                DownloadManager.STATUS_PENDING -> {
                }
                DownloadManager.STATUS_RUNNING -> {
                }
                DownloadManager.STATUS_SUCCESSFUL -> {
                    //下载完成安装APK
                    installAPK()
                    cursor.close()
                }
                DownloadManager.STATUS_FAILED -> {
                    Toast.makeText(  App.getInstance().applicationContext, "下载失败", Toast.LENGTH_SHORT).show()
                    cursor.close()
                    App.getInstance().applicationContext.unregisterReceiver(receiver)
                }
            }
        }
    }
    private fun installAPK() {
        pathstr?.let { setPermission(it) }
        val intent = Intent(Intent.ACTION_VIEW)
        // 由于没有在Activity环境下启动Activity,设置下面的标签
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        //Android 7.0以上要使用FileProvider
        val file = File(pathstr)
        if (Build.VERSION.SDK_INT >= 24) {
            //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
            val apkUri: Uri =
                FileProvider.getUriForFile(mContext, "com.example.mechanicalapp.fileprovider", file)
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive")
        } else {
        intent.setDataAndType(
            Uri.fromFile(file),
            "application/vnd.android.package-archive"
        )
        }
        mContext.startActivity(intent)
    }

    //修改文件权限
    private fun setPermission(absolutePath: String) {
        val command = "chmod 777 $absolutePath"
        val runtime = Runtime.getRuntime()
        try {
            runtime.exec(command)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
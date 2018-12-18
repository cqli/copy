package com.ljb.mvp.kotlin

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.ljb.mvp.kotlin.common.GITHUB_CLIENT_ID
import com.ljb.mvp.kotlin.common.GITHUB_CLIENT_SECRET
import com.ljb.mvp.kotlin.common.HTTP_API_DOMAIN
import com.ljb.mvp.kotlin.utils.DeviceInfo
import com.ljb.mvp.kotlin.utils.SPUtils
import com.squareup.leakcanary.LeakCanary
import net.ljb.kt.HttpConfig

/**
 * Created by L on 2017/7/14.
 */
  class KotlinMVPApplication : Application() {

    companion object {
        var mContext: Context? = null

    }
    //应避免创建全局的Application引用
    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        mContext = applicationContext
        LeakCanary.install(this)
        SPUtils.init(this)
        initNet()
    }

    private fun initNet() {
        val paramMap = mapOf(
                "client_id" to GITHUB_CLIENT_ID,
                "client_secret" to GITHUB_CLIENT_SECRET)
        val headerMap = mapOf(
                "id" to "865736034702103",
                "model" to  DeviceInfo.getInstance().deviceType,
                "channel" to DeviceInfo.getInstance().channel,
                "version" to DeviceInfo.getInstance().osVersion,
                "display" to DeviceInfo.getInstance().display,
                "sid" to "1538732170138",
                "ssid" to "17fe26be8e413d4e4ec8965860110475",
                "appversion" to DeviceInfo.getInstance()
                        .versionCode.toString()
        )
        HttpConfig.init(HTTP_API_DOMAIN, headerMap, paramMap, true)
    }
}
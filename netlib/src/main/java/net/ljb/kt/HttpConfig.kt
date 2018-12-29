package net.ljb.kt

import net.ljb.kt.utils.NetLog

/**
 * 网络请求配置
 */
object HttpConfig {
    private var mHeaderMap: Map<String, String>? = null
    private var mParamMap: Map<String, String>? = null
    private var mBaseUrl: String = "https://course.hundun.cn"//课程搜索
//    private var mBaseUrl: String = "https://user.hundun.cn"//登陆

    private var isLog: Boolean = false

    fun init(baseUrl: String, headers: Map<String, String>? = null, params: Map<String, String>? = null, isLog: Boolean = false) {
        setBaseUrl(baseUrl)
        headers?.apply { setHeader(this) }
        params?.apply { setParam(this) }
        setLogEnable(isLog)
    }

    fun setBaseUrl(url: String) {
        mBaseUrl = url
    }

    fun getBaseUrl(): String {
        return checkNotNull(mBaseUrl)
    }

    fun setHeader(map: Map<String, String>) {
        mHeaderMap = map
    }

    fun setParam(map: Map<String, String>) {
        mParamMap = map
    }

    fun getHeader(): Map<String, String>? {
        return mHeaderMap
    }

    fun getParam(): Map<String, String>? {
        return mParamMap
    }

    fun setLogEnable(isLog: Boolean) {
        this.isLog = isLog
    }

    fun getLogLv(): Int {
        return if (isLog) NetLog.LEVEL_ALL else NetLog.LEVEL_NONE
    }

}
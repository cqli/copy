package com.ljb.mvp.kotlin.utils


import android.content.Context
import android.content.SharedPreferences


object SPUtils {

    private const val SP_NAME = "sp58che"

    private var instance: SharedPreferences? = null

    /** 使用前请先初始化 */
    fun init(context: Context) {
        if (instance != null) return
        instance = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }

    private fun checkInstance() {
        if (instance == null) throw InstantiationException("not init SharedPreferences ")
    }

    fun putString(key: String, value: String) {
        checkInstance()
        instance!!.edit().putString(key, value).apply()
    }


    fun getString(key: String): String {
        checkInstance()
        return instance!!.getString(key, "")
    }

    fun putBoolean(key: String, value: Boolean) {
        checkInstance()
        instance!!.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return instance!!.getBoolean(key, false)
    }

    fun putLong(key: String, value: Long) {
        checkInstance()
        instance!!.edit().putLong(key, value).apply()
    }

    fun getLong(key: String): Long {
        checkInstance()
        return instance!!.getLong(key, 0L)
    }

    fun putInt(key: String, value: Int) {
        checkInstance()
        instance!!.edit().putInt(key, value).apply()
    }

    fun getInt(key: String): Int {
        checkInstance()
        return instance!!.getInt(key, 0)
    }

    fun putFloat(key: String, value: Float) {
        checkInstance()
        instance!!.edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String): Float {
        checkInstance()
        return instance!!.getFloat(key, 0f)
    }

    fun putStringSet(key: String, setValue: Set<String>) {
        checkInstance()
        instance!!.edit().putStringSet(key, setValue).apply()
    }

    fun getStringSet(key: String): Set<String> {
        checkInstance()
        return instance!!.getStringSet(key, null)
    }

    private val APP_NAME = "yanxishe"

    fun getBooleanValue(paramString: String, paramContext: Context): Boolean {
        try {
            return paramContext.getSharedPreferences("yanxishe", 0).getBoolean(paramString, false)
        } catch (localException: Exception) {
        }

        return false
    }

    fun getFloatValue(paramString: String, paramContext: Context): Float {
        try {
            return paramContext.getSharedPreferences("yanxishe", 0).getFloat(paramString, 0.0f)
        } catch (localException: Exception) {
        }

        return 0.0f
    }

    fun getIntValue(paramString: String, paramContext: Context): Int {
        try {
            return paramContext.getSharedPreferences("yanxishe", 0).getInt(paramString, 0)
        } catch (localException: Exception) {
        }

        return 0
    }

    fun getLongValue(paramString: String, paramContext: Context): Long {
        try {
            return paramContext.getSharedPreferences("yanxishe", 0).getLong(paramString, 0L)
        } catch (localException: Exception) {
        }

        return 0L
    }

    fun getStringValue(paramString: String, paramContext: Context): String? {
        try {
            return paramContext.getSharedPreferences("yanxishe", 0).getString(paramString, "")
        } catch (localException: Exception) {
        }

        return null
    }

    fun setBooleanValue(paramString: String, paramBoolean: Boolean, paramContext: Context) {
        paramContext.getSharedPreferences("yanxishe", 0).edit().putBoolean(paramString, paramBoolean).apply()
    }

    fun setFloatValue(paramString: String, paramFloat: Float, paramContext: Context) {
        paramContext.getSharedPreferences("yanxishe", 0).edit().putFloat(paramString, paramFloat).apply()
    }

    fun setIntValue(paramString: String, paramInt: Int, paramContext: Context) {
        paramContext.getSharedPreferences("yanxishe", 0).edit().putInt(paramString, paramInt).apply()
    }

    fun setLongValue(paramString: String, paramLong: Long, paramContext: Context) {
        paramContext.getSharedPreferences("yanxishe", 0).edit().putLong(paramString, paramLong).apply()
    }

    fun setStringValue(paramString1: String, paramString2: String, paramContext: Context) {
        paramContext.getSharedPreferences("yanxishe", 0).edit().putString(paramString1, paramString2).apply()
    }
}

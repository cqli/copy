package com.ljb.mvp.kotlin.utils

import android.content.Context

object HunDunSP {

    fun clearUserInfo(paramContext: Context) {
        setUserid("", paramContext)
        setName("", paramContext)
        setPhone("", paramContext)
        setPhone("", paramContext)
        setPassword("", paramContext)
        setThirdId("", paramContext)
        setThirdType("", paramContext)
        setAvatar("", paramContext)
        setAppModel("", paramContext)
    }

    fun getAppModel(paramContext: Context): String? {
        return SPUtils.getStringValue("app_model", paramContext)
    }

    fun getAvatar(paramContext: Context): String? {
        return SPUtils.getStringValue("AVATAR", paramContext)
    }

    fun getDeviceToken(paramContext: Context): String? {
        return SPUtils.getStringValue("DEVICE_TOKEN", paramContext)
    }

    fun getDotStatus(paramContext: Context): Boolean {
        return SPUtils.getBooleanValue("dot_status", paramContext)
    }

    fun getFristStartStatus(paramContext: Context): Boolean {
        return SPUtils.getBooleanValue("first_status", paramContext)
    }

    fun getLiveAudio(paramContext: Context): Int {
        return SPUtils.getIntValue("LIVE_AUDIO", paramContext)
    }

    fun getName(paramContext: Context): String? {
        return SPUtils.getStringValue("NAME", paramContext)
    }

    fun getPassword(paramContext: Context): String? {
        return SPUtils.getStringValue("PASSWORD", paramContext)
    }

    fun getPhone(paramContext: Context): String? {
        return SPUtils.getStringValue("PHONE", paramContext)
    }

    fun getQuesCount(paramContext: Context): String? {
        return SPUtils.getStringValue("ques_count", paramContext)
    }

    fun getRewardPhone(paramContext: Context): String? {
        return SPUtils.getStringValue("REWARD_PHONE", paramContext)
    }

    fun getSearchHistory(paramContext: Context): String? {
        return SPUtils.getStringValue("HISTORY", paramContext)
    }

    fun getThirdId(paramContext: Context): String? {
        return SPUtils.getStringValue("THIRD_ID", paramContext)
    }

    fun getThirdType(paramContext: Context): String? {
        return SPUtils.getStringValue("THIRD_TYPE", paramContext)
    }

    fun getTypeId(paramContext: Context): String? {
        return SPUtils.getStringValue("type_id", paramContext)
    }

    fun getUserid(paramContext: Context): String? {
        return SPUtils.getStringValue("USER_ID", paramContext)
    }

    fun setAppModel(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("app_model", paramString, paramContext)
    }

    fun setAvatar(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("AVATAR", paramString, paramContext)
    }

    fun setDeviceToken(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("DEVICE_TOKEN", paramString, paramContext)
    }

    fun setDotStatus(paramBoolean: Boolean, paramContext: Context) {
        SPUtils.setBooleanValue("dot_status", java.lang.Boolean.valueOf(paramBoolean), paramContext)
    }

    fun setFristStartStatus(paramBoolean: Boolean, paramContext: Context) {
        SPUtils.setBooleanValue("first_status", java.lang.Boolean.valueOf(paramBoolean), paramContext)
    }

    fun setLiveAudio(paramInt: Int, paramContext: Context) {
        SPUtils.setIntValue("LIVE_AUDIO", paramInt, paramContext)
    }

    fun setName(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("NAME", paramString, paramContext)
    }

    fun setPassword(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("PASSWORD", paramString, paramContext)
    }

    fun setPhone(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("PHONE", paramString, paramContext)
    }

    fun setQuesCount(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("ques_count", paramString, paramContext)
    }

    fun setRewardPhone(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("REWARD_PHONE", paramString, paramContext)
    }

    fun setSearchHistory(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("HISTORY", paramString, paramContext)
    }

    fun setThirdId(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("THIRD_ID", paramString, paramContext)
    }

    fun setThirdType(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("THIRD_TYPE", paramString, paramContext)
    }

    fun setTypeId(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("type_id", paramString, paramContext)
    }

    fun setUserid(paramString: String, paramContext: Context) {
        SPUtils.setStringValue("USER_ID", paramString, paramContext)
    }


    private val APP_MODEL = "app_model"
    private val AVATAR = "AVATAR"
    private val DEVICE_TOKEN = "DEVICE_TOKEN"
    private val DOT_STATUS = "dot_status"
    private val FIRST_STATUS = "first_status"
    private val HISTORY = "HISTORY"
    private val LIVE_AUDIO = "LIVE_AUDIO"
    private val NAME = "NAME"
    private val PASSWORD = "PASSWORD"
    private val PHONE = "PHONE"
    private val QUES_COUNT = "ques_count"
    private val REWARD_PHONE = "REWARD_PHONE"
    private val THIRD_ID = "THIRD_ID"
    private val THIRD_TYPE = "THIRD_TYPE"
    private val TYPE_ID = "type_id"
    private val USER_ID = "USER_ID"

}

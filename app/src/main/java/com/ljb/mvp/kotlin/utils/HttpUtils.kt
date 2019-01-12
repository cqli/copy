package com.ljb.mvp.kotlin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils

import com.ljb.mvp.kotlin.KotlinMVPApplication

import java.util.HashMap

import okhttp3.Headers
import okhttp3.Request
import com.ljb.mvp.kotlin.resultbean.post.BasePostEntity
import java.security.MessageDigest


/**
 * 混沌学院 App 公共参数
 */
class HttpUtils {
    companion object {
        private val EMPTY_IMEI = "000000000000000"

        fun MD5(paramString: String): String {
            val arrayOfChar1 = charArrayOf(48.toChar(), 49.toChar(), 50.toChar(), 51.toChar(), 52.toChar(), 53.toChar(), 54.toChar(), 55.toChar(), 56.toChar(), 57.toChar(), 65.toChar(), 66.toChar(), 67.toChar(), 68.toChar(), 69.toChar(), 70.toChar())
            try {
                val arrayOfByte1 = paramString.toByte()
                val localMessageDigest = MessageDigest.getInstance("MD5")
                localMessageDigest.update(arrayOfByte1)
                val arrayOfByte2 = localMessageDigest.digest()
                val arrayOfChar2 = CharArray(2 * arrayOfByte2.size)
                val i = arrayOfByte2.size
                var j = 0
                var k = 0
                while (j < i) {
                    val m = arrayOfByte2[j].toInt()
                    val n = k + 1
                    arrayOfChar2[k] = arrayOfChar1[0xF and m.ushr(4)]
                    k = n + 1
                    arrayOfChar2[n] = arrayOfChar1[m and 0xF]
                    j++
                }
                return String(arrayOfChar2)
            } catch (localException: Exception) {
                localException.printStackTrace()
            }

            return ""
        }

        fun addHeaderToRequest(var0: Request.Builder, var1: Context) {
            var0.addHeader("versionName", VersionUtils.getVersionName(var1))
            var0.addHeader("clientType", phoneType + "_" + androidSDKVersion)
            var0.addHeader("imei", getImei(var1))
            var0.addHeader("net", "cmwap")
//            val var6 = HunDunSP.getUserid(var1)
            val var6  = "136c410fa193c38528870125ace273bd"
                var0.addHeader("user_id", var6!!)

            val var7 = HunDunSP.getAppModel(KotlinMVPApplication.mContext!!)
            if (!TextUtils.isEmpty(var7)) {
                var0.addHeader("app_role", var7)
            } else {
                var0.addHeader("app_role", "yxs")
            }

            var0.addHeader("device_type", deviceType)
        }

        fun addToPost(paramBasePostEntity: BasePostEntity, paramContext: Context) {
            paramBasePostEntity.versionName = VersionUtils.getVersionName(paramContext)
            paramBasePostEntity.clientType = phoneType + "_" + androidSDKVersion
            paramBasePostEntity.imei = getImei(paramContext)
            paramBasePostEntity.appChannel = VersionUtils.getChannel()
            val str1 = HunDunSP.getUserid(KotlinMVPApplication.mContext!!)
            if (str1 != null && !TextUtils.isEmpty(str1))
                paramBasePostEntity.user_id = "136c410fa193c38528870125ace273bd"
            paramBasePostEntity.net = "cmwap"
            val str2 = HunDunSP.getAppModel(KotlinMVPApplication.mContext!!)
            if (!TextUtils.isEmpty(str2))
                paramBasePostEntity.app_role = str2

            paramBasePostEntity.app_role = "yxs"
        }

        fun addToGet(): Map<String, String> {
            val var0 = HashMap<String, String>()
            var0.put("versionName", VersionUtils.getVersionName(KotlinMVPApplication.mContext!!))
            var0.put("channel", VersionUtils.getChannel())
            var0.put("clientType", phoneType + "_" + androidSDKVersion)
            var0.put("imei", this!!.getImei(KotlinMVPApplication.mContext)!!)
            val var5 = HunDunSP.getUserid(KotlinMVPApplication.mContext!!)
            if (var5 != null && !TextUtils.isEmpty(var5)) {
                var0.put("user_id", "136c410fa193c38528870125ace273bd")
            }

            val var6 = HunDunSP.getAppModel(KotlinMVPApplication.mContext!!)
            if (!TextUtils.isEmpty(var6)) {
                if (var6 != null) {
                    var0.put("app_role", var6)
                }
            } else {
                var0.put("app_role", "yxs")
            }

            var0.put("device_type", deviceType)
            return var0
        }


        fun buildWebViewBaseUrl(var0: String, var1: Context): String {
            val var2 = StringBuilder()
            var2.append(var0).append("user_id=").append("136c410fa193c38528870125ace273bd").append("&versionName=").append(VersionUtils.getVersionName(var1)).append("&net=").append("cmwap").append("&clientType=").append(phoneType).append("_").append(androidSDKVersion).append("&imei=").append(getImei(var1)).append("&phone=").append(HunDunSP.getPhone(var1)).append("&app_role=").append(HunDunSP.getAppModel(var1))
            return var2.toString()
        }

        fun decodeHeader(var0: Headers): Map<String, String> {
            val var1 = HashMap<String, String>()

            for (var2 in 0 until var0.size()) {
                var1.put(var0.name(var2), var0.value(var2))
            }

            return var1
        }

        internal val androidSDKVersion: String
            get() = "android_" + Build.VERSION.RELEASE

        private val deviceType: String
            get() = if (15 and KotlinMVPApplication.mContext!!.resources.configuration.screenLayout >= 3) "pad" else "phone"

        @SuppressLint("WrongConstant", "MissingPermission")
        fun getImei(paramContext: Context?): String? {
            try {
                val localTelephonyManager = paramContext!!.getSystemService("phone") as TelephonyManager
                var str: String? = null
                if (localTelephonyManager != null)
                    str = localTelephonyManager.deviceId
                if (localTelephonyManager != null && TextUtils.isEmpty(str))
                    str = Settings.Secure.getString(paramContext.contentResolver, "android_id")
                if (localTelephonyManager != null && TextUtils.isEmpty(str))
                    str = localTelephonyManager.simSerialNumber
                if (localTelephonyManager != null && TextUtils.isEmpty(str))
                    str = (KotlinMVPApplication.mContext!!.applicationContext.getSystemService("wifi") as WifiManager).connectionInfo.macAddress
                if (localTelephonyManager != null && TextUtils.isEmpty(str)) {
                    val localStringBuilder = StringBuilder()
                    localStringBuilder.append("XS")
                    localStringBuilder.append(Build.BOARD.length % 10)
                    localStringBuilder.append(Build.BRAND.length % 10)
                    localStringBuilder.append(Build.CPU_ABI.length % 10)
                    localStringBuilder.append(Build.DEVICE.length % 10)
                    localStringBuilder.append(Build.DISPLAY.length % 10)
                    localStringBuilder.append(Build.HOST.length % 10)
                    localStringBuilder.append(Build.ID.length % 10)
                    localStringBuilder.append(Build.MANUFACTURER.length % 10)
                    localStringBuilder.append(Build.MODEL.length % 10)
                    localStringBuilder.append(Build.PRODUCT.length % 10)
                    localStringBuilder.append(Build.TAGS.length % 10)
                    localStringBuilder.append(Build.TYPE.length % 10)
                    localStringBuilder.append(Build.USER.length % 10)
                    str = localStringBuilder.toString()
                }
                if (TextUtils.isEmpty(str))
                    str = "000000000000000"
                return str
            } catch (localThrowable: Throwable) {
            }

            return "000000000000000"
        }

        internal val phoneType: String
            get() {
                var var0 = Build.MODEL.replace(" ", "")
                if (!TextUtils.isEmpty(var0)) {
                    var0 = var0.trim { it <= ' ' }
                }

                if (TextUtils.isEmpty(var0)) {
                    var0 = "null"
                }

                return var0
            }
    }
}

package com.ljb.mvp.kotlin.presenter

import android.util.Log
import com.google.gson.Gson
import com.ljb.mvp.kotlin.KotlinMVPApplication
import com.ljb.mvp.kotlin.common.ex.subscribeEx
import com.ljb.mvp.kotlin.contract.CollegeContract
import com.ljb.mvp.kotlin.presenter.base.BaseRxLifePresenter
import com.ljb.mvp.kotlin.protocol.http.IUserHttpProtocol
import com.ljb.mvp.kotlin.resultbean.post.Login
import com.ljb.mvp.kotlin.utils.HttpUtils
import com.ljb.mvp.kotlin.utils.VersionUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.ljb.kt.client.HttpFactory
import okhttp3.RequestBody

/**
 * Created by L on 2017/7/18.
 */
class CollegePresenter : BaseRxLifePresenter<CollegeContract.IView>(),
        CollegeContract.IPresenter {
    override fun getData() {
        val localMap: HashMap<String, String> = HttpUtils.addToGet() as HashMap<String, String>
        localMap.put("sc_query", "为什么聪明人也会做蠢事")
        localMap.put("page", "0")
        HttpFactory.getProtocol(IUserHttpProtocol::class.java, false).searchCourse(localMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeEx(onNext = {
                    Log.e("lcq", it.toString())
                })
                .bindRxLifeEx(RxLife.ON_DESTROY)

    }

    override  fun login() {

        var localLogin =  Login()
        HttpUtils.addToPost(localLogin, KotlinMVPApplication.mContext!!)
        localLogin.setPhone("18600260492")
        localLogin.setPasswd(HttpUtils.MD5("775263.lcq"));
        localLogin.setChannel(VersionUtils.getChannel())
        var l = System.currentTimeMillis() / 1000L
        localLogin.setTimestamp(l)
        localLogin.setAuth_code(HttpUtils.MD5("app_key=358e36bea512d841bed9212952362ac4&timestamp=" + l))

        val create = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), Gson().toJson(localLogin))

        val localMap: HashMap<String, String> = HttpUtils.addToGet() as HashMap<String, String>
        HttpFactory.getProtocol(IUserHttpProtocol::class.java, true).login( create)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeEx(onNext = {
                    Log.e("lcq", it.toString())
                })
                .bindRxLifeEx(RxLife.ON_DESTROY)

    }



}
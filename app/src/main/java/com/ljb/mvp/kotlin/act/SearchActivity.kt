package com.ljb.mvp.kotlin.act

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.ljb.mvp.kotlin.common.ex.subscribeEx

import com.ljb.mvp.kotlin.presenter.base.BaseRxLifePresenter
import com.ljb.mvp.kotlin.protocol.http.IUserHttpProtocol
import com.ljb.mvp.kotlin.utils.HttpUtils

import net.ljb.kt.client.HttpFactory

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.logging.Logger


class SearchActivity : FragmentActivity() {
    internal var getCourse = "https://course.hundun.cn"//host地址
    internal var path = ""

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initData()
    }

    private fun initData() {
        val localMap:HashMap<String,String> = HttpUtils.addToGet() as HashMap<String, String>
        localMap.put("sc_query", "研习社")
        localMap.put("page", "1")
        HttpFactory.getProtocol(IUserHttpProtocol::class.java, true).searchCourse(HashMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeEx(onNext = {
                    if (it != null) {
                        Log.e("lcq", it.toString())
                    }
                })
    }
}

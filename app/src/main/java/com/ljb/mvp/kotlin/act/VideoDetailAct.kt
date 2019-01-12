package com.ljb.mvp.kotlin.act

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.ljb.mvp.kotlin.R
import com.ljb.mvp.kotlin.common.ex.subscribeEx
import com.ljb.mvp.kotlin.protocol.http.IUserHttpProtocol
import com.ljb.mvp.kotlin.utils.HttpUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_video_detail.*
import net.ljb.kt.client.HttpFactory

class VideoDetailAct : FragmentActivity() {
    var videoId = ""
    var courseID = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_detail)
        videoId = intent.getStringExtra("videoId")
        courseID = intent.getStringExtra("courseID")
        initData()
    }

    private fun initData() {
        val localMap: HashMap<String, String> = HttpUtils.addToGet() as HashMap<String, String>
        //视频ID 视频url
        localMap.put("video_id", videoId)
        localMap.put("clarity", "1")
//        //视频ID 视频url
//        localMap.put("video_id", "2b9b481ca78aa3dd705c74e80acd8836")
//        localMap.put("course_id", "2a9de999301644ce4e47f2bd4e44758d")
        HttpFactory.getProtocol(IUserHttpProtocol::class.java, true).getCourseVideoUrl(localMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeEx(onNext = {
                    Log.e("lcq", it.toString())
                    tv1.text = it
                })

        val localMap2: HashMap<String, String> = HttpUtils.addToGet() as HashMap<String, String>
//        //视频ID 视频url
        localMap2.put("video_id", videoId)
        localMap2.put("course_id", courseID)
        HttpFactory.getProtocol(IUserHttpProtocol::class.java, true).getCoursePlayVideoUrl(localMap2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeEx(onNext = {
                    Log.e("lcq", it.toString())
                    tv2.text = it
                })

    }
}
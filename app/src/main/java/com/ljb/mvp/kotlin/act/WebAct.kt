package com.ljb.mvp.kotlin.act

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.ljb.mvp.kotlin.R
import com.ljb.mvp.kotlin.utils.ParseWebUrlHelper
import kotlinx.android.synthetic.main.activity_webview.*

class WebAct : Activity() {
    var parseWebUrlHelper: ParseWebUrlHelper? = null
    var url = "https:www.hundun.cn/course_video/detail?course_id=6d18d7ceb51a12044138eee9a898d798&backplay=1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        webview.loadUrl(url)
        parseWebUrlHelper = ParseWebUrlHelper()
        parseWebUrlHelper?.init(this, url)
        parseWebUrlHelper?.setOnParseListener(object : ParseWebUrlHelper.OnParseWebUrlListener {
            override fun onFindUrl(url: String?) {

                Log.e("lcq", url)
            }

            override fun onError(errorMsg: String?) {

            }
        })
//        parseWebUrlHelper = ParseWebUrlHelper.getInstance().init(this.mAct, "");
//        //解析网页中视频
//        parseWebUrlHelper . setOnParseListener (new ParseWebUrlHelper . OnParseWebUrlListener () {
//            @Override public void onFindUrl(String url) { Log.d("webUrl", url);
//                *****处理代码
//            }
//            @Override public void onError(String errorMsg) {
//            ****出错监听
//            }
//        }
    }
}
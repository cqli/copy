package com.ljb.mvp.kotlin.act

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.webkit.WebView
import com.ljb.mvp.kotlin.R
import com.ljb.mvp.kotlin.common.act.BaseActivity
import com.ljb.mvp.kotlin.utils.ParseWebUrlHelper
import com.ljb.mvp.kotlin.widget.webview.SimpleWebActionCallBack
import com.ljb.mvp.kotlin.widget.webview.WebActionCallBack
import com.ljb.mvp.kotlin.widget.webview.WebViewProxy
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.layout_common_title.*
import kotlinx.android.synthetic.main.layout_web.*

/**
 * Author:Ljb
 * Time:2018/8/14
 * There is a lot of misery in life
 **/

class WebActivity : BaseActivity() {


    companion object {
        private const val KEY_URL = "webUrl"
        private const val KEY_TITLE = "webTitle"

        fun startActivity(context: Context, url: String, title: String = "") {
            val intent = Intent(context, WebActivity::class.java)
            intent.putExtra(KEY_URL, url)
            intent.putExtra(KEY_TITLE, title)
            context.startActivity(intent)
        }
    }

    private var mTitle: String? = null
    private var mUrl: String? = null
    private lateinit var mProxy: WebViewProxy
    var parseWebUrlHelper: ParseWebUrlHelper? = null

    override fun getLayoutId() = R.layout.activity_web

    override fun init(savedInstanceState: Bundle?) {
        mTitle = intent.getStringExtra(KEY_TITLE)
        mUrl = "https:www.hundun.cn/course_video/detail?course_id=6d18d7ceb51a12044138eee9a898d798&backplay=1"
        if (TextUtils.isEmpty(mUrl)) finish()
    }

    override fun initView() {
        page_layout.apply {
            setContentView(R.layout.layout_web)
        }
        iv_back.setOnClickListener { onBack() }
        mProxy = WebViewProxy(this, webview, page_layout, object : SimpleWebActionCallBack() {
            override fun onReceivedTitle(view: WebView?, title: String?) {
                if (TextUtils.isEmpty(mTitle)) tv_title.text = title
            }
        })
        parseWebUrlHelper = ParseWebUrlHelper()
        parseWebUrlHelper?.init(this, mUrl)
        parseWebUrlHelper?.setOnParseListener(object : ParseWebUrlHelper.OnParseWebUrlListener {
            override fun onFindUrl(url: String?) {

                Log.e("lcq", url)
            }

            override fun onError(errorMsg: String?) {

            }
        })
    }

    override fun initData() {
        if (!TextUtils.isEmpty(mTitle)) {
            tv_title.text = mTitle
        }
        if (!TextUtils.isEmpty(mUrl) && !mUrl!!.startsWith("http")) {
            mUrl = "http://$mUrl"
        }
        mProxy.loadUrl(mUrl!!)
    }


    override fun onPause() {
        super.onPause()
        mProxy.onWebViewPause()
    }

    override fun onResume() {
        super.onResume()
        mProxy.onWebViewResume()
    }

    override fun onBack() {
        if (mProxy.canGoBack()) {
            mProxy.goBack()
        } else {
            super.onBack()
        }
    }

    override fun onDestroy() {
        mProxy.onDestroy()
        super.onDestroy()
    }
}
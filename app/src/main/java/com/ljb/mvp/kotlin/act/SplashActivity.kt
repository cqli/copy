package com.ljb.mvp.kotlin.act

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.RelativeLayout
import com.githang.statusbar.StatusBarCompat
import com.ljb.mvp.kotlin.R
import com.ljb.mvp.kotlin.utils.DeviceInfo
import com.ljb.mvp.kotlin.utils.DeviceInfo.dp2px
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity: FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        StatusBarCompat.setStatusBarColor(this, resources.getColor(R.color.colorWhite))
        StatusBarCompat.setTranslucent(window, true)
        initView()
        val dp2px = dp2px(this, 15f)
        val layoutParamsRela = downText.layoutParams as RelativeLayout.LayoutParams
        layoutParamsRela.setMargins(dp2px, DeviceInfo.getStatusHeight(this)+dp2px,dp2px,dp2px)
        downText.layoutParams = layoutParamsRela
    }

    private fun initView() {
        downText.setDuration(5000) {
            goHome()
        }
    }
    fun goHome(){
        val intent=  Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
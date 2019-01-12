package com.ljb.mvp.kotlin.act

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.zxing.client.android.CaptureActivity2
import com.ljb.mvp.kotlin.R
import kotlinx.android.synthetic.main.actitivy_scannerview.*

class ScannerViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actitivy_scannerview)
        tvClick.setOnClickListener {
            val intent = Intent(this@ScannerViewActivity, CaptureActivity2::class.java)
            intent.putExtra(CaptureActivity2.USE_DEFUALT_ISBN_ACTIVITY, true)
            startActivityForResult(intent, 100)
        }
    }

    @SuppressLint("ShowToast")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            val isbn = data?.getStringExtra("CaptureIsbn")
            Toast.makeText(baseContext,isbn,Toast.LENGTH_LONG)
            if (!TextUtils.isEmpty(isbn))
                Log.e("lcq",isbn)
        }
    }
}
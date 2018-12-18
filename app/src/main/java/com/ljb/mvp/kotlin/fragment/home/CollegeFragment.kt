package com.ljb.mvp.kotlin.fragment.home

import android.content.DialogInterface
import com.ljb.mvp.kotlin.R
import com.ljb.mvp.kotlin.common.fragment.BaseMvpFragment
import com.ljb.mvp.kotlin.contract.CollegeContract
import com.ljb.mvp.kotlin.presenter.CollegePresenter
import com.ljb.mvp.kotlin.widget.dialog.NormalMsgDialog
import kotlinx.android.synthetic.main.fragment_college.*


/**
 * 课程首页
 */
class CollegeFragment : BaseMvpFragment<CollegeContract.IPresenter>(), CollegeContract.IView {
    override fun showMsg(str: String) {
            tv_msg.text = str
    }

    private val mLogoutDialog by lazy {
        NormalMsgDialog(activity!!)
                .setMessage(R.string.logout_user)
                .setLeftButtonInfo(R.string.cancel)
                .setRightButtonInfo(R.string.enter, DialogInterface.OnClickListener { _, _ ->

                })
    }

    override fun getLayoutId() = R.layout.fragment_college

    override fun registerPresenter() = CollegePresenter::class.java

    override fun initView() {
        btn_logout.setOnClickListener {
                getPresenter().getData()
        }
    }

    override fun initData() {
    }


}
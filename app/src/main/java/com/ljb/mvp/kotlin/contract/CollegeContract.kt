package com.ljb.mvp.kotlin.contract

import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract
import com.ljb.mvp.kotlin.domain.User

/**
 * Created by L on 2017/7/18.
 */
interface CollegeContract {

    interface IView : IViewContract {
        fun showMsg(str: String)
    }

    interface IPresenter : IPresenterContract {
        fun getData()
    }
}
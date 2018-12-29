package com.ljb.mvp.kotlin.contract

import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract
import com.ljb.mvp.kotlin.domain.User
import com.ljb.mvp.kotlin.resultbean.BaseResult
import com.ljb.mvp.kotlin.resultbean.HttpResult
import com.ljb.mvp.kotlin.resultbean.course.ExerciseRuleInfo

/**
 * Created by L on 2017/7/18.
 */
interface CollegeContract {

    interface IView : IViewContract {
        fun showMsg(str: HttpResult<ExerciseRuleInfo>)
    }

    interface IPresenter : IPresenterContract {
        fun getData()
        fun login()
    }
}
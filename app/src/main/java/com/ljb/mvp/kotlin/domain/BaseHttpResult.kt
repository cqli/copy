package com.ljb.mvp.kotlin.domain

/**
 * Created by lcq on 2016/10/21.
 * 抽取的一个基类的bean,直接在泛型中传data就行
 */

class BaseHttpResult<T> {
    var data: T? = null
    var code: Int = 0
    var errorMsg: String? = null

    override fun toString(): String {
        return "BaseHttpResult{" +
                "datas=" + data +
                ", code=" + code +
                ", errorMsg='" + errorMsg + '\''.toString() +
                '}'.toString()
    }
}

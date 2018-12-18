package com.ljb.mvp.kotlin.presenter

import com.ljb.mvp.kotlin.common.ex.subscribeEx
import com.ljb.mvp.kotlin.contract.CollegeContract
import com.ljb.mvp.kotlin.presenter.base.BaseRxLifePresenter
import com.ljb.mvp.kotlin.protocol.http.IUserHttpProtocol
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.ljb.kt.client.HttpFactory

/**
 * Created by L on 2017/7/18.
 */
class CollegePresenter : BaseRxLifePresenter<CollegeContract.IView>(),
        CollegeContract.IPresenter {
    override fun getData() {
        HttpFactory.getProtocol(IUserHttpProtocol::class.java,true).getCate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeEx(onNext = {
                    if (it != null) {
                        getMvpView().showMsg(it)
                    }
                })
                .bindRxLifeEx(RxLife.ON_DESTROY)

    }





}
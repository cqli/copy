package com.ljb.mvp.kotlin.modules.me;

import com.ljb.mvp.kotlin.resultbean.BaseResult;
import com.ljb.mvp.kotlin.resultbean.HttpResult;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 获取消息列表
 */
public abstract interface IMeService {
    public static final String URL_HEADER = "https://course.hundun.cn";

    @GET("https://course.hundun.cn/practice/get_notify_list")
    public abstract Flowable<HttpResult<BaseResult>> getNotifyList(@Query("page_no") int paramInt);
}

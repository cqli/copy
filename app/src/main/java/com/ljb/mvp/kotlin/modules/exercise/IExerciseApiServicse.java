package com.ljb.mvp.kotlin.modules.exercise;

import com.ljb.mvp.kotlin.resultbean.BaseResult;
import com.ljb.mvp.kotlin.resultbean.HttpResult;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public abstract interface IExerciseApiServicse {

    public static final String LIST_SORT_DEFUALT = "default";
    public static final String LIST_SORT_TIME = "by_time";
    public static final String URL_HEADER = "https://course.hundun.cn";

//    @GET("https://course.hundun.cn/practice/answer_comment_list")
//    public abstract Flowable<HttpResult<ExerciseCommentsNet>> getCommentsList(@Query("answer_id") int paramInt1, @Query("page_no") int paramInt2);
//
//    @GET("https://course.hundun.cn/get_course_detail")
//    public abstract Flowable<HttpResult<ExerciseRuleInfo>> getCourseMeta(@Query("course_id") String paramString);
//
//    @GET("https://course.hundun.cn/credit/course_credit_detail")
//    public abstract Flowable<HttpResult<CreditDetailNet>> getCreditDetail(@Query("course_id") String paramString);
//
//    @GET("https://course.hundun.cn/practice/practice_answer_list")
//    public abstract Flowable<HttpResult<ExerciseAnswersNet>> getExerciseAnswerList(@Query("practice_id") int paramInt1, @Query("order_type") String paramString, @Query("page_no") int paramInt2);
//
//    @GET("https://course.hundun.cn/practice/get_practice_detail")
//    public abstract Flowable<HttpResult<ExerciseDetailNet>> getExerciseDetail(@Query("course_id") String paramString);
//
//    @GET("https://course.hundun.cn/practice/practice_list")
//    public abstract Flowable<HttpResult<ExerciseTitlesNet>> getExerciseTitles(@Query("page_no") int paramInt);
//
//    @GET("https://course.hundun.cn/practice/get_my_practice_answer")
//    public abstract Flowable<HttpResult<ExerciseMyAnswersNet>> getMyExerciseAnswers(@Query("page_no") int paramInt);
//
//    @GET("https://course.hundun.cn/practice/get_my_answer_review")
//    public abstract Flowable<HttpResult<ExerciseMyAnswersNet>> getMyReviewExerciseAnswers(@Query("page_no") int paramInt);
//
//    @GET("https://course.hundun.cn/practice/get_review_rules")
//    public abstract Flowable<HttpResult<ExerciseRuleInfo>> getRuleInfo();
//
//    @GET("https://course.hundun.cn/practice/practice_answer_detail")
//    public abstract Flowable<HttpResult<ExerciseAnswerDetailNet>> getUserAnswerDetail(@Query("answer_id") int paramInt);
//
//    @POST("https://course.hundun.cn/practice/apply_reviewer")
//    public abstract Flowable<HttpResult<ExerciseApplyReviewerResult>> postApplyReviewer();
//
//    @POST("https://course.hundun.cn/practice/del_answer_comment")
//    public abstract Flowable<HttpResult<EmptNetData>> postDeleteComment(@Body DeleteCommentPost paramDeleteCommentPost);
//
//    @POST("https://course.hundun.cn/practice/answer_comment_thumb")
//    public abstract Flowable<HttpResult<EmptNetData>> postPraiseForComment(@Body PraiseCommentPost paramPraiseCommentPost);
//
//    @POST("https://course.hundun.cn/practice/practice_answer_thumb")
//    public abstract Flowable<HttpResult<EmptNetData>> postPraiseForExer(@Body PraiseAnswerPost paramPraiseAnswerPost);
//
//    @POST("https://course.hundun.cn/practice/push_practice_answer")
//    public abstract Flowable<HttpResult<ExercisePublishResNet>> postPublishUserExercise(@Body PublishAnswerPost paramPublishAnswerPost);
//
//    @Retention(RetentionPolicy.SOURCE)
//    public static @interface ListSortType
//    {
//    }
}

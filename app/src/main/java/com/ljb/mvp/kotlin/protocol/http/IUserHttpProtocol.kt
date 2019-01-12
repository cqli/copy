package com.ljb.mvp.kotlin.protocol.http

import com.ljb.mvp.kotlin.domain.*
import com.ljb.mvp.kotlin.resultbean.HttpResult
import com.ljb.mvp.kotlin.resultbean.course.CourseDetial
import com.ljb.mvp.kotlin.resultbean.course.ExerciseRuleInfo
import com.ljb.mvp.kotlin.resultbean.course.SearchResult
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

interface IUserHttpProtocol {
    /**
     * @param userName 用户名
     * @return  用户基本信息
     * */
    @GET("/users/{userName}")
    fun getUserInfoByName(@Path("userName") userName: String): Observable<User?>

    @POST("phone/ugm4_ugcCates.xhtml")
    fun getCate(): Observable<String?>

    //获取课程详情
    @GET("get_course_detail")
    fun getCourseMeta(@Query("course_id") paramString: String): Observable<HttpResult<ExerciseRuleInfo>>

    //搜索课程
    @GET("/search/main_study_search")
    fun searchCourse(@QueryMap paramsMap: Map<String, String>): Observable<SearchResult>

    //获取课程信息  视频id
    @GET("/get_course_detail")
    fun getCourseDetail(@QueryMap paramsMap: Map<String, String>): Observable<CourseDetial>
    //获取视频url
    @GET("/oss_video_url")
    fun getCourseVideoUrl(@QueryMap paramsMap: Map<String, String>): Observable<String>

    //获取播放视频url
    @GET("/video/video_url_set")
    fun getCoursePlayVideoUrl(@QueryMap paramsMap: Map<String, String>): Observable<String>
    //搜索课程
    @POST("/login")
    fun login(@Body body: RequestBody ): Observable<String>

    /**
     * @param userName 用户名
     * @param page 页码
     * @return Events列表数据
     * */
    @GET("/users/{userName}/events")
    fun getEventsByName(@Path("userName") userName: String, @Query("page") page: Int): Observable<MutableList<Event>>

    /**
     * @param userName 用户名
     * @param page 页码
     * @return Starred列表数据
     * */
    @GET("/users/{userName}/starred")
    fun getStarredByName(@Path("userName") userName: String, @Query("page") page: Int): Observable<MutableList<Starred>>

    /**
     * @param userName 用户名
     * @param page 页码
     * @returnt Followers列表数据
     * */
    @GET("/users/{userName}/followers")
    fun getFollowersByName(@Path("userName") userName: String, @Query("page") page: Int): Observable<MutableList<Follower>>

    /**
     * @param userName 用户名
     * @param page 页码
     * @returnt Repositories列表数据
     * */
    @GET("/users/{userName}/repos")
    fun getRepositoriesByName(@Path("userName") userName: String, @Query("page") page: Int): Observable<MutableList<Repository>>

    /**
     * @param userName 用户名
     * @param page 页码
     * @returnt Following列表数据
     * */
    @GET("/users/{userName}/following")
    fun getFollowingByName(@Path("userName") userName: String, @Query("page") page: Int): Observable<MutableList<Following>>
}
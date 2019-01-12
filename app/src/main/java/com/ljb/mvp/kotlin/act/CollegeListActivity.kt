package com.ljb.mvp.kotlin.act

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Browser
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.ljb.mvp.kotlin.R
import com.ljb.mvp.kotlin.adapter.rv.CollegeListAdapter
import com.ljb.mvp.kotlin.adapter.rv.FollowersDecoration
import com.ljb.mvp.kotlin.common.ex.subscribeEx
import com.ljb.mvp.kotlin.domain.College
import com.ljb.mvp.kotlin.presenter.base.BaseRxLifePresenter
import com.ljb.mvp.kotlin.protocol.http.IUserHttpProtocol
import com.ljb.mvp.kotlin.utils.HttpUtils
import com.ljb.mvp.kotlin.widget.loadmore.LoadMoreRecyclerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_list_college.*
import net.ljb.kt.client.HttpFactory

class CollegeListActivity : FragmentActivity(), LoadMoreRecyclerAdapter.OnItemClickListener {
    override fun onItemClick(view: View, position: Int) {
        if (isCourseID){

            val uri = Uri.parse("https://www.hundun.cn/course_video/detail?course_id=${list!![position].courseId}&backplay=1")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.putExtra(Browser.EXTRA_APPLICATION_ID, getPackageName())
            try {
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("URLSpan", "Actvity was not found for intent, " + intent.toString())
            }
        }else{
            var intent = Intent(this,VideoDetailAct::class.java)
            intent.putExtra("courseID",courseID)
            intent.putExtra("videoId", list!![position].courseId)
            startActivity(intent)
        }

//        WebActivity.startActivity(this, "https://www.hundun.cn/course_video/detail?course_id=${list!![position].courseId}&backplay=1", list!![position].name)
    }
    var courseID = ""

    var list: MutableList<College>? = null
    var isCourseID : Boolean = false
    private val mAdapter by lazy { CollegeListAdapter(this, mutableListOf()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_college)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(FollowersDecoration())
            adapter = mAdapter
            mAdapter.setOnItemClickListener(this@CollegeListActivity)
        }
        btSearch.setOnClickListener {
            getSearchData(etKey.text.toString())
        }
        btCancel.setOnClickListener {
            mAdapter.mData.clear()
            mAdapter.mData.addAll(list!!)
            mAdapter.notifyDataSetChanged()
        }
        btVideoSearch.setOnClickListener {
            val localMap: HashMap<String, String> = HttpUtils.addToGet() as HashMap<String, String>
//            课程详细信息
            localMap.put("course_id", etCourID.text.toString())
//        //视频ID 视频url
//        localMap.put("video_id", "2b9b481ca78aa3dd705c74e80acd8836")
//        localMap.put("clarity", "1")
//        //视频ID 视频url
//        localMap.put("video_id", "2b9b481ca78aa3dd705c74e80acd8836")
//        localMap.put("course_id", "2a9de999301644ce4e47f2bd4e44758d")
            HttpFactory.getProtocol(IUserHttpProtocol::class.java, false).getCourseDetail(localMap)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeEx(onNext = {
                        Log.e("lcq", it.toString())
                        isCourseID = false
                        var listSearch: MutableList<College> = mutableListOf()
                        it.course_detail.i18n_directory[0].directory.forEach {
                            listSearch.add(College(it.title, it.video_id))
                        }
                        list = listSearch
                        mAdapter.mData.clear()
                        mAdapter.mData.addAll(listSearch!!)
                        mAdapter.notifyDataSetChanged()
                    })
        }
        initData()
    }

    fun getSearchData(key: String) {
        val localMap: HashMap<String, String> = HttpUtils.addToGet() as HashMap<String, String>
        //搜索
        localMap.put("sc_query", key)
        localMap.put("page", "0")
        //课程详细信息
//        localMap.put("course_id", "2a9de999301644ce4e47f2bd4e44758d")
//        //视频ID 视频url
//        localMap.put("video_id", "2b9b481ca78aa3dd705c74e80acd8836")
//        localMap.put("clarity", "1")
//        //视频ID 视频url
//        localMap.put("video_id", "2b9b481ca78aa3dd705c74e80acd8836")
//        localMap.put("course_id", "2a9de999301644ce4e47f2bd4e44758d")
        HttpFactory.getProtocol(IUserHttpProtocol::class.java, false).searchCourse(localMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeEx(onNext = {
                    Log.e("lcq", it.toString())
                    isCourseID = true
                    var listSearch: MutableList<College> = mutableListOf()
                    etCourID.setText(it.data.course_list[0].course_id.toString())
                    courseID = it.data.course_list[0].course_id.toString()
                    it.data.course_list.forEach {
                        listSearch.add(College(it.title, it.course_id))
                    }
                    list = listSearch
                    mAdapter.mData.clear()
                    mAdapter.mData.addAll(listSearch!!)
                    mAdapter.notifyDataSetChanged()
                })
    }

    private fun initData() {
        list = mutableListOf()
        list?.add(College("【一】资本视角下的公司运营\t", "2a9de999301644ce4e47f2bd4e44758d"))
        list?.add(College("【二】金融财务会计联动的资本战略", "70d91993d24cf3a9d5a51a9ae1e3f7b2"))
        list?.add(College("【三】定价工具与技术", "ca2e24309616681605db6dc9540d40c2"))
        list?.add(College("【四】注意力缺失世界中的品牌与促销", "02d615dc5097ab47621bc93c2258d98a"))
        list?.add(College("【一】何为市场营销", "09d014d5ae80b549773e5644e28188b2"))
        list?.add(College("【二】4P&4C理论与市场营销研发", "157a480fdfb3e2d9629f658f74fda41f"))
        list?.add(College(" 【一】宏观经济和大类资产：基本原理", "10765ef76f81f40a66af8ba4ba14f8ae"))
        list?.add(College("【二】转型宏观：增速换挡和高质量发展", "d651ea25bdad14551111c461fe7076d4"))
        list?.add(College("【三】中国经济形势与中美贸易战", "9412c0317a6978a6fc8d7ea659dce267"))
        list?.add(College("【四】机制设计的原理及应用", "b152ce7de56cddb28c0565cc403665a8"))
        list?.add(College("【一】人力资源管理创新与重构", "2ebca781a2b7edcbcc9d3f3ce871a3bc"))
        list?.add(College("【二】人力资源管理的战略思考", "8adecd4edc046cdd3ef616b5fa4330d8"))
        list?.add(College("【三】组织运行、制度体系与文化整合（上）", "300aeb5186c49ab65691780733d867d7"))
        list?.add(College("【四】文化整合（下）与管理圣经", "158c92de04c15d6ca1dcff3fb67ac76b"))
        list?.add(College("【五】六段式表格及其运用", "41903c9c33f090a82ed21f11fe29d7d8"))

        list?.add(College("【一】财务分析与企业生命周期", "ef77caeb8ccbad41ff251e6160092fff"))
        list?.add(College("【二】财务报表的原理", "fd4cefabe279872c63f3653eecebddc8"))
        list?.add(College("【三】财务报表的应用", "b7eb010a9aca340606eaf73340722816"))
        list?.add(College("【四】财务报表的分析方法和案例", "398c1b9cb6f6ed2d66bd78855bacc5f5"))

        list?.add(College("【一】如何找到最佳领导区", "707c9ceb6833f6dcea5e189829b51ba1"))
        list?.add(College("【二】如何应对压力与保持专注", "0e0b710ae00e0b34e0c976218ee0f5d4"))
        list?.add(College("【三】如何打造最优领导关系", "c702709451e36fab20931a6ce336630c"))


        list?.add(College("古希腊哲学【一】之古希腊文化与哲学", "4e649591cf53cecb2fa51e94acc2f923"))
        list?.add(College("古希腊哲学【二】之古希腊哲学的辉煌时代", "0200e44cbbc6307060ff3746f97da29e"))
        list?.add(College(" 古希腊哲学【三】古希腊哲学的顶峰和衰落", "232460988a2c3c0563cf4d95c024e33b"))

        list?.add(College("复杂性科学【一】混沌与涌现", "2dc2b4e0278552e935590c325d79a251"))
        list?.add(College("复杂性科学【二】开放与进化", "2b2dd3384032f4b3f94774a7b8f6fb91"))
        list?.add(College("复杂性科学【三】之网络科学", "261e0352985392669e92fd64cde75250"))
        list?.add(College("复杂性科学【四】之成功法则", "a006d1f48f34f38613fdfddb7bbff237"))


        list?.add(College("科学精神【一】科学精神的起源", "4cb9586d1f5fe4c94084ad03296c6f58"))
        list?.add(College("科学精神【二】近代科学革命", "4f505a23fe4971be8f3e21239b014d84"))
        list?.add(College("科学精神【三】科学与艺术", "c317bbd44ba9a182fe83f4bd6d79fdfa"))


        list?.add(College("批判性思维【一】两副眼镜", "57f48bfde04826530b209f07437e6ca5"))
        list?.add(College("批判性思维【二】思维遮蔽性", "fa9ae38c51e2d133fd9a691a6cefb9ef"))
        list?.add(College("批判性思维【三】批判性思维", "19d8732222ecef3d868ed589c216c812"))
        list?.add(College("批判性思维【四】给思想洗澡", "668ef176eff1fd19fc6722a70c76b512"))
        list?.add(College("批判性思维【五】贝索斯的思维模型", "e91892c6bac3c6a5cea4993c35683a72"))

        list?.add(College("人文社会学【一】人文社会学导论", "428ab000b768e9bd1bb7922c7a8e5701"))
        list?.add(College(" 人文社会学【二】宗教的凝视", "f0e0f784086abbeafee18b6cb4e5c2cc"))
        list?.add(College("人文社会学【三】哲学的凝视", "5d74662c9fc506c9baf9aa6fc585acb5"))
        list?.add(College("人文社会学【四】历史的凝视", "c3311ba8ab9a5f28692989b15cabc094"))
        list?.add(College("人文社会学【五】美学的凝视", "798884720dbcdd4a7457df826740fe30"))


        list?.add(College("第一性原理【一】第一性原理", "0bb970ae391120f5840a004244993e82"))
        list?.add(College("第一性原理【二】非连续性", "19e0f2932c265793462db6d9cc298e79"))

        list?.add(College("我的第一性原理」分享课", "44b946ffcc6247f3a39bc194790401da"))
        list?.add(College("第一性原理【三】非连续窘境", "946440a85ec12db1e6cb21ab7fbf343c"))
        list?.add(College("第一性原理【四】非连续增长", "87819e9a41674673c9e990d862714ba2"))


        list?.add(College("AI思维【一】智能模型", "3f602a3e1d6e3d6f6cff677fddf0cb7c"))
        list?.add(College("AI思维【二】机器学习", "73b0c204c3271f127ad58746ef438a54"))
        list?.add(College("AI思维【三】AI工程", "6aace088f466767f718e2634afffc139"))
        list?.add(College("AI思维【四】人机协作", "5368a330c895bf46ca5ffcb848023b74"))
        list?.add(College("第二曲线【一】颠覆式创新", "3e7448413b80bfc7d5b69be8edee4009"))
        list?.add(College("第二曲线【二】创业方法论", "a651e4aa30af04d9c25633f1ae68907a"))
        list?.add(College("第二曲线【三】价值网", "f76c4cd38e7c1f05323c3c256b938b18"))
        list?.add(College("第二曲线【四】组织心智", "d995c33b5406ccf34e9e771c27faa454"))
        list?.add(College("第二曲线【五】第二曲线式增长", "1c0a54ad47b1b1da87a5fed46b91a3fe"))
        list?.add(College("认知心理学【一】快思慢想", "443a6454b1ebb4a91ef887dc3c82e2b8"))
        list?.add(College("认知心理学【二】认知神经科学", "f14a8d668c2aae2b3aae6959ca5a1212"))
        list?.add(College("认知心理学【三】情绪与决策", "0696b5a1d739de55c0e7ed3b79b84f6b"))
        list?.add(College("认知心理学【四】男女之别", "7e1ea81e52d74cc30bef7acce40c2f6a"))
        list?.add(College("生物学思维【一】生命思维", "c610706519626daefe00d53372ab1027"))
        list?.add(College("生物学思维【二】演化思维", "7a6c407d063c54b500ccdb9b91c51a13"))
        list?.add(College("生物学思维【三】生态与人", "7855a02b0c554b090d9339b4513228cb"))
        list?.add(College("美学思维【一】极端法则", "91f1088095940e2052351978f118c66e"))
        list?.add(College("美学思维【二】对立法则", "20a79fd05e950d158f18186ea5401c45"))
        list?.add(College("美学思维【三】比照法则", "99a18bcc3835d0648ecbcf18e7c887cc"))
        list?.add(College("美学思维【四】自否法则", "15b8023a697fdb4f68252147a2438e6e"))



        list?.add(College("  物理学【一】古典宇宙观", "5c27ae26847f096a41f5f8db5e3ae487"))
        list?.add(College("物理学【二】牛顿机械论", "13a3d77b9e3d1b17a7930e3f9a4d9764"))
        list?.add(College("物理学【三】能量守恒与熵增", "b2b200e4318b3ad1a85e7286276c8e3c"))
        list?.add(College("  物理学【四】量子力学", "194ce249762e400b413d49ef1fa5cb69"))





        mAdapter.mData.addAll(list!!)
        mAdapter.notifyDataSetChanged()
    }
}
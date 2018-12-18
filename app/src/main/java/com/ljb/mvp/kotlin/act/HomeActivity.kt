package com.ljb.mvp.kotlin.act

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.widget.RelativeLayout
import android.widget.Toast
import com.githang.statusbar.StatusBarCompat
import com.ljb.mvp.kotlin.R
import com.ljb.mvp.kotlin.domain.TabBean
import com.ljb.mvp.kotlin.fragment.home.FollowingFragment
import com.ljb.mvp.kotlin.fragment.home.MyFragment
import com.ljb.mvp.kotlin.fragment.home.RepositoriesFragment
import com.ljb.mvp.kotlin.adapter.MainTabAdapter
import com.ljb.mvp.kotlin.fragment.home.CollegeFragment
import com.ljb.mvp.kotlin.utils.DeviceInfo
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by L on 2017/7/14.
 */
class HomeActivity : FragmentActivity() {

    private var mFirstDownBack: Long = 0L
    private var mCurIndex: Int = 0

    private val mFragments = listOf<Fragment>(
            CollegeFragment(),
            RepositoriesFragment(),
            FollowingFragment(),
            MyFragment())

    private val mTabList = listOf(
            TabBean(R.drawable.bottom_tab_home, R.string.college_tab),
            TabBean(R.drawable.bottom_tab_repos, R.string.repos),
            TabBean(R.drawable.bottom_tab_following, R.string.following),
            TabBean(R.drawable.bottom_tab_my, R.string.my))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let { supportFragmentManager.popBackStackImmediate(null, 1) }
        setContentView(R.layout.activity_home)
        StatusBarCompat.setStatusBarColor(this, resources.getColor(R.color.colorWhite))
        StatusBarCompat.setTranslucent(window, true)
        initView(savedInstanceState)
        val layoutParamsRela = fl_content.layoutParams as RelativeLayout.LayoutParams
        layoutParamsRela.setMargins(0,DeviceInfo.getStatusHeight(this),0,0)
        fl_content.layoutParams = layoutParamsRela
    }

    private fun initView(savedInstanceState: Bundle?) {
        tgv_group.setOnItemClickListener { openTabFragment(it) }
        tgv_group.setAdapter(MainTabAdapter(this, mTabList))
        openTabFragment(savedInstanceState?.getInt("index") ?: 0)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("index", mCurIndex)
    }

    private fun openTabFragment(position: Int) {
        tgv_group.setSelectedPosition(position)
        val ft = supportFragmentManager.beginTransaction()
        ft.hide(mFragments[mCurIndex])
        var f = supportFragmentManager.findFragmentByTag(mFragments[position].javaClass.simpleName)
        if (f == null) {
            f = mFragments[position]
            ft.add(R.id.fl_content, f, f.javaClass.simpleName)
        }
        ft.show(f).commit()
        mCurIndex = position
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - mFirstDownBack > 2000) {
            Toast.makeText(this, R.string.exit_go_out, Toast.LENGTH_SHORT).show()
            mFirstDownBack = System.currentTimeMillis()
            return
        }
        super.onBackPressed()
    }
}
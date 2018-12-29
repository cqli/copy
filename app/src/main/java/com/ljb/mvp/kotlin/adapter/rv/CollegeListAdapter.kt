package com.ljb.mvp.kotlin.adapter.rv

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ljb.mvp.kotlin.R
import com.ljb.mvp.kotlin.domain.College
import com.ljb.mvp.kotlin.domain.Follower
import com.ljb.mvp.kotlin.img.ImageLoader
import com.ljb.mvp.kotlin.utils.CustomURLSpan
import com.ljb.mvp.kotlin.widget.findViewByIdEx
import com.ljb.mvp.kotlin.widget.loadmore.LoadMoreRecyclerAdapter
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

/**
 * Created by L on 2017/7/19.
 */
class CollegeListAdapter(mContext: Context, mData: MutableList<College>) : LoadMoreRecyclerAdapter<College>(mContext, mData) {


    override fun getItemHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder =
            FollowersViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_college_list, parent, false))

    @SuppressLint("SetTextI18n")
    override fun onBindData(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FollowersViewHolder) {
            val item = mData[position]
            holder.tv_follower_name.text = item.name
            holder. tv_url.text = "https://www.hundun.cn/course_video/detail?course_id=${item.courseId}&backplay=1"
            CustomURLSpan.setURLSpan(0, holder.tv_url)
        }
    }


    class FollowersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_follower_name by lazy { itemView.findViewByIdEx<TextView>(R.id.tv_follower_name) }
        val tv_url by lazy { itemView.findViewByIdEx<TextView>(R.id.tv_url) }


    }

}
package com.myhome.siviewpager

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class SIViewPager(context: Context, attr:AttributeSet):LinearLayout(context, attr){
    lateinit var viewPager:ViewPager
    lateinit var pagerAdapter:PagerAdapter
    lateinit var animationIndicator: AnimationIndicator
    val attr = attr
    var defaultImageId:Int = 0
    var selectImageId:Int = 0
    var margin = 10


    fun init(pagerAdapter: SIPagerAdapter, defaultImageId:Int, selectImageId:Int){
        this.pagerAdapter = pagerAdapter
        this.defaultImageId = defaultImageId
        this.selectImageId = selectImageId
        viewPager = ViewPager(context)
        viewPager.adapter = pagerAdapter
        animationIndicator = AnimationIndicator(context)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
        params.weight = 1F
        params.topMargin = margin
        params.bottomMargin = margin
        params.leftMargin = margin
        params.rightMargin = margin
        params.gravity = Gravity.CENTER
        animationIndicator.init(pagerAdapter, defaultImageId, selectImageId)
        viewPager.layoutParams = params
        val params2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params2.gravity = Gravity.CENTER
        animationIndicator.layoutParams = params2
        addView(viewPager)
        addView(animationIndicator)
        setViewPagerController()
    }

    fun setViewPagerController(){
        viewPager.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                viewPager.findViewWithTag<View>(position).isSelected = true
                animationIndicator.selectImage(position)
            }
        })
    }
}
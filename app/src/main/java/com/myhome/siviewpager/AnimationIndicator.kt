package com.myhome.siviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout

class AnimationIndicator(context:Context):LinearLayout(context){
    var margin = 10
    var duration = 250
    lateinit var pagerAdapter:SIPagerAdapter
    lateinit var imageList:ArrayList<ImageView>
    val siPagerListener = object : SIPagerListener {
        override fun itemAdd() {
            addItem()
        }

        override fun itemRemovedAt(position:Int) {
            removeAt(position)
        }

        override fun clear() {

        }
    }

    fun init(size:Int){
        for(i in  0..size-1){
            addItem()
        }
        selectImage(0)
    }

    fun init(adapter:SIPagerAdapter){
        this.pagerAdapter = adapter
        adapter.siPagerListener = siPagerListener
        imageList = ArrayList()
        init(adapter.count)
    }

    fun clear(){
        removeAllViews()
        imageList.clear()
    }

    fun addItem(){
        val myImageView = ImageView(context)
        imageList.add(myImageView)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.topMargin = margin
        params.bottomMargin = margin
        params.leftMargin = margin
        params.rightMargin = margin
        params.gravity = Gravity.CENTER

        myImageView.layoutParams = params
        myImageView.setImageResource(R.drawable.ic_brightness_gray_12dp)
        myImageView.setTag(myImageView.id, false)
        addView(myImageView)
    }

    fun removeAt(position:Int){
        val item = imageList.removeAt(position)
        removeView(item)
        notifyDatasetChangedByPosition(position)
    }

    fun notifyDatasetChangedByPosition(position:Int){
        if(position == 0) {
            selectImage(0)
        }
        else {
            selectImage(position-1)
        }
    }

    fun selectImage(position:Int){
        for(i in 0..imageList.size - 1){
            if(i == position){
                imageList[i].setImageResource(R.drawable.ic_brightness_primary_12dp)
                selectScalAnim(imageList[i], 1f, 1.2f)
            }else{
                if(imageList[i].getTag(imageList[i].id) == true){
                    imageList[i].setImageResource(R.drawable.ic_brightness_gray_12dp)
                    defaultScaleAnim(imageList[i], 1.2f, 1f)
                }
            }
        }
    }

    fun selectScalAnim(view: View, startScale:Float, endScale:Float){
        val anim = ScaleAnimation(startScale, endScale, startScale, endScale, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        anim.fillAfter = true
        anim.duration = duration.toLong()
        view.startAnimation(anim)
        view.setTag(view.id, true)
    }

    fun defaultScaleAnim(view: View, startScale: Float, endScale: Float){
        val anim = ScaleAnimation(startScale, endScale, startScale, endScale, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        anim.fillAfter = true
        anim.duration = duration.toLong()
        view.startAnimation(anim)
        view.setTag(view.id, false)
    }

}
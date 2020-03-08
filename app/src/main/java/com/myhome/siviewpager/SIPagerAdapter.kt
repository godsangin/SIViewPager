package com.myhome.siviewpager

import android.view.View
import androidx.viewpager.widget.PagerAdapter

open class SIPagerAdapter : PagerAdapter() {
    open var items:ArrayList<Any>? = ArrayList()
    var siPagerListener:SIPagerListener? = null

    fun addItem(item:Any){
        items?.add(item)
        notifyDataSetChanged()
        siPagerListener?.itemAdd()
    }

    fun removeAt(position:Int){
        items?.removeAt(position)
        notifyDataSetChanged()
        siPagerListener?.itemRemovedAt(position)
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object` as View)
    }

    override fun getCount(): Int {
        if(items == null){
            return 0
        }
        else{
            return items?.size!!
        }
    }

}
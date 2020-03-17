package com.myhome.siviewpager

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

open class SIPagerAdapter : PagerAdapter() {
    open var items:ArrayList<Any> = ArrayList()
    var siPagerListener:SIPagerListener? = null

    fun addItem(item:Any){
        items.add(item)
        notifyDataSetChanged()
        siPagerListener?.itemAdd()
    }

    fun removeAt(position:Int){
        items.removeAt(position)
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

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}
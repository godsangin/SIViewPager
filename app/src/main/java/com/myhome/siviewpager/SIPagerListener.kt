package com.myhome.siviewpager

interface SIPagerListener {
    fun itemAdd()
    fun itemRemovedAt(position:Int)
    fun clear()
}
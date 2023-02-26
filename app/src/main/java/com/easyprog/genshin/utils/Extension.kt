package com.easyprog.genshin.utils

import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import java.util.*

const val DELAY_SECONDS = 2500L

fun <T> ImageView.load(image: T) {
    Glide.with(this).load(image).fitCenter().centerCrop().into(this)
}

fun ViewPager2.enableAutoScroll(totalPages: Int): Timer {
    val autoTimerTask = Timer()
    var currentPageIndex = 0
    autoTimerTask.schedule(object : TimerTask() {
        override fun run() {
            if (currentPageIndex == totalPages) currentPageIndex = 0
            this@enableAutoScroll.setCurrentItem(currentPageIndex++, true)
        }
    }, DELAY_SECONDS, DELAY_SECONDS)

    return autoTimerTask
}
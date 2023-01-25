package com.easyprog.genshin.utils

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

fun <T> ImageView.load(image: T) {
    Glide.with(this).load(image).fitCenter().centerCrop().into(this)
}

//fun <T, L> RecyclerView.clickItem(block: (element: T) -> Unit) { object : L
//
//}
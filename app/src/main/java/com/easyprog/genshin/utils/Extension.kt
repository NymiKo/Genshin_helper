package com.easyprog.genshin.utils

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.easyprog.genshin.adapters.BaseListener
import com.easyprog.genshin.adapters.heroes.HeroesActionListener

fun <T> ImageView.load(image: T) {
    Glide.with(this).load(image).fitCenter().centerCrop().into(this)
}
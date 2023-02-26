package com.easyprog.genshin.fragments.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyprog.genshin.R
import kotlin.random.Random
import kotlin.random.nextInt

class MainViewModel : ViewModel() {
    private val _numberImageEmblem = MutableLiveData<Int>()
    val numberImageEmblem: LiveData<Int> = _numberImageEmblem

    private val _bannerList = MutableLiveData<List<Int>>()
    val bannerList: LiveData<List<Int>> = _bannerList

    init {
        getBannerList()
    }

    fun changeNumberEmblem() {
        _numberImageEmblem.value = Random.nextInt(0..6)
    }

    fun getBannerList() {
        _bannerList.value = listOf(
            R.drawable.banner_kaveh_baizhy,
            R.drawable.banner_kaveh_baizhy,
            R.drawable.banner_kaveh_baizhy,
            R.drawable.banner_kaveh_baizhy
        )
    }
}
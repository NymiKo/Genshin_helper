package com.easyprog.genshin.fragments.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import kotlin.random.nextInt

class MainViewModel : ViewModel() {
    private val _numberImageEmblem = MutableLiveData<Int>()
    val numberImageEmblem: LiveData<Int> = _numberImageEmblem

    init {
        changeNumberEmblem()
    }

    fun changeNumberEmblem() {
        _numberImageEmblem.value = Random.nextInt(0..6)
    }
}
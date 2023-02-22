package com.easyprog.genshin.fragments.hero_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.easyprog.genshin.model.Hero

abstract class HeroProfileViewModel: ViewModel() {
    abstract val hero: LiveData<Hero>

    abstract fun getHero(id: Int)
}
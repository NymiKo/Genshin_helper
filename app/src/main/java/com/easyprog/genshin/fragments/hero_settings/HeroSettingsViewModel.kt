package com.easyprog.genshin.fragments.hero_settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.easyprog.genshin.model.PriorityHeroes

abstract class HeroSettingsViewModel : ViewModel() {
    abstract val heroSettings: LiveData<PriorityHeroes>

    abstract fun getHeroSettings(idHero: Int)
}
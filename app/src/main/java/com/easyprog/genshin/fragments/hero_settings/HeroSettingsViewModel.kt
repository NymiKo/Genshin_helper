package com.easyprog.genshin.fragments.hero_settings

import androidx.lifecycle.ViewModel

abstract class HeroSettingsViewModel: ViewModel() {
    abstract fun getHeroSettings(idHero: Int)
}
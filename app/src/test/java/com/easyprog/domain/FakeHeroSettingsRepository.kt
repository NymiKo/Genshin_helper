package com.easyprog.domain

import com.easyprog.domain.repositories.HeroSettingsRepository
import com.easyprog.genshin.model.PriorityHeroes

class FakeHeroSettingsRepository : HeroSettingsRepository {

    private var heroSettingsList = emptyList<PriorityHeroes>()

    fun setHeroSettings(heroSettingsList: List<PriorityHeroes>) {
        this.heroSettingsList = heroSettingsList
    }

    override suspend fun getSettingsHeroAsync(idHero: Int): PriorityHeroes {
        return heroSettingsList[idHero]
    }

    override suspend fun insertHeroSetting(priorityHeroes: PriorityHeroes) {

    }
}
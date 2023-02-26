package com.easyprog.domain

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.entities.PriorityHeroesEntity
import com.easyprog.domain.repositories.HeroSettingsRepository
import com.easyprog.genshin.model.PriorityHeroes

class FakeHeroSettingsRepository: HeroSettingsRepository {

    private var heroSettingsList = emptyList<PriorityHeroes>()

    fun setHeroSettings(heroSettingsList: List<PriorityHeroes>) {
        this.heroSettingsList = heroSettingsList
    }

    override fun getSettingsHeroAsync(idHero: Int): LiveData<PriorityHeroesEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertHeroSetting(priorityHeroes: PriorityHeroes) {
        TODO("Not yet implemented")
    }
}
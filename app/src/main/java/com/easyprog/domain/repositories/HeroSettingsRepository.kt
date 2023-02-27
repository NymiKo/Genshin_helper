package com.easyprog.domain.repositories

import com.easyprog.data.storage.entities.PriorityHeroesEntity
import com.easyprog.genshin.model.PriorityHeroes

interface HeroSettingsRepository {

    suspend fun getSettingsHeroAsync(idHero: Int): PriorityHeroes?
    suspend fun insertHeroSetting(priorityHeroes: PriorityHeroes)

}
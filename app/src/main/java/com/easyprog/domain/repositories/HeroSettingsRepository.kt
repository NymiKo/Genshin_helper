package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.model.PriorityHeroesEntity
import com.easyprog.genshin.model.PriorityHeroes

interface HeroSettingsRepository {

    fun getSettingsHeroAsync(idHero: Int): LiveData<PriorityHeroesEntity>
    suspend fun checkInsertORUpdateSetting(priorityHeroes: PriorityHeroes)

    suspend fun insertSettingsHero(priorityHeroesEntity: PriorityHeroesEntity)
    suspend fun updateSettingsHero(priorityHeroesEntity: PriorityHeroesEntity)

}
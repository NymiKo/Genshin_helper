package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.model.PriorityHeroesEntity

interface HeroSettingsRepository {

    fun getSettingsHeroAsync(idHero: Int): LiveData<PriorityHeroesEntity>
    suspend fun checkInsertORUpdateSetting(
        idPriority: Int,
        elevationPriority: Boolean,
        talentPriority: Boolean,
        artifactPriority: Boolean,
        idHero: Int
    )

    suspend fun insertSettingsHero(priorityHeroesEntity: PriorityHeroesEntity)
    suspend fun updateSettingsHero(priorityHeroesEntity: PriorityHeroesEntity)

}
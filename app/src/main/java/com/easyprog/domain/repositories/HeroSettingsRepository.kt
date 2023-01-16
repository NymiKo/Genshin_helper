package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.model.PriorityHeroesEntity
import kotlinx.coroutines.CoroutineScope

interface HeroSettingsRepository {

    fun getSettingsHeroAsync(idHero: Int): LiveData<PriorityHeroesEntity>
    fun checkInsertORUpdateSetting(idPriority: Int, elevationPriority: Boolean, talentPriority: Boolean, artifactPriority: Boolean, idHero: Int)
    fun insertSettingsHero(priorityHeroesEntity: PriorityHeroesEntity)
    fun updateSettingsHero(priorityHeroesEntity: PriorityHeroesEntity)

}
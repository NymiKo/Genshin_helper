package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.Result
import com.easyprog.data.storage.model.PriorityHeroesEntity

interface HeroSettingsRepository {

    fun getSettingsHeroAsync(idHero: Int): LiveData<PriorityHeroesEntity>
    fun insertSettingsHero(elevationPriority: Boolean, talentPriority: Boolean, artifactPriority: Boolean, idHero: Int)

}
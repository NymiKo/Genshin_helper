package com.easyprog.domain.repositories.implementations

import android.util.Log
import androidx.lifecycle.LiveData
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.domain.repositories.HeroSettingsRepository
import com.easyprog.data.storage.model.PriorityHeroesEntity
import kotlinx.coroutines.*
import javax.inject.Inject

class HeroSettingsRepositoryImpl @Inject constructor(val localDataSource: RoomDatabaseApp) : HeroSettingsRepository {

    override fun getSettingsHeroAsync(idHero: Int): LiveData<PriorityHeroesEntity> {
        return localDataSource.priorityHeroesDao().getPriorityHero(idHero)
    }

    override fun checkInsertORUpdateSetting(
        idPriority: Int,
        elevationPriority: Boolean,
        talentPriority: Boolean,
        artifactPriority: Boolean,
        idHero: Int
    ) {
        val priorityHeroEntity = PriorityHeroesEntity(
            idPriority = idPriority,
            elevationPriority = elevationPriority,
            talentPriority = talentPriority,
            artifactPriority = artifactPriority,
            idHero = idHero
        )
        if (localDataSource.priorityHeroesDao().getPriorityHero(idHero).value != null) {
            updateSettingsHero(priorityHeroEntity)
        } else {
            insertSettingsHero(priorityHeroEntity)
        }
    }

    override fun insertSettingsHero(
        priorityHeroesEntity: PriorityHeroesEntity
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.priorityHeroesDao().insertPriorityHero(priorityHeroesEntity = priorityHeroesEntity)
        }
    }

    override fun updateSettingsHero(
        priorityHeroesEntity: PriorityHeroesEntity
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.priorityHeroesDao().updatePriorityHero(priorityHeroesEntity = priorityHeroesEntity)
        }
    }


}
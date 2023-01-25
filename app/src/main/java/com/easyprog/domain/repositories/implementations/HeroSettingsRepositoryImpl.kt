package com.easyprog.domain.repositories.implementations

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.model.PriorityHeroesEntity
import com.easyprog.domain.repositories.HeroSettingsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeroSettingsRepositoryImpl @Inject constructor(
    private val localDataSource: RoomDatabaseApp
) : HeroSettingsRepository {

    override fun getSettingsHeroAsync(idHero: Int): LiveData<PriorityHeroesEntity> {
        return localDataSource.priorityHeroesDao().getPriorityHeroLiveData(idHero)
    }

    override suspend fun checkInsertORUpdateSetting(
        idPriority: Int,
        elevationPriority: Boolean,
        talentPriority: Boolean,
        artifactPriority: Boolean,
        idHero: Int
    ) {
        val priorityHeroEntity = PriorityHeroesEntity(
            id = idPriority,
            elevationPriority = elevationPriority,
            talentPriority = talentPriority,
            artifactPriority = artifactPriority,
            heroId = idHero
        )
        localDataSource.priorityHeroesDao().insertPriorityHero(priorityHeroesEntity = priorityHeroEntity)
    }

    override suspend fun insertSettingsHero(
        priorityHeroesEntity: PriorityHeroesEntity
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.priorityHeroesDao()
                .insertPriorityHero(priorityHeroesEntity = priorityHeroesEntity)
        }
    }

    override suspend fun updateSettingsHero(
        priorityHeroesEntity: PriorityHeroesEntity
    ) {
        localDataSource.priorityHeroesDao()
            .updatePriorityHero(priorityHeroesEntity = priorityHeroesEntity)
    }
}
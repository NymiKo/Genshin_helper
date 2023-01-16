package com.easyprog.domain.repositories.implementations

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.model.PriorityHeroesEntity
import com.easyprog.domain.repositories.HeroSettingsRepository
import com.easyprog.genshin.DispatchersList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeroSettingsRepositoryImpl @Inject constructor(
    private val localDataSource: RoomDatabaseApp,
    private val dispatchersList: DispatchersList
) : HeroSettingsRepository {

    override fun getSettingsHeroAsync(idHero: Int): LiveData<PriorityHeroesEntity> {
        return localDataSource.priorityHeroesDao().getPriorityHeroLiveData(idHero)
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
        insertSettingsHero(priorityHeroEntity)
    }

    override fun insertSettingsHero(
        priorityHeroesEntity: PriorityHeroesEntity
    ) {
        CoroutineScope(dispatchersList.io()).launch {
            localDataSource.priorityHeroesDao()
                .insertPriorityHero(priorityHeroesEntity = priorityHeroesEntity)
        }
    }

    override fun updateSettingsHero(
        priorityHeroesEntity: PriorityHeroesEntity
    ) {
        CoroutineScope(dispatchersList.io()).launch {
            localDataSource.priorityHeroesDao()
                .updatePriorityHero(priorityHeroesEntity = priorityHeroesEntity)
        }
    }
}
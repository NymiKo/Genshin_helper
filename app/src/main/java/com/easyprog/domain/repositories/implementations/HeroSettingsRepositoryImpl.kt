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

    override fun insertSettingsHero(
        elevationPriority: Boolean,
        talentPriority: Boolean,
        artifactPriority: Boolean,
        idHero: Int
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val priorityHero = PriorityHeroesEntity(
                elevationPriority = elevationPriority,
                talentPriority = talentPriority,
                artifactPriority = artifactPriority,
                idHero = idHero
            )
            Log.e("CHECK_INSERT", priorityHero.toString())
            localDataSource.priorityHeroesDao().insertPriorityHero(priorityHeroesEntity = priorityHero)
        }
    }


}
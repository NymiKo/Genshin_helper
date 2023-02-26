package com.easyprog.domain.repositories.implementations

import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.entities.PriorityHeroesEntity
import com.easyprog.domain.repositories.HeroSettingsRepository
import com.easyprog.genshin.model.PriorityHeroes
import javax.inject.Inject

class HeroSettingsRepositoryImpl @Inject constructor(
    private val localDataSource: RoomDatabaseApp
) : HeroSettingsRepository {

    override suspend fun getSettingsHeroAsync(idHero: Int): PriorityHeroesEntity {
        return localDataSource.priorityHeroesDao().getPriorityHero(idHero)
    }

    override suspend fun insertHeroSetting(priorityHeroes: PriorityHeroes) {
        val priorityHeroEntity = PriorityHeroesEntity.toPriorityHeroesEntity(priorityHeroes)
        localDataSource.priorityHeroesDao()
            .insertPriorityHero(priorityHeroesEntity = priorityHeroEntity)
    }
}
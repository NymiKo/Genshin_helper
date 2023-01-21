package com.easyprog.domain.repositories.implementations

import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.domain.repositories.GoalsRepository
import javax.inject.Inject

class GoalsRepositoryImpl @Inject constructor(private val localDataSource: RoomDatabaseApp) : GoalsRepository {
    override suspend fun getPriorityWithHeroesList(): List<PriorityWithHero> {
        return localDataSource.priorityHeroesDao().getPriorityHeroWithHeroes()
    }
}
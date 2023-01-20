package com.easyprog.domain.repositories.implementations

import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.HeroesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(
    private val localDataSource: RoomDatabaseApp
) : HeroesRepository {

    override suspend fun getHeroes(): List<HeroesEntity> {
        return localDataSource.heroesDao().getHeroes()
    }
}
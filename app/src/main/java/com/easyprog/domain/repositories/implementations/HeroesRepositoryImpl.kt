package com.easyprog.domain.repositories.implementations

import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.domain.repositories.HeroesRepository
import com.easyprog.genshin.model.Hero
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(
    private val localDataSource: RoomDatabaseApp
) : HeroesRepository {

    override suspend fun getHeroes(): List<Hero> {
        return localDataSource.heroesDao().getHeroes().map { it.toHeroes() }
    }
}
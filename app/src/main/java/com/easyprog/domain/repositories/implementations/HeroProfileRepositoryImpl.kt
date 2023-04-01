package com.easyprog.domain.repositories.implementations

import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.domain.repositories.HeroProfileRepository
import com.easyprog.genshin.model.Hero
import javax.inject.Inject

class HeroProfileRepositoryImpl @Inject constructor(private val localDataSource: RoomDatabaseApp) :
    HeroProfileRepository {

    override suspend fun getHero(id: Int): Hero {
        return localDataSource.heroesDao().getHero(id).toHeroes()
    }
}
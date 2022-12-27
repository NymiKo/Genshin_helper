package com.easyprog.domain.repositories.implementations

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.HeroesRepository
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(val localDataSource: RoomDatabaseApp): HeroesRepository {

    override fun getHeroes(): LiveData<List<HeroesEntity>> {
        return localDataSource.heroesDao().getHeroes()
    }
}
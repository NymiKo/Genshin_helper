package com.easyprog.domain.repositories.implementations

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.HeroProfileRepository
import javax.inject.Inject

class HeroProfileRepositoryImpl @Inject constructor(private val localDataSource: RoomDatabaseApp): HeroProfileRepository {

    override fun getHero(id: Int): LiveData<HeroesEntity> {
        return localDataSource.heroesDao().getHero(id)
    }

}
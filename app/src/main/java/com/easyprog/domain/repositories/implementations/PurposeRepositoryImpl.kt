package com.easyprog.domain.repositories.implementations

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.domain.repositories.PurposeRepository

class PurposeRepositoryImpl(val localDataSource: RoomDatabaseApp) : PurposeRepository {

    override fun getPriorityWithHeroesList(): LiveData<List<PriorityWithHero>> {
        return localDataSource.priorityHeroesDao().getPriorityHeroWithHeroes()
    }
}
package com.easyprog.domain.repositories.implementations

import android.util.Log
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.MainActivityRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityRepositoryImpl @Inject constructor(val localDataSource: RoomDatabaseApp): MainActivityRepository {

    override fun insertHeroesList(heroesList: List<HeroesEntity>) {
        Log.e("CHECK", heroesList.toString())
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.heroesDao().insertHeroes(heroesList)
        }
    }
}
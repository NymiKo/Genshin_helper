package com.easyprog.domain.repositories.implementations

import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.data.storage.model.WeaponsEntity
import com.easyprog.domain.repositories.MainActivityRepository
import com.easyprog.genshin.DispatchersList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityRepositoryImpl @Inject constructor(
    private val localDataSource: RoomDatabaseApp,
    private val dispatchersList: DispatchersList
) : MainActivityRepository {

    override fun insertHeroesList(heroesList: List<HeroesEntity>) {
        CoroutineScope(dispatchersList.io()).launch {
            localDataSource.heroesDao().insertHeroes(heroesList)
        }
    }

    override fun insertWeaponsList(weaponsList: List<WeaponsEntity>) {
        CoroutineScope(dispatchersList.io()).launch {
            localDataSource.weaponsDao().insertWeapon(weaponsList)
        }
    }
}
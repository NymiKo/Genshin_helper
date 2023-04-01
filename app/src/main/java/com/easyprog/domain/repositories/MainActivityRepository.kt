package com.easyprog.domain.repositories

import com.easyprog.data.storage.entities.BuildsHeroesWeaponsEntity
import com.easyprog.data.storage.entities.HeroesEntity
import com.easyprog.data.storage.entities.WeaponsEntity

interface MainActivityRepository {

    fun insertHeroesList(heroesList: List<HeroesEntity>)
    fun insertWeaponsList(weaponsList: List<WeaponsEntity>)
    suspend fun insertBuildsHeroesWeaponsList(weaponsList: List<BuildsHeroesWeaponsEntity>)

}
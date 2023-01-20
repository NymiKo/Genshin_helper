package com.easyprog.domain.repositories

import com.easyprog.data.storage.model.BuildsHeroesWeaponsEntity
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.data.storage.model.WeaponsEntity

interface MainActivityRepository {

    fun insertHeroesList(heroesList: List<HeroesEntity>)
    fun insertWeaponsList(weaponsList: List<WeaponsEntity>)
    fun insertBuildsHeroesWeaponsList(weaponsList: List<BuildsHeroesWeaponsEntity>)

}
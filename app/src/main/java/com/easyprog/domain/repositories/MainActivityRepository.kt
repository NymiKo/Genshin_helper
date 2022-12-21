package com.easyprog.domain.repositories

import com.easyprog.data.storage.model.HeroesEntity

interface MainActivityRepository {

    fun insertHeroesList(heroesList: List<HeroesEntity>)

}
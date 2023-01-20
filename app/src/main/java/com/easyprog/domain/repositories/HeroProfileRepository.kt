package com.easyprog.domain.repositories

import com.easyprog.data.storage.model.HeroesEntity

interface HeroProfileRepository {

    suspend fun getHero(id: Int): HeroesEntity

}
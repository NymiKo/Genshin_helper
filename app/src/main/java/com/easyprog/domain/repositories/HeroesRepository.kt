package com.easyprog.domain.repositories

import com.easyprog.genshin.model.Heroes

interface HeroesRepository {

    suspend fun getHeroes(): List<Heroes>

}
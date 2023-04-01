package com.easyprog.domain.repositories

import com.easyprog.genshin.model.Hero

interface HeroesRepository {

    suspend fun getHeroes(): List<Hero>

}
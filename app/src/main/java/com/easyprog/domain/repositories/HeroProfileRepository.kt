package com.easyprog.domain.repositories

import com.easyprog.genshin.model.Hero

interface HeroProfileRepository {

    suspend fun getHero(id: Int): Hero

}
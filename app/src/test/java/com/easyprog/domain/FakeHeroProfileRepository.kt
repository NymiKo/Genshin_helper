package com.easyprog.domain

import com.easyprog.domain.repositories.HeroProfileRepository
import com.easyprog.genshin.model.Hero

class FakeHeroProfileRepository : HeroProfileRepository {

    private lateinit var hero: Hero

    fun setHero(hero: Hero) {
        this.hero = hero
    }

    override suspend fun getHero(id: Int): Hero {
        return hero
    }
}
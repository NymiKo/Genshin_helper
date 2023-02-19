package com.easyprog.domain

import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.HeroesRepository
import com.easyprog.genshin.model.Heroes

class FakeRepositoryHeroes : HeroesRepository {

    private var heroesList = emptyList<HeroesEntity>()

    fun setHeroes(heroes: List<HeroesEntity>) {
        heroesList = heroes
    }

    override suspend fun getHeroes(): List<Heroes> = heroesList.map { it.toHeroes() }
}
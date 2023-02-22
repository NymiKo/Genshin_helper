package com.easyprog.domain

import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.domain.repositories.GoalsRepository

class FakeGoalsRepository: GoalsRepository {

    private var priorityHeroesList = emptyList<PriorityWithHero>()

    fun setPriorityWithHeroesList(priorityWithHeroes: List<PriorityWithHero>) {
        priorityHeroesList = priorityWithHeroes
    }

    override suspend fun getPriorityWithHeroesList(): List<PriorityWithHero> = priorityHeroesList
}
package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.entities.PriorityHeroesEntity
import kotlin.random.Random

class PriorityHeroesDaoTestHelper {

    fun createRandomListOfPriorityHeroes(
        count: Int,
        randomPriorityFlag: Boolean = true
    ): List<PriorityHeroesEntity> {
        val priorityHeroes = mutableListOf<PriorityHeroesEntity>()
        val randomPriority = Random.nextBoolean()

        for (i in 1..count) {
            priorityHeroes.add(
                PriorityHeroesEntity(
                    i,
                    if (randomPriorityFlag) randomPriority else true,
                    if (randomPriorityFlag) randomPriority else true,
                    if (randomPriorityFlag) randomPriority else true
                )
            )
        }
        return priorityHeroes
    }

}
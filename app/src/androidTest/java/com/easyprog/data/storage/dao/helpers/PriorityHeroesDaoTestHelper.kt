package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.model.PriorityHeroesEntity
import kotlin.random.Random

class PriorityHeroesDaoTestHelper {

    fun createRandomListOfPriorityHeroes(
        count: Int,
        randomPriorityFlag: Boolean
    ): List<PriorityHeroesEntity> {
        val priorityHeroes = mutableListOf<PriorityHeroesEntity>()
        val randomPriority = Random.nextBoolean()

        for (i in 1..count) {
            priorityHeroes.add(
                PriorityHeroesEntity(
                    i,
                    randomPriority,
                    if (randomPriorityFlag) randomPriority else true,
                    randomPriority,
                    i
                )
            )
        }
        return priorityHeroes
    }

}
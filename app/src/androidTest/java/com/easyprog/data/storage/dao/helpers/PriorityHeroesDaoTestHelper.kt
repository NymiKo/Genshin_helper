package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.model.MaterialWeaponsEntity
import com.easyprog.data.storage.model.PriorityHeroesEntity
import kotlin.random.Random

class PriorityHeroesDaoTestHelper {

    fun createRandomListOfPriorityHeroes(
        count: Int
    ): List<PriorityHeroesEntity> {
        val priorityHeroes = mutableListOf<PriorityHeroesEntity>()
        val randomNumber = Random.nextInt(1, 100)
        val randomPriority = Random.nextBoolean()

        for (i in 1..count) {
            priorityHeroes.add(
                PriorityHeroesEntity(
                    i,
                    randomPriority,
                    randomPriority,
                    randomPriority,
                    i
                )
            )
        }
        return priorityHeroes
    }

}
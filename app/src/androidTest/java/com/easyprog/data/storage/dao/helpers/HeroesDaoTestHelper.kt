package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.entities.HeroesEntity
import kotlin.random.Random

class HeroesDaoTestHelper {

    fun createRandomListOfHeroes(
        count: Int
    ): List<HeroesEntity> {
        val heroesList = mutableListOf<HeroesEntity>()
        val randomNumber = Random.nextInt(1, 100)
        val randomTalentId = Random.nextInt(1, 10)

        for (i in 1..count) {
            heroesList.add(
                HeroesEntity(
                    i,
                    "Имя героя $randomNumber",
                    randomNumber,
                    "Дата рождения: $randomNumber",
                    "Элемент $randomNumber",
                    "Регион: $randomNumber",
                    randomTalentId
                )
            )
        }
        return heroesList
    }

}
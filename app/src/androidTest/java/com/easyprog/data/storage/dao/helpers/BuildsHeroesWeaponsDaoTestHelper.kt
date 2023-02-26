package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.entities.BuildsHeroesWeaponsEntity
import kotlin.random.Random

class BuildsHeroesWeaponsDaoTestHelper {

    fun createRandomListOfBuildsHeroesWeapons(
        count: Int,
        randomIdHero: Boolean
    ): List<BuildsHeroesWeaponsEntity> {
        val buildsHeroesWeapons = mutableListOf<BuildsHeroesWeaponsEntity>()
        val randomNumber = Random.nextInt(1, 100)

        for (i in 1..count) {
            buildsHeroesWeapons.add(
                BuildsHeroesWeaponsEntity(
                    i,
                    "Описание$randomNumber",
                    if (randomIdHero) i else 1,
                    i
                )
            )
        }
        return buildsHeroesWeapons
    }

}
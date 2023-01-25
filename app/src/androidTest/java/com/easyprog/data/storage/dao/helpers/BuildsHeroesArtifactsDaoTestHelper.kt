package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.model.BuildsHeroesArtifactsEntity
import kotlin.random.Random

class BuildsHeroesArtifactsDaoTestHelper {

    fun createRandomListOfBuildsHeroesArtifacts(count: Int, randomIdHero: Boolean): List<BuildsHeroesArtifactsEntity> {
        val buildsHeroesArtifacts = mutableListOf<BuildsHeroesArtifactsEntity>()
        val randomNumber = Random.nextInt(1, 100)

        for (i in 1..count) {
            buildsHeroesArtifacts.add(
                BuildsHeroesArtifactsEntity(
                    id = i,
                    flower = i,
                    statFlower = "$randomNumber",
                    stylus = i,
                    statStylus = "$randomNumber",
                    watch = i,
                    statWatch = "$randomNumber",
                    cup = i,
                    statCup = "$randomNumber",
                    cap = i,
                    statCap = "$randomNumber",
                    heroId = if (randomIdHero) i else 1
                )
            )
        }

        return buildsHeroesArtifacts
    }
}
package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.entities.BuildsHeroesArtifactsEntity
import kotlin.random.Random

class BuildsHeroesArtifactsDaoTestHelper {

    fun createRandomListOfBuildsHeroesArtifacts(count: Int): List<BuildsHeroesArtifactsEntity> {
        val buildsHeroesArtifacts = mutableListOf<BuildsHeroesArtifactsEntity>()
        val randomNumber = Random.nextInt(1, 100)
        val randomHeroId = Random.nextInt(1, 10)

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
                    heroId = randomHeroId
                )
            )
        }

        return buildsHeroesArtifacts
    }
}
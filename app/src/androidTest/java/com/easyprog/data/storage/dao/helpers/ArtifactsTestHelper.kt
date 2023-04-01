package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.entities.ArtifactsEntity
import kotlin.random.Random

class ArtifactsTestHelper {

    fun createRandomListOfArtifacts(count: Int): List<ArtifactsEntity> {
        val listArtifacts = mutableListOf<ArtifactsEntity>()
        val randomNumber = Random.nextInt(1, 100)
        for (i in 1..count) {
            listArtifacts.add(
                ArtifactsEntity(
                    i,
                    "Название сета$randomNumber",
                    "Цветок$randomNumber",
                    randomNumber,
                    "Перо$randomNumber",
                    randomNumber,
                    "Часы$randomNumber",
                    randomNumber,
                    "Кубок$randomNumber",
                    randomNumber,
                    "Шапка$randomNumber",
                    randomNumber
                )
            )
        }
        return listArtifacts
    }
}
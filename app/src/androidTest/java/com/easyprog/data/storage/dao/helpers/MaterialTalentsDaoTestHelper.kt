package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.model.MaterialTalentsEntity
import kotlin.random.Random

class MaterialTalentsDaoTestHelper {

    fun createRandomListOfMaterialTalents(
        count: Int
    ): List<MaterialTalentsEntity> {
        val materialTalents = mutableListOf<MaterialTalentsEntity>()
        val randomNumber = Random.nextInt(1, 100)

        for (i in 1..count) {
            materialTalents.add(
                MaterialTalentsEntity(
                    i,
                    "Зеленый материал $randomNumber",
                    i,
                    "Синий материал $randomNumber",
                    i,
                    "Фиолетовый материал $randomNumber",
                    i,
                    "Описание $randomNumber",
                    i
                )
            )
        }
        return materialTalents
    }

}
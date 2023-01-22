package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.model.MaterialWeaponsEntity
import kotlin.random.Random

class MaterialWeaponsDaoTestHelper {

    fun createRandomListOfMaterialWeapons(
        count: Int
    ): List<MaterialWeaponsEntity> {
        val materialWeapons = mutableListOf<MaterialWeaponsEntity>()
        val randomNumber = Random.nextInt(1, 100)

        for (i in 1..count) {
            materialWeapons.add(
                MaterialWeaponsEntity(
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
        return materialWeapons
    }

}
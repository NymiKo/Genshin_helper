package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.entities.DungeonsWeaponMaterialEntity
import kotlin.random.Random

class DungeonsWeaponMaterialDaoTestHelper {

    fun createRandomListOfDungeonsWeaponMaterial(
        count: Int
    ): List<DungeonsWeaponMaterialEntity> {
        val dungeonWeaponMaterial = mutableListOf<DungeonsWeaponMaterialEntity>()
        val randomNumber = Random.nextInt(1, 100)

        for (i in 1..count) {
            dungeonWeaponMaterial.add(
                DungeonsWeaponMaterialEntity(
                    i,
                    randomNumber,
                    "Описание подземелья $randomNumber"
                )
            )
        }

        return dungeonWeaponMaterial
    }

}
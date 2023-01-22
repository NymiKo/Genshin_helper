package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.model.BuildsHeroesWeaponsEntity
import com.easyprog.data.storage.model.DungeonsTalentMaterialEntity
import kotlin.random.Random

class DungeonsTalentMaterialDaoTestHelper {

    fun createRandomListOfDungeonsTalentMaterial(
        count: Int
    ): List<DungeonsTalentMaterialEntity> {
        val dungeonTalentsMaterial = mutableListOf<DungeonsTalentMaterialEntity>()
        val randomNumber = Random.nextInt(1, 100)

        for (i in 1..count) {
            dungeonTalentsMaterial.add(
                DungeonsTalentMaterialEntity(
                    i,
                    randomNumber,
                    "Описание подземелья $randomNumber"
                )
            )
        }

        return dungeonTalentsMaterial
    }

}
package com.easyprog.data.storage.dao.helpers

import com.easyprog.data.storage.model.PriorityHeroesEntity
import com.easyprog.data.storage.model.WeaponsEntity
import kotlin.random.Random

class WeaponsDaoTestHelper {

    fun createRandomListOfWeapons(
        count: Int
    ): List<WeaponsEntity> {
        val weaponsList = mutableListOf<WeaponsEntity>()
        val randomNumber = Random.nextInt(1, 100)

        for (i in 1..count) {
            weaponsList.add(
                WeaponsEntity(
                    i,
                    "Название оружия",
                    randomNumber,
                    "50-100",
                    "Какой-то стат $randomNumber",
                    i
                )
            )
        }
        return weaponsList
    }

}
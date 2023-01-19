package com.easyprog.data.storage.additional_models

import androidx.room.Relation
import com.easyprog.data.storage.additional_models.weapon.Weapons
import com.easyprog.data.storage.model.WeaponsEntity

data class BuildsHeroesWeapons(
    val idBuildsHeroesWeapons: Int,
    val description: String,
    val weaponId: Int,

    @Relation(parentColumn = "weaponId", entityColumn = "idWeapon", entity = WeaponsEntity::class)
    val weapon: Weapons

)

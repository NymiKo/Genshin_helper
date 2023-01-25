package com.easyprog.data.storage.additional_models

import androidx.room.ColumnInfo
import androidx.room.Relation
import com.easyprog.data.storage.additional_models.weapon.Weapons
import com.easyprog.data.storage.model.WeaponsEntity

data class BuildsHeroesWeapons(
    val id: Int,
    val description: String,
    @ColumnInfo(name = "weapon_id") val weaponId: Int,

    @Relation(parentColumn = "weapon_id", entityColumn = "id", entity = WeaponsEntity::class)
    val weapon: Weapons

)

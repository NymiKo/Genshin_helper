package com.easyprog.data.storage.additional_models

import androidx.room.Embedded
import androidx.room.Relation
import com.easyprog.data.storage.model.DungeonsWeaponMaterialEntity
import com.easyprog.data.storage.model.MaterialWeaponsEntity

data class MaterialWeaponsWithDungeons(

    @Embedded
    val materialWeapons: MaterialWeaponsEntity,

    @Relation(parentColumn = "weapon_material_dungeon_id", entityColumn = "id")
    val dungeonsWeaponMaterial: DungeonsWeaponMaterialEntity

)
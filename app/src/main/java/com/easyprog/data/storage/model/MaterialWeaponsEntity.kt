package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableMaterialsWeapons)
data class MaterialWeaponsEntity(
    @PrimaryKey
    val idWeaponMaterial: Int,
    val nameGreenMaterial: String,
    val imageGreenMaterial: Int,
    val nameBlueMaterial: String,
    val imageBlueMaterial: Int,
    val namePurpleMaterial: String,
    val imagePurpleMaterial: Int,
    val description: String,
    val weaponMaterialDungeonId: Int,
)

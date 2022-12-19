package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableMaterialsWeapons)
data class MaterialWeaponsEntity(
    @PrimaryKey
    val idWeaponMaterial: Int,
    val nameGreenMaterial: String,
    val imageGreenMaterial: String,
    val nameBlueMaterial: String,
    val imageBlueMaterial: String,
    val namePurpleMaterial: String,
    val imagePurpleMaterial: String
)

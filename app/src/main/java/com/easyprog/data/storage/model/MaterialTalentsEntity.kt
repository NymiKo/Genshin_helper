package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableMaterialTalents)
data class MaterialTalentsEntity(
    @PrimaryKey
    val idTalentMaterial: Int,
    val nameGreenMaterial: String,
    val imageGreenMaterial: String,
    val nameBlueMaterial: String,
    val imageBlueMaterial: String,
    val namePurpleMaterial: String,
    val imagePurpleMaterial: String
)

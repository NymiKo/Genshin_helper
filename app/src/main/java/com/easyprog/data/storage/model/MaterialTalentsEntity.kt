package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableMaterialTalents)
data class MaterialTalentsEntity(
    @PrimaryKey
    val idTalentMaterial: Int,
    val nameGreenMaterial: String,
    val imageGreenMaterial: Int,
    val nameBlueMaterial: String,
    val imageBlueMaterial: Int,
    val namePurpleMaterial: String,
    val imagePurpleMaterial: Int,
    val description: String,
    val talentDungeonId: Int
)

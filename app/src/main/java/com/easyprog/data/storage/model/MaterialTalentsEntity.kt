package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableMaterialTalents)
data class MaterialTalentsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name_green_material") val nameGreenMaterial: String,
    @ColumnInfo(name = "image_green_material") val imageGreenMaterial: Int,
    @ColumnInfo(name = "name_blue_material") val nameBlueMaterial: String,
    @ColumnInfo(name = "image_blue_material") val imageBlueMaterial: Int,
    @ColumnInfo(name = "name_purple_material") val namePurpleMaterial: String,
    @ColumnInfo(name = "image_purple_material") val imagePurpleMaterial: Int,
    val description: String,
    @ColumnInfo(name = "talent_dungeon_id") val talentDungeonId: Int
)

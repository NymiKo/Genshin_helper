package com.easyprog.genshin.model

import androidx.room.ColumnInfo

data class MaterialTalents(
    val id: Int,
    val nameGreenMaterial: String,
    val imageGreenMaterial: Int,
    val nameBlueMaterial: String,
    val imageBlueMaterial: Int,
    val namePurpleMaterial: String,
    val imagePurpleMaterial: Int,
    val description: String,
    val talentDungeonId: Int?
)

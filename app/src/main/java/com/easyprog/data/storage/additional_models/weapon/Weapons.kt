package com.easyprog.data.storage.additional_models.weapon

import androidx.room.ColumnInfo

data class Weapons(
    val name: String,
    @ColumnInfo(name = "image_weapon") val imageWeapon: Int
)

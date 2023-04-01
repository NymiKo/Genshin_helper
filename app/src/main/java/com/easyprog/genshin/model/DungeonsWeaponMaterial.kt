package com.easyprog.genshin.model

import androidx.room.ColumnInfo

data class DungeonsWeaponMaterial(
    val id: Int = 0,
    val imageDungeonOnMap: Int,
    val descriptionDungeon: String
)

package com.easyprog.genshin.model

import androidx.room.ColumnInfo

data class DungeonsWeaponMaterialByDay(
    val id: Int,
    val numberDayOfWeek: Int,
    val weaponDungeonId: Int?
)

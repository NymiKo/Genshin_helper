package com.easyprog.genshin.model

import androidx.room.ColumnInfo

data class BuildsHeroesWeapons(
    val id: Int,
    val description: String,
    val heroId: Int?,
    val weaponId: Int?
)

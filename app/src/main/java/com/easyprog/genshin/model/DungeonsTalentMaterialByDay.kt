package com.easyprog.genshin.model

import androidx.room.ColumnInfo

data class DungeonsTalentMaterialByDay(
    val id: Int,
    val numberDayOfWeek: Int,
    val talentDungeonId: Int?
)

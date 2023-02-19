package com.easyprog.genshin.model

import androidx.room.ColumnInfo

data class PriorityHeroes(
    val id: Int = 0,
    val elevationPriority: Boolean,
    val talentPriority: Boolean,
    val artifactPriority: Boolean,
    val heroId: Int?
)

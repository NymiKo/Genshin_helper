package com.easyprog.genshin.model

import androidx.room.ColumnInfo

data class PriorityHeroes(
    val heroId: Int,
    val elevationPriority: Boolean,
    val talentPriority: Boolean,
    val artifactPriority: Boolean,
)

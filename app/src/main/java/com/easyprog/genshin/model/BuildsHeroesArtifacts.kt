package com.easyprog.genshin.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class BuildsHeroesArtifacts(
    val id: Int,
    val flower: Int,
    val statFlower: String,
    val stylus: Int,
    val statStylus: String,
    val watch: Int,
    val statWatch: String,
    val cup: Int,
    val statCup: String,
    val cap: Int,
    val statCap: String,
    val heroId: Int?
)

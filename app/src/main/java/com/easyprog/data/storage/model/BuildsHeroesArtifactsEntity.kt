package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableBuildsHeroesArtifacts)
data class BuildsHeroesArtifactsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val flower: Int,
    @ColumnInfo(name = "stat_flower") val statFlower: String,
    val stylus: Int,
    @ColumnInfo(name = "stat_stylus") val statStylus: String,
    val watch: Int,
    @ColumnInfo(name = "stat_watch") val statWatch: String,
    val cup: Int,
    @ColumnInfo(name = "stat_cup") val statCup: String,
    val cap: Int,
    @ColumnInfo(name = "stat_cap") val statCap: String,
    @ColumnInfo(name = "hero_id") val heroId: Int
)

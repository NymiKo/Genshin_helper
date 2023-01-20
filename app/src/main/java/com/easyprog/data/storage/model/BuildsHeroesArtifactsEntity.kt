package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableBuildsHeroesArtifacts)
data class BuildsHeroesArtifactsEntity(
    @PrimaryKey
    val idBuildHeroesArtifacts: Int,
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
    val idHero: Int
)

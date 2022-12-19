package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableBuildsHeroes)
data class BuildsHeroesEntity(
    @PrimaryKey
    val idBuild: Int,
    val idWeapon: Int,
    val flower: Int,
    val statFlower: String,
    val stylus: Int,
    val statStylus: String,
    val watch: Int,
    val statWatch: String,
    val cup: Int,
    val statCup: String,
    val cap: Int,
    val statCap: String
)

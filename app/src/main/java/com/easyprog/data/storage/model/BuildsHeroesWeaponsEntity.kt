package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableBuildsHeroesWeapons)
data class BuildsHeroesWeaponsEntity(
    @PrimaryKey
    val idBuildsHeroesWeapons: Int,
    val description: String,
    val idHero: Int,
    val weaponId: Int
)

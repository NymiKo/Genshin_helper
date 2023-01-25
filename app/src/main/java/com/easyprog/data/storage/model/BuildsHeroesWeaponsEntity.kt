package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableBuildsHeroesWeapons)
data class BuildsHeroesWeaponsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val description: String,
    @ColumnInfo(name = "hero_id") val heroId: Int,
    @ColumnInfo(name = "weapon_id") val weaponId: Int
)

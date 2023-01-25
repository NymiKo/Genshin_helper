package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableDungeonsTalentsMaterialByDay)
data class DungeonsTalentMaterialByDayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "number_day_of_week") val numberDayOfWeek: Int,
    @ColumnInfo(name = "talent_dungeon_id") val talentDungeonId: Int
)

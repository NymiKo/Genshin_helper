package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableDungeonsTalentsMaterialByDay)
data class DungeonsTalentMaterialByDayEntity(
    @PrimaryKey(autoGenerate = true)
    val idTalentDungeonByDay: Int,
    val numberDayOfWeek: Int,
    val talentDungeonId: Int
)

package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableDungeonsTalentsMaterial)
data class DungeonsTalentMaterialEntity(
    @PrimaryKey
    val idTalentDungeon: Int,
    val idTalentMaterial: Int,
    val numberDayOfWeek: Int
)

package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableDungeonsTalentsMaterial)
data class DungeonsTalentMaterialEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "image_dungeon_on_map") val imageDungeonOnMap: Int,
    @ColumnInfo(name = "description_dungeon") val descriptionDungeon: String
)

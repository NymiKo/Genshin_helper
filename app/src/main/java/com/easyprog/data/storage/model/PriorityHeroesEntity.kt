package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tablePriorityHeroes)
data class PriorityHeroesEntity(
    @PrimaryKey(autoGenerate = true)
    val idPriority: Int = 0,
    val elevationPriority: Boolean,
    val talentPriority: Boolean,
    val artifactPriority: Boolean,

    @ColumnInfo(name = "id_hero")
    val idHero: Int
)

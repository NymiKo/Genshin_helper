package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(
    tableName = RoomContract.tablePriorityHeroes,
    foreignKeys = [
        ForeignKey(
            entity = HeroesEntity::class,
            parentColumns = ["id"],
            childColumns = ["hero_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class PriorityHeroesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "elevation_priority") val elevationPriority: Boolean,
    @ColumnInfo(name = "talent_priority") val talentPriority: Boolean,
    @ColumnInfo(name = "artifact_priority") val artifactPriority: Boolean,
    @ColumnInfo(name = "hero_id") val heroId: Int?
)

package com.easyprog.data.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.DungeonsTalentMaterialByDay

@Entity(
    tableName = RoomContract.tableDungeonsTalentsMaterialByDay,
    foreignKeys = [
        ForeignKey(
            entity = DungeonsTalentMaterialEntity::class,
            parentColumns = ["id"],
            childColumns = ["talent_dungeon_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class DungeonsTalentMaterialByDayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "number_day_of_week") val numberDayOfWeek: Int,
    @ColumnInfo(name = "talent_dungeon_id") val talentDungeonId: Int?
) {

    companion object {
        fun toDungeonsTalentMaterialByDayEntity(dungeonsTalentMaterialByDay: DungeonsTalentMaterialByDay) = DungeonsTalentMaterialByDay(
            id = dungeonsTalentMaterialByDay.id,
            numberDayOfWeek = dungeonsTalentMaterialByDay.numberDayOfWeek,
            talentDungeonId = dungeonsTalentMaterialByDay.talentDungeonId
        )
    }

    fun toDungeonsTalentMaterialByDay() = DungeonsTalentMaterialByDay(
        id = id,
        numberDayOfWeek = numberDayOfWeek,
        talentDungeonId = talentDungeonId
    )
}

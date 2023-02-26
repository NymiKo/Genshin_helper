package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.PriorityHeroes

@Entity(
    tableName = RoomContract.tablePriorityHeroes,
    foreignKeys = [
        ForeignKey(
            entity = HeroesEntity::class,
            parentColumns = ["id"],
            childColumns = ["hero_id"]
            //TODO после заполнения таблицы героев добавить onDelete и onUpdate
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
) {

    companion object {
        fun toPriorityHeroesEntity(priorityHeroes: PriorityHeroes) = PriorityHeroesEntity(
            id = priorityHeroes.id,
            elevationPriority = priorityHeroes.elevationPriority,
            talentPriority = priorityHeroes.talentPriority,
            artifactPriority = priorityHeroes.artifactPriority,
            heroId = priorityHeroes.heroId
        )
    }

    fun toPriorityHeroes() = PriorityHeroes(
        id = id,
        elevationPriority = elevationPriority,
        talentPriority = talentPriority,
        artifactPriority = artifactPriority,
        heroId = heroId
    )
}

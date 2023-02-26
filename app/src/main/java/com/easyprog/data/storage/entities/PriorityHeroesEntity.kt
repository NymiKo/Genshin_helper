package com.easyprog.data.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.PriorityHeroes
import org.jetbrains.annotations.NotNull

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
    @PrimaryKey
    @ColumnInfo(name = "hero_id") val heroId: Int,
    @ColumnInfo(name = "elevation_priority") val elevationPriority: Boolean,
    @ColumnInfo(name = "talent_priority") val talentPriority: Boolean,
    @ColumnInfo(name = "artifact_priority") val artifactPriority: Boolean,
) {

    companion object {
        fun toPriorityHeroesEntity(priorityHeroes: PriorityHeroes) = PriorityHeroesEntity(
            heroId = priorityHeroes.heroId,
            elevationPriority = priorityHeroes.elevationPriority,
            talentPriority = priorityHeroes.talentPriority,
            artifactPriority = priorityHeroes.artifactPriority
        )
    }

    fun toPriorityHeroes() = PriorityHeroes(
        heroId = heroId,
        elevationPriority = elevationPriority,
        talentPriority = talentPriority,
        artifactPriority = artifactPriority,
    )
}

package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.BuildsHeroesArtifacts

@Entity(
    tableName = RoomContract.tableBuildsHeroesArtifacts,
    foreignKeys = [
        ForeignKey(
            entity = HeroesEntity::class,
            parentColumns = ["id"],
            childColumns = ["hero_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BuildsHeroesArtifactsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val flower: Int,
    @ColumnInfo(name = "stat_flower") val statFlower: String,
    val stylus: Int,
    @ColumnInfo(name = "stat_stylus") val statStylus: String,
    val watch: Int,
    @ColumnInfo(name = "stat_watch") val statWatch: String,
    val cup: Int,
    @ColumnInfo(name = "stat_cup") val statCup: String,
    val cap: Int,
    @ColumnInfo(name = "stat_cap") val statCap: String,
    @ColumnInfo(name = "hero_id") val heroId: Int?
) {

    companion object {
        fun toBuildsHeroesArtifactsEntity(buildsHeroesArtifacts: BuildsHeroesArtifacts) = BuildsHeroesArtifactsEntity(
            id = buildsHeroesArtifacts.id,
            flower = buildsHeroesArtifacts.flower,
            statFlower = buildsHeroesArtifacts.statFlower,
            stylus = buildsHeroesArtifacts.stylus,
            statStylus = buildsHeroesArtifacts.statStylus,
            watch = buildsHeroesArtifacts.watch,
            statWatch = buildsHeroesArtifacts.statWatch,
            cup = buildsHeroesArtifacts.cup,
            statCup = buildsHeroesArtifacts.statCup,
            cap = buildsHeroesArtifacts.cap,
            statCap = buildsHeroesArtifacts.statCap,
            heroId = buildsHeroesArtifacts.heroId
        )
    }

    fun toBuildsHeroesArtifacts() = BuildsHeroesArtifacts(
        id = id,
        flower = flower,
        statFlower = statFlower,
        stylus = stylus,
        statStylus = statStylus,
        watch = watch,
        statWatch = statWatch,
        cup = cup,
        statCup = statCup,
        cap = cap,
        statCap = statCap,
        heroId = heroId
    )

}
package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.BuildsHeroesWeapons

@Entity(
    tableName = RoomContract.tableBuildsHeroesWeapons,
    foreignKeys = [
        ForeignKey(
            entity = HeroesEntity::class,
            parentColumns = ["id"],
            childColumns = ["hero_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = WeaponsEntity::class,
            parentColumns = ["id"],
            childColumns = ["weapon_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class BuildsHeroesWeaponsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val description: String,
    @ColumnInfo(name = "hero_id") val heroId: Int?,
    @ColumnInfo(name = "weapon_id") val weaponId: Int?
) {

    companion object {
        fun toBuildsHeroesWeaponsEntity(buildsHeroesWeapons: BuildsHeroesWeapons) = BuildsHeroesWeaponsEntity(
            id = buildsHeroesWeapons.id,
            description = buildsHeroesWeapons.description,
            heroId = buildsHeroesWeapons.heroId,
            weaponId = buildsHeroesWeapons.weaponId
        )
    }

    fun toBuildsHeroesWeapons() = BuildsHeroesWeapons(
        id = id,
        description = description,
        heroId = heroId,
        weaponId = weaponId
    )
}

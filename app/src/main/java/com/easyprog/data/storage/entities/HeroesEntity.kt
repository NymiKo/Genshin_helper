package com.easyprog.data.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.Hero

@Entity(
    tableName = RoomContract.tableHeroes,
    foreignKeys = [
        ForeignKey(
            entity = MaterialTalentsEntity::class,
            parentColumns = ["id"],
            childColumns = ["talent_material_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class HeroesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val avatar: Int,
    val birthday: String,
    val element: String,
    val region: String,
    @ColumnInfo(name = "talent_material_id") val talentMaterialId: Int?
) {

    companion object {
        fun toHeroesEntity(hero: Hero) = Hero(
            id = hero.id,
            name = hero.name,
            avatar = hero.avatar,
            birthday = hero.birthday,
            element = hero.element,
            region = hero.region,
            talentMaterialId = hero.talentMaterialId
        )
    }

    fun toHeroes() = Hero(
            id = id,
            name = name,
            avatar = avatar,
            birthday = birthday,
            element = element,
            region = region,
            talentMaterialId = talentMaterialId
        )
}

package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.Heroes

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
        fun toHeroesEntity(heroes: Heroes) = Heroes(
            id = heroes.id,
            name = heroes.name,
            avatar = heroes.avatar,
            birthday = heroes.birthday,
            element = heroes.element,
            region = heroes.region,
            talentMaterialId = heroes.talentMaterialId
        )
    }

    fun toHeroes() = Heroes(
            id = id,
            name = name,
            avatar = avatar,
            birthday = birthday,
            element = element,
            region = region,
            talentMaterialId = talentMaterialId
        )
}

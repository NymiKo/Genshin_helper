package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.MaterialTalents

@Entity(
    tableName = RoomContract.tableMaterialTalents,
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
data class MaterialTalentsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name_green_material") val nameGreenMaterial: String,
    @ColumnInfo(name = "image_green_material") val imageGreenMaterial: Int,
    @ColumnInfo(name = "name_blue_material") val nameBlueMaterial: String,
    @ColumnInfo(name = "image_blue_material") val imageBlueMaterial: Int,
    @ColumnInfo(name = "name_purple_material") val namePurpleMaterial: String,
    @ColumnInfo(name = "image_purple_material") val imagePurpleMaterial: Int,
    val description: String,
    @ColumnInfo(name = "talent_dungeon_id") val talentDungeonId: Int?
) {

    companion object {
        fun toMaterialTalentsEntity(materialTalents: MaterialTalents) = MaterialTalents(
            id = materialTalents.id,
            nameGreenMaterial = materialTalents.nameGreenMaterial,
            imageGreenMaterial = materialTalents.imageGreenMaterial,
            nameBlueMaterial = materialTalents.nameBlueMaterial,
            imageBlueMaterial = materialTalents.imageBlueMaterial,
            namePurpleMaterial = materialTalents.namePurpleMaterial,
            imagePurpleMaterial = materialTalents.imagePurpleMaterial,
            description = materialTalents.description,
            talentDungeonId = materialTalents.talentDungeonId
        )
    }

    fun toMaterialTalents() = MaterialTalents(
        id = id,
        nameGreenMaterial = nameGreenMaterial,
        imageGreenMaterial = imageGreenMaterial,
        nameBlueMaterial = nameBlueMaterial,
        imageBlueMaterial = imageBlueMaterial,
        namePurpleMaterial = namePurpleMaterial,
        imagePurpleMaterial = imagePurpleMaterial,
        description = description,
        talentDungeonId = talentDungeonId
    )
}

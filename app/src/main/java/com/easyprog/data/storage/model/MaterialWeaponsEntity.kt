package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.MaterialWeapons

@Entity(
    tableName = RoomContract.tableMaterialsWeapons,
    foreignKeys = [
        ForeignKey(
            entity = DungeonsWeaponMaterialEntity::class,
            parentColumns = ["id"],
            childColumns = ["weapon_material_dungeon_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class MaterialWeaponsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name_green_material") val nameGreenMaterial: String,
    @ColumnInfo(name = "image_green_material") val imageGreenMaterial: Int,
    @ColumnInfo(name = "name_blue_material") val nameBlueMaterial: String,
    @ColumnInfo(name = "image_blue_material") val imageBlueMaterial: Int,
    @ColumnInfo(name = "name_purple_material") val namePurpleMaterial: String,
    @ColumnInfo(name = "image_purple_material") val imagePurpleMaterial: Int,
    val description: String,
    @ColumnInfo(name = "weapon_material_dungeon_id") val weaponMaterialDungeonId: Int?
) {

    companion object {
        fun toMaterialWeaponsEntity(materialWeapons: MaterialWeapons) = MaterialWeapons(
            id = materialWeapons.id,
            nameGreenMaterial = materialWeapons.nameGreenMaterial,
            imageGreenMaterial = materialWeapons.imageGreenMaterial,
            nameBlueMaterial = materialWeapons.nameBlueMaterial,
            imageBlueMaterial = materialWeapons.imageBlueMaterial,
            namePurpleMaterial = materialWeapons.namePurpleMaterial,
            imagePurpleMaterial = materialWeapons.imagePurpleMaterial,
            description = materialWeapons.description,
            weaponMaterialDungeonId = materialWeapons.weaponMaterialDungeonId
        )
    }

    fun toMaterialWeapons() = MaterialWeapons(
        id = id,
        nameGreenMaterial = nameGreenMaterial,
        imageGreenMaterial = imageGreenMaterial,
        nameBlueMaterial = nameBlueMaterial,
        imageBlueMaterial = imageBlueMaterial,
        namePurpleMaterial = namePurpleMaterial,
        imagePurpleMaterial = imagePurpleMaterial,
        description = description,
        weaponMaterialDungeonId = weaponMaterialDungeonId
    )
}

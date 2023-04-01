package com.easyprog.data.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.Weapons

@Entity(
    tableName = RoomContract.tableWeapon,
    foreignKeys = [
        ForeignKey(
            entity = MaterialWeaponsEntity::class,
            parentColumns = ["id"],
            childColumns = ["weapon_materials_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class WeaponsEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "image_weapon") val imageWeapon: Int,
    @ColumnInfo(name = "attack_power") val attackPower: String,
    @ColumnInfo(name = "main_stat") val mainStat: String,
    @ColumnInfo(name = "weapon_materials_id") val weaponMaterialsId: Int?
) {

    companion object {
        fun toWeaponsEntity(weapons: Weapons) = Weapons(
            id = weapons.id,
            name = weapons.name,
            imageWeapon = weapons.imageWeapon,
            attackPower = weapons.attackPower,
            mainStat = weapons.mainStat,
            weaponMaterialsId = weapons.weaponMaterialsId
        )
    }

    fun toWeapons() = Weapons(
        id = id,
        name = name,
        imageWeapon = imageWeapon,
        attackPower = attackPower,
        mainStat = mainStat,
        weaponMaterialsId = weaponMaterialsId
    )
}
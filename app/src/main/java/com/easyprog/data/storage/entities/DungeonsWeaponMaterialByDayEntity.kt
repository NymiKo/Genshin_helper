package com.easyprog.data.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.DungeonsWeaponMaterialByDay

@Entity(
    tableName = RoomContract.tableDungeonsWeaponMaterialByDay,
    foreignKeys = [
        ForeignKey(
            entity = DungeonsWeaponMaterialEntity::class,
            parentColumns = ["id"],
            childColumns = ["weapon_dungeon_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class DungeonsWeaponMaterialByDayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "number_day_of_week") val numberDayOfWeek: Int,
    @ColumnInfo(name = "weapon_dungeon_id") val weaponDungeonId: Int?
) {
    companion object {
        fun toDungeonsWeaponMaterialByDayEntity(dungeonsWeaponMaterialByDay: DungeonsWeaponMaterialByDay) = DungeonsWeaponMaterialByDay(
            id = dungeonsWeaponMaterialByDay.id,
            numberDayOfWeek = dungeonsWeaponMaterialByDay.numberDayOfWeek,
            weaponDungeonId = dungeonsWeaponMaterialByDay.weaponDungeonId
        )
    }

    fun toDungeonsWeaponMaterialByDay() = DungeonsWeaponMaterialByDay(
        id = id,
        numberDayOfWeek = numberDayOfWeek,
        weaponDungeonId = weaponDungeonId
    )
}
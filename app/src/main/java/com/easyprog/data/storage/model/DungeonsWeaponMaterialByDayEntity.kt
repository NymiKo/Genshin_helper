package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableDungeonsWeaponMaterialByDay)
data class DungeonsWeaponMaterialByDayEntity(
    @PrimaryKey(autoGenerate = true)
    val idWeaponDungeonByDay: Int,
    val numberDayOfWeek: Int,
    val weaponDungeonId: Int
)
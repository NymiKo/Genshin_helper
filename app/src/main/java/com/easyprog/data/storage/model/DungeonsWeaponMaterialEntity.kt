package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableDungeonsWeaponMaterial)
data class DungeonsWeaponMaterialEntity(
    @PrimaryKey
    val idWeaponDungeon: Int,
    val idWeaponMaterial: Int,
    val numberDayOfWeek: Int
)

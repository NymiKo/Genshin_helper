package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableWeapon)
data class WeaponsEntity(
    @PrimaryKey
    val idWeapon: Int,
    val name: String,
    val imageWeapon: Int,
    val attackPower: String,
    val mainStat: String,
    val weaponMaterialsId: Int
)
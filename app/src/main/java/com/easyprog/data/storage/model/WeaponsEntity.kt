package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableWeapon)
data class WeaponsEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "image_weapon") val imageWeapon: Int,
    @ColumnInfo(name = "attack_power") val attackPower: String,
    @ColumnInfo(name = "main_stat") val mainStat: String,
    @ColumnInfo(name = "weapon_materials_id") val weaponMaterialsId: Int
)
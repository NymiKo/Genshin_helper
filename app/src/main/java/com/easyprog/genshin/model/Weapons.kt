package com.easyprog.genshin.model

import androidx.room.ColumnInfo

data class Weapons(
    val id: Int,
    val name: String,
    val imageWeapon: Int,
    val attackPower: String,
    val mainStat: String,
    val weaponMaterialsId: Int?
)

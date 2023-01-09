package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableHeroes)
data class HeroesEntity(
    @PrimaryKey(autoGenerate = true)
    val idHero: Int,
    val name: String,
    val avatar: Int,
    val birthday: String,
    val element: String,
    val region: String,
    val idTalentMaterial: Int
)

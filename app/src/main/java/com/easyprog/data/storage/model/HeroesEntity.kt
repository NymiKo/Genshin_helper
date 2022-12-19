package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableHeroes)
data class HeroesEntity(
    @PrimaryKey
    val idHero: Int,
    val name: String,
    val avatar: String,
    val idTalentMaterial: Int
)

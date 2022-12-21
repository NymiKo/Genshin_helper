package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableHeroes)
data class HeroesEntity(
    @PrimaryKey(autoGenerate = true)
    val idHero: Int = 0,
    val name: String,
    val avatar: Int,
    val idTalentMaterial: Int
)

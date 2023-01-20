package com.easyprog.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(tableName = RoomContract.tableArtifacts)
data class ArtifactsEntity(
    @PrimaryKey(autoGenerate = true)
    val idSetArtifacts: Int = 0,
    val nameSet: String,
    val nameFlower: String,
    val imageFlower: Int,
    val nameStylus: String,
    val imageStylus: Int,
    val nameWatch: String,
    val imageWatch: Int,
    val nameCup: String,
    val imageCup: Int,
    val nameCap: String,
    val imageCap: Int
)

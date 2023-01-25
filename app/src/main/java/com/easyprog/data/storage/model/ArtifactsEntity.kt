package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract

@Entity(
    tableName = RoomContract.tableArtifacts,
    indices = [
        Index("id")
    ]
)
data class ArtifactsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name_set") val nameSet: String,
    @ColumnInfo(name = "name_flower") val nameFlower: String,
    @ColumnInfo(name = "image_flower") val imageFlower: Int,
    @ColumnInfo(name = "name_stylus") val nameStylus: String,
    @ColumnInfo(name = "image_stylus") val imageStylus: Int,
    @ColumnInfo(name = "name_watch") val nameWatch: String,
    @ColumnInfo(name = "image_watch") val imageWatch: Int,
    @ColumnInfo(name = "name_cup") val nameCup: String,
    @ColumnInfo(name = "image_cup") val imageCup: Int,
    @ColumnInfo(name = "name_cap") val nameCap: String,
    @ColumnInfo(name = "image_cap") val imageCap: Int
)

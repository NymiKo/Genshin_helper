package com.easyprog.data.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.genshin.model.Artifacts

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
) {

    companion object {
        fun toArtifactsEntity(artifacts: Artifacts) = ArtifactsEntity(
            id = artifacts.id,
            nameSet = artifacts.nameSet,
            nameFlower = artifacts.nameFlower,
            imageFlower = artifacts.imageFlower,
            nameStylus = artifacts.nameStylus,
            imageStylus = artifacts.imageStylus,
            nameWatch = artifacts.nameWatch,
            imageWatch = artifacts.imageWatch,
            nameCup = artifacts.nameCup,
            imageCup = artifacts.imageCup,
            nameCap = artifacts.nameCap,
            imageCap = artifacts.imageCap
        )
    }

    fun toArtifacts() = Artifacts(
        id = id,
        nameSet = nameSet,
        nameFlower = nameFlower,
        imageFlower = imageFlower,
        nameStylus = nameStylus,
        imageStylus = imageStylus,
        nameWatch = nameWatch,
        imageWatch = imageWatch,
        nameCup = nameCup,
        imageCup = imageCup,
        nameCap = nameCap,
        imageCap = imageCap
    )

}

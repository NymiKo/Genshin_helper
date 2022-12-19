package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.easyprog.data.storage.model.ArtifactsEntity

@Dao
interface ArtifactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtifacts(artifactsEntity: List<ArtifactsEntity>)

}
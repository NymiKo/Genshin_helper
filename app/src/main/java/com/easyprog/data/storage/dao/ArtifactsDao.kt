package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.model.ArtifactsEntity

@Dao
interface ArtifactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtifacts(artifactsEntity: List<ArtifactsEntity>)

    @Query("SELECT * FROM ${RoomContract.tableArtifacts} WHERE idSetArtifacts = :idSetArtifact")
    fun getSetArtifact(idSetArtifact: Int): ArtifactsEntity

    @Query("SELECT * FROM ${RoomContract.tableArtifacts}")
    fun getSetArtifacts(): List<ArtifactsEntity>
}
package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.model.DungeonsTalentMaterialEntity

@Dao
interface DungeonsTalentMaterialDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDungeonsTalentMaterial(dungeonsTalentMaterialEntity: List<DungeonsTalentMaterialEntity>)

}
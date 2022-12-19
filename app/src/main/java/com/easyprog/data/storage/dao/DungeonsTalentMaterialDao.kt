package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.easyprog.data.storage.model.DungeonsTalentMaterialEntity

@Dao
interface DungeonsTalentMaterialDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDungeonsTalentMaterial(dungeonsTalentMaterialEntity: List<DungeonsTalentMaterialEntity>)

}
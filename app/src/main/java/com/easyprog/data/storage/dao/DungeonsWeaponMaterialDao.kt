package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.easyprog.data.storage.model.DungeonsTalentMaterialEntity
import com.easyprog.data.storage.model.DungeonsWeaponMaterialEntity

@Dao
interface DungeonsWeaponMaterialDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDungeonsWeaponMaterial(dungeonsWeaponMaterialEntity: List<DungeonsWeaponMaterialEntity>)

}
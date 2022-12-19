package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.easyprog.data.storage.model.MaterialWeaponsEntity

@Dao
interface MaterialWeaponsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMaterialWeapons(materialWeaponsEntity: List<MaterialWeaponsEntity>)

}
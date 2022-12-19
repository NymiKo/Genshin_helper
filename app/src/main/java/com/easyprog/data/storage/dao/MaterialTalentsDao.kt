package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.easyprog.data.storage.model.MaterialTalentsEntity

@Dao
interface MaterialTalentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMaterialTalents(materialTalentsEntity: List<MaterialTalentsEntity>)

}
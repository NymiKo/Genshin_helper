package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.easyprog.data.storage.additional_models.MaterialTalentsWithDungeons
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.model.MaterialTalentsEntity

@Dao
interface MaterialTalentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMaterialTalents(materialTalentsEntity: List<MaterialTalentsEntity>)

    @Transaction
    @Query("SELECT * FROM ${RoomContract.tableMaterialTalents} WHERE idTalentMaterial = :talentsMaterialId")
    suspend fun getMaterialTalentsWithDungeons(talentsMaterialId: Int): List<MaterialTalentsWithDungeons>

}
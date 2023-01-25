package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.easyprog.data.storage.additional_models.MaterialWeaponsWithDungeons
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.model.MaterialWeaponsEntity

@Dao
interface MaterialWeaponsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMaterialWeapons(materialWeaponsEntity: List<MaterialWeaponsEntity>)

    @Transaction
    @Query("SELECT * FROM ${RoomContract.tableMaterialsWeapons} WHERE id = :idWeaponMaterial")
    suspend fun getMaterialWeaponWithDungeon(idWeaponMaterial: Int): MaterialWeaponsWithDungeons

}
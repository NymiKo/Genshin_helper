package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.entities.WeaponsEntity

@Dao
interface WeaponsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeapon(weaponsEntity: List<WeaponsEntity>)

    @Query("SELECT * FROM ${RoomContract.tableWeapon} WHERE id = :idWeapon")
    suspend fun getWeapon(idWeapon: Int): WeaponsEntity

}
package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.easyprog.data.storage.model.MaterialWeaponsEntity

@Dao
interface WeaponsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeapon(weaponsEntity: List<MaterialWeaponsEntity>)

}
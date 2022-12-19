package com.easyprog.data.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.model.PriorityHeroesEntity

@Dao
interface PriorityHeroesDao {

    @Query("SELECT * FROM ${RoomContract.tablePriorityHeroes} WHERE idHero = :id")
    fun getPriorityHero(id: Int): LiveData<PriorityHeroesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPriorityHero(priorityHeroesEntity: PriorityHeroesEntity)

    @Update
    fun updatePriorityHero(priorityHeroesEntity: PriorityHeroesEntity)

}
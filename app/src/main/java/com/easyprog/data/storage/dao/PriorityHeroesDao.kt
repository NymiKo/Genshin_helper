package com.easyprog.data.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.model.PriorityHeroesEntity

@Dao
interface PriorityHeroesDao {

    @Transaction
    @Query("SELECT * FROM ${RoomContract.tablePriorityHeroes} WHERE elevation_priority <> 0 OR talent_priority <> 0 OR artifact_priority <> 0")
    suspend fun getPriorityHeroWithHeroes(): List<PriorityWithHero>

    @Query("SELECT * FROM ${RoomContract.tablePriorityHeroes} WHERE hero_id = :idHero")
    fun getPriorityHeroLiveData(idHero: Int): LiveData<PriorityHeroesEntity>

    @Query("SELECT * FROM ${RoomContract.tablePriorityHeroes} WHERE hero_id = :idHero")
    suspend fun getPriorityHero(idHero: Int): PriorityHeroesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriorityHero(priorityHeroesEntity: PriorityHeroesEntity)

    @Update
    suspend fun updatePriorityHero(priorityHeroesEntity: PriorityHeroesEntity)

}
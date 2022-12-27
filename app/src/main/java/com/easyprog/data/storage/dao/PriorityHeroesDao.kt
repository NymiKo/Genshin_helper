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
//WHERE elevationPriority <> 0 OR talentPriority <> 0 OR artifactPriority <> 0
    @Transaction
    @Query("SELECT * FROM ${RoomContract.tablePriorityHeroes} WHERE elevationPriority <> 0 OR talentPriority <> 0 OR artifactPriority <> 0")
    fun getPriorityHeroWithHeroes(): LiveData<List<PriorityWithHero>>

    @Query("SELECT * FROM ${RoomContract.tablePriorityHeroes} WHERE id_hero = :id")
    fun getPriorityHeroLiveData(id: Int): LiveData<PriorityHeroesEntity>

    @Query("SELECT * FROM ${RoomContract.tablePriorityHeroes} WHERE id_hero = :id")
    fun getPriorityHero(id: Int): PriorityHeroesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPriorityHero(priorityHeroesEntity: PriorityHeroesEntity)

    @Update
    fun updatePriorityHero(priorityHeroesEntity: PriorityHeroesEntity)

}
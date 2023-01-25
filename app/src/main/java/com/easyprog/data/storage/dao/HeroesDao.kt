package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.model.HeroesEntity

@Dao
interface HeroesDao {

    @Query("SELECT * FROM ${RoomContract.tableHeroes}")
    suspend fun getHeroes(): List<HeroesEntity>

    @Query("SELECT * FROM ${RoomContract.tableHeroes} WHERE id = :idHero")
    suspend fun getHero(idHero: Int): HeroesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroesEntity: List<HeroesEntity>)

}
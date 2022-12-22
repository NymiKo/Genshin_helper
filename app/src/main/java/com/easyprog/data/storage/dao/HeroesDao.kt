package com.easyprog.data.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.model.HeroesEntity

@Dao
interface HeroesDao {

    @Query("SELECT * FROM ${RoomContract.tableHeroes} WHERE idHero = :id")
    fun getHero(id: Int): LiveData<HeroesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHeroes(heroesEntity: List<HeroesEntity>)

}
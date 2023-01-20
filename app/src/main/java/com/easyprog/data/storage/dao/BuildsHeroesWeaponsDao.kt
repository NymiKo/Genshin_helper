package com.easyprog.data.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.easyprog.data.storage.additional_models.BuildsHeroesWeapons
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.model.BuildsHeroesWeaponsEntity

@Dao
interface BuildsHeroesWeaponsDao {

    @Transaction
    @Query("SELECT idBuildsHeroesWeapons, description, weaponId FROM ${RoomContract.tableBuildsHeroesWeapons} WHERE idHero = :heroId")
    fun getBuildsHeroesWeapons(heroId: Int): LiveData<List<BuildsHeroesWeapons>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBuildsHeroesWeapons(buildsHeroesWeapons: List<BuildsHeroesWeaponsEntity>)

}
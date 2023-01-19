package com.easyprog.data.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.easyprog.data.storage.additional_models.BuildsHeroesWeapons
import com.easyprog.data.storage.contract.RoomContract

@Dao
interface BuildsHeroesWeaponsDao {

    @Transaction
    @Query("SELECT idBuildsHeroesWeapons, description, weaponId FROM ${RoomContract.tableBuildsHeroesWeapons} WHERE idHero = :heroId")
    fun getBuildsWeapons(heroId: Int): LiveData<List<BuildsHeroesWeapons>>

}
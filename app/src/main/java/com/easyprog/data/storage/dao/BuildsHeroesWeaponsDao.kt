package com.easyprog.data.storage.dao

import androidx.room.*
import com.easyprog.data.storage.additional_models.BuildsHeroesWeapons
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.entities.BuildsHeroesWeaponsEntity

@Dao
interface BuildsHeroesWeaponsDao {

    @Transaction
    @Query("SELECT id, description, weapon_id FROM ${RoomContract.tableBuildsHeroesWeapons} WHERE hero_id = :idHero")
    suspend fun getBuildsHeroesWeapons(idHero: Int): List<BuildsHeroesWeapons>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBuildsHeroesWeapons(buildsHeroesWeapons: List<BuildsHeroesWeaponsEntity>)

}
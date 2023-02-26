package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyprog.data.storage.contract.RoomContract
import com.easyprog.data.storage.entities.BuildsHeroesArtifactsEntity

@Dao
interface BuildsHeroesArtifactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBuildsHeroes(buildsHeroesEntity: List<BuildsHeroesArtifactsEntity>)

    @Query("SELECT * FROM ${RoomContract.tableBuildsHeroesArtifacts} WHERE hero_id = :idHero")
    suspend fun getBuildsArtifactsHero(idHero: Int): List<BuildsHeroesArtifactsEntity>

}
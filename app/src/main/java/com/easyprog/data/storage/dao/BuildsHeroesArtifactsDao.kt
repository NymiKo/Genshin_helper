package com.easyprog.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.easyprog.data.storage.model.BuildsHeroesArtifactsEntity

@Dao
interface BuildsHeroesArtifactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBuildsHeroes(buildsHeroesEntity: List<BuildsHeroesArtifactsEntity>)

}
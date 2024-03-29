package com.easyprog.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.easyprog.data.storage.dao.*
import com.easyprog.data.storage.entities.*

@Database(
    entities = [ArtifactsEntity::class, BuildsHeroesArtifactsEntity::class, BuildsHeroesWeaponsEntity::class, DungeonsTalentMaterialEntity::class, DungeonsWeaponMaterialEntity::class, HeroesEntity::class,
        MaterialTalentsEntity::class, MaterialWeaponsEntity::class, PriorityHeroesEntity::class, WeaponsEntity::class],
    version = 1,
    exportSchema = true
)
abstract class RoomDatabaseApp : RoomDatabase() {

    abstract fun artifactsDao(): ArtifactsDao
    abstract fun buildsHeroesArtifactsDao(): BuildsHeroesArtifactsDao
    abstract fun buildsHeroesWeaponsDao(): BuildsHeroesWeaponsDao
    abstract fun dungeonsTalentMaterialDao(): DungeonsTalentMaterialDao
    abstract fun dungeonsWeaponMaterialDao(): DungeonsWeaponMaterialDao
    abstract fun heroesDao(): HeroesDao
    abstract fun materialTalentsDao(): MaterialTalentsDao
    abstract fun materialWeaponsDao(): MaterialWeaponsDao
    abstract fun priorityHeroesDao(): PriorityHeroesDao
    abstract fun weaponsDao(): WeaponsDao

}
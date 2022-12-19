package com.easyprog.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.easyprog.data.storage.dao.*
import com.easyprog.data.storage.model.*

@Database(
    entities = [ArtifactsEntity::class, BuildsHeroesEntity::class, DungeonsTalentMaterialEntity::class, DungeonsWeaponMaterialEntity::class, HeroesEntity::class,
        MaterialTalentsEntity::class, MaterialWeaponsEntity::class, PriorityHeroesEntity::class, WeaponsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDatabaseApp: RoomDatabase() {

    abstract fun artifactsDao(): ArtifactsDao
    abstract fun buildsHeroesDao(): BuildsHeroesDao
    abstract fun dungeonsTalentMaterialDao(): DungeonsTalentMaterialDao
    abstract fun dungeonsWeaponMaterialDao(): DungeonsWeaponMaterialDao
    abstract fun heroesDao(): HeroesDao
    abstract fun materialTalentsDao(): MaterialTalentsDao
    abstract fun materialWeaponsDao(): MaterialWeaponsDao
    abstract fun priorityHeroesDao(): PriorityHeroesDao
    abstract fun weaponsDao(): WeaponsDao

}
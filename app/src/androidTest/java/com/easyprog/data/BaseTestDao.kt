package com.easyprog.data

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.dao.helpers.*
import com.easyprog.data.storage.entities.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
open class BaseTestDao {

    companion object {
        private const val SIZE_LIST = 10
    }

    private val db: RoomDatabaseApp = Room.inMemoryDatabaseBuilder(
        InstrumentationRegistry.getInstrumentation().targetContext,
        RoomDatabaseApp::class.java
    ).build()

    val artifactsDao = db.artifactsDao()
    val buildsHeroesArtifactsDao = db.buildsHeroesArtifactsDao()
    val buildsHeroesWeaponsDao = db.buildsHeroesWeaponsDao()
    val dungeonsTalentsMaterialDao = db.dungeonsTalentMaterialDao()
    val dungeonsWeaponsMaterialDao = db.dungeonsWeaponMaterialDao()
    val heroesDao = db.heroesDao()
    val materialTalentsDao = db.materialTalentsDao()
    val materialWeaponsDao = db.materialWeaponsDao()
    val priorityHeroesDao = db.priorityHeroesDao()
    val weaponsDao = db.weaponsDao()

    var artifactsList = emptyList<ArtifactsEntity>()
    var buildsHeroesArtifacts = emptyList<BuildsHeroesArtifactsEntity>()
    var buildsHeroesWeaponsList = emptyList<BuildsHeroesWeaponsEntity>()
    var dungeonsTalentsMaterialList = emptyList<DungeonsTalentMaterialEntity>()
    var dungeonsWeaponsMaterialList = emptyList<DungeonsWeaponMaterialEntity>()
    var heroesList = emptyList<HeroesEntity>()
    var materialTalentsList = emptyList<MaterialTalentsEntity>()
    var materialWeaponsList = emptyList<MaterialWeaponsEntity>()
    var priorityHeroesList = emptyList<PriorityHeroesEntity>()
    var weaponsList = emptyList<WeaponsEntity>()

    @Before
    fun createDb() {
        db
        runBlocking {
            artifactsList = ArtifactsTestHelper().createRandomListOfArtifacts(SIZE_LIST)
            buildsHeroesArtifacts = BuildsHeroesArtifactsDaoTestHelper().createRandomListOfBuildsHeroesArtifacts(SIZE_LIST)
            buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(SIZE_LIST)
            dungeonsTalentsMaterialList = DungeonsTalentMaterialDaoTestHelper().createRandomListOfDungeonsTalentMaterial(SIZE_LIST)
            dungeonsWeaponsMaterialList = DungeonsWeaponMaterialDaoTestHelper().createRandomListOfDungeonsWeaponMaterial(SIZE_LIST)
            heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(SIZE_LIST)
            materialTalentsList = MaterialTalentsDaoTestHelper().createRandomListOfMaterialTalents(SIZE_LIST)
            materialWeaponsList = MaterialWeaponsDaoTestHelper().createRandomListOfMaterialWeapons(SIZE_LIST)
            priorityHeroesList = PriorityHeroesDaoTestHelper().createRandomListOfPriorityHeroes(SIZE_LIST)
            weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(SIZE_LIST)

            dungeonsTalentsMaterialDao.insertDungeonsTalentMaterial(dungeonsTalentsMaterialList)
            dungeonsWeaponsMaterialDao.insertDungeonsWeaponMaterial(dungeonsWeaponsMaterialList)
            materialTalentsDao.insertMaterialTalents(materialTalentsList)
            materialWeaponsDao.insertMaterialWeapons(materialWeaponsList)
            artifactsDao.insertArtifacts(artifactsList)
            weaponsDao.insertWeapon(weaponsList)
            heroesDao.insertHeroes(heroesList)
            buildsHeroesArtifactsDao.insertBuildsHeroes(buildsHeroesArtifacts)
            buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsList)
            priorityHeroesList.forEach { priorityHeroesDao.insertPriorityHero(it) }
        }
    }

    @After
    fun closeDB() {
        db.close()
    }
}
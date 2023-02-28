package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BuildsHeroesWeaponsDaoTest: BaseTestDao() {

    private val buildsHeroesWeaponsDao = db.buildsHeroesWeaponsDao()
    private val weaponsDao = db.weaponsDao()
    private val heroesDao = db.heroesDao()
    private val materialWeaponsDao = db.materialWeaponsDao()
    private val dungeonsWeaponsMaterialDao = db.dungeonsWeaponMaterialDao()
    private val materialTalentsDao = db.materialTalentsDao()
    private val dungeonsTalentsMaterialDao = db.dungeonsTalentMaterialDao()

    @Before
    fun addNecessaryDataToDatabase() = runBlocking {
        val materialTalentsList = MaterialTalentsDaoTestHelper().createRandomListOfMaterialTalents(10)
        val dungeonsTalentsMaterialList = DungeonsTalentMaterialDaoTestHelper().createRandomListOfDungeonsTalentMaterial(10)
        val materialWeaponsList = MaterialWeaponsDaoTestHelper().createRandomListOfMaterialWeapons(10)
        val heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(10)
        val dungeonsWeaponsMaterialList = DungeonsWeaponMaterialDaoTestHelper().createRandomListOfDungeonsWeaponMaterial(10)
        dungeonsWeaponsMaterialDao.insertDungeonsWeaponMaterial(dungeonsWeaponsMaterialList)
        materialWeaponsDao.insertMaterialWeapons(materialWeaponsList)
        dungeonsTalentsMaterialDao.insertDungeonsTalentMaterial(dungeonsTalentsMaterialList)
        materialTalentsDao.insertMaterialTalents(materialTalentsList)
        heroesDao.insertHeroes(heroesList)
    }

    @Test
    fun insertBuildsHeroesWeaponsAndGetThem() = runBlocking {
        val buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(1, true)
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(1)

        weaponsDao.insertWeapon(weaponsList)
        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsList)

        assertEquals(1, buildsHeroesWeaponsDao.getBuildsHeroesWeapons(1).size)
    }

    @Test
    fun insertALotOfBuildsHeroesWeaponsAndGetThem() = runBlocking {
        val buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(5, false)
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(5)

        weaponsDao.insertWeapon(weaponsList)
        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsList)

        assertEquals(5, buildsHeroesWeaponsDao.getBuildsHeroesWeapons(1).size)
    }

    @Test
    fun insertALotOfBuildsHeroesWeaponsThenAddNewBuildsAndGetThem() = runBlocking {
        var buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(5, false)
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(10)

        weaponsDao.insertWeapon(weaponsList)
        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsList)

        buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(7, false)
        val buildsHeroesWeaponsAddNewBuilds = listOf(buildsHeroesWeaponsList[5], buildsHeroesWeaponsList[6])
        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsAddNewBuilds)

        assertEquals(7, buildsHeroesWeaponsDao.getBuildsHeroesWeapons(1).size)
    }

    @Test
    fun insertALotOfBuildsHeroesWeaponsThenAddNewBuildsAndGetThemWithoutId() = runBlocking {
        var buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(5, false)
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(10)

        weaponsDao.insertWeapon(weaponsList)
        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsList)

        buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(7, true)
        val buildsHeroesWeaponsAddNewBuilds = listOf(buildsHeroesWeaponsList[5], buildsHeroesWeaponsList[6])
        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsAddNewBuilds)

        assertEquals(5, buildsHeroesWeaponsDao.getBuildsHeroesWeapons(1).size)
    }
}
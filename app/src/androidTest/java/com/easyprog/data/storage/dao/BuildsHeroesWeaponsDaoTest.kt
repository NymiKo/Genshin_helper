package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.BuildsHeroesWeaponsDaoTestHelper
import com.easyprog.data.storage.dao.helpers.WeaponsDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class BuildsHeroesWeaponsDaoTest: BaseTestDao() {

    private val buildsHeroesWeaponsDao = db.buildsHeroesWeaponsDao()
    private val weaponsDao = db.weaponsDao()

    @Test
    fun insertBuildsHeroesWeaponsAndGetThem() = runBlocking {
        val buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(1, true)
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(1)

        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsList)
        weaponsDao.insertWeapon(weaponsList)

        assertEquals(1, buildsHeroesWeaponsDao.getBuildsHeroesWeapons(1).size)
    }

    @Test
    fun insertALotOfBuildsHeroesWeaponsAndGetThem() = runBlocking {
        val buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(5, false)
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(5)

        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsList)
        weaponsDao.insertWeapon(weaponsList)

        assertEquals(5, buildsHeroesWeaponsDao.getBuildsHeroesWeapons(1).size)
    }

    @Test
    fun insertALotOfBuildsHeroesWeaponsThenAddNewBuildsAndGetThem() = runBlocking {
        var buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(5, false)
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(10)

        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsList)
        weaponsDao.insertWeapon(weaponsList)

        buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(7, false)
        val buildsHeroesWeaponsAddNewBuilds = listOf(buildsHeroesWeaponsList[5], buildsHeroesWeaponsList[6])
        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsAddNewBuilds)

        assertEquals(7, buildsHeroesWeaponsDao.getBuildsHeroesWeapons(1).size)
    }

    @Test
    fun insertALotOfBuildsHeroesWeaponsThenAddNewBuildsAndGetThemWithoutId() = runBlocking {
        var buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(5, false)
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(10)

        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsList)
        weaponsDao.insertWeapon(weaponsList)

        buildsHeroesWeaponsList = BuildsHeroesWeaponsDaoTestHelper().createRandomListOfBuildsHeroesWeapons(7, true)
        val buildsHeroesWeaponsAddNewBuilds = listOf(buildsHeroesWeaponsList[5], buildsHeroesWeaponsList[6])
        buildsHeroesWeaponsDao.insertBuildsHeroesWeapons(buildsHeroesWeaponsAddNewBuilds)

        assertEquals(5, buildsHeroesWeaponsDao.getBuildsHeroesWeapons(1).size)
    }
}
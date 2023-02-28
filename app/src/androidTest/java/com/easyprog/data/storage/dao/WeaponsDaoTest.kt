package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.WeaponsDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class WeaponsDaoTest : BaseTestDao() {

    @Test
    fun insertWeaponAndGetThemById() = runBlocking {
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(1)
        weaponsDao.insertWeapon(weaponsList)
        assertEquals(weaponsList[0], weaponsDao.getWeapon(1))
        assertNotEquals(weaponsList[0], weaponsDao.getWeapon(2))
    }

    @Test
    fun insertALotOfWeaponAndGetThemById() = runBlocking {
        val weaponsList = WeaponsDaoTestHelper().createRandomListOfWeapons(5)
        weaponsDao.insertWeapon(weaponsList)
        assertEquals(weaponsList[2], weaponsDao.getWeapon(3))
        assertNotEquals(1, weaponsDao.getWeapon(6))
    }

}
package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.WeaponsDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class WeaponsDaoTest : BaseTestDao() {

    @Test
    fun testGetWeaponById() = runBlocking {
        assertTrue(weaponsList[0] == weaponsDao.getWeapon(weaponsList[0].id))
    }

    @Test
    fun testGetWeapons() = runBlocking {
        assertTrue(weaponsList == weaponsDao.getWeapons())
    }
}
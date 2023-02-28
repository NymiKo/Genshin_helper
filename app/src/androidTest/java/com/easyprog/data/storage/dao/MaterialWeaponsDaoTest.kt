package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.DungeonsWeaponMaterialDaoTestHelper
import com.easyprog.data.storage.dao.helpers.MaterialWeaponsDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class MaterialWeaponsDaoTest : BaseTestDao() {

    @Test
    fun insertMaterialWeaponAndGetThem() = runBlocking {
        assertTrue(materialWeaponsList[0] == materialWeaponsDao.getMaterialWeaponWithDungeon(materialWeaponsList[0].id).materialWeapons)
        assertTrue(dungeonsWeaponsMaterialList[0] == materialWeaponsDao.getMaterialWeaponWithDungeon(materialWeaponsList[0].id).dungeonsWeaponMaterial)
    }
}
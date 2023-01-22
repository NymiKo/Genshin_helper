package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.DungeonsWeaponMaterialDaoTestHelper
import com.easyprog.data.storage.dao.helpers.MaterialWeaponsDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class MaterialWeaponsDaoTest : BaseTestDao() {

    private val materialWeaponsDao = db.materialWeaponsDao()
    private val dungeonsWeaponMaterialDao = db.dungeonsWeaponMaterialDao()

    @Test
    fun insertMaterialWeaponAndGetThem() = runBlocking {
        val materialWeaponsDaoList =
            MaterialWeaponsDaoTestHelper().createRandomListOfMaterialWeapons(1)
        val dungeonsWeaponMaterialList =
            DungeonsWeaponMaterialDaoTestHelper().createRandomListOfDungeonsWeaponMaterial(1)
        materialWeaponsDao.insertMaterialWeapons(materialWeaponsDaoList)
        dungeonsWeaponMaterialDao.insertDungeonsWeaponMaterial(dungeonsWeaponMaterialList)
        assertTrue(materialWeaponsDaoList[0] == materialWeaponsDao.getMaterialWeaponWithDungeon(1).materialWeapons)
        assertTrue(dungeonsWeaponMaterialList[0] == materialWeaponsDao.getMaterialWeaponWithDungeon(1).dungeonsWeaponMaterial)
    }

    @Test
    fun insertALotOfMaterialWeaponAndGetThem() = runBlocking {
        val materialWeaponsDaoList =
            MaterialWeaponsDaoTestHelper().createRandomListOfMaterialWeapons(5)
        val dungeonsWeaponMaterialList =
            DungeonsWeaponMaterialDaoTestHelper().createRandomListOfDungeonsWeaponMaterial(5)
        materialWeaponsDao.insertMaterialWeapons(materialWeaponsDaoList)
        dungeonsWeaponMaterialDao.insertDungeonsWeaponMaterial(dungeonsWeaponMaterialList)
        assertTrue(materialWeaponsDaoList[2] == materialWeaponsDao.getMaterialWeaponWithDungeon(3).materialWeapons)
        assertTrue(dungeonsWeaponMaterialList[2] == materialWeaponsDao.getMaterialWeaponWithDungeon(3).dungeonsWeaponMaterial)
    }

}